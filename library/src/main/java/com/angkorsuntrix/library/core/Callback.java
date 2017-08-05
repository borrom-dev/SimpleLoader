package com.angkorsuntrix.library.core;

/**
 * Created by borrom on 5/8/17.
 */

public interface Callback<E> {
    void onCompleted(E result);
    void onError(Exception e);
}
