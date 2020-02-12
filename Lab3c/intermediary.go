package main

import (
	"fmt"
	"math/rand"
	"time"
	"sync"
)

type Intermediary struct {
	t *Table
}

func NewIntermediary(t *Table) Intermediary {
	i := Intermediary{t}
	return i
}

func (i Intermediary) run(wg *sync.WaitGroup) {
	defer wg.Done()
	for {
		if !i.t.smoking {
			i.t.smoking = true
			s := rand.NewSource(time.Now().UnixNano())
			r := rand.New(s)

			dontPut := r.Intn(3)

			switch dontPut {
			case 0:
				i.t.putMatches()
				i.t.putPaper()
				fmt.Printf("Intermediary put matches and paper\n")
			case 1:
				i.t.putTobacco()
				i.t.putPaper()
				fmt.Printf("Intermediary put tobacco and paper\n")
			case 2:
				i.t.putTobacco()
				i.t.putMatches()
				fmt.Printf("Intermediary put tobacco and matches\n")
			}
		}
	}
}