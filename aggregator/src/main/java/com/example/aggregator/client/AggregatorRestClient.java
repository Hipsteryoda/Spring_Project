package com.example.aggregator.client;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.example.aggregator.model.Entry;

@Component
public class AggregatorRestClient {

  private RestTemplate restTemplate;

  public AggregatorRestClient(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public Entry getDefinitionFor(String word) {
    String uri = "http://localhost:9091/getWord/" + word;

    Entry result = restTemplate.getForObject(uri, Entry.class);

    return result;
  }

  public List<Entry> getWordsStartingWith(String chars) {

    String uri = "http://localhost:9091/getWordsStartingWith/" + chars;

    ResponseEntity<Entry[]> result = restTemplate.getForEntity(uri, Entry[].class);
    Entry[] entryArray = result.getBody();

    return Arrays.stream(entryArray)
      .collect(Collectors.toList());
  }

  public List<Entry> getWordsEndingWith(String chars) {

    String uri = "http://localhost:9091/getWordsEndingWith/" + chars;

    ResponseEntity<Entry[]> result = restTemplate.getForEntity(uri, Entry[].class);
    Entry[] entryArray = result.getBody();

    return Arrays.stream(entryArray)
      .collect(Collectors.toList());
  }

  public List<Entry> getWordsThatContain(String chars) {

    String uri = "http://localhost:9091/getWordsThatContain/" + chars;

    ResponseEntity<Entry[]> result = restTemplate.getForEntity(uri, Entry[].class);
    Entry[] entryArray = result.getBody();

    return Arrays.stream(entryArray)
      .collect(Collectors.toList());
  }

  public List<Entry> getWordsThatContainConsecutiveLetters() {

    String uri = "http://localhost:9091/getWordsThatContainConsecutiveLetters";

    ResponseEntity<Entry[]> result = restTemplate.getForEntity(uri, Entry[].class);
    Entry[] entryArray = result.getBody();

    return Arrays.stream(entryArray)
      .collect(Collectors.toList());
  }
}
