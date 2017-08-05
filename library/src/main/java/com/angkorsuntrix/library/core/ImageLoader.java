package com.angkorsuntrix.library.core;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageView;

import java.io.InputStream;


/**
 * Created by borrom on 2/8/17.
 */

public class ImageLoader implements Loader {
    private ImageView mImageView;

    private Handler mHandler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(Message msg) {
            mImageView.setImageBitmap((Bitmap) msg.obj);
        }
    };
    public ImageLoader(ImageView imageView) {
        mImageView = imageView;
    }

    public void setPlaceHolder(int placeHolder){
        mImageView.setImageResource(placeHolder);
    }

    @Override
    public void readStream(InputStream stream) {
        Message message = mHandler.obtainMessage(1,BitmapFactory.decodeStream(stream));
        message.sendToTarget();
    }

}
