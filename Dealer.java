import java.util.*;

class Dealer
{
	ArrayList<Card> dealerCd = new ArrayList<Card>();
	
	public Deck dealerInit(Deck dk1)
	{
		dealerCd.add(dk1.deal());
		dealerCd.add(dk1.deal());
		System.out.println("Dealer's 1st Card: " + dealerCd.get(0));
		
		return dk1;
	}
	
	public Deck move(Deck dk1)
	{
		int dealerVal = val();
		
		if(dealerVal <= 16)
		{
			dealerCd.add(dk1.deal());
			System.out.println("The dealer hits");
		}
		
		else if(dealerVal > 16 && dealerVal < 21)
		{
			System.out.println("The dealer stands");
		}
		
		else if(dealerVal > 21)
		{
			System.out.println("Congrats you won! The dealer took them L");
			System.out.println("The value of the dealers cards is: " + dealerVal);
			System.exit(0);
		}
		return dk1;
	}
	
	public int val()
	{
		int dealerVal = 0;
		Card cd1;
		for(int i = 0; i < dealerCd.size(); i++)
		{
			cd1 = dealerCd.get(i);
			dealerVal += cd1.pointValue();
		}
		return dealerVal;
	}
	
	public int dealerCards()
	{
		Card temp;
		System.out.println("The dealers cards: ");
		for(int i = 0; i < dealerCd.size(); i++)
		{
			temp = dealerCd.get(i);
			System.out.println(temp.toString());
		}
		
		int dealerVal = 0;
		Card cd1;
		for(int i = 0; i < dealerCd.size(); i++)
		{
			cd1 = dealerCd.get(i);
			dealerVal += cd1.pointValue();
		}
		
		System.out.println("The dealer card values: " + dealerVal);
		return dealerVal;
	}
	
	public void endGame()
	{
		
	}
}
