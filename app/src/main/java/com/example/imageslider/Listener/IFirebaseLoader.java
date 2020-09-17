package com.example.imageslider.Listener;

import com.example.imageslider.Modal.News;

import java.util.List;

public interface IFirebaseLoader {

    void onFirebaseLoadSuccess(List<News> News_image_list);
}
