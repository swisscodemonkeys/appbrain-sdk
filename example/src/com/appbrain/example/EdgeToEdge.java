package com.appbrain.example;

import android.view.View;
import android.view.WindowInsets;

/**
 * Helper for edge-to-edge layout, which is enforced on Android 15+ (API 35+):
 * the window draws behind the status and navigation bars, so content needs to be
 * padded to stay clear of them.
 */
final class EdgeToEdge {

    private EdgeToEdge() {
    }

    /** Pads {@code root} by the system-bar insets so its content isn't drawn behind them. */
    @SuppressWarnings("deprecation") // getSystemWindowInset* works on every supported API level.
    static void applySystemBarInsets(final View root) {
        root.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
            @Override
            public WindowInsets onApplyWindowInsets(View v, WindowInsets insets) {
                v.setPadding(
                    insets.getSystemWindowInsetLeft(),
                    insets.getSystemWindowInsetTop(),
                    insets.getSystemWindowInsetRight(),
                    insets.getSystemWindowInsetBottom());
                return insets;
            }
        });
    }
}
