package com.aakash.gradienttextview;

import android.graphics.Color;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.aakash.auroratextview.AuroraTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        AuroraTextView auroraTextView = findViewById(R.id.AuroraTextView);

        // Apply gradient colors
        auroraTextView.setGradientColors(new int[]{Color.MAGENTA, Color.CYAN});

        // Enable animation
        auroraTextView.setAnimated(true);

        // Add stroke around the text
        auroraTextView.setStroke(6f, Color.BLACK);

        // Enable per-letter rainbow mode
        auroraTextView.setPerLetterGradient(true);

        // Enable auto dark mode awareness
        auroraTextView.setAutoDarkMode(true);

    }
}