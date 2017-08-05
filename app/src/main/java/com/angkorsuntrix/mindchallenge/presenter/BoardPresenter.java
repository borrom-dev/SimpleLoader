package com.angkorsuntrix.mindchallenge.presenter;

import com.angkorsuntrix.library.core.Callback;
import com.angkorsuntrix.library.core.JsonLoader;
import com.angkorsuntrix.library.response.Board;
import com.angkorsuntrix.mindchallenge.model.BoardModel;


import java.util.List;

import javax.inject.Inject;

/**
 * Created by borrom on 5/8/17.
 */

public class BoardPresenter implements BoardContract.Presenter {

    private final BoardModel mBoardModel;
    private BoardContract.View mBoardView;

    @Inject
    public BoardPresenter(BoardModel boardModel, BoardContract.View boardView){
        mBoardModel = boardModel;
        mBoardView = boardView;
    }

    @Inject
    @Override
    public void start() {
        mBoardView.setPresenter(this);
    }

    @Override
    public void loadBoards() {
        mBoardModel.getAll("http://pastebin.com/raw/wgkJgazE", new JsonLoader(new Callback<List<Board>>() {
            @Override
            public void onCompleted(List<Board> boards) {
                mBoardView.showBoards(boards);
            }

            @Override
            public void onError(Exception e) {

            }
        }));
    }
}
