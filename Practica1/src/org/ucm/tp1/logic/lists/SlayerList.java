package org.ucm.tp1.logic.lists;

import org.ucm.tp1.logic.Game;
import org.ucm.tp1.logic.objects.Slayer;

public class SlayerList {

	
	
	// Atributes

	private Game game;
	private int numeroSlayers;
	private Slayer[] list;
	
	// Methods
	
	/** Crea la lista */
	
	public SlayerList(Game game){
		
		this.game = game;
		this.numeroSlayers = 0;
		this.list = new Slayer[32];
		
	}
	
	public void Update (){
		
		for (int i = 0; i < this.numeroSlayers; i ++){
			
			list[i].Update();
			
		}
		
	}
	public void DeleteS (int i){
		
		this.numeroSlayers--;
		
		for (int j = i; j < this.numeroSlayers; j++){
			
			this.list[j].Changei(i - 1);
			
		}
		
		for (int j = i; j < this.numeroSlayers; j++){
			
			this.list[j] = this.list[j + 1];

		}
		
	}
	
	public int GetScount() {
		// TODO Auto-generated method stub
		return this.numeroSlayers;
	}

	public int GetSx(int i) {
		// TODO Auto-generated method stub
		return this.list[i].GetSx();
	}

	public int GetSy(int i) {
		// TODO Auto-generated method stub
		return this.list[i].GetSy();
	}

	
	public void addSlayer(int x, int y) {
		// TODO Auto-generated method stub
		
		this.list[numeroSlayers] = new Slayer(x, y, game, this.numeroSlayers);
		this.numeroSlayers ++;
	}
	
	public void DecreaseSHP(int i, int dmg){
		
		this.list[i].DecreaseHP (dmg);
		
	}
	
	public String StoString(int i) {
		
		return this.list[i].toString();
		
	}
	
}
