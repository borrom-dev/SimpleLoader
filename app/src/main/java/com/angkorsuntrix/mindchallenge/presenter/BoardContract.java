package com.angkorsuntrix.mindchallenge.presenter;


import com.angkorsuntrix.library.response.Board;
import com.angkorsuntrix.mindchallenge.BasePresenter;
import com.angkorsuntrix.mindchallenge.BaseView;

import java.util.List;

/**
 * Created by borrom on 5/8/17.
 */

public interface BoardContract {

    interface View extends BaseView<Presenter> {
        void showBoards(List<Board> boards);

        void showError(String message);
    }

    interface Presenter extends BasePresenter {
        void loadBoards();
    }
}
