package com.cod3rboy.crashbottomsheetexample;

import android.app.Application;

import com.cod3rboy.crashbottomsheet.CrashBottomSheet;
import com.cod3rboy.crashbottomsheet.DeviceInfo;

public class CustomApplication extends Application {
    public CustomApplication() {
        super();
        // Register without custom report action callback
        // CrashBottomSheet.register(this);
        // Register with custom report action callback
        CrashBottomSheet.register(this, new CrashBottomSheet.onCrashReport() {
            @Override
            public void handleCrashReport(String stackTrace, DeviceInfo deviceInfo) {
                // Write your custom action here to handle crash report e.g. send report to your server or log it in the file or whatever.
                CrashBottomSheet.sendCrashEmail(CustomApplication.this, stackTrace, deviceInfo); // Using default email action for now.
            }
        });
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // You can also register CrashBottomSheet here
    }
}
