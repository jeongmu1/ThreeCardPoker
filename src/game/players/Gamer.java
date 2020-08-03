package game.players;

import java.util.Scanner;

import game.card.Card;

public class Gamer extends Player {
	private int money = 5000;
	Scanner scan = new Scanner(System.in);

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	public void setHand(Card[] hand) {
		this.hand = hand;
	}
	
	public int getAnteBet() {
		int input;
		
		while(true) {
			System.out.print("Ante베팅 금액을 입력해주세요 (0은 종료) >> ");
			input = scan.nextInt();
			
			if(input > money) {
				System.out.println("소지금보다 작은 금액을 입력해주세요.");
				continue;
			}
			
			if(input < 0) {
				System.out.println("0보다 큰 금액을 입력해주세요.");
				continue;
			}
			
			money -= input;
			return input;
		}
	}
	
	public int getPairPlusBet() {
		int input;
		
		while(true) {
			System.out.print("Pair Plus 베팅 금액을 입력해주세요 >> ");
			input = scan.nextInt();
			
			if(input > money) {
				System.out.println("소지금보다 작은 금액을 입력해주세요.");
				continue;
			}
			
			if(input < 0) {
				System.out.println("0보다 큰 금액을 입력해주세요.");
				continue;
			}
			
			money -= input;
			return input;
		}
	}
	
	public int getPlayBet(int anteBet) {
		int input;
		
		while(true) {
			System.out.print("1.Fold 2.Play >> ");
			input = scan.nextInt();
			
			if(input == 1) {
				System.out.println("폴드하셨습니다.");
				return -1;
			}
			else if(input == 2) {
				if(anteBet < money) {
					money -= anteBet;
					System.out.println("베팅 후 소지금 : " + money);
					return anteBet;
				}
				else {
					System.out.println("올인!");
					int forReturn = money;
					money = 0;
					return forReturn;
				}
			}
			else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
	
	/*
	 * public int get6CardBonusBet() { int input;
	 * 
	 * while(true) { System.out.print("6 Card Bonus 베팅 금액을 입력해주세요 >> "); input =
	 * scan.nextInt();
	 * 
	 * if(input > money) { System.out.println("소지금보다 작은 금액을 입력해주세요."); continue; }
	 * 
	 * if(input < 0) { System.out.println("0보다 큰 금액을 입력해주세요."); continue; }
	 * 
	 * money -= input; return input; } }
	 */
}