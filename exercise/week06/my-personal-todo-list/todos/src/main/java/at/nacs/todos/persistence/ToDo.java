package at.nacs.todos.persistence;

import lombok.Data;

@Data
public class ToDo {
    private String id;
    private String title;
    private boolean done;

}
