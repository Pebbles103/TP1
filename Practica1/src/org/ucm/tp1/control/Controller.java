package org.ucm.tp1.control;

import java.util.Scanner;

import org.ucm.tp1.logic.Game;

public class Controller {

	
	public final String prompt = "Command > ";
	public static final String helpMsg = String.format(
			"Available commands:%n" +
			"[a]dd <x> <y>: add a slayer in position x, y%n" +
			"[h]elp: show this help%n" + 
			"[r]eset: reset game%n" + 
			"[e]xit: exit game%n"+ 
			"[n]one | []: update%n");
	
	public static final String unknownCommandMsg = String.format("Unknown command");
	public static final String invalidCommandMsg = String.format("Invalid command");
	public static final String invalidPositionMsg = String.format("Invalid position");

    private Game game;
    private Scanner scanner;
    
    public Controller(Game game, Scanner scanner) {
	    this.game = game;
	    this.scanner = scanner;
	   	this.game.update();
    }
    
    public void  printGame() {
   	 System.out.println(game);
    }
    
    public void run() {
		// TODO fill your code
    
    	
    	String com;
    	String slayer;
    	int x,y;
    	int i;
    	boolean empty,pasarTurno = false;
    	com = this.scanner.nextLine();
    	com = com.trim();
    	com = com.toLowerCase();
 
    	
    	while (com!="exit" && game.GetGameActive()) {
    		
    		String[] comando = com.split(" ");
    		
    		switch (comando[0]) {
    		case "add" : case "a":
    			
    			if (comando.length != 4) {
    				System.out.print("[ERROR]: Comando incompleto\n");
					System.out.print("Command > ");
					pasarTurno = false;
					break;
    			}
    		
	    		slayer = comando[1];
	    		slayer = slayer.toLowerCase();
				x = Integer.valueOf(comando[2]);
				y = Integer.valueOf(comando[3]);
	    		empty = true;
    		
	    		if ((x >= 0) && (x <= 7) && (y >= 0) && (y <= 3)) {
					
					i = 0;

					if (empty){
						
						i = 0;
						while(i < game.GetScount() && empty){
							
							if ((game.GetSx(i) == x) && (game.GetSy(i) == y))
								empty = false;
							i++;
						}
						
					}
				
					if (empty){
						
						i = 0;
						while(i < game.GetVcount() && empty){
							
							if ((game.GetVx(i) == x) && (game.GetVy(i) == y))
								empty = false;
							
							i++;
						}
						
					}
				
					if (empty){
						
						switch (slayer){
						
						case "slayer": case "s":
							
							if (game.GetCoins() >= game.GetSCost()){
								
								game.AddSlayer(x, y);
								game.DecreaseCoins(game.GetSCost());
								
							}
							
							else {
								
								System.out.println("[ERROR]: No tienes suficientes Coins\n");
								System.out.print("Command > ");
								pasarTurno = false;
								
							}
							
							break;
					
						default:
							
							System.out.print("[ERROR]: Introduzca un valor valido\n");
							System.out.print("Command > ");
							pasarTurno = false;
							break;
						
							}
					}
				
					else {
						
						System.out.println("[ERROR]: Seleccione una casilla válida.\n");
						System.out.print("Command > ");
						pasarTurno = false;
											
					}
	    		}
				
				else {
					
					System.out.println("[ERROR]: Coordenadas no válidas:");
					System.out.println("		  Introduzca una x en el intervalo (0, 7)");
					System.out.println("		  Introduzca una y en el intervalo (0, 3)\n");
					System.out.print("Command > ");
					
					pasarTurno = false;
					
					
				}
	    		break;
			case "reset": case "r":
				
				this.game = new Game(this.game.GetSeed(), this.game.getLevel());	
				pasarTurno = false;
			
			break;	
			
			case "exit": case "e":
				
				game.exitGame();
				
			break;
			
			case "help": case "h":
				System.out.println("[a]dd <x> <y>: add a slayer in position x, y");
				System.out.println("[h]elp: show this help");
				System.out.println("[r]eset: reset game");
				System.out.println("[e]xit: exit game");
				System.out.println("[n]one | []: update\\n");
				System.out.print("Command > ");

				pasarTurno = false;
				
			break;
			
			case "":
				
				pasarTurno = true;
				
			break;
				
	    	
			default:
				
				System.out.println("[ERROR]: Comando \"" + com + "\" desconocido\n");
				System.out.print("Command > ");
				pasarTurno = false;
				
			break;
	    		
	    		
    			}
    		
    		if(pasarTurno) {
				
				this.game.update();
				
			}
    		
			com = scanner.nextLine();
			com = com.toLowerCase();
    		}
    	}
    }


    		
    		
    		
    		
    		
    	
    	
    



