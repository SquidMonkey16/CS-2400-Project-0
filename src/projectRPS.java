import java.util.Scanner;

public class projectRPS {
	public static void main(String[] args) {
		
		determineWinner(computerChoice(), userChoice());
		
		while (playAgain())
			determineWinner(computerChoice(), userChoice());
		
		System.out.println("Thanks for playing!");
	}
	// This is a comment
	public static String computerChoice()
	{
		int computerChoice = (int) (Math.random() * 3 + 1); // num from 1 to 3 (starts with rand from 0 to 0.9999999)
		
		if (computerChoice == 1)
			return "rock";
		
		else if (computerChoice == 2)
			return "paper";
		
		else
			return "scissors";
	}
	
	public static String userChoice()
	{
		Scanner scan = new Scanner(System.in);
		String userChoice;
		
		System.out.print("Enter rock, paper, or scissors: ");
		userChoice = scan.next();
		
		while (!isValidChoice(userChoice))
		{
			System.out.println("Invalid option. Please try again.");
			System.out.print("Enter rock, paper, or scissors: ");
			userChoice = scan.next();
		}
		
		return userChoice;
	}
	
	public static boolean isValidChoice (String choice)
	{
		if (choice.equals("rock") || choice.equals("paper") || choice.equals("scissors"))
			return true;
		else
			return false;	
	}
	
	public static void determineWinner(String computer, String user)
	{
		if (user.equals(computer))
			System.out.println("It's a tie! Play again to determine a winner.");
		
		if (user.equals("rock") && computer.equals("paper") || user.equals("paper") && computer.equals("scissors") || user.equals("scissors") && computer.equals("rock"))
			System.out.println("You lose, computer chose " + computer + ".");
		
		if (user.equals("rock") && computer.equals("scissors") || user.equals("paper") && computer.equals("rock") || user.equals("scissors") && computer.equals("paper"))
			System.out.println("You win! Computer chose " + computer + ".");
	}
	
	public static boolean playAgain()
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.print("\nWould you like to play again? (yes or no): ");
		String again = scan.next();
		
		if (again.equalsIgnoreCase("yes"))
			return true;
		else
			return false;
	}
}