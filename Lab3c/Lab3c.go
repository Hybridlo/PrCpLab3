package main

import (
	"sync"
)

func main() {
	var wg sync.WaitGroup

	wg.Add(4)

	t := NewTable()
	s0 := NewSmoker(&t, 0)
	s1 := NewSmoker(&t, 1)
	s2 := NewSmoker(&t, 2)
	i := NewIntermediary(&t)
	go i.run(&wg)
	go s0.run(&wg)
	go s1.run(&wg)
	go s2.run(&wg)

	wg.Wait()
}