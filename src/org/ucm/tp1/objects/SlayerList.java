package org.ucm.tp1.objects;

import org.ucm.tp1.logic.Game;

public class SlayerList {
	
	private int N=100;
	private int cont = 0;
	
	private Slayer [] slayers;
	
	public SlayerList() {
		this.slayers = new Slayer[N];
	}
	
	public void addSlayer(Game game, int x, int y) {
		this.slayers[this.cont] = new Slayer(game,x,y);
		this.cont++;
	}
	
	public int getContador() {	
		return this.cont;
	}

	public Slayer getSlayer(int x) {
		return this.slayers[x];
	}
	
	public void clean(int pos) {
		int i=pos;
		while(i< this.cont) {
			slayers[i]=slayers[i+1];
			i++;
		}
		this.cont--;
	}
	

}
