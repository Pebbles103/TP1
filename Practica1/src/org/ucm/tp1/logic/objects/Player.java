package org.ucm.tp1.logic.objects;

import org.ucm.tp1.logic.Game;

public class Player {
	private int coins;
	Game game;
	
	public Player(Game game) {
		this.game = game;
		this.coins = 50;
	}
	
	
	public int getCoins() {
		// TODO Auto-generated method stub
		return coins;
	}

	public void addCoins(int coins) {
		// TODO Auto-generated method stub
		this.coins += coins;
	}


	public void DecreaseCoins(int coins) {
		// TODO Auto-generated method stub
		this.coins -= coins;
		
	}
}
