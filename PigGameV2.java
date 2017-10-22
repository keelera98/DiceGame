/*
Austin Keeler
Pig Dice Game
*/
import java.util.*;
public class PigGameV2{
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		String playerName;
		//holds points
		int computerTotal1 = 0;
		int computerTotal2 = 0;
		int computerTotal3 = 0;
		//stops loops
		boolean stopPlayer3 = false;
		boolean stopPlayer4 = false;
		int randomNumber = 0;
		int playerTotal = 0;
		int stopPlayer = 1;
		int stopComputer = 0;
		int stopGame = 1;
		int keepRolling = 1;
		int stopRolling = 1;

		Random dieRoll = new Random();

		System.out.printf("Enter your name: ");
		playerName = input.next();

		do{
			while(stopPlayer == 1){
				System.out.printf("%s's turn\n", playerName);
				System.out.printf("--------------------\n");

				randomNumber = dieRoll.nextInt(6);
				randomNumber = randomNumber + 1;

				System.out.printf("%s's roll is %d\n", playerName, randomNumber);
				playerTotal = playerTotal + randomNumber;

				if(randomNumber == 1){
					playerTotal = 0;
					System.out.printf("You Rolled a one, zero points and end of turn\n");
					System.out.printf("--------------------\n");
					stopPlayer = 0;
					stopGame = 1;
					stopRolling = 1;
				}else{
					if(playerTotal >= 100){
						stopGame = 0;
						stopPlayer = 0;
						stopComputer = 3;
						stopPlayer3 = true;
						stopPlayer4 = true;
						System.out.printf("%s Wins\n", playerName);
						stopRolling = 0;
					}else{
						System.out.printf("%s's total is %d\n", playerName, playerTotal);
						System.out.printf("Press 0 to hold or 1 to keep rolling: ");
						stopPlayer = input.nextInt();

						System.out.printf("--------------------\n");
						System.out.printf("Player 2's total is %d\n", computerTotal1);
						System.out.printf("Player 3's total is %d\n", computerTotal2);
						System.out.printf("Player 4's total is %d\n", computerTotal3);
						System.out.printf("--------------------\n");

						stopComputer = 0;
						stopPlayer3 = false;
						stopPlayer4 = false;
						stopGame = 1;
						stopRolling = 1;
					}
				}
			}

			while(stopComputer < 3){
				System.out.printf("Player 2's turn\n");
				System.out.printf("--------------------\n");

				randomNumber = dieRoll.nextInt(6);
				randomNumber = randomNumber + 1;

				System.out.printf("Player 2's roll is %d\n", randomNumber);
				computerTotal1 = computerTotal1 + randomNumber;

				if(randomNumber == 1){
					computerTotal1 = 0;
					System.out.printf("Player 2 rolled a one, and ends the turn with zero points\n");
					stopComputer = 3;
					System.out.printf("--------------------\n");

					stopRolling = 1;
					stopPlayer3 = false;
					stopPlayer4 = false;
				}else{
					if(computerTotal1 >= 100){
						stopGame = 0;
						stopComputer = 3;
						stopPlayer3 = true;
						stopPlayer4 = true;

						System.out.printf("Player 2 Wins\n");
						System.out.printf("Player 2's total is %d\n", computerTotal1);
						System.out.printf("--------------------\n");
						stopRolling = 0;
					}else{
						stopComputer++;
						System.out.printf("Player 2's total is %d\n", computerTotal1);
						System.out.printf("--------------------\n");

						stopPlayer = 1;
						stopPlayer3 = false;
						stopPlayer4 = false;
						stopRolling = 1;
						if(stopComputer == 3){
							System.out.printf("Player 2 holds\n");
							System.out.printf("--------------------\n");
						}
					}
				}
			}

			while(((computerTotal2 > playerTotal) || (computerTotal2 <= playerTotal)) && (stopPlayer3 == false)){
				System.out.printf("Player 3's turn\n");
				System.out.printf("--------------------\n");

				if(computerTotal2 > playerTotal){
					System.out.printf("--------------------\n");
					System.out.printf("Player 3's total is %d\n", computerTotal2);
					System.out.printf("Player 3 Holds\n");
					System.out.printf("--------------------\n");
					stopPlayer3 = true;
				}else{
					randomNumber = dieRoll.nextInt(6);
					randomNumber = randomNumber + 1;

					System.out.printf("Player 3's roll is %d\n", randomNumber);
					computerTotal2 = computerTotal2 + randomNumber;

					if(randomNumber == 1){
						computerTotal2 = 0;
						System.out.printf("Player 3 rolled a one, and ends the turn with zero points\n");
						stopPlayer3 = true;
						System.out.printf("--------------------\n");
						stopRolling = 1;
					}else{

						if(computerTotal2 >= 100){
							stopGame = 0;
							stopPlayer3 = true;
							stopPlayer4 = true;

							System.out.printf("Player 3 Wins\n");
							System.out.printf("Player 3's total is %d\n", computerTotal2);
							System.out.printf("--------------------\n");
							stopRolling = 0;
						}else{
							System.out.printf("Player 3's total is %d\n", computerTotal2);
							System.out.printf("--------------------\n");
							stopPlayer = 1;
							stopRolling = 1;
						}
					}
				}
			}

			while(((computerTotal3 > computerTotal1) || (computerTotal3 <= computerTotal1)) && (stopPlayer4 == false)){
				System.out.printf("Player 4's turn\n");
				System.out.printf("--------------------\n");

				if(computerTotal3 > computerTotal1){
					System.out.printf("--------------------\n");
					System.out.printf("Player 4's total is %d\n", computerTotal3);
					System.out.printf("Player 4 Holds\n");
					System.out.printf("--------------------\n");
					stopPlayer4 = true;
				}else{
					randomNumber = dieRoll.nextInt(6);
					randomNumber = randomNumber + 1;

					System.out.printf("Player 4's roll is %d\n", randomNumber);
					computerTotal3 = computerTotal3 + randomNumber;

					if(randomNumber == 1){
						computerTotal3 = 0;

						System.out.printf("Player 4 rolled a one, and ends the turn with zero points\n");
						stopPlayer4 = true;
						System.out.printf("--------------------\n");
						stopRolling = 1;
					}else{

						if(computerTotal3 >= 100){
							stopGame = 0;
							stopPlayer4 = true;

							System.out.printf("Player 4 Wins\n");
							System.out.printf("Player 4's total is %d\n", computerTotal3);
							System.out.printf("--------------------\n");
							stopRolling = 0;
						}else{
							System.out.printf("Player 4's total is %d\n", computerTotal3);
							System.out.printf("--------------------\n");
							stopPlayer = 1;
							stopRolling = 1;
						}
					}
				}
			}

			while(stopRolling == 1){
				System.out.printf("Press 0 to hold or 1 to roll: ");
				keepRolling = input.nextInt();

				if (keepRolling == 1){
					stopComputer = 0;
					stopPlayer3 = false;
					stopPlayer4 = false;
					stopPlayer = 1;
					stopGame = 1;
					stopRolling = 0;
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

		}while(stopGame == 1);
	}
}
