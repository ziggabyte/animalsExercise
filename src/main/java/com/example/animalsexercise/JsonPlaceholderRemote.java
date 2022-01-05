package com.example.animalsexercise;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class JsonPlaceholderRemote {

    public JsonPlaceholderPost apiCall(String remoteId) {
        RestTemplate restTemplate = new RestTemplate();
        JsonPlaceholderPost post = restTemplate.getForObject(
                "https://jsonplaceholder.typicode.com/posts/" + remoteId,
                JsonPlaceholderPost.class);
        return post;
    }
}
