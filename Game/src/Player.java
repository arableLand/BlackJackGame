import java.util.Vector;

public class Player {
	private Vector<Integer> cardValue = new Vector<Integer>();
	public void addCard(int num) { cardValue.add(num);}
	public void Clear() { cardValue.clear();}
	public int Score() {
		int s=0;
		for(int i=0; i<cardValue.size(); i++) {
			if(cardValue.get(i)>0 && cardValue.get(i)<10) {
				s = s + cardValue.get(i) + 1;
			}
			else if(cardValue.get(i)==10 || cardValue.get(i)==11 || cardValue.get(i)==12) {
				s = s + 10;
			}
			else if(cardValue.get(i)>13 && cardValue.get(i)<23) {
				s = s + cardValue.get(i) -12;
			}
			else if(cardValue.get(i)==23 || cardValue.get(i)==24 || cardValue.get(i)==25) {
				s = s + 10;
			}
			else if(cardValue.get(i)>26 && cardValue.get(i)<36) {
				s = s + cardValue.get(i) - 25;
			}
			else if(cardValue.get(i)==36 || cardValue.get(i)==37 || cardValue.get(i)==38) {
				s = s + 10;
			}
			else if(cardValue.get(i)>39 && cardValue.get(i)<49) {
				s = s + cardValue.get(i) - 38;
			}
			else if(cardValue.get(i)==49 || cardValue.get(i)==50 || cardValue.get(i)==51) {
				s = s + 10;
			}
			
		}
		for(int j=0; j<cardValue.size(); j++) {
			if(cardValue.get(j)==0 || cardValue.get(j)==13 || cardValue.get(j)==26 || cardValue.get(j)==39) {
				if(s+10>21) {
					s = s+1;
				}
				else {
					s = s+10;
				}
			}
		}
		return s;
	}
	
}
