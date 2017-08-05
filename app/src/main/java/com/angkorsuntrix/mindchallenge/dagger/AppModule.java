package com.angkorsuntrix.mindchallenge.dagger;

import com.angkorsuntrix.library.core.HttpDownloader;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by borrom on 5/8/17.
 */

@Module
public class AppModule {

    @Singleton
    @Provides
    public HttpDownloader provideHttDownloader(){
        return HttpDownloader.init();
    }
}
