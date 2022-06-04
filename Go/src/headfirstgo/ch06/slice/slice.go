package main

import "fmt"

func inRange(min float64, max float64, numbers ...float64) []float64 {
	var result []float64
	for _, number := range numbers {
		if number >= min && number <= max {
			result = append(result, number)
		}
	}
	return result
}
func main() {
	var notes []string
	notes = make([]string, 7)
	primes := make([]int, 5)
	odds := []int{1, 3, 5}
	notes[3] = "!"
	fmt.Println(notes[3])
	fmt.Println(primes)
	fmt.Println(odds)

	myArray := [5]int{1, 2, 3, 4, 5}
	mySlice := myArray[1:4]
	fmt.Println(mySlice, len(mySlice))
	for _, element := range mySlice {
		fmt.Print(element, ",")
	}
	fmt.Println()
	fmt.Println(inRange(1, 100, -123, 456, 10))
	fmt.Println(inRange(1, 100, -231, 23, 45, 67, 89))
}
