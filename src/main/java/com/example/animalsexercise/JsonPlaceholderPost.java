package com.example.animalsexercise;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class JsonPlaceholderPost {
    int id;
    String title;
    String body;
    int userId;

    public JsonPlaceholderPost() {
        id = 0;
        title = null;
        body = null;
        userId = 1;
    }
}
