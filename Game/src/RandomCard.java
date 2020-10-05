import java.util.Vector;

public class RandomCard {
	public static int CardNumber(Vector<Integer> v) {
		while(true) {
			int z=0;
			int n = (int)(Math.random()*52);
			for(int i=0; i<v.size(); i++) {
				if(n==v.get(i))
					z++;
			}
			if(z==1) {
				continue;
			}
			return n;
		}
		
		
	}
}
