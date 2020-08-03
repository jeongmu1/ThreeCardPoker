package game.card;

public class Card {
	private final int shape;
	private final int number;
	private boolean face;
	
	public int getShape() {
		return shape;
	}

	public int getNumber() {
		return number;
	}
	
	public boolean getFace() {
		return face;
	}
	
	public void setFace(boolean input) {
		face = input;
	}

	public Card(int shape, int number, boolean face) {
		this.shape = shape;		// 0 = 클로버, 1 = 하트, 2 = 다이아, 3 = 스페이드
		this.number = number;	// J = 11, Q = 12, K = 13, A = 14
		this.face = face;	// true = 앞면, false = 뒷면
	}
}
