package main

import (
	"fmt"
	"headfirstgo/ch07/datafile"
	"log"
	"sort"
)

func main() {
	lines, err := datafile.GetStrings("votes.txt")
	if err != nil {
		log.Fatal(err)
	}
	counts := make(map[string]int)
	names := make([]string, 0)
	for _, line := range lines {
		counts[line]++
	}
	for name := range counts {
		names = append(names, name)
	}
	sort.Strings(names)
	for _, name := range names {
		fmt.Printf("Votes for %s: %d\n", name, counts[name])
	}
}
