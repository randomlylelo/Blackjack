import java.util.*;

class Player
{
	ArrayList<Card> hand = new ArrayList<Card>();
	
	public void startGame()
	{
		Dealer dl = new Dealer();
		Deck dk1 = Welcome(dl);
		
		run(dl, dk1);
		
	}
	
	public void run(Dealer dl, Deck dk1)
	{
		String choice;
		String preChoice = "";
		int totalVal = yourVal();
		int preSize;
		int dlVal;
		
		while(totalVal < 22)
		{
			choice = HitOrStand();
			if(choice.equals("s"))
			{
				preSize = dk1.size();
				dk1 = dl.move(dk1);
				preChoice = "s";
				if(preSize == dk1.size())
				{
					System.out.println("Revealing all cards...");
					dlVal = dl.dealerCards();
					totalVal = yourVal();
					yourCards();
					
					if(totalVal > dlVal)
					{
						System.out.println("You win!");
					}
					
					else if(totalVal < dlVal)
					{
						System.out.println("You lost... rip");
					}
					
					else if(totalVal == dlVal)
					{
						System.out.println("It's a tie!");
					}
					
					System.exit(0);
				}
			}
			else if(choice.equals("h"))
			{
				hand.add(dk1.deal());
				System.out.println("The card that you just got: " + hand.get(hand.size()-1));
				totalVal = yourVal();
				if(totalVal > 21)
				{
					System.out.println("Rip... you lost!");
					System.exit(0);
				}
				dk1 = dl.move(dk1);
				preChoice = "h";
			}
			else
			{
				System.out.println("Please type (h) or (s)!");
			}
			totalVal = yourVal();
			System.out.println("Your current card values: " + totalVal);
		}
		System.out.println("Rip... you lost!");
	}
	
	public Deck Welcome(Dealer dl)
	{
		System.out.println("Hello! Welcome to Utlimate Blackjack...");
		System.out.println("Let's start the game.");
		System.out.println("You get two cards.");
		
		String[] ranks = {"Ace", "King", "Queen", "Jack", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
		String[] suits = {"spades", "hearts", "diamonds", "clubs"};
		int[] pointValues = {11, 10, 10, 10, 10, 9, 8, 7, 6, 5, 4, 3, 2};
		Deck dk1 = new Deck(ranks, suits, pointValues);
		dk1.shuffle();
		
		hand.add(dk1.deal());
		hand.add(dk1.deal());
		
		System.out.println(hand.get(0));
		System.out.println(hand.get(1));
		
		dk1 = dl.dealerInit(dk1);
		
		return dk1;
	}
	
	public String HitOrStand()
	{
		String choice;
		Scanner sc1 = new Scanner(System.in);
		
		System.out.println("Would you like to Hit(h) or Stand(s)?");
		choice = sc1.nextLine();
		
		return choice;
	}
	
	public int yourVal()
	{
		int val = 0;
		Card cd1;
		
		for(int i = 0; i < hand.size(); i++)
		{
			cd1 = hand.get(i);
			val += cd1.pointValue();
		}
		return val;
	}
	
	public void yourCards()
	{
		Card temp;
		System.out.println("Your cards: ");
		for(int i = 0; i < hand.size(); i++)
		{
			temp = hand.get(i);
			System.out.println(temp.toString());
		}
		
		int val = 0;
		Card cd1;
		
		for(int i = 0; i < hand.size(); i++)
		{
			cd1 = hand.get(i);
			val += cd1.pointValue();
		}
		System.out.println("Your current card values: " + val);
	}
	
	
}
