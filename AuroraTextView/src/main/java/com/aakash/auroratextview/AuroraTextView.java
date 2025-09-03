package com.aakash.auroratextview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.*;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

import org.jetbrains.annotations.Nullable;

public class AuroraTextView extends AppCompatTextView {

    public static final int TYPE_LINEAR = 0;
    public static final int TYPE_RADIAL = 1;
    public static final int TYPE_SWEEP = 2;

    private int[] gradientColors = {0xFF2196F3, 0xFF4CAF50};
    private int gradientType = TYPE_LINEAR;

    private boolean animated = false;
    private int animationSpeed = 2000;
    private ValueAnimator animator;
    private float animOffset = 0f;

    private boolean perLetterGradient = false;
    private boolean autoDarkMode = false;

    private float strokeWidth = 0f;
    private int strokeColor = Color.TRANSPARENT;

    private Shader shader;

    public AuroraTextView(Context context) {
        super(context);
        init(context, null);
    }

    public AuroraTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public AuroraTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AuroraTextView);

            int startColor = a.getColor(R.styleable.AuroraTextView_startColor, gradientColors[0]);
            int endColor = a.getColor(R.styleable.AuroraTextView_endColor, gradientColors[1]);
            gradientColors = new int[]{startColor, endColor};

            gradientType = a.getInt(R.styleable.AuroraTextView_gradientType, TYPE_LINEAR);

            animated = a.getBoolean(R.styleable.AuroraTextView_animated, false);
            animationSpeed = a.getInt(R.styleable.AuroraTextView_animationSpeed, 2000);

            strokeWidth = a.getDimension(R.styleable.AuroraTextView_strokeWidth, 0f);
            strokeColor = a.getColor(R.styleable.AuroraTextView_strokeColor, Color.TRANSPARENT);

            perLetterGradient = a.getBoolean(R.styleable.AuroraTextView_perLetterGradient, false);
            autoDarkMode = a.getBoolean(R.styleable.AuroraTextView_autoDarkMode, false);

            a.recycle();
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (changed) {
            buildShader(getWidth(), getHeight());
            if (animated) startAnimation();
        }
    }

    private void buildShader(int width, int height) {
        if (width == 0 || height == 0) return;

        int[] colorsToUse = gradientColors.clone();
        if (autoDarkMode && (getResources().getConfiguration().uiMode &
                Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES) {
            // invert brightness for dark mode
            for (int i = 0; i < colorsToUse.length; i++) {
                int r = 255 - Color.red(colorsToUse[i]);
                int g = 255 - Color.green(colorsToUse[i]);
                int b = 255 - Color.blue(colorsToUse[i]);
                colorsToUse[i] = Color.rgb(r, g, b);
            }
        }

        switch (gradientType) {
            case TYPE_RADIAL:
                float radius = Math.max(width, height) / 2f;
                shader = new RadialGradient(width / 2f, height / 2f,
                        radius, colorsToUse, null, Shader.TileMode.CLAMP);
                break;

            case TYPE_SWEEP:
                shader = new SweepGradient(width / 2f, height / 2f,
                        colorsToUse, null);
                break;

            case TYPE_LINEAR:
            default:
                shader = new LinearGradient(
                        0 + animOffset, 0,
                        width + animOffset, height,
                        colorsToUse, null, Shader.TileMode.CLAMP
                );
                break;
        }
        getPaint().setShader(shader);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (strokeWidth > 0) {
            Paint paint = getPaint();
            Shader originalShader = paint.getShader();

            // Stroke pass
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(strokeWidth);
            paint.setColor(strokeColor);
            paint.setShader(null);
            super.onDraw(canvas);

            // Fill pass with gradient
            paint.setStyle(Paint.Style.FILL);
            paint.setShader(originalShader);
        }

        if (perLetterGradient) {
            Paint paint = getPaint();
            paint.setShader(null); // disable global gradient shader

            CharSequence text = getText();
            for (int i = 0; i < text.length(); i++) {
                float charX = getLayout().getPrimaryHorizontal(i);
                int color = Color.HSVToColor(new float[]{(i * 30) % 360, 1f, 1f});
                paint.setColor(color);
                canvas.drawText(text, i, i + 1, charX, getBaseline(), paint);
            }
        } else {
            super.onDraw(canvas);
        }
    }

    // ===== Animation =====
    private void startAnimation() {
        if (getWidth() == 0) return;

        if (animator != null && animator.isRunning()) {
            animator.cancel();
        }

        animator = ValueAnimator.ofFloat(0, getWidth());
        animator.setDuration(animationSpeed);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.addUpdateListener(a -> {
            animOffset = (float) a.getAnimatedValue();
            buildShader(getWidth(), getHeight());
            invalidate();
        });
        animator.start();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (animator != null) animator.cancel();
    }

    // ===== Public API =====
    public void setGradientColors(int[] colors) {
        this.gradientColors = colors;
        buildShader(getWidth(), getHeight());
        invalidate();
    }

    public void setAnimated(boolean enable) {
        this.animated = enable;
        if (enable) startAnimation();
        else if (animator != null) animator.cancel();
    }

    public void setStroke(float width, int color) {
        this.strokeWidth = width;
        this.strokeColor = color;
        invalidate();
    }

    public void setPerLetterGradient(boolean enable) {
        this.perLetterGradient = enable;
        invalidate();
    }

    public void setAutoDarkMode(boolean enable) {
        this.autoDarkMode = enable;
        buildShader(getWidth(), getHeight());
        invalidate();
    }
}
