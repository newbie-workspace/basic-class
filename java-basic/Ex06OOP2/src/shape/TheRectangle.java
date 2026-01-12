package shape; //package 선언문
		// class TheRectangle { // default class 는 같은 package 에서만 사용할 수 있다.
public class TheRectangle { // public class는 다른 package 에서도 이 클래스를 사용할수 있다.

	int leftX;
	private int topY;
	private int rightX;
	private int bottomY;
	public int getLeftX() {
		return leftX;
	}
	public void setLeftX(int leftX) {
		this.leftX = leftX;
	}
	public int getTopY() {
		return topY;
	}
	public void setTopY(int topY) {
		this.topY = topY;
	}
	public int getRightX() {
		return rightX;
	}
	public void setRightX(int rightX) {
		this.rightX = rightX;
	}
	public int getBottomY() {
		return bottomY;
	}
	public void setBottomY(int bottomY) {
		this.bottomY = bottomY;
	}
	
}
