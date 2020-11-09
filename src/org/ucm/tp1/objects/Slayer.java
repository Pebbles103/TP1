package org.ucm.tp1.objects;

import org.ucm.tp1.logic.Game;

public class Slayer {

	private int x,y;
	private int hp= 3;
	private Game game;
	private boolean alive;
	private int COST= 50;
	private int DMG = 1;
	
	//Constructor
	public Slayer(Game game, int x, int y) {
		this.x=x;
		this.y=y;
		this.game = game;
		this.alive = true;
		
	}
	
	public boolean isAlive() {
		if (this.hp <= 0) {
			this.alive = false;
			}
	return this.alive;	
	}
	
	public void decreaseHP(int dmg) {
		this.hp= this.hp - dmg;
	}
	
	
	public String toString(){
		String s = "S ["+this.hp+"]";
		return s;
				
	}
	
	public void attack() { 
		int coord = this.x+1;
		boolean atacado = false;
		
		while(!atacado && coord < this.game.level.dimensionx()) {
			int dmg = this.DMG;
			atacado = this.game.attackSlayer(coord,this.y,dmg);
			coord++;
		}
	}
	
	public int getHP() {
		return this.hp;
	}
	
	public int getSx(){
		return this.x;	
	}
	public int getSy(){
		return this.y;	
	}
}
