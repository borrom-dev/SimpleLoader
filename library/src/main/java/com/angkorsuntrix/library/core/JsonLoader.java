package com.angkorsuntrix.library.core;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.angkorsuntrix.library.response.Board;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by borrom on 5/8/17.
 */

public class JsonLoader implements Loader {

    private Callback mCallback;
    private Handler mHandler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(Message msg) {
            mCallback.onCompleted(msg.obj);
        }
    };

    public JsonLoader(Callback callback){
        mCallback = callback;
    }

    @Override
    public void readStream(InputStream stream) {
        try {
            readJson(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readJson(InputStream in) throws Exception {
        Reader reader = new InputStreamReader(in, "UTF-8");
        Type listType = new TypeToken<ArrayList<Board>>(){}.getType();
        List<Board> results = new Gson().fromJson(reader, listType);
        Message message = mHandler.obtainMessage(1, results);
        message.sendToTarget();
    }

}
