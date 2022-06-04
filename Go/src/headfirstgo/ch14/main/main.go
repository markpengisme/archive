package main

import (
	"fmt"
	"headfirstgo/ch14/join"
)

func main() {
	phrases := []string{"my parents", "a rodeo clown"}
	fmt.Println("A photo of", join.JoinWithCommas(phrases))
	phrases = []string{"my parents", "a rodeo clown", "a prize bull"}
	fmt.Println("A photo of", join.JoinWithCommas(phrases))
}
