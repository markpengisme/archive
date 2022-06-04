const uri = process.env.API_URI
const handleResponse = (response) => {
  return response.text().then((res) => {
    console.log(res)
    if (!response.ok) {
      console.log(response)
      return Promise.reject(res)
    } else if (res !== '') {
      res = JSON.parse(res)
      return res
    }
  })
}
const getTodos = () => {
  const requestOptions = {
    method: 'GET',
    headers: { 'Content-Type': 'application/json' },
  }

  return fetch(`${uri}/todo`, requestOptions)
    .then(handleResponse)
    .then((res) => {
      return res.data
    })
    .catch((err) => {
      alert(err)
      return []
    })
}

const createTodos = (data) => {
  const requestOptions = {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(data),
  }

  return fetch(`${uri}/todo`, requestOptions)
    .then(handleResponse)
    .then((res) => {
      return res.data
    })
    .catch((err) => alert(err))
}

const updateTodos = (id, data) => {
  const requestOptions = {
    method: 'PUT',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(data),
  }

  return fetch(`${uri}/todo/${id}`, requestOptions)
    .then(handleResponse)
    .catch((err) => alert(err))
}

const deleteTodos = (id) => {
  const requestOptions = {
    method: 'DELETE',
    headers: { 'Content-Type': 'application/json' },
  }

  return fetch(`${uri}/todo/${id}`, requestOptions)
    .then(handleResponse)
    .catch((err) => alert(err))
}

export const todoServices = {
  getTodos,
  createTodos,
  updateTodos,
  deleteTodos,
}
