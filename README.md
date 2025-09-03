# AuroraTextView 🌌

A customizable Android TextView with gradient, stroke, animation, and dark mode support.

![AuroraTextView Demo](demo.gif)

---

## Installation

Add JitPack to your **settings.gradle**:

```gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url "https://jitpack.io" }
    }
}
```

Then add the dependency in your **module build.gradle**:

```gradle
dependencies {
    implementation "com.github.aakashsakhalkar:AuroraTextView:v1.0.0"
}
```

---

## Usage Examples

### XML

```xml
<?xml version="1.0" encoding="utf-8"?>
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="16dp"
    tools:context=".MainActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:gravity="center"
        android:orientation="vertical"
        android:spacing="12dp">

        <!-- 1. Plain Text -->
        <com.aakash.auroratextview.AuroraTextView
            android:id="@+id/AuroraTextView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Aurora Gradient"
            android:textSize="24sp"  />

        <!-- 2. Basic Gradient -->
        <com.aakash.auroratextview.AuroraTextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Basic Gradient"
            android:textSize="24sp"
            app:endColor="@android:color/holo_green_light"
            app:startColor="@android:color/holo_blue_light" />

        <!-- 3. Linear Gradient -->
        <com.aakash.auroratextview.AuroraTextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Linear Gradient"
            android:textSize="24sp"
            app:endColor="@android:color/holo_blue_bright"
            app:gradientType="linear"
            app:startColor="@android:color/holo_purple" />

        <!-- 4. Radial Gradient -->
        <com.aakash.auroratextview.AuroraTextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Radial Gradient"
            android:textSize="24sp"
            app:endColor="@android:color/holo_green_dark"
            app:gradientType="radial"
            app:startColor="@android:color/holo_red_dark" />

        <!-- 5. Sweep Gradient -->
        <com.aakash.auroratextview.AuroraTextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Sweep Gradient"
            android:textSize="24sp"
            app:endColor="@android:color/holo_orange_dark"
            app:gradientType="sweep"
            app:startColor="@android:color/holo_blue_dark" />

        <!-- 6. Animated Gradient -->
        <com.aakash.auroratextview.AuroraTextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Animated Gradient"
            android:textSize="24sp"
            app:animated="true"
            app:animationSpeed="1500"
            app:endColor="@android:color/holo_blue_light"
            app:startColor="@android:color/holo_red_light" />

        <!-- 7. Stroke + Gradient -->
        <com.aakash.auroratextview.AuroraTextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Stroke + Fill Gradient"
            android:textSize="24sp"
            app:endColor="@android:color/holo_purple"
            app:startColor="@android:color/holo_red_light"
            app:strokeColor="@android:color/black"
            app:strokeWidth="3dp" />

        <!-- 8. Per-letter rainbow -->
        <com.aakash.auroratextview.AuroraTextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Rainbow Letters"
            android:textSize="24sp"
            app:perLetterGradient="true" />

        <!-- 9. Auto Dark Mode -->
        <com.aakash.auroratextview.AuroraTextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Dark Mode Aware"
            android:textSize="24sp"
            app:autoDarkMode="true"
            app:endColor="@android:color/holo_orange_light"
            app:startColor="@android:color/holo_green_light" />

    </LinearLayout>
</ScrollView>
```

### Java

```java
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
```

### Kotlin

```kotlin
val auroraTextView = findViewById<AuroraTextView>(R.id.AuroraTextView)

// Apply gradient colors
auroraTextView.setGradientColors(intArrayOf(Color.MAGENTA, Color.CYAN))

// Enable animation
auroraTextView.setAnimated(true)

// Add stroke around the text
auroraTextView.setStroke(6f, Color.BLACK)

// Enable per-letter rainbow mode
auroraTextView.setPerLetterGradient(true)

// Enable auto dark mode awareness
auroraTextView.setAutoDarkMode(true)
```

---

## Features ✨
- Linear, Radial, and Sweep Gradients
- Animated Gradient
- Stroke Support
- Per-letter Rainbow Gradient
- Dark Mode Awareness
- Fully customizable via XML or code

---

## Demo APK 📱
👉 [Download Release APK](https://github.com/aakashsakhalkar/AuroraTextView/releases)

---

## License 📜
This project is licensed under the MIT License.
