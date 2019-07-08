package com.jayli3n.toggleimmersivemode;

        import com.facebook.react.bridge.ReactContextBaseJavaModule;
        import com.facebook.react.bridge.ReactApplicationContext;
        import com.facebook.react.bridge.ReactMethod;

        import java.lang.Runnable;

        import android.app.Activity;
        import android.view.View;

public class ToggleImmersiveModeModule extends ReactContextBaseJavaModule {
    public ToggleImmersiveModeModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "ToggleImmersiveMode";
    }

    @ReactMethod
    private void immersiveModeOn() {
        final Activity reactActivity = getCurrentActivity();
        final int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

        if (reactActivity != null) {
            reactActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    reactActivity.getWindow()
                        .getDecorView()
                        .setSystemUiVisibility(flags);
                }
            });
        }
    }


    @ReactMethod
    private void immersiveModeOff() {
        final Activity reactActivity = getCurrentActivity();
        final int flag = View.SYSTEM_UI_FLAG_VISIBLE;

        if (reactActivity != null) {
            reactActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    reactActivity.getWindow()
                        .getDecorView()
                        .setSystemUiVisibility(flag);
                }
            });
        }
    }
}
