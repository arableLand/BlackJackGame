
import javax.swing.JFrame;

public class BlackJack extends JFrame{
	
	public BlackJack() {
		setTitle("BlackJack");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Ground ground = new Ground();
		setContentPane(ground);
		ground.setLayout(null);
		Input s = new Input();
		s.setSize(900,650);
		s.setLocation(0,0);
		ground.add(s);
		
		setSize(900,650);
		setVisible(true);
	}

	public static void main(String[] args) {
		new BlackJack();

	}

}
