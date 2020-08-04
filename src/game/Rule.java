package game;

import game.card.Card;

public class Rule {
	private boolean win;
	
	public int[] pay(int[] gResult, int[] dResult, int anteBet, int playBet, int pairPlusBet) {
		int[] pot = new int[4]; // 0 = ante, 1 = play, 2 = ante bonus, 3 = pair plus
		
		if(win) {
			//딜러 Nothing
			if(dResult[2] == 0 && dResult[1] < 12) {
				pot[0] = anteBet * 2;
				pot[1] = playBet;
			}
			//평소
			else {
				pot[0] = anteBet * 2;
				pot[1] = playBet * 2;
			}
		}
		
		if(gResult[2] == 5) {
			pot[3] = pairPlusBet * 41;
			pot[2] = anteBet * 5;
		}
		else if(gResult[2] == 4) {
			pot[3] = pairPlusBet * 31;
			pot[2] = anteBet * 4;
		}
		else if(gResult[2] == 3) {
			pot[3] = pairPlusBet * 7;
			pot[2] = anteBet * 1;
		}
		else if(gResult[2] == 2) {
			pot[3] = pairPlusBet * 5;
		}
		else if(gResult[2] == 1) {
			pot[3] = pairPlusBet * 2;
		}
		
		return pot;
	}
	
	public int[] judge(Card[] player) {
		//리턴할 배열의 형식 { 대표카드 문양, 대표카드 숫자, 랭크 }
		
		int rank = rank(player);
		Card repCard;
		int[] forReturn = new int[3];
		
		/*
		 * 0 = High Card
		 * 1 = One Pair
		 * 2 = Flush
		 * 3 = Straight
		 * 4 = Three of Kind
		 * 5 = Straight Flush
		 */
				
		if(rank == 0 || rank == 3 || rank == 5) {
			repCard = findHighestNumber(player);
		}
		else if(rank == 1) {
			repCard = findHighestShapeInPair(player);
		}
		else{
			repCard = findHighestShape(player);
		}
			
		forReturn[0] = repCard.getShape();
		forReturn[1] = repCard.getNumber();
		forReturn[2] = rank;
		
		return forReturn;
	}
	
	private Card findHighestShapeInPair(Card[] player) {
		if(player[0].getNumber() == player[1].getNumber()) {
			if(player[0].getShape() > player[1].getShape()) return player[0];
			else return player[1];
		}
		else if(player[0].getNumber() == player[2].getNumber()) {
			if(player[0].getShape() > player[2].getShape()) return player[0];
			else return player[2];
		}
		else {
			if(player[1].getShape() > player[2].getShape()) return player[1];
			else return player[2];
		}
	}
	
	private Card findHighestShape(Card[] player) {
		Card highest = player[0];
		
		for(int i = 1; i < 3; i++) {
			if(player[i].getShape() > highest.getShape()) {
				highest = player[i];
			}
		}
		
		return highest;
	}
	
	private Card findHighestNumber(Card[] player) {
		Card highest = player[0];
		
		for(int i = 1; i < 3; i++) {
			if(player[i].getNumber() > highest.getNumber()) {
				highest = player[i];
			}
		}
		
		return highest;
	}
	
	public void setWLResult(int[] gResult, int[] dResult) {
		if(gResult[2] > dResult[2]) win = true;
		else if(gResult[2] == dResult[2]) {
			if(gResult[1] > dResult[1]) win = true;
			else if(gResult[1] == dResult[1]) {
				if(gResult[0] > dResult[0]) win = true;
				else win = false;
			}
			else win = false;
		}
		else win = false;
	}
	
	public boolean getWin() {
		return this.win;
	}
	
	private int rank(Card[] player) {
		//랭크 판단
		boolean PAIR = false, FLUSH = false, STRAIGHT = false, TRIPLE = false;
		//PAIR
		if(player[0].getNumber() == player[1].getNumber() || player[0].getNumber() == player[2].getNumber() || player[1].getNumber() == player[2].getNumber()) {
			PAIR = true;
		}
		
		if(!PAIR) {
			//FLUSH
			if(player[0].getShape() == player[1].getShape() && player[1].getShape() == player[2].getShape()) {
				FLUSH = true;
			}
			//STRAIGHT
			Card[] tempPlayerHand = sort(player);
			if(tempPlayerHand[0].getNumber() + 1 == tempPlayerHand[1].getNumber() && tempPlayerHand[1].getNumber() + 1 == tempPlayerHand[2].getNumber()) {
				STRAIGHT = true;
			}
		}
		else {
			//TRIPLE
			if(player[0].getNumber() == player[1].getNumber() && player[1].getNumber() == player[2].getNumber()) {
				TRIPLE = true;
			}
		}
		
		if(PAIR) {
			if(TRIPLE) {
				return 4;
			}
			else {
				return 1;
			}
		}
		else if(FLUSH) {
			if(STRAIGHT) {
				return 5;
			}
			else {
				return 2;
			}
		}
		else if(STRAIGHT) {
			return 3;
		}
		else {
			return 0;
		}
	}
	
	private Card[] sort(Card[] player) {
		Card temp;
		for(int i = 0; i < player.length - 1; i++) {
			for(int j = 0; j < player.length - 1 - i; j++) {
				if(player[j].getNumber() > player[j + 1].getNumber()) {
					temp = player[j];
					player[j] = player[j + 1];
					player[j + 1] = temp;
				}
			}
		}
		
		return player;
	}
	
}