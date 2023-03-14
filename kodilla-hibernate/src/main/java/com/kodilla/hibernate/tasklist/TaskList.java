package com.kodilla.hibernate.tasklist;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

@Entity
@Table(name = "TASKLISTS")
public class TaskList {

    private int id;
    private String listName;
    private String description;

    public TaskList(int id, String listName, String description) {
        this.id = id;
        this.listName = listName;
        this.description = description;
    }

    public TaskList() {
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "LISTNAME")
    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}