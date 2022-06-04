import React from 'react'
import { useState } from 'react'

const TodoForm = ({handleAdd}) => {
    const [toDoText, setToDoText] = useState('')

    const onInputChange = (event) => {
        const value = event.target.value
        setToDoText(value)
    }
    const onHandleSubmit = () => {
        setToDoText("")
    }

    return (
    <div className="header">
        <input type="text" id="todoInput" name="todoInput" value={toDoText} placeholder="New Item..." onChange={onInputChange}/>
        <button type="submit" className="addBtn" onClick={()=> {handleAdd(toDoText); onHandleSubmit()}}>
            Add
        </button>
    </div>
    )
}

export default TodoForm