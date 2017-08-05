package com.angkorsuntrix.library.response;

/**
 * Created by borrom on 5/8/17.
 */

public class Board {

    private String id;
    private User user;
    private Urls urls;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Urls getUrls() {
        return urls;
    }

    public void setUrls(Urls urls) {
        this.urls = urls;
    }

}
