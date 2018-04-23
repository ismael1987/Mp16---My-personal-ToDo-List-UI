package com.Mp16My.personal.ToDo.List.UI.Mp16.My.personal.ToDo.List.UI;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class Getter {

    List<ToDo> bringTodo(){
        RestTemplate restTemplate = new RestTemplate();
        String todourl = "http://localhost:9000/todo";
        ToDo[] forObject = restTemplate.getForObject(todourl, ToDo[].class);
        Arrays.stream(forObject).forEach(s -> System.out.println(s));
        return Arrays.asList(forObject);
    }
}
