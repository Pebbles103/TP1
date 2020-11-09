package org.ucm.tp1.objects;

import org.ucm.tp1.logic.Game;
import org.ucm.tp1.logic.Level;

public class VampireList {
	private int N= 100;
	private int cont = 0;
	
	private Vampire [] vampires;
	
	public VampireList() {	
		this.vampires = new Vampire[N];
	}
	
	public void addVampire(Game game, int x, int y) {
		this.vampires[this.cont] = new Vampire(game,x,y);
		this.cont++;
	}
	
	public Vampire getVampire(int x) {
		return this.vampires[x];
	}
	
	public int getContador() {
		return this.cont;
	}
	
	public void clean(int pos) {
		int i=pos;
		while(i< this.cont) {
			vampires[i]=vampires[i+1];
			i++;
		}
		this.cont--;
	}

}
