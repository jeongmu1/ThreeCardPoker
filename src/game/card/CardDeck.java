package game.card;

import java.util.Random;

public class CardDeck {
	private Card[] cardDeck = new Card[52];
	private int index = 0;
	
	private void inputDeck() {
		int count = 0;
		for(int i = 0; i < 4; i++) {
			for(int j = 2; j < 15; j++) {
				cardDeck[count] = new Card(i, j);
				count++;
			}
		}
	}
	
	private void shuffleDeck() {
		Random rand = new Random();
		Card temp;
		int r;
		
		for(int i = 0; i < cardDeck.length; i++) {
			r = rand.nextInt(52);
			temp = cardDeck[i];
			cardDeck[i] = cardDeck[r];
			cardDeck[r] = temp;
		}
	}
	
	public CardDeck() {
		inputDeck();
		shuffleDeck();
	}
	
	public Card getCard() {
		return cardDeck[index++];
	}
}
