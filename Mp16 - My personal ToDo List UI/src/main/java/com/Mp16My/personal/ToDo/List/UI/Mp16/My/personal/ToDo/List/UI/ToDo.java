package com.Mp16My.personal.ToDo.List.UI.Mp16.My.personal.ToDo.List.UI;


public class ToDo {
    private String id;
    private String task;
    private boolean done;

    public ToDo(String id, String task, boolean done) {
        this.id = id;
        this.task = task;
        this.done = done;
    }

    public ToDo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
    @Override
    public String toString() {
        return "Applicant{" +
                "id='" + id + '\'' +
                ", task='" + task + '\'' +
                ", done='" + done + '\'' +

                '}';
    }
}
