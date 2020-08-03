package game.players;

import java.util.Scanner;

import game.card.Card;

public class Gamer extends Player {
	Scanner scan = new Scanner(System.in);
	
	public void setHand(Card[] hand) {
		this.hand = hand;
	}
}