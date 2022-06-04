import React from 'react'
import { useState, useEffect } from 'react'

import TitleBox from '../components/TitleBox'
import TodoForm from '../components/TodoForm'
import TodoItems from '../components/TodoItems'
import { todoServices } from '../services/todo'


const Todo = () => {
    const [todos, setTodos] = useState([])

    useEffect(() => {
        todoServices.getTodos().then((data) => {
            setTodos(data)
        })
    }, [])

    const handleAdd = (text) => {
        const todo = {
            task: text,
        }
        todoServices.createTodos(todo).then((data) => {
            todo.id = data.id;
            todo.status = false; 
            todos.push(todo)
            setTodos([...todos])
        })
    }

    const handleUpdate = (id, data) => {
        todoServices.updateTodos(id, data).then((res) => {
            const mapTodos = todos.map((todo) => {
                if (todo.id === id) {
                    todo.status = data.status
                }
                return todo
            })
            setTodos(mapTodos)
        })
    }

    const handleDelete = (id) => {
        todoServices.deleteTodos(id).then((res) => {
            todos.forEach((todo, index) => {
                if (todo.id === id) {
                    todos.splice(index, 1)
                }
            })
            setTodos([...todos])
        })
    }

    return (
        <div className="container">
            <TitleBox/>
            <div className="todo-box">
                <TodoForm handleAdd={handleAdd} />
                <TodoItems todos={todos} handleUpdate={handleUpdate} handleDelete={handleDelete} />
            </div>
        </div>
    )
}

export default Todo