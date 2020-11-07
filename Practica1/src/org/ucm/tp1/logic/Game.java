package org.ucm.tp1.logic;

import java.util.*; 
import org.ucm.tp1.logic.lists.*;
import org.ucm.tp1.view.GamePrinter;
import org.ucm.tp1.logic.managers.*;
import org.ucm.tp1.logic.objects.*;
import org.ucm.tp1.logic.managers.GameObjectBoard.*;

@SuppressWarnings("unused")
public class Game {

	// Atributos
	
	private long seed;
	private boolean isGameActive;
	private int cicleCount;
	private GamePrinter GPrinter;
	private Level level;
	private GameObjectBoard VManager;
	private Player Jugador;
	private Random rand;
	
	// Metodos
	public Game(Long seed, Level level) {
		this.rand = new Random(this.seed);
		this.cicleCount = 0;
		this.setGameActive(true);
		this.setLevel(level);
		
	}
	
	public void update (){

		this.VManager.update();
		
		if (this.GetCurrentCicle() != 0)
			this.VManager.AddVampire(this.rand.nextInt(4));
		
		if (this.GetCurrentCicle() == 0)
			System.out.println("Seed : " + this.seed);
		
		System.out.println("Number of cycles : " + this.GetCurrentCicle());
		System.out.println("Coins : " + this.GetCoins());
		System.out.println("Remaining Vampires : " + this.VManager.GetVampiresRemaining());
		System.out.println("Vampires on board : " + this.VManager.getVampiresCount());
		System.out.println(this.GPrinter = new GamePrinter (this, 4, 8));
		
		System.out.print("Command > ");
		
		this.endGame();
		this.cicleCount++;

	}

	
	public void endGame () {
		
		boolean Vwins = false;
		
		for (int i = 0; i < this.GetVcount(); i++) {
			
			if (this.GetVx(i) == 0)
				Vwins = true;
			
		}
		
		if ((this.GetVcount() == 0) && (this.VManager.GetVampiresRemaining() == 0)) {
			
			this.isGameActive = false;
			for(int i  = 0; i < 40; i++) {
				
				System.out.println("\n");
			
			}
			System.out.println("GAME OVER!");
			System.out.println("Player wins!");
			
		}
		
		else if (Vwins) {
			
			this.isGameActive = false;
			for(int i  = 0; i < 40; i++) {
				
				System.out.println("\n");
			
			}
			System.out.println("GAME OVER!");
			System.out.println("Zombies win!");

		}
		
		
	}

	public long GetSeed() {
		
		return this.seed;
		
	}
	
	public void exitGame() {
		
		this.isGameActive = false;
		
	}
	
	public boolean GetGameActive() {
		
		return this.isGameActive;
		
	}
	
	public String GetDif() {
		
		return this.level.GetDif();
		
	}
	
	public int GetCoins() {
		// TODO Auto-generated method stub
		return this.Jugador.getCoins();
	}

	public void DecreaseCoins (int coins) {
		
		this.Jugador.DecreaseCoins(coins);
		
	}
	

	public void AddCoins (int coins) {
		
		this.Jugador.addCoins(coins);;
		
	}
	
	public int GetSCost(){
		
		return Slayer.COST;
		
	}
	
	public int GetSDmg () {
		
		return Slayer.DMG;
		
	}
	
	public int GetVampiresRemaining() {
		// TODO Auto-generated method stub
		return VManager.GetVampiresRemaining();
	}

	public int GetCurrentCicle() {
		return this.cicleCount;
	}

	public boolean isGameActive() {
		return isGameActive;
	}

	public void setGameActive(boolean isGameActive) {
		this.isGameActive = isGameActive;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public int GetVcount() {
		return this.VManager.getVampiresCount();
	}

	public int GetVy(int i) {
		// TODO Auto-generated method stub
		return this.VManager.getVy(i);
	}

	public int GetVx(int i) {
		// TODO Auto-generated method stub
		return this.VManager.getVx(i);
	}

	public void DecreaseVHP(int j, int dmg) {
		// TODO Auto-generated method stub
		this.VManager.DecreaseVHP(j, dmg);
		
	}

	public void DeleteS(int i) {
		// TODO Auto-generated method stub
		this.VManager.DeleteS(i);
		
	}

	public void DeleteV(int i) {
		// TODO Auto-generated method stub
		this.VManager.DeleteV(i);
		
	}

	public void DecreaseSHP(int i, int dmg) {
		// TODO Auto-generated method stub
		this.VManager.DecreaseSHP(i, dmg);
		
	}

	public int GetSx(int i) {
		// TODO Auto-generated method stub
		return this.VManager.getSx(i);
	}

	public int GetSy(int i) {
		// TODO Auto-generated method stub
		return this.VManager.getSy(i);
	}

	public int GetScount() {
		// TODO Auto-generated method stub
		return this.VManager.getSlayersCount();
	}
	
	public void AddSlayer (int x, int y){
		
		this.VManager.AddSlayer(x,y);
		
	}
	
}