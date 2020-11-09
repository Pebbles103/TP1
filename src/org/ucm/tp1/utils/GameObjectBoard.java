package org.ucm.tp1.utils;

import org.ucm.tp1.logic.Game;
import org.ucm.tp1.objects.Slayer;
import org.ucm.tp1.objects.SlayerList;
import org.ucm.tp1.objects.Vampire;
import org.ucm.tp1.objects.VampireList;


public class GameObjectBoard {
	
	private VampireList vampireList;
	private SlayerList slayerList;
	private Game game;
	
	
	public GameObjectBoard(Game game) {
		// TODO Auto-generated constructor stub
		this.game = game;
		this.slayerList = new SlayerList();
		this.vampireList = new VampireList();

	}
	
	public void addS (int x, int y) {
		this.slayerList.addSlayer(this.game,x, y);
	}
	
	public void addV(int x, int y) {
		this.vampireList.addVampire(this.game, x, y);	
	}
	
	public void update() {
		
		// Movimiento 
		for(int i=0;i<this.vampireList.getContador();i++){
			Vampire vampire = this.vampireList.getVampire(i);
			int j=0;
			boolean ok=true;
			while( j<this.slayerList.getContador() && ok) {
				Slayer slayer = this.slayerList.getSlayer(j);
				if(slayer.getSx()== (vampire.getVx()-1) && slayer.getSy() == vampire.getVy()) {
					ok = false;
				}
				j++;
			}
			if(ok) {
				vampire.move();
			}
		}	
		
		
		// Ataque de slayers y vampiros
		for(int i = 0; i<this.slayerList.getContador();i++) {
			Slayer slayer = this.slayerList.getSlayer(i);
			slayer.attack();
		}
		
		for(int i=0;i<this.vampireList.getContador();i++){
			Vampire vampire = this.vampireList.getVampire(i);
			vampire.attack();			
		}	
		
		// Limpieza de cadaveres
		for(int i = 0; i<this.slayerList.getContador();i++) {
			Slayer slayer = this.slayerList.getSlayer(i);
			if(!slayer.isAlive()) {
				this.slayerList.clean(i);
			}
		}
		
		for(int i=0;i<this.vampireList.getContador();i++){
			Vampire vampire = this.vampireList.getVampire(i);
			if(!vampire.isAlive()) {
				this.vampireList.clean(i);
			}
		}	
		
		
	}
	
	// Vampiro ataca Slayer 
	public void attackV(int x, int y,int dmg) {
		Slayer slayer= this.buscarSlayer(x, y);
		if(slayer != null) {
			slayer.decreaseHP(dmg);
		}
	}
	
	// Slayer ataca Vampiro
	public boolean attackS(int x, int y,int dmg) {
		boolean encontrado=false;
		Vampire vampire= this.buscarVampire(x, y);
		if(vampire != null) {
			vampire.decreaseHP(dmg);
			encontrado=true;
		}
		return encontrado;
	
	}
	

	// Busqueda de un Slayer 
	public Slayer buscarSlayer (int x, int y) {
		boolean  encontrado=false;
		int i=0;
		while(i<this.slayerList.getContador() && !encontrado) {
			Slayer slayer = this.getS(i);
			if( slayer.getSx() == x && slayer.getSy() == y) {
				 encontrado = true;
				 return this.slayerList.getSlayer(i);
			}
			i++;
		}
		return null;
	}
	
	public Vampire buscarVampire(int x, int y) {
		boolean  encontrado=false;
		int i=0;
		
		while(i<this.vampireList.getContador() && !encontrado) {
			Vampire vampire = this.vampireList.getVampire(i);
			if( vampire.getVx() == x && vampire.getVy() == y) {
				 encontrado = true; 
				 return this.vampireList.getVampire(i);
			}
			i++;
		}	
			return null;	
	}
	
	public Vampire getV(int x) {
		return this.vampireList.getVampire(x);			
	}
	public Slayer getS(int x) {
		return this.slayerList.getSlayer(x);
	}
	
	public VampireList getVL() {
		return this.vampireList;
	}
	public SlayerList getSl() {
		return this.slayerList;
	}
}
