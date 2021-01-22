package com.machinecoding.machinecoding.Controller;

import com.machinecoding.machinecoding.Exception.NewsException;
import com.machinecoding.machinecoding.Model.Articles;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class NewsController {
    String baseUrl = "http://newsapi.org/v2/";
    @GetMapping("/top-headlines")
    public ResponseEntity<Articles> getHeadLines(@RequestParam("country") String country,
                                                 @RequestParam("category") String category,
                                                 @RequestParam("apiKey") String apiKey
                                                 ) throws NewsException {
        if( country == null || category == null || apiKey == null){
            //throw bad reques
        }

        String headLineUrl=   baseUrl + "top-headlines"+ "?country="+country + "&category="+category + "&apiKey="+apiKey;



        RestTemplate restTemplate = new RestTemplate();
        URI uri;
        try {
             uri = new URI(headLineUrl);
        } catch (URISyntaxException e) {
            throw new NewsException("URI exception");
        }

        ResponseEntity<Articles> result = restTemplate.getForEntity(uri, Articles.class);

        //return new ResponseEntity<>(result, HttpStatus.OK);

        return result;
    }

    @GetMapping("/everything")
    public ResponseEntity<Articles> getEverything(@RequestParam("q") String q,
                                                 @RequestParam("from") String from,
                                                 @RequestParam("sortBy") String sortBy,
                                                 @RequestParam("apiKey") String apiKey) throws NewsException {
        if( q == null || from == null || apiKey == null){
            //throw bad reques
        }

        String headLineUrl =   baseUrl + "everything"+ "?q="+q + "&from="+from + "&sortBy=" + sortBy+ "&apiKey="+apiKey;


        RestTemplate restTemplate = new RestTemplate();
        URI uri;
        try {
            uri = new URI(headLineUrl);
        } catch (URISyntaxException e) {
            throw new NewsException("URI exception");
        }

        ResponseEntity<Articles> result = restTemplate.getForEntity(uri, Articles.class);

        //return new ResponseEntity<>(result, HttpStatus.OK);

        return result;
    }

    @GetMapping("/sources")
    public ResponseEntity<Articles> getSourcess(@RequestParam("sources") String sources,
                                                 @RequestParam("apiKey") String apiKey
    ) throws NewsException {
        if( sources == null || apiKey == null){
            //throw bad reques
        }

        String headLineUrl=   baseUrl + "top-headlines"+ "?sources="+sources + "&apiKey="+apiKey;



        RestTemplate restTemplate = new RestTemplate();
        URI uri;
        try {
            uri = new URI(headLineUrl);
        } catch (URISyntaxException e) {
            throw new NewsException("URI exception");
        }

        ResponseEntity<Articles> result = restTemplate.getForEntity(uri, Articles.class);

        //return new ResponseEntity<>(result, HttpStatus.OK);

        return result;
    }
}
