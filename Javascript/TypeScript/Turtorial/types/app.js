"use strict";
exports.__esModule = true;
// variable & constant
var name = 'John';
var age = 25;
var active = true;
// array
var scores = ['Programming', 5, 'Software Design', 4];
// tuple
var skill = ['Programming', 5];
var bgColor, headerColor;
bgColor = [0, 255, 255, 0.5];
headerColor = [0, 255, 255];
// object
var person = {
    name: 'John',
    age: 25
};
// function
function add(x, y) {
    return x + y;
}
var greeting = function (name) {
    return "Hi ".concat(name);
};
var double;
double = function (num) { return num * 2; };
// enum
var Month;
(function (Month) {
    Month[Month["Jan"] = 0] = "Jan";
    Month[Month["Feb"] = 1] = "Feb";
    Month[Month["Mar"] = 2] = "Mar";
    Month[Month["Apr"] = 3] = "Apr";
    Month[Month["May"] = 4] = "May";
    Month[Month["Jun"] = 5] = "Jun";
    Month[Month["Jul"] = 6] = "Jul";
    Month[Month["Aug"] = 7] = "Aug";
    Month[Month["Sep"] = 8] = "Sep";
    Month[Month["Oct"] = 9] = "Oct";
    Month[Month["Nov"] = 10] = "Nov";
    Month[Month["Dec"] = 11] = "Dec";
})(Month || (Month = {}));
function isItSummer(month) {
    var isSummer;
    switch (month) {
        case Month.Jun:
        case Month.Jul:
        case Month.Aug:
            isSummer = true;
            break;
        default:
            isSummer = false;
            break;
    }
    return isSummer;
}
console.log(isItSummer(Month.Jun));
