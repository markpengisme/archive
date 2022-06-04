const b = require('./b')
const printA = () => 'A'
const printB = () => b.printB()
const printC = () => 'C'

module.exports = { printA, printB }
