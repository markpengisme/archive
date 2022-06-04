package main

import (
	"fmt"
	"reflect"
)

func add1(num int) {
	num++
}

func add2(ptr *int) {
	*ptr++
}

func outOfFunc() *int {
	num := 87
	return &num
}

func main() {
	myInt := 6
	myIntPointer := &myInt
	fmt.Println(reflect.TypeOf(myInt), myInt)
	fmt.Println(reflect.TypeOf(myIntPointer), myIntPointer)

	add1(myInt)
	fmt.Printf("add1(myInt) 6 -> %d\n", myInt)
	add2(myIntPointer)
	fmt.Printf("add2(myIntPointer) 6 -> %d\n", myInt)
	num := outOfFunc()
	fmt.Printf("num = %d\n", *num)
}
