package org.ucm.tp1.logic.managers;

import java.util.Random;

import org.ucm.tp1.logic.Game;
import org.ucm.tp1.logic.lists.SlayerList;
import org.ucm.tp1.logic.lists.VampireList;
import org.ucm.tp1.logic.objects.Slayer;


public class GameObjectBoard {
	
	private int contadorVampiros;
	private int contadorSlayers;
	private VampireList Vlist;
	private SlayerList Slist;
	private Game game;
	private int vampires_to_play;
	public GameObjectBoard() {
		this.contadorVampiros = 0;
		this.contadorSlayers = 0;
		this.Vlist = new VampireList(game);
		this.Slist = new SlayerList(game);
		this.vampires_to_play = 2;
	}

	public void AddVampire(int rand) {
		int y = rand;
		int x = 7;
		boolean add = true;
		
		for (int i = 0; i < Vlist.GetVcount(); i++) {
			
			if ((Vlist.GetVx(i) == x) && (Vlist.GetVx(i) == y)) {
				
				add = false;
				
			}
			
		}
		
		for (int i = 0; i < Slist.GetScount(); i++) {
			
			if ((Slist.GetSx(i) == x) && (Slist.GetSy(i) == y)) {
				
				Slist.DeleteS(i);
				
			}
			
		}
				
		if (add) {
		
			this.Vlist.AddVampiro(x, y);
			
		}
		this.contadorVampiros++;
		this.vampires_to_play--;
	}
	
	
	public void AddSlayer(int x, int y){
		
		this.Slist.addSlayer(x,y);
		this.contadorSlayers++;
		
	}

	public int getVampiresCount() {
		return this.contadorVampiros;
	}

	public VampireList getVlist() {
		return Vlist;
	}

	public void setVlist(VampireList vlist) {
		Vlist = vlist;
	}

	public SlayerList getSlist() {
		return Slist;
	}

	public void setSlist(SlayerList slist) {
		Slist = slist;
	}

	public int getVy(int i) {
		// TODO Auto-generated method stub
		return this.Vlist.GetVy(i);
	}

	public int getVx(int i) {
		// TODO Auto-generated method stub
		return this.Vlist.GetVx(i);
	}

	public void DecreaseVHP(int j, int dmg) {
		// TODO Auto-generated method stub
		this.Vlist.DecreaseVHP(j, dmg);
	}

	public void DeleteV(int i) {
		// TODO Auto-generated method stub
		this.Vlist.DeleteV(i);
	}

	public void DeleteS(int i) {
		// TODO Auto-generated method stub
		this.Slist.DeleteS(i);
	}

	public void DecreaseSHP(int i, int dmg) {
		// TODO Auto-generated method stub
		this.Slist.DecreaseSHP(i, dmg);
	}

	public int getSx(int i) {
		// TODO Auto-generated method stub
		return this.Slist.GetSx(i);
	}

	public int getSy(int i) {
		// TODO Auto-generated method stub
		return this.Slist.GetSy(i);
	}

	public int getSlayersCount() {
		// TODO Auto-generated method stub
		return this.contadorSlayers;
	}

	public int GetVampiresRemaining() {
		// TODO Auto-generated method stub
		return this.vampires_to_play;
	}

	public void update() {
		this.Slist.Update();
		this.Vlist.Update();
		
		
	}


}
