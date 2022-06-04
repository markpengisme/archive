import React from 'react'
import ReactDOM from 'react-dom'
import Todo from './pages/Todo'

const App = () => {
  return (
    <>
      <Todo></Todo>
    </>
  )
}

ReactDOM.render(<App />, document.getElementById('root'))
