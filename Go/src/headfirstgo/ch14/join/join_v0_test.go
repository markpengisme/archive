package join

import (
	"fmt"
	"testing"
)

func TestTwoElementsV0(t *testing.T) {
	list := []string{"apple", "orange"}
	got := JoinWithCommasV0(list)
	want := "apple and orange"
	if got != want {
		t.Errorf(errorStringV0(list, got, want))
	}
}

func TestThreeElementsV0(t *testing.T) {
	list := []string{"apple", "orange", "pear"}
	got := JoinWithCommasV0(list)
	want := "apple, orange, and pear"
	if got != want {
		t.Errorf(errorStringV0(list, got, want))
	}
}

func errorStringV0(list []string, got string, want string) string {
	return fmt.Sprintf("JoinWithCommas(%#v) = \"%s\", want \"%s\"",
		list, got, want)
}
