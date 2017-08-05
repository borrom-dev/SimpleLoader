package com.angkorsuntrix.library.core;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by borrom on 2/8/17.
 */

public final class HttpDownloader {

    private static com.angkorsuntrix.library.core.HttpDownloader sInstance;
    private ThreadPoolExecutor mExecutorService;
    private static final int DEFAULT_THREAD_COUNT = 3;
    private static final int DEFAULT_TIME_OUT = 3000;

    public static HttpDownloader init() {
        if (sInstance == null) {
            synchronized (HttpDownloader.class) {
                sInstance = new com.angkorsuntrix.library.core.HttpDownloader();
            }
        }
        return sInstance;
    }

    private HttpDownloader() {
        mExecutorService = new ThreadPoolExecutor(DEFAULT_THREAD_COUNT, DEFAULT_THREAD_COUNT, 0,
                TimeUnit.MICROSECONDS,
                new ArrayBlockingQueue<Runnable>(100));
    }

    public void download(String path, final Loader loader) {
        mExecutorService.submit(new HttpDownloaderTask(path, loader));
    }

    private final class HttpDownloaderTask implements Runnable {
        private final String mPath;
        private Loader mLoader;

        public HttpDownloaderTask(String path, Loader loader) {
            mPath = path;
            mLoader = loader;
        }

        @Override
        public void run() {
            try {
                HttpURLConnection connection;
                URL url = new URL(mPath);
                connection = (HttpURLConnection) url.openConnection();
                connection.setConnectTimeout(DEFAULT_TIME_OUT);
                connection.setReadTimeout(DEFAULT_TIME_OUT);
                connection.setInstanceFollowRedirects(true);
                connection.connect();
                final InputStream stream = connection.getInputStream();
                mLoader.readStream(stream);
            } catch (Exception ex) {
                //TODO: Handle error message
            } finally {

            }
        }
    }
}
