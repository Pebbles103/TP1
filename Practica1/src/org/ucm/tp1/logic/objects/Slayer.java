package org.ucm.tp1.logic.objects;

import org.ucm.tp1.logic.Game;

public class Slayer {	
		// Atributes
		
		public static final int COST = 50;
		public static final int DMG = 1;
		private Game game;
		private int hp;
		private int cost;
		private int x;
		private int y;
		private int i;
		private int cicleAdded;
		
		// Methods
		
		/** Constructor de Slayer */
		
		public Slayer(int x, int y, Game game, int i){
			
			this.i = i;
			this.game = game;
			this.hp = 3;
			this.cost = 50;
			this.x = x;
			this.y = y;
			this.cicleAdded = game.GetCurrentCicle();
			
		}
		
// El update comprueba las acciones que debe tomar el slayer y las aplica
		
		public void Update(){
			
			int Vxmin = 8, j = 0;
			Boolean found = false, atck = false;
			
			if (game.GetCurrentCicle() != this.cicleAdded) {

				for (int i = 0; i < game.GetVcount(); i++) {
					
					if (this.y == game.GetVy(i)) {
						
						atck = true;
						
						for (int k = 0; k < game.GetVcount(); k++) {
							
							if (game.GetVx(i) < Vxmin) {
								
								Vxmin = game.GetVx(i);
								
							}
							
						}
						
					}
					
				}
				
				if (atck){
				
					while (j < game.GetVcount() && !found){
						
						if ((game.GetVx(j) == Vxmin) && (game.GetVy(j) == this.y)){
							
							game.DecreaseVHP(j, DMG);
							found = true;
							
						}
						
						j++;
					}
				
				}
			
			}
			
		}
		
		
		/** Getters, setter y toString */
		
		public int GetCost (){
			
			return this.cost;
			
		}
		
		public int GetSx (){

			return this.x;
			
		}
		
		public int GetSy (){
			
			return this.y;
			
		}
		
		public void DecreaseHP (int dmg){
			
			this.hp -= dmg;
			
			if (this.hp == 0){
				
				game.DeleteS(this.i);
				
			}
			
		}
		
		public void Changei(int i){
			
			this.i = i;
			
		}
		
		public String toString (){
			
			String a;
			a = "S [";
			a += this.hp;
			a += "]";
			
			return a;
			
		}

	}