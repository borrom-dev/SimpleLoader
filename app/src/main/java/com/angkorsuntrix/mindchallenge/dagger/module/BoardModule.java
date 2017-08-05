package com.angkorsuntrix.mindchallenge.dagger.module;

import com.angkorsuntrix.mindchallenge.model.BoardModel;
import com.angkorsuntrix.mindchallenge.presenter.BoardContract;
import com.angkorsuntrix.mindchallenge.presenter.BoardPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by borrom on 5/8/17.
 */

@Module
public class BoardModule {
    private final BoardContract.View mView;

    public BoardModule(BoardContract.View view){
        mView = view;
    }

    @Provides
    BoardContract.View provideBoardView(){
        return mView;
    }
}
