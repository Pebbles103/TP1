package org.ucm.tp1.logic.objects;

import org.ucm.tp1.logic.Game;

public class Vampiro {
		// Atributes
		
		private Game game;
		private int hp;
		private int dmg;
		private int cicleAdded;
		private int spd;
		private int x;
		private int y;
		private int i; // Almacena la posición del zombie en la lista
		
		// Methods
		
//Constructor de vampiro
		
		public Vampiro(int x, int y, int i, Game game){
			
			this.game = game;
			this.hp = 5;
			this.dmg = 1;
			this.cicleAdded = game.GetCurrentCicle();
			this.spd = 2;
			this.x = 7;
			this.y = y;
			this.i = i;
			
		}

// El update comprueba las acciones indicadas por el comportamiento del vampiro.
		
		public void Update(){
			
			boolean mov = true;
			int PScount, PSx, PSy;
					
			PScount = game.GetScount();
			
			for (int i = 0; i < PScount; i++){
				
				PSx = game.GetSx(i);
				PSy = game.GetSy(i);
				
				if ((this.y == PSy) && ((this.x - 1) == PSx)){
					
					game.DecreaseSHP(i, this.dmg);
					mov = false;
					
				}
				
			}
			
			if ((mov) && ((game.GetCurrentCicle() - this.cicleAdded) % this.spd ) == 0){
				
				this.x --;
				
			}
			
		
		}
		
// Getters y Setters
		
		public int GetVx (){

			return this.x;
			
		}
		
		public int GetVy (){

			return this.y;
			
		}
		
		public void DecreaseHP (int dmg){
			
			this.hp -= dmg;
			
			if (this.hp == 0){
				
				game.DeleteV(this.i);
				
			}
					
		}

		public void Changei(int i){
			
			this.i = i;
			
		}
		
		public String toString (){
			
			String a;
			a = "V [";
			a += this.hp;
			a += "]";
			
			return a;
			
		}
		
	}
