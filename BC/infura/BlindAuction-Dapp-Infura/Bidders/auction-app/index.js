var express = require('express');
var app = express();
app.use(express.static('src'));
app.listen(3000, function () {
  console.log('Bidder : Blind Auction listening on port 3000!');
});