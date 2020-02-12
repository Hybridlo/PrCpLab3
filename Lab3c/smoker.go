package main

import (
	"fmt"
	"time"
	"sync"
)

type Smoker struct {
	t *Table
	has int
}

func NewSmoker(t *Table, has int) Smoker {
	s := Smoker{t, has}
	return s
}

func (s Smoker) run(wg *sync.WaitGroup) {
	defer wg.Done()

	for {
		switch s.has {
		case 0:
			s.t.getMatchesAndPaper()
			fmt.Printf("Smoker took matches and paper\n")
		case 1:
			s.t.getPaperAndTobacco()
			fmt.Printf("Smoker took paper and tobacco\n")
		case 2:
			s.t.getTobaccoAndMatches()
			fmt.Printf("Smoker took tobacco and matches\n")
		}
		time.Sleep(5 * time.Second)
		s.t.smoking = false
		fmt.Printf("Smoker finished smoking\n\n")
	}
}