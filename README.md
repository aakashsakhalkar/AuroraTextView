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
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="16dp"
    tools:context=".MainActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:orientation="vertical"
        android:spacing="12dp">

        <!-- Basic Gradient -->
        <com.aakash.auroratextview.AuroraTextView
            android:id="@+id/AuroraTextView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Aurora Gradient"
            android:textSize="24sp"
            app:startColor="@android:color/holo_red_light"
            app:endColor="@android:color/holo_orange_light"/>
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
