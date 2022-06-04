package join

import (
	"testing"
)

type testData struct {
	list []string
	want string
}

func TestJoinWithCommasV2(t *testing.T) {
	tests := []testData{
		testData{list: []string{}, want: ""},
		testData{list: []string{"apple"}, want: "apple"},
		testData{list: []string{"apple", "orange"}, want: "apple and orange"},
		testData{list: []string{"apple", "orange", "pear"}, want: "apple, orange, and pear"},
	}
	for _, test := range tests {
		got := JoinWithCommasV2(test.list)
		if got != test.want {
			t.Errorf("JoinWithCommas(%#v) = \"%s\", want \"%s\"", test.list, got, test.want)
		}
	}
}
