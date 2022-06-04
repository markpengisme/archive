package main

import (
	"headfirstgo/ch04/greeting"
	"headfirstgo/ch04/greeting/dansk"
	"headfirstgo/ch04/greeting/deutsch"
)

func main() {
	greeting.Hello()
	greeting.Hi()
	deutsch.Hallo()
	deutsch.GutenTag()
	dansk.Hej()
	dansk.GodMorgen()
}
