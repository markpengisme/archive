package main

import (
	"fmt"
	"headfirstgo/ch08/magazine"
)

func main() {
	var myStruct struct {
		name string
		age  int
	}
	myStruct.name = "Mark"
	myStruct.age = 99
	fmt.Println("")

	type book struct {
		name  string
		price int
	}
	var mag book
	mag.name = "Hello World"
	mag.price = 99
	fmt.Println("")

	test := magazine.Subscriber{
		Name:   "Test",
		Rate:   1,
		Active: true,
		Address: magazine.Address{
			Street:     "Test",
			City:       "Test",
			State:      "Test",
			PostalCode: "Test"}}
	magazine.SubscriberDeactive(&test)
	magazine.PrintInfo(&test)
	fmt.Println("")

	markPtr := magazine.DefaultSubscriber("Mark")
	markPtr.Rate = 0.01
	magazine.SubscriberDeactive(markPtr)
	magazine.PrintInfo(markPtr)
	fmt.Println("")

	subscriber := magazine.Subscriber{Name: "Alice"}
	subscriber.Address.Street = "123 Oak St"
	subscriber.Address.City = "Omaha"
	subscriber.Address.State = "NE"
	subscriber.Address.PostalCode = "68111"
	fmt.Println("Street:", subscriber.Address.Street)
	fmt.Println("City:", subscriber.Address.City)
	fmt.Println("State:", subscriber.Address.State)
	fmt.Println("Postal Code:", subscriber.Address.PostalCode)
	fmt.Println("")

	employee := magazine.Employee{Name: "Bob"}
	employee.Street = "456 Elm St"
	employee.City = "Portland"
	employee.State = "OR"
	employee.PostalCode = "97222"
	fmt.Println("Street:", employee.Street)
	fmt.Println("City:", employee.City)
	fmt.Println("State:", employee.State)
	fmt.Println("Postal Code:", employee.PostalCode)

}
