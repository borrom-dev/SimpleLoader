package com.angkorsuntrix.mindchallenge.model;

import com.angkorsuntrix.library.core.HttpDownloader;
import com.angkorsuntrix.library.core.JsonLoader;
import com.angkorsuntrix.library.core.Loader;

import javax.inject.Inject;

/**
 * Created by borrom on 5/8/17.
 */

public class BoardModel {

    private HttpDownloader mHttpDownloader;

    @Inject
    public BoardModel(HttpDownloader httpDownloader) {
        mHttpDownloader = httpDownloader;
    }

    public void getAll(String s, JsonLoader loader) {
        mHttpDownloader.download(s, loader);
    }
}
