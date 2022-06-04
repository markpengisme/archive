package join

import (
	"fmt"
	"testing"
)

func TestOneElementV1(t *testing.T) {
	list := []string{"apple"}
	got := JoinWithCommasV1(list)
	want := "apple"
	if got != want {
		t.Errorf(errorStringV1(list, got, want))
	}
}

func TestTwoElementsV1(t *testing.T) {
	list := []string{"apple", "orange"}
	got := JoinWithCommasV1(list)
	want := "apple and orange"
	if got != want {
		t.Errorf(errorStringV1(list, got, want))
	}
}

func TestThreeElementsV1(t *testing.T) {
	list := []string{"apple", "orange", "pear"}
	got := JoinWithCommasV1(list)
	want := "apple, orange, and pear"
	if got != want {
		t.Errorf(errorStringV1(list, got, want))
	}
}

func errorStringV1(list []string, got string, want string) string {
	return fmt.Sprintf("JoinWithCommas(%#v) = \"%s\", want \"%s\"",
		list, got, want)
}
