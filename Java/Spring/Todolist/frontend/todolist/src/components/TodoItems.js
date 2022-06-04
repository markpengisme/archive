import React from 'react'

const TodoItems = ({ todos, handleUpdate, handleDelete }) => {
    const done = true
    const notDone = false
    return (
        <ul>
            {todos.map((todo, index) => (
                <li
                    className={todo.status === done ? 'checked' : ''}
                    key={index}
                    onClick={() => {
                        const data = {status: done}
                        if (todo.status === done) {
                            data.status = notDone
                        }
                        handleUpdate(todo.id, data)
                    }}>
                    <span>{todo.task}</span>
                    <span className="close" onClick={(event)=> {
                        event.stopPropagation()
                        handleDelete(todo.id)
                        }}>X
                    </span>
                </li>
            ))}
        </ul>
    )
}

export default TodoItems