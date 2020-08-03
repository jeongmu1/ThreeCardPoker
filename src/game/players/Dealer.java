package game.players;

import game.card.Card;
import game.card.CardDeck;

public class Dealer extends Player {
	
	public Card[] handOutCards() {
		CardDeck deck = new CardDeck();
		
		Card[] forPlayerHand = new Card[3];
		for(int i = 0; i < 3; i++) {
			forPlayerHand[i] = deck.getCard();
		}
		for(int i = 0; i < 3; i++) {
			this.hand[i] = deck.getCard();
		}
		
		return forPlayerHand;
	}
	
}
