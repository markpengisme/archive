package main

import "fmt"

type Liters float64
type Gallons float64
type Milliliters float64

func (m MyType) sayHi(s string) (string, string) {
	fmt.Println("Hi from", m)
	fmt.Println(s)
	return "Hello", "World"
}

func (l Liters) ToGallons() Gallons {
	return Gallons(l * 0.264)
}

func (g Gallons) ToLiters() Liters {
	return Liters(g * 3.785)
}

func (g Gallons) ToMilliliters() Milliliters {
	return Milliliters(g * 3785.41)
}

type Number int

func (n *Number) double() {
	*n *= 2
}

type MyType string

func (m MyType) method() {
	fmt.Println("Method with value recevier")
}

func (m *MyType) pointerMethod() {
	fmt.Println("Method with pointer recevier")
}

func main() {
	fmt.Println(Gallons(5.2) + Gallons(2.2))
	fmt.Println(Gallons(5.2) - Gallons(2.2))
	fmt.Println(Liters(3.2) * Liters(2.3))
	fmt.Println(Liters(4.4) / Liters(2.2))
	fmt.Println(Milliliters(1.3) == Milliliters(1.3))
	fmt.Println(Milliliters(1) < Milliliters(2))
	fmt.Println(Milliliters(3) > Milliliters(1.3))

	fmt.Println(Liters(2) / 2)
	// fmt.Println(Liters(2) * Gallons(2)) // mismatched types error

	value := MyType("a MyType value")
	a, b := value.sayHi("...")
	fmt.Println(a, b)

	carFuel := Gallons(10.0)
	busFuel := Liters(240.0)
	fmt.Println(carFuel, "Gallons =", carFuel.ToLiters(), "Liters")
	fmt.Println(carFuel, "Gallons = ", carFuel.ToMilliliters(), "Milliliters")
	fmt.Println(busFuel, "Liters = ", busFuel.ToGallons(), "Gallons")

	num := Number(2)
	num.double()
	fmt.Println(num)

	value = MyType("a value")
	pointer := &value
	value.method()
	value.pointerMethod()
	pointer.method()
	pointer.pointerMethod()

}
