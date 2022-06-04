package com.markpeng.Todolist.model.entity;

import java.util.Set;
import javax.persistence.*;

@Entity
@Table
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column
    public String tag;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "tags")
    Set<Todo> todos;
}
