package com.markpeng.Todolist.model.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import lombok.Data;

@Entity
@Table
@Data
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column
    String task;

    @Column(insertable = false, columnDefinition = "bool default false")
    Boolean status;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    Date createTime = new Date();

    @LastModifiedDate
    @Column(nullable = false)
    Date updateTime = new Date();

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "todos_tag", joinColumns = { @JoinColumn(name = "todo_id") }, inverseJoinColumns = {
            @JoinColumn(name = "tag_id") })
    Set<Tag> tags;
}
