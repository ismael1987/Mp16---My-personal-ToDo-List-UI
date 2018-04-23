package com.Mp16My.personal.ToDo.List.UI.Mp16.My.personal.ToDo.List.UI;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/")
public class EndPoint {

    private Getter getter;

    private String task;

    public EndPoint(Getter getter) {
        this.getter = getter;
    }

    @GetMapping
    String homepage(){
        return "homepage";
    }

    @ModelAttribute("todos")
    List<ToDo> todos() {
        List<ToDo> toDos = getter.bringTodo();
        return toDos;
    }

    @ModelAttribute("todo")
    ToDo check(){
        return new ToDo();
    }


    @PostMapping("{id}/done")
    String updateToDone(@PathVariable String id){
        System.out.println(id);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity("http://localhost:9000/"+id+"/done",id,String.class);

        return "redirect:/";
    }


    @PostMapping("{id}/undone")
    String updatetoUnDone(@PathVariable String id){
        System.out.println(id);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity("http://localhost:9000/"+id+"/undone",id,String.class);
        return "redirect:/";
    }

    @PostMapping("/addToList")
    String sendText( @RequestParam String todoo) {
        System.out.println(todoo);
        RestTemplate restTemplate= new RestTemplate();
        restTemplate.postForEntity("http://localhost:9000/addToList", todoo, String.class);
        return "redirect:/";
    }

    @PostMapping("/{id}/moveElement")
    String delet(@PathVariable String id){
        RestTemplate restTemplate= new RestTemplate();
        restTemplate.postForEntity("http://localhost:9000/"+id+"/moveElement", id, void.class);
        return "redirect:/";

    }



}
