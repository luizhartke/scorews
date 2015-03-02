package com.battycode.scorews.dto;

public class Score {

	private final long id;
	private final long userId;
	private final long bestScore;

	public Score(long id, long userId, long bestScore) {
		this.id = id;
		this.userId = userId;
		this.bestScore = bestScore;
	}

	public long getId() {
		return this.id;
	}


	public long getUserId() {
		return this.userId;
	}


	public long getBestScore() {
		return this.bestScore;
	}

}
