package game;

import game.card.Card;
import game.players.Dealer;
import game.players.Gamer;

public class GameClient {
	private Gamer gamer = new Gamer();
	private Dealer dealer = new Dealer();
	private Rule rule = new Rule();
	private boolean cardOpen;
	private int[] dResult, gResult;
	
	private void printHands() {
		//게이머
		Card[] GHand = gamer.getHand();
		System.out.print("Gamer\t:\t");
		for(int i = 0; i < 3; i++) {
			printCard(GHand[i]);
			System.out.print("\t");
			
		}
		printResult(gResult);
		
		//딜러
		System.out.print("\nDealer\t:\t");
		Card[] DHand = dealer.getHand();
		if(cardOpen) {
			for(int i = 0; i < 3; i++) {
				printCard(DHand[i]);
				System.out.print("\t");
			}
			printResult(dResult);
			System.out.println();
			
			//System.out.print("6 Cards\t:\t");
			
		}
		else {
			for(int i = 0; i < 3; i++) {
				System.out.print("__\t");
			}
			System.out.println();
		}
	}
	
	private void printResult(int[] result) {
		System.out.print("[ ");
		Card repCard = new Card(result[0], result[1]);
		printCard(repCard);
		
		if(result[2] == 0) {
			System.out.print(" High ]");
		}
		else if(result[2] == 1) {
			System.out.print(" One Pair! ]");
		}
		else if(result[2] == 2) {
			System.out.print(" Flush! ]");
		}
		else if(result[2] == 3) {
			System.out.print(" Straight! ]");
		}
		else if(result[2] == 4) {
			System.out.print(" Three of Kind!! ]");
		}
		else {
			System.out.print(" Straight Flush!! ]");
		}
	}
	
	private void printCard(Card card) {
		//문양
		if(card.getShape() == 0) {
			System.out.print("♣");
		}
		else if(card.getShape() == 1) {
			System.out.print("♥");
		}
		else if(card.getShape() == 2) {
			System.out.print("◆");
		}
		else if(card.getShape() == 3) {
			System.out.print("♠");
		}
		
		//숫자
		if(card.getNumber() == 11) {
			System.out.print("J");
		}
		else if(card.getNumber() == 12) {
			System.out.print("Q");
		}
		else if(card.getNumber() == 13) {
			System.out.print("K");
		}
		else if(card.getNumber() == 14) {
			System.out.print("A");
		}
		else {
			System.out.print(card.getNumber());
		}
	}
	
	public boolean start() {
		int pairPlusBet = 0, anteBet = 0, playBet = 0;
		
		cardOpen = false;
		System.out.println("소지금 : " + gamer.getMoney());
		
		//초기 베팅
		anteBet = gamer.getAnteBet();
		
		if(anteBet == 0) {
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.println("게임을 종료합니다.");
			System.out.println("소지금 : " + gamer.getMoney());
			return false;
		}
		
		if(gamer.getMoney() != 0) {
			pairPlusBet = gamer.getPairPlusBet();
		}
		
//		if(gamer.getMoney() != 0) {
//			rule.setSixCardBonusBet(gamer.get6CardBonusBet());
//		}
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		//카드 배부 및 확인
			gamer.setHand(dealer.handOutCards());
			gResult = rule.judge(gamer.getHand());
			dResult = rule.judge(dealer.getHand());
			
		if(gamer.getMoney() != 0) {
			printHands();
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

			//Fold, Play결정
			playBet = gamer.getPlayBet(anteBet);
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		}
		
		
		cardOpen = true;
		printHands();
		
		if(playBet != -1) {
			rule.setWLResult(gResult, dResult);
			
			int money = gamer.getMoney() + rule.pay(gResult, dResult, anteBet, playBet, pairPlusBet);
			gamer.setMoney(money); 
		}
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		if(gamer.getMoney() == 0) {
			System.out.println("소지금을 탕진하셨습니다...");
			return false;
		}
		else 
			return true;
	}
}