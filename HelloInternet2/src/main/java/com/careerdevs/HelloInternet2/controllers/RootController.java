package com.careerdevs.HelloInternet2.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RootController {

    @GetMapping("/")
    private String rootRoute() {
        return "You requested the root router";
    }

    @GetMapping("/hello")
    private String helloCareerDevs() {
        return "Hello CareerDevs!!!";
    }

    @GetMapping("/random")
    private int randomRoute() {
        return (int) (Math.random() * 100) + 1;
    }

    @GetMapping("/joke")
    private String jokeRoute() {
    String [] jokes = {
            "I'm afraid for this calendar. Its days are numbered.",
            "What do you call a joke that isn't funny? A sentence.",
            "What did Batman say to Robin before they got in the Batmobile? \"Get in the batmobile\".",
            "What's red and bad for your teeth? a brick.",
            "A dyslexic man walked into a bra..."
    };
        int jokeIndex = (int) (Math.random() * jokes.length);
        return jokes[jokeIndex];
    }

    @GetMapping("/getPostById/{id}")
    public Object getPostById(RestTemplate restTemplate, @PathVariable String id) {
        return restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/" + id, Object.class);
    }

    @GetMapping("/comments")
    public Object getCommentsByQuery(RestTemplate restTemplate, @RequestParam String id) {
        return restTemplate.getForObject("https://jsonplaceholder.typicode.com/comments?postId=" + id, Object.class);
    }

}
