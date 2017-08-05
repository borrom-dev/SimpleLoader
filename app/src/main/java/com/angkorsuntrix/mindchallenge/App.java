package com.angkorsuntrix.mindchallenge;

import android.app.Application;

import com.angkorsuntrix.mindchallenge.dagger.AppComponent;
import com.angkorsuntrix.mindchallenge.dagger.AppModule;
import com.angkorsuntrix.mindchallenge.dagger.DaggerAppComponent;
//import com.angkorsuntrix.mindchallenge.dagger.DaggerAppComponent;

/**
 * Created by borrom on 5/8/17.
 */

public class App extends Application {

    private static App sInstance;
    private AppComponent mComponent;

    public App() {
        sInstance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mComponent = DaggerAppComponent.builder()
                .appModule(new AppModule())
                .build();
        mComponent.inject(this);
    }

    public static AppComponent getComponent() {
        return sInstance.mComponent;
    }
}
