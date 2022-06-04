package main

import (
	"fmt"
	"log"
	"os"
	"strconv"
)

func average(numbers ...float64) float64 {
	var sum float64 = 0
	for i := 0; i < len(numbers); i++ {
		fmt.Println(i, numbers[i])
	}
	for _, number := range numbers {
		sum += number
	}
	sampleCount := float64(len(numbers))
	return sum / sampleCount
}

func main() {
	arguments := os.Args[1:]
	var numbers []float64
	for _, argument := range arguments {
		number, err := strconv.ParseFloat(argument, 64)
		if err != nil {
			log.Fatal(err)
		}
		numbers = append(numbers, number)
	}

	fmt.Printf("Average: %0.2f\n", average(numbers...))
}
