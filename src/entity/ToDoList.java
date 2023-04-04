package entity;

public class ToDoList {

    private String toDo;

    public ToDoList() {
    }

    public ToDoList(String toDo) {
        this.toDo = toDo;
    }

    public String getToDo() {
        return toDo;
    }

    public void setToDo(String toDo) {
        this.toDo = toDo;
    }
}
