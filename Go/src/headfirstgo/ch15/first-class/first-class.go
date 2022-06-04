package main

import "fmt"

func sayHi() {
	fmt.Println("Hi")
}

func sayBye() {
	fmt.Println("Bye")
}

func divide(a int, b int) float64 {
	return float64(a) / float64(b)
}
func multiply(a int, b int) float64 {
	return float64(a * b)
}

func doGreeting(passedFunction func()) {
	passedFunction()
}

func doMath(passedFunction func(int, int) float64) {
	result := passedFunction(4, 2)
	fmt.Println(result)
}
func main() {
	var greeterFunction func()
	var mathFunction func(int, int) float64
	greeterFunction = sayHi
	greeterFunction()
	greeterFunction = sayBye
	greeterFunction()
	mathFunction = divide
	fmt.Println(mathFunction(4, 2))
	mathFunction = multiply
	fmt.Println(mathFunction(4, 2))

	doGreeting(sayHi)
	doGreeting(sayBye)
	doMath(divide)
	doMath(multiply)
}
