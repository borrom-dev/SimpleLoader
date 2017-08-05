package com.angkorsuntrix.mindchallenge.ui.board;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.angkorsuntrix.mindchallenge.App;
import com.angkorsuntrix.mindchallenge.R;
//import com.angkorsuntrix.mindchallenge.dagger.component.DaggerBoardComponent;
//import com.angkorsuntrix.mindchallenge.dagger.DaggerAppComponent;
//import com.angkorsuntrix.mindchallenge.dagger.component.DaggerBoardComponent;
import com.angkorsuntrix.mindchallenge.dagger.component.DaggerBoardComponent;
import com.angkorsuntrix.mindchallenge.dagger.module.BoardModule;
import com.angkorsuntrix.mindchallenge.presenter.BoardPresenter;

import javax.inject.Inject;

public class BoardActivity extends AppCompatActivity {

    @Inject
    BoardPresenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
        BoardFragment fragment = (BoardFragment) getSupportFragmentManager().findFragmentById(R.id.board_fragment);
        DaggerBoardComponent.builder()
                .appComponent(App.getComponent())
                .boardModule(new BoardModule(fragment))
                .build()
                .inject(this);
    }
}
