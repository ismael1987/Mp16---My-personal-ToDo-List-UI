package com.Mp9MyPersonalToDoList.Mp9MyPersonalToDoList.controller;

import com.Mp9MyPersonalToDoList.Mp9MyPersonalToDoList.persistence.ToDo;
import com.Mp9MyPersonalToDoList.Mp9MyPersonalToDoList.persistence.ToDoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EndPoint {

    private ToDoRepository toDoRepository;

    public EndPoint(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }
    @GetMapping("/todo")
    List<ToDo> getalltodos(){
       return toDoRepository.findAll();
    }


    @PostMapping("/todo")
    void setToDo(@RequestBody ToDo toDo){
        toDoRepository.save(toDo);
    }

    @PostMapping("/{id}/done")
    void workdone(@PathVariable String id){
        System.out.println(id);
        ToDo toDo =toDoRepository.findById(id).get();
        toDo.setDone(true);
        toDoRepository.save(toDo);
        //return toDo;
    }

    @PostMapping("/{id}/undone")
    void workundone(@PathVariable String id){
        System.out.println(id);

        ToDo toDo = toDoRepository.findById(id).get();
        toDo.setDone(false);
        toDoRepository.save(toDo);
        //return toDo;
    }

    @PostMapping("/addToList")
    void newElement(@RequestBody String toDo) {
        System.out.println(toDo);
        ToDo toDo1 = new ToDo();
        toDo1.setTask(toDo);
        toDo1.setDone(false);
        toDoRepository.save(toDo1);
    }

    @PostMapping("/{id}/moveElement")
    void moveElement(@PathVariable String id){
        System.out.println(id);
        ToDo toDo2 = toDoRepository.findById(id).get();
        toDoRepository.delete(toDo2);
    }


}
