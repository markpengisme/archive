require('dotenv').config()
const express = require('express')
const { ApolloServer } = require('apollo-server-express')
const jwt = require('jsonwebtoken')
const helmet = require('helmet')
const cors = require('cors')
const depthLimit = require('graphql-depth-limit')
const { createComplexityLimitRule } = require('graphql-validation-complexity')

const typeDefs = require('./schema')
const resolvers = require('./resolvers')
const db = require('./db')
const models = require('./models')

const port = process.env.PORT || 4000
const DB_HOST = process.env.DB_HOST
const getUser = (token) => {
  if (token) {
    try {
      return jwt.verify(token, process.env.JWT_SECRET)
    } catch (err) {
      throw new Error('Session invalid')
    }
  }
}

const app = express()
app.use(
  helmet({
    contentSecurityPolicy:
      process.env.NODE_ENV === 'production' ? undefined : false,
  })
)
app.use(cors())

db.connect(DB_HOST)
const server = new ApolloServer({
  typeDefs,
  resolvers,
  validationRules: [depthLimit(5), createComplexityLimitRule(1000)],
  context: ({ req }) => {
    const token = req.headers.authorization
    const user = getUser(token)
    return { models, user }
  },
})
server.applyMiddleware({ app, path: '/api' })

app.get('/', (req, res) => res.send('Hello World!!!'))

app.listen(port, () => {
  console.log(`Server running at http://localhost:${port}`)
  console.log(
    `GraphQL Server running at http://localhost:${port}${server.graphqlPath}`
  )
})
