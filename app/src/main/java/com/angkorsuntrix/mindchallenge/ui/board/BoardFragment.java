package com.angkorsuntrix.mindchallenge.ui.board;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.angkorsuntrix.library.response.Board;
import com.angkorsuntrix.mindchallenge.R;
import com.angkorsuntrix.mindchallenge.databinding.FragmentBoardBinding;
import com.angkorsuntrix.mindchallenge.presenter.BoardContract;
import com.angkorsuntrix.mindchallenge.ui.adapter.BoardAdapter;

import java.util.List;

public class BoardFragment extends Fragment implements BoardContract.View{

    private BoardContract.Presenter mPresenter;

    FragmentBoardBinding mBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_board, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        mBinding.boardList.setLayoutManager(layoutManager);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.loadBoards();
    }

    @Override
    public void setPresenter(BoardContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showBoards(List<Board> boards) {
        final BoardAdapter adapter = new BoardAdapter(boards);
        mBinding.boardList.setAdapter(adapter);
    }

    @Override
    public void showError(String message) {

    }
}
