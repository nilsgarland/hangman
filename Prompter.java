import java.util.Scanner;

public class Prompter
{

	private Game game;

	public Prompter(Game game)
	{
		this.game = game;
	}

	public boolean promptForGuess()
	{
		Scanner scanner = new Scanner(System.in);
		boolean isHit = false;
		boolean isAcceptable = false;

		do  {
			System.out.print("Enter a letter: ");
			String guessInput = scanner.nextLine();
			try{
				isHit = game.applyGuess(guessInput);
				isAcceptable = true;
			} catch(IllegalArgumentException iae) {
				System.out.println(iae.getMessage());
			}
		} while (!isAcceptable);
		return isHit;

	}

	public void displayProgress()
	{
		System.out.printf("You have %d tries left to solve: %s%n", game.getRemainingTries(), game.getCurrentProgress());
	}

	public void displayOutCome()
	{
		if (game.isWon()) {
			System.out.println("Awesome, You Won!");
		} 
		else {
			System.out.printf("Bummer! The word was %s.%n", game.getAnswer());
		}
	}


}
