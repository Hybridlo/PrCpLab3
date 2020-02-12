package main

import (
	"golang.org/x/sync/semaphore"
	"context"
)

type Table struct {
	ctx context.Context
	tobacco *semaphore.Weighted
	matches *semaphore.Weighted
	paper *semaphore.Weighted
	smoking bool
}

func NewTable() Table {
	t := Table { context.Background(),
		semaphore.NewWeighted(int64(1)),
		semaphore.NewWeighted(int64(1)),
		semaphore.NewWeighted(int64(1)),
		false,
	}

	t.tobacco.Acquire(t.ctx, 1)
	t.matches.Acquire(t.ctx, 1)
	t.paper.Acquire(t.ctx, 1)

	return t
}

func (t Table) putTobacco() {
	t.tobacco.Release(1)
}

func (t Table) putMatches() {
	t.matches.Release(1)
}

func (t Table) putPaper() {
	t.paper.Release(1)
}

func (t Table) getTobaccoAndMatches() {
	for {
		t.tobacco.Acquire(t.ctx, 1)
		if t.matches.TryAcquire(1) {
			break;
		} else {
			t.tobacco.Release(1)
		}
	}
}

func (t Table) getMatchesAndPaper() {
	for {
		t.matches.Acquire(t.ctx, 1)
		if t.paper.TryAcquire(1) {
			break;
		} else {
			t.matches.Release(1)
		}
	}
}

func (t Table) getPaperAndTobacco() {
	for {
		t.paper.Acquire(t.ctx, 1)
		if t.tobacco.TryAcquire(1) {
			break;
		} else {
			t.paper.Release(1)
		}
	}
}