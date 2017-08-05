package com.angkorsuntrix.mindchallenge.dagger.component;

import com.angkorsuntrix.mindchallenge.dagger.AppComponent;
import com.angkorsuntrix.mindchallenge.dagger.FragmentScope;
import com.angkorsuntrix.mindchallenge.dagger.module.BoardModule;
import com.angkorsuntrix.mindchallenge.model.BoardModel;
import com.angkorsuntrix.mindchallenge.ui.board.BoardActivity;

import dagger.Component;

/**
 * Created by borrom on 5/8/17.
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = BoardModule.class)
public interface BoardComponent {
    void inject(BoardActivity boardActivity);
//    BoardModel getModel();
}
