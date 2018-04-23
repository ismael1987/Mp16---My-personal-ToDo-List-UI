package com.Mp9MyPersonalToDoList.Mp9MyPersonalToDoList.initialise;

import com.Mp9MyPersonalToDoList.Mp9MyPersonalToDoList.persistence.ToDo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service

public class Starter {


    private List<ToDo> toDos = new ArrayList<>();


    public void add(ToDo todo) {
        toDos.add(todo);
    }

    public List<ToDo> findAll() {
        return new ArrayList<>(toDos);
    }
}
