package org.ucm.tp1.logic;


import java.util.Random;

import org.ucm.tp1.objects.Player;
import org.ucm.tp1.objects.Vampire;
import org.ucm.tp1.utils.GameObjectBoard;
import org.ucm.tp1.view.GamePrinter;

public class Game {
	
	public Long seed;
	public Level level;
	public GameObjectBoard board;
	private int x;
	private int y;
	private GamePrinter printer;
	private Random rand;
	private Player player;
	private int contadorCiclos;
	private boolean GameOver;
	
	
	public Game(long seed, Level level) {
		//falta todo
		this.seed = seed;
		this.level = level;
		this.x = this.level.dimensionx();
		this.y = this.level.dimensiony();
		this.printer = new GamePrinter(this, this.x, this.y);
		Vampire.startLevel(level);
		this.rand = new Random(seed);
		this.player = new Player(this.rand);
		this.board = new GameObjectBoard(this);
		this.contadorCiclos = 0;
		this.GameOver = false;	
	}
	
	public void addVampire() {
		if((Vampire.VRest() > 0) && Vampire.doesAdd(this.rand)) {
			int x = this.x - 1;  
			int y = rand.nextInt(this.y);
			if(this.board.buscarVampire(x, y) == null) {
				this.board.addV(x, y);
			}
		}
	}
	
	public boolean addSlayer(int x, int y) {
		if((x < (this.x - 1) && x >= 0) && (y < this.y && y >= 0)) {
			if((this.board.buscarSlayer(x, y) == null) && (this.board.buscarVampire(x, y) == null)) {
				if(this.player.hayDinero()) {
					this.player.comprar();
					this.board.addS(x, y);
					return true;
				}
			}
		}
		return false;
	}
	
	
	
	public void setGameOver(boolean end){
		this.GameOver = end;	
	}
	
	public boolean getGameOver(){
		return this.GameOver;
	}
	
	public void update() {		
		this.player.addCoins();
		this.addVampire(); 
		this.board.update();
		this.contadorCiclos += 1;
		if(Vampire.VDentro() == 0 && Vampire.VRest() == 0) {
			setGameOver(true);
		}
	}
	
	public void attackVampire(int x, int y,int dmg) {
		this.board.attackV(x, y, dmg);
	}
	public boolean attackSlayer(int x, int y,int  dmg) {
		return this.board.attackS(x,y,dmg);
	}
	public void draw() {
		System.out.println("Number of cycles: " + this.contadorCiclos);
		System.out.println("Coins: " + this.player.getCoins());
		System.out.println("Remaining vampires: " + Vampire.VRest());
		System.out.println("Vampires on the board: " + Vampire.VDentro());
		System.out.println(this.printer.toString());
		
	}

}
