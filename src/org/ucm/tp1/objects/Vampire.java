package org.ucm.tp1.objects;


import java.util.Random;
import org.ucm.tp1.logic.Game;
import org.ucm.tp1.logic.Level;

public class Vampire {
	private int x;
	private int y;
	private int hp= 5;
	private Game game;
	private static int DMG=1; 
	private static int MOV = 1; 
	private int pasoSig;
	private static Level level = null;
	private static int vampirosDentro = 0;
	private static int vampirosRestantes;
	boolean alive;
	
	
	public Vampire(Game game,int x, int y) {
		this.x=x;
		this.y=y;
		this.game = game;
		this.alive = true;
		this.pasoSig = Vampire.MOV + 1;
		Vampire.vampirosRestantes--;
		Vampire.vampirosDentro++;
	}
	
	
	public static void startLevel(Level level) {
		if(Vampire.level == null) {
			Vampire.level = level;
			vampirosRestantes = level.getN();
		}
	}
	
	public static int VRest() {
		return Vampire.vampirosRestantes;
	}
	
	public static int VDentro() {
		return Vampire.vampirosDentro;
	}
	
	public static boolean doesAdd(Random rand) {
		return (rand.nextDouble() <= Vampire.level.getF());
	}
	
	public boolean isAlive() {		
		if (this.hp <= 0) {
			Vampire.vampirosDentro--;
			this.alive = false;
		}
	return this.alive;	
	}
	
	public void decreaseHP(int dmg) {
		this.hp= this.hp - dmg;
	}
	
	public int getHP() {
		return this.hp;
	}
	
	public void move() {
		if(this.pasoSig <= 0) {
			this.x --;
			this.pasoSig = Vampire.MOV;
			if(this.x < 0) {
				this.game.setGameOver(true);
			}
		}else {
			this.pasoSig--;
		}
		
	}
	
	public void attack() {
		this.game.attackVampire(this.x-1,this.y,Vampire.DMG);
	}
	
	public String toString(){
		String s = "V ["+this.hp+"]";
		return s;	
	}
	
	public static boolean hayVampRestantes() {
		return(Vampire.vampirosRestantes > 0);
	}
	
	public int getVx() {
		return this.x;
	}
	
	public int getVy() {	
		return this.y;
	}
	
}
