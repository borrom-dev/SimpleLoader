package com.angkorsuntrix.mindchallenge.dagger;

import com.angkorsuntrix.mindchallenge.App;
import com.angkorsuntrix.mindchallenge.model.BoardModel;
import com.angkorsuntrix.mindchallenge.ui.adapter.BoardAdapter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by borrom on 5/8/17.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(App app);
    BoardModel getBoardModel();
    void inject(BoardAdapter boardAdapter);
}
