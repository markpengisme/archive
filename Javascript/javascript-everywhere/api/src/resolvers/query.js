module.exports = {
  hello: () => 'Hello world',
  notes: async (parent, args, { models }) => {
    return await models.Note.find().limit(100)
  },
  note: async (parent, args, { models }) => {
    return await models.Note.findById(args.id)
  },
  noteFeed: async (parent, { cursor }, { models }) => {
    const limit = 10
    let hasNextPage = false
    let cursorQuery = {}

    if (cursor) {
      cursorQuery = { _id: { $lt: cursor } }
    }

    let notes = await models.Note.find(cursorQuery)
      .sort({ _id: -1 })
      .limit(limit + 1)

    if (notes.length > limit) {
      hasNextPage = true
      notes = notes.slice(0, -1)
    }

    let newCursor = ''
    if (notes.length !== 0) {
      newCursor = notes[notes.length - 1]._id
    }

    return {
      notes,
      cursor: newCursor,
      hasNextPage,
    }
  },
  user: async (parent, { username }, { models }) => {
    return await models.User.findOne({ username: username })
  },
  users: async (parent, args, { models }) => {
    return await models.User.find().limit(100)
  },
  me: async (parent, args, { models, user }) => {
    return await models.User.findById(user.id)
  },
}
