// variable & constant
let name: string = 'John'
let age: number = 25
let active: boolean = true
// array
let scores: (string | number)[] = ['Programming', 5, 'Software Design', 4]
// tuple
let skill: [string, number] = ['Programming', 5]
let bgColor, headerColor: [number, number, number, number?]
bgColor = [0, 255, 255, 0.5]
headerColor = [0, 255, 255]

// object
let person: {
    name: string
    age: number
} = {
    name: 'John',
    age: 25
}

// function
function add(x: number, y: number): number {
    return x + y
}
let greeting = (name: string): string => {
    return `Hi ${name}`
}
let double: (num: number) => number
double = (num) => num * 2

// enum
enum Month {
    Jan,
    Feb,
    Mar,
    Apr,
    May,
    Jun,
    Jul,
    Aug,
    Sep,
    Oct,
    Nov,
    Dec
}

function isItSummer(month: Month) {
    let isSummer: boolean
    switch (month) {
        case Month.Jun:
        case Month.Jul:
        case Month.Aug:
            isSummer = true
            break
        default:
            isSummer = false
            break
    }
    return isSummer
}
console.log(isItSummer(Month.Jun))

export {}
