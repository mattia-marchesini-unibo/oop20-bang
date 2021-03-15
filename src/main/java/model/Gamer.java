package model;

public class Gamer {
	
	private int range;
	private int pos;
	
	public Gamer(int pos, int range) {
		this.range = range;
		this.pos = pos;
	}
	
	public void changeRange(BlueCardImpl bluecard) {
		this.range = bluecard.getRangeShout();
	}
	
	
}
