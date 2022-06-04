# API

## Query & Mutation examples

- hello
- User
  - query
    - user
    - users
    - me
  - mutation
    - signUp
    - signIn
- Note
  - query
    - note
    - notes
  - mutation
    - newNote
    - updateNote
    - deleteNote
    - toogleFavorite

### hello

```graphql
query {
  hello
}
```

### User

```graphql
query {
  user(username: "Mark") {
    id
    username
    email
    notes {
      content
    }
  }
  users {
    id
    username
    email
    avatar
    notes {
      id
      content
      createdAt
      updatedAt
      favoriteCount
    }
  }
  me {
    id
    username
    email
    favorites {
      id
      content
      createdAt
      updatedAt
      favoriteCount
    }
  }
}
```

```graphql
mutation {
  signUp(username: "Mark", email: "example@example.com", password: "Peng")
}
```

```graphql
mutation {
  signIn(username: "Mark", email: "example@example.com", password: "Peng")
}
```

### note

```graphql
query {
  notes {
    id
    content
    author {
      username
    }
    createdAt
    updatedAt
    favoriteCount
    favoritedBy {
      username
    }
  }
  note(id: "616c1d5339244036ffa36a1d") {
    id
    content
    author {
      id
      username
    }
    createdAt
    updatedAt
    favoriteCount
    favoritedBy {
      id
      username
    }
  }
}
```

```graphql
mutation {
  newNote(content: "This is a new note !!!") {
    id
    content
    author {
      username
    }
    createdAt
    updatedAt
    favoriteCount
  }
}
```

```graphql
mutation {
  updateNote(id: "616c2725f28b5ef3ffba55db", content: "This is a new note~~~") {
    id
    content
    author {
      username
    }
    createdAt
    updatedAt
    favoriteCount
    favoritedBy {
      username
    }
  }
}
```

```graphql
mutation {
  deleteNote(id: "616c2725f28b5ef3ffba55db")
}
```

```graphql
mutation {
  toggleFavorite(id: "616c25ebb4ae8865ae129613") {
    id
    content
    favoriteCount
    favoritedBy {
      username
    }
  }
}
```

## Solutions to some problems

1. mongoose 5.X -> 6.X

   - Error: `useNewUrlParser` is an invalid option
   - [No More Deprecation Warning Options](https://mongoosejs.com/docs/migrating_to_6.html#no-more-deprecation-warning-options)

2. List and not-null in GraphQL([ref](https://graphql-dotnet.github.io/docs/getting-started/lists-non-null/))

   ```js
   myField: [String!]
   myField: null // valid
   myField: [] // valid
   myField: ['a', 'b'] // valid
   myField: ['a', null, 'b'] // error

   myField: [String]!
   myField: null // error
   myField: [] // valid
   myField: ['a', 'b'] // valid
   myField: ['a', null, 'b'] // valid

   myField: [String!]!
   myField: null // error
   myField: [] // valid
   myField: ['a', 'b'] // valid
   myField: ['a', null, 'b'] // error
   ```

3. GraphQL IDE

- [Enabling GraphQL Playground in production](https://www.apollographql.com/docs/apollo-server/v2/testing/graphql-playground/#enabling-graphql-playground-in-production)
- [GraphQL playground application](https://github.com/graphql/graphql-playground)
- [Disable contentSecurityPolicy in Helmet when Dev](https://github.com/graphql/graphql-playground/issues/1283#issuecomment-703631091)
