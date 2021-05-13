package me.elb1to.parcial1.Prom1.team.impl;

import me.elb1to.parcial1.Prom1.team.BasketballTeam;

/**
 * Created by Elb1to
 * Project: DS3
 * Date: 5/11/2021 @ 10:15 AM
 */
public class BasketballPlayer extends BasketballTeam {

	private int uniformNumber;
	private String playerName;
	private int pointsScored;

	public void setUniformNumber(int uniformNumber) {
		this.uniformNumber = uniformNumber;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getPointsScored() {
		return pointsScored;
	}

	public void setPointsScored(int pointsScored) {
		this.pointsScored = pointsScored;
	}
}
