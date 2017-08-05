package com.angkorsuntrix.mindchallenge.ui.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.angkorsuntrix.library.core.ImageLoader;
import com.angkorsuntrix.library.response.Board;
import com.angkorsuntrix.library.core.HttpDownloader;
import com.angkorsuntrix.mindchallenge.App;
import com.angkorsuntrix.mindchallenge.R;
import com.angkorsuntrix.mindchallenge.databinding.BoardItemBinding;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by borrom on 5/8/17.
 */

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.BoardHolder>{

    @Inject
    HttpDownloader mImageLoader;

    private List<Board> mBoards = new ArrayList<>();
    public BoardAdapter(List<Board> boards){
        mBoards = boards;
        App.getComponent().inject(this);
    }
    @Override
    public BoardHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.board_item, parent, false);
        BoardHolder holder = new BoardHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(BoardHolder holder, int position) {
        final Board board = mBoards.get(position);
        holder.mBinding.boardId.setText(board.getUser().getName());
        final ImageLoader imageLoader = new ImageLoader(holder.mBinding.boardPreview);
        imageLoader.setPlaceHolder(R.drawable.ic_placeholder);
        mImageLoader.download(board.getUrls().getRegular(), imageLoader);
    }

    @Override
    public int getItemCount() {
        return mBoards.size();
    }

    public final class BoardHolder extends RecyclerView.ViewHolder{
        BoardItemBinding mBinding;
        public BoardHolder(View itemView) {
            super(itemView);
            mBinding = DataBindingUtil.bind(itemView);
        }
    }
}
