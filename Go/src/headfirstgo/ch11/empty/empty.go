package empty

import "fmt"

type Whistle string

func (w Whistle) MakeSound() {
	fmt.Println("Tweet!")
}

func AcceptAnything(thing interface{}) {
	fmt.Println(thing)
	whistle, ok := thing.(Whistle)
	if ok {
		whistle.MakeSound()
	}
}
