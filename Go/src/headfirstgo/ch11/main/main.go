package main

import (
	"fmt"
	"headfirstgo/ch11/empty"
	"headfirstgo/ch11/error"
	"headfirstgo/ch11/gadget"
	"headfirstgo/ch11/stringer"
	"headfirstgo/ch11/toy"
)

func main() {

	var t toy.NoiseMaker
	t = toy.Whistle("W1")
	t.MakeSound()
	t = toy.Horn("H1")
	t.MakeSound()
	t = toy.Robot("R1")
	t.MakeSound()
	// t.Walk() //(x)
	toy.Play(t)
	fmt.Println()

	gadget.TryOut(gadget.TapeRecorder{})
	gadget.TryOut(gadget.TapePlayer{})
	fmt.Println()

	err := error.CheckTemperature(123, 100)
	if err != nil {
		fmt.Println(err)
	}

	fmt.Println(stringer.Gallons(12))
	fmt.Println(stringer.Liters(12))
	fmt.Println(stringer.Milliliters(12))
	fmt.Println()

	empty.AcceptAnything(3.1415)
	empty.AcceptAnything("A string")
	empty.AcceptAnything(true)
	empty.AcceptAnything(empty.Whistle("Toyco Canary"))
}
