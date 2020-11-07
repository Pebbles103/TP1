package org.ucm.tp1.logic.lists;

import org.ucm.tp1.logic.Game;
import org.ucm.tp1.logic.objects.Vampiro;

public class VampireList {

	// Atributos
	
	private Game game;
	private int numeroVampiros;
	private Vampiro[] list;
	
	public VampireList(Game game){
		
		this.game = game;
		this.numeroVampiros = 0;
		this.list = new Vampiro[32];
		
	}
	
	public void Update(){
		
		for (int i = 0; i < this.numeroVampiros; i ++){
			
			list[i].Update();
			
		}
		
	}
	
	public void AddVampiro(int x, int y){
		this.list[numeroVampiros] = new Vampiro(x, y, numeroVampiros, game);
		this.numeroVampiros++;
		
	}
	public int GetVcount() {
		// TODO Auto-generated method stub
		return this.numeroVampiros;
	}

	public int GetVx(int i) {
		// TODO Auto-generated method stub
		return this.list[i].GetVx();
	}

	public int GetVy (int i){
		
		return this.list[i].GetVy();
		
	}
	
	public void DecreaseVHP(int i, int dmg){
		
		this.list[i].DecreaseHP(dmg);
		
	}

	public void DeleteV (int i){
		
		this.numeroVampiros--;	
				
		for (int j = i; j < this.numeroVampiros; j++){
			
			this.list[j] = this.list[j + 1];
			
		}
		
		for (int j = i; j < this.numeroVampiros; j++){
			
			this.list[j].Changei(j);
			
		}
		
	}
	
	public String VtoString (int i) {
		
		return this.list[i].toString();
		
	}

}
