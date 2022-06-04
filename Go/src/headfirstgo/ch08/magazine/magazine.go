package magazine

import "fmt"

type Subscriber struct {
	Name   string
	Rate   float64
	Active bool
	Address
}

type Employee struct {
	Name   string
	Salary float64
	Address
}

type Address struct {
	Street     string
	City       string
	State      string
	PostalCode string
}

func DefaultSubscriber(name string) *Subscriber {
	var s Subscriber
	s.Name = name
	s.Rate = 5.99
	s.Active = true
	return &s
}

func SubscriberDeactive(s *Subscriber) {
	// (*s).Active = false
	s.Active = false
}

func PrintInfo(s *Subscriber) {
	fmt.Println("Name:", s.Name)
	fmt.Println("Rate:", s.Rate)
	fmt.Println("Active:", s.Active)
	fmt.Println("Street:", s.Street)
	fmt.Println("City:", s.City)
	fmt.Println("State:", s.State)
	fmt.Println("PostalCode:", s.PostalCode)
}
