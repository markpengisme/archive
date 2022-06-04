package main

import (
	"fmt"
	"log"

	"github.com/markpengisme/Go/src/headfirstgo/ch04/keyboard"
)

func main() {
	fmt.Print("Enter a temparature in Fahrenheit: ")
	fahrenheit, err := keyboard.GetFloat()
	if err != nil {
		log.Fatal(err)
	}
	celsius := (fahrenheit - 32) * 5 / 9
	fmt.Printf("%0.2f degrees Celsius\n", celsius)
}
