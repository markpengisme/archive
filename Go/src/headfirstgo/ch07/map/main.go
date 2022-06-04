package main

import "fmt"

func main() {
	var ranks map[string]int
	ranks = make(map[string]int)
	isPrime := make(map[int]bool)
	elements := map[string]string{"H": "Hello", "W": "World"}

	ranks["gold"] = 0
	ranks["silver"] = 1
	ranks["bronze"] = 2

	isPrime[4] = false
	isPrime[7] = true

	fmt.Println(ranks)
	fmt.Println(isPrime)
	fmt.Println(elements)

	var empty1 map[string]int
	empty2 := map[string]int{}
	fmt.Printf("%#v\n", empty1)
	fmt.Printf("%#v\n", empty2)

	value, ok := ranks["gold"]
	fmt.Printf("[gold] rank: %d, ok: %v\n", value, ok)
	value, ok = ranks["silver"]
	fmt.Printf("[silver] rank: %d, ok: %v\n", value, ok)
	value, ok = ranks["iron"]
	fmt.Printf("[iron] rank: %d, ok: %v\n", value, ok)

	value, ok = ranks["bronze"]
	fmt.Printf("[bronze] rank: %d, ok: %v\n", value, ok)
	delete(ranks, "bronze")
	value, ok = ranks["bronze"]
	fmt.Printf("[bronze] rank: %d, ok: %v\n", value, ok)

}
