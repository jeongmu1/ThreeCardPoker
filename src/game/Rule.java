package game;

import game.card.Card;

public class Rule {
	private boolean win;
	
	public int pay(int[] gResult, int[] dResult, int anteBet, int playBet, int pairPlusBet) {
		int pot = 0;
		
		if(win) {
			System.out.print("승리하셨습니다!");
			if(dResult[2] == 0 && dResult[1] < 12) {
				System.out.println("딜러의 패가 No Hand이므로 Ante의 1배만 지급합니다. (상금 : " + anteBet + ")");
				pot += anteBet * 2 + playBet;
			}
			else {
				System.out.print(" (상금 : " + (anteBet + playBet) + ")\n");
				pot += anteBet * 2 + playBet * 2;
			}
		}
		else {
			System.out.println("패배하셨습니다.");
		}
		
		if(gResult[2] == 5) {
			if(pairPlusBet != 0) System.out.println("Straight Flush에 대한 Pair Plus 배당금 " + pairPlusBet * 40 + "지급 (배당률 : 40)");
			System.out.println("Straight Flush에 대한 Ante 보너스 " + anteBet * 5 + "지급 (배당률 : 5)");
			pot += pairPlusBet * 41 + anteBet * 5;
		}
		else if(gResult[2] == 4) {
			if(pairPlusBet != 0) System.out.println("Three of Kind에 대한 Pair Plus 배당금 " + pairPlusBet * 30 + "지급 (배당률 : 30)");
			System.out.println("Three of Kind에 대한 Ante 보너스 " + anteBet * 4 + "지급 (배당률 : 4)");
			pot += pairPlusBet * 31 + anteBet * 4;
		}
		else if(gResult[2] == 3) {
			if(pairPlusBet != 0) System.out.println("Straight에 대한 Pair Plus 배당금 " + pairPlusBet * 6 + "지급 (배당률 : 6)");
			System.out.println("Straight에 대한 Ante 보너스 " + anteBet * 1 + "지급 (배당률 : 1)");
			pot += pairPlusBet * 7 + anteBet * 1;
		}
		else if(gResult[2] == 2) {
			if(pairPlusBet != 0) System.out.println("Flush에 대한 Pair Plus 배당금 " + pairPlusBet * 4 + "지급 (배당률 : 4)");
			pot += pairPlusBet * 5;
		}
		else if(gResult[2] == 1) {
			if(pairPlusBet != 0) System.out.println("One Pair에 대한 Pair Plus 배당금 " + pairPlusBet * 1 + "지급 (배당률 : 1)");
			pot += pairPlusBet * 2;
		}
		
		return pot;
	}
	
	/*
	 * 6카드보너스
	 * 
	 * public int judge6Cards(Card[] gHand, Card[] dHand) { Card[] allHand = new
	 * Card[6]; for(int i = 0; i < 3; i++) { allHand[i] = gHand[i]; allHand[i+3] =
	 * dHand[i]; }
	 * 
	 * if(searchSame(allHand, 3)) { if(searchSame(allHand, 4)) { return 5; } else
	 * if(searchFullHouse(allHand)) { return 4; } else { return 1; }
	 * 
	 * }
	 * 
	 * 
	 * 
	 * return 0; }
	 * 
	 * private boolean searchFullHouse(Card[] allHand) {
	 * 
	 * }
	 * 
	 * private boolean[] searchStraight(Card[] allHand) { List<Card> list = new
	 * ArrayList<Card>(); for(int i = 0; i < allHand.length; i++) {
	 * list.add(allHand[i]); }
	 * 
	 * for(int i = 0; i < list.size(); i++) { Card marker = list.get(i); for(int j =
	 * i; j < list.size(); j++) {
	 * 
	 * } }
	 * 
	 * return ; }
	 * 
	 * 
	 * private boolean searchSame(Card[] allHand, int n) { Card[] arr = new Card[n];
	 * 
	 * for(int i = 0; i < allHand.length; i++) { for(int a = 0; a < n; a++) { arr[a]
	 * = null; }
	 * 
	 * arr[0] = allHand[i]; int count = 0; for(int j = i; j < allHand.length; j++) {
	 * if(arr[0] == arr[j]) { arr[count] = arr[j]; count++; } }
	 * 
	 * if(arr[n - 1] != null) { return true; } }
	 * 
	 * return false; }
	 */
	
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