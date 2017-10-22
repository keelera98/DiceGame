/*
Austin Keeler
Pig Dice Game
CSCI 161
*/
//imports the utility library for the scanner and random number generator
import java.util.*;
//main class, named after the programs name
public class PigGameV2{
	//where the computer starts reading the program
	public static void main(String args[]){
		//declares the scanner named input, used to get the player's name
		Scanner input = new Scanner(System.in);
		//declares the variable that holds the player's name
		String playerName;
		//declares and initializes the variable that will hold the computer's score
		int computerTotal1 = 0;
		//third players variable to hold their points
		int computerTotal2 = 0;
		//variable to keep the score of the 3rd computer
		int computerTotal3 = 0;
		//boolean variable, used to stop the second players loop, set to false because we want the loop to start
		boolean stopPlayer3 = false;
		//boolean variable, used to stop the third players loop, set to false to start the loop
		boolean stopPlayer4 = false;
		//varaible that will hold the random number, used to simulate the die roll
		int randomNumber = 0;
		//variable that will hold the player's total score 
		int playerTotal = 0;
		//variable used to start and stop the while loop for the player 
		int stopPlayer = 1;
		//variable used to start and stop the while loop for the computer
		int stopComputer = 0;
		//variable used to start and stop the do-while loop used for the entire game, variable can stop the game
		int stopGame = 1;
		//variable used to let the user roll or not roll depending on what the choose
		int keepRolling = 1;
		//variable used to stop the while loop that controls if the player is prompted if they want to continue rolling
		int stopRolling = 1;
		//declares the random variable, used to get random numbers
		Random dieRoll = new Random();
		
		//prompts the user to enter their name 
		System.out.printf("Enter your name: ");
		//initializes the variable to hold user name
		playerName = input.next();
		
		//start of the do-while loop, the loop does the code first than checks the condition to see if it wants to do it again
		do{
			//while loop for the player, stops if the condition is not = to 1
			while(stopPlayer == 1){
				//tells the user that it is their turn
				System.out.printf("%s's turn\n", playerName);
				//used to space our the text, makes it easier to read in the program
				System.out.printf("--------------------\n");
				//random number goes into the variable, the number can be from 0 to 6
				randomNumber = dieRoll.nextInt(6);
				//adds one to the random number because the number will sometimes be 0 which isn't on the die
				randomNumber = randomNumber + 1;
				//tells the user what value came from the roll
				System.out.printf("%s's roll is %d\n", playerName, randomNumber);
				//puts the number in the variable, keeps track of the number and adds the new random number when necessary
				playerTotal = playerTotal + randomNumber;
				//asks if the number generated is 1, if so puts points back to 0 and ends the loop for the player
				if(randomNumber == 1){
					//puts points back to 0
					playerTotal = 0;
					//tells the player that they rolled a one and lost their points
					System.out.printf("You Rolled a one, zero points and end of turn\n");
					System.out.printf("--------------------\n");
					//ends the loop for the player 
					stopPlayer = 0;
					//keeps the game going by not ending the game loop 
					stopGame = 1;
					//keeps the loop at the end going so the user can choose to hold or not to hold 
					stopRolling = 1;
				//if the above is false goes to this block of code 
				}else{
					//asks if the players score is 100 or above, if so ends the game and tells the player they win
					if(playerTotal >= 100){
						//ends the main loop for the game 
						stopGame = 0;
						//ends the players loop 
						stopPlayer = 0;
						//makes sure the computer loop doesn't happen
						stopComputer = 3;
						//stops the 2nd computers loop
						stopPlayer3 = true;
						//stops the 3rd computers loop
						stopPlayer4 = true;
						//tells the player they win 
						System.out.printf("%s Wins\n", playerName);
						//stops the loop at the end that asks the user if they want to hold
						stopRolling = 0;
					//if the above is false, does the following code
					}else{
						//tells the player total, using their name 
						System.out.printf("%s's total is %d\n", playerName, playerTotal);
						//asks the user if they want to hold or keep playing
						System.out.printf("Press 0 to hold or 1 to keep rolling: ");
						//puts their choice in this variable, used to keep the loop going or end it 
						stopPlayer = input.nextInt();
						System.out.printf("--------------------\n");
						//tells the other player's total, so the user can tell if they want to hold or not
						System.out.printf("Player 2's total is %d\n", computerTotal1);
						System.out.printf("Player 3's total is %d\n", computerTotal2);
						System.out.printf("Player 4's total is %d\n", computerTotal3);
						System.out.printf("--------------------\n");
						//allows the computer loop to happen 
						stopComputer = 0;
						//keeps the 2nd computers loop going
						stopPlayer3 = false;
						//keeps the 3rd computers loop going 
						stopPlayer4 = false;
						//keeps the main game loop going 
						stopGame = 1;
						//keeps the loop at the end going so they will be prompted
						stopRolling = 1;
					}
				}
			}
			
			//starts the loop for the computer to run through, runs through 3 times
			while(stopComputer < 3){
				System.out.printf("Player 2's turn\n");
				System.out.printf("--------------------\n");
				//same code for the random number as before
				randomNumber = dieRoll.nextInt(6);
				randomNumber = randomNumber + 1;
				//prints the computers roll on the screen
				System.out.printf("Player 2's roll is %d\n", randomNumber);
				//keeps track of the computers total 
				computerTotal1 = computerTotal1 + randomNumber;
				//asks if the number generated is 1
				if(randomNumber == 1){
					//resets the computers score 
					computerTotal1 = 0;
					//prints that the computers turn has ended and they lost their points
					System.out.printf("Player 2 rolled a one, and ends the turn with zero points\n");
					//stops the computers loop
					stopComputer = 3;
					System.out.printf("--------------------\n");
					//keeps the loop at the bottom going so the user will be asked if they want to hold or roll
					stopRolling = 1;
					//keeps the 2nd computers loop going
					stopPlayer3 = false;
					//keeps the 3rd computers loop going 
					stopPlayer4 = false;
				//if the above is false do this 
				}else{
					//asks if the computer has reaches the score cap
					if(computerTotal1 >= 100){
						//stops the game loop, because the game is over
						stopGame = 0;
						//stops the computers loop 
						stopComputer = 3;
						//stops the 2nd computers loop
						stopPlayer3 = true;
						//stops 3rd computers loop 
						stopPlayer4 = true;
						//prints that the computer has won
						System.out.printf("Player 2 Wins\n");
						//prints the computers total score
						System.out.printf("Player 2's total is %d\n", computerTotal1);
						System.out.printf("--------------------\n");
						//stops the loop on the bottom
						stopRolling = 0;
					//if the above is false do this
					}else{
						//adds one to the variable each time the loop goes through, allows the loop to happen 3 times 
						stopComputer++;
						//prints the computers total 
						System.out.printf("Player 2's total is %d\n", computerTotal1);
						System.out.printf("--------------------\n");
						//keeps the player loop going 
						stopPlayer = 1;
						//keeps the 2nd computers loop going
						stopPlayer3 = false;
						//keeps 3rd computer loop going
						stopPlayer4 = false;
						//keeps the loop at the bottom going 
						stopRolling = 1;
						//asks if stop computer is equal to 3, if yes prints out that they hold
						if(stopComputer == 3){
							//prints out that they hold
							System.out.printf("Player 2 holds\n");
							System.out.printf("--------------------\n");
						}
					}
				}
			}
			//while loop for the 2nd computer, goes if their score is less than the user or greater than
			//the boolean varaible is used to stop the loop if necessary
			while(((computerTotal2 > playerTotal) || (computerTotal2 <= playerTotal)) && (stopPlayer3 == false)){
				//states that it's the 2nd computers turn
				System.out.printf("Player 3's turn\n");
				System.out.printf("--------------------\n");
				//asks if the 2nd computer total is greater than the user, if so hold/don't roll
				if(computerTotal2 > playerTotal){
					System.out.printf("--------------------\n");
					System.out.printf("Player 3's total is %d\n", computerTotal2);
					System.out.printf("Player 3 Holds\n");
					System.out.printf("--------------------\n");
					stopPlayer3 = true;
				//if false do the following code
				}else{
					//same code for the random number as before
					randomNumber = dieRoll.nextInt(6);
					randomNumber = randomNumber + 1;
					//prints the computers roll on the screen
					System.out.printf("Player 3's roll is %d\n", randomNumber);
					//keeps track of the computers total 
					computerTotal2 = computerTotal2 + randomNumber;
					//asks if the number generated is 1
					if(randomNumber == 1){
						//resets the computers score 
						computerTotal2 = 0;
						//prints that the computers turn has ended and they lost their points
						System.out.printf("Player 3 rolled a one, and ends the turn with zero points\n");
						//stops the computers loop
						//stops the loop for the 2nd computer
						stopPlayer3 = true;
						System.out.printf("--------------------\n");
						//keeps the loop at the bottom going so the user will be asked if they want to hold or roll
						stopRolling = 1;
					//if the above is false do this 
					}else{
						//asks if the computer has reaches the score cap
						if(computerTotal2 >= 100){
							//stops the game loop, because the game is over
							stopGame = 0;
							//stops the computers loop 
							stopPlayer3 = true;
							//stops the loop for the 3rd computer
							stopPlayer4 = true;
							//prints that the computer has won
							System.out.printf("Player 3 Wins\n");
							//prints the computers total score
							System.out.printf("Player 3's total is %d\n", computerTotal2);
							System.out.printf("--------------------\n");
							//stops the loop on the bottom
							stopRolling = 0;
						//if the above is false do this
						}else{
							//adds one to the variable each time the loop goes through, allows the loop to happen 3 times 
							//stopComputer++;
							//prints the computers total 
							System.out.printf("Player 3's total is %d\n", computerTotal2);
							System.out.printf("--------------------\n");
							//keeps the player loop going 
							stopPlayer = 1;
							//keeps the loop at the bottom going 
							stopRolling = 1;
						}
					}
				}
			}
			
			//while loop for the 3rd computer, runs if its score is above/below/equal to the 1st computer
			//boolean is there to stop the loop
			while(((computerTotal3 > computerTotal1) || (computerTotal3 <= computerTotal1)) && (stopPlayer4 == false)){
				//states that it's the 2nd computers turn
				System.out.printf("Player 4's turn\n");
				System.out.printf("--------------------\n");
				//asks if the 2nd computer total is greater than the user, if so hold/don't roll
				if(computerTotal3 > computerTotal1){
					System.out.printf("--------------------\n");
					System.out.printf("Player 4's total is %d\n", computerTotal3);
					System.out.printf("Player 4 Holds\n");
					System.out.printf("--------------------\n");
					stopPlayer4 = true;
				//if false do the following code
				}else{
					//same code for the random number as before
					randomNumber = dieRoll.nextInt(6);
					randomNumber = randomNumber + 1;
					//prints the computers roll on the screen
					System.out.printf("Player 4's roll is %d\n", randomNumber);
					//keeps track of the computers total 
					computerTotal3 = computerTotal3 + randomNumber;
					//asks if the number generated is 1
					if(randomNumber == 1){
						//resets the computers score 
						computerTotal3 = 0;
						//prints that the computers turn has ended and they lost their points
						System.out.printf("Player 4 rolled a one, and ends the turn with zero points\n");
						//stops the computers loop
						//stops the loop for the 2nd computer
						stopPlayer4 = true;
						System.out.printf("--------------------\n");
						//keeps the loop at the bottom going so the user will be asked if they want to hold or roll
						stopRolling = 1;
					//if the above is false do this 
					}else{
						//asks if the computer has reaches the score cap
						if(computerTotal3 >= 100){
							//stops the game loop, because the game is over
							stopGame = 0;
							//stops the computers loop 
							stopPlayer4 = true;
							//prints that the computer has won
							System.out.printf("Player 4 Wins\n");
							//prints the computers total score
							System.out.printf("Player 4's total is %d\n", computerTotal3);
							System.out.printf("--------------------\n");
							//stops the loop on the bottom
							stopRolling = 0;
						//if the above is false do this
						}else{
							//adds one to the variable each time the loop goes through, allows the loop to happen 3 times 
							//stopComputer++;
							//prints the computers total 
							System.out.printf("Player 4's total is %d\n", computerTotal3);
							System.out.printf("--------------------\n");
							//keeps the player loop going 
							stopPlayer = 1;
							//keeps the loop at the bottom going 
							stopRolling = 1;
						}
					}
				}
			}
			
			//loop that asks the user if they want to hold after the computers turn is over
			while(stopRolling == 1){
				//prints the prompt for the user to make a choice
				System.out.printf("Press 0 to hold or 1 to roll: ");
				//holds the choice the user makes 
				keepRolling = input.nextInt();
				//if they choose to roll it will keep all the loops above going
				if (keepRolling == 1){
					stopComputer = 0;
					stopPlayer3 = false;
					stopPlayer4 = false;
					stopPlayer = 1;
					stopGame = 1;
					stopRolling = 0;
				//if they choose no it turns off the players loop but keeps the other ones going
				}else{
					if(keepRolling == 0){
						stopPlayer = 0;
						stopPlayer3 = false;
						stopPlayer4 = false;
						stopComputer = 0;
						stopGame = 1;
						stopRolling = 0;
					}
				}
			}
		//checks the condition for the loop to see if it should go through again
		}while(stopGame == 1);			
	}
}