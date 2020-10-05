
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Input extends JPanel {
	private JButton Bet[] = new JButton[3];
	private JButton Deal[] =new JButton[4];
	private ImageIcon card[] = {new ImageIcon("images/Clubs1.png"), new ImageIcon("images/Clubs2.png"), new ImageIcon("images/Clubs3.png"), new ImageIcon("images/Clubs4.png"), new ImageIcon("images/Clubs5.png"), new ImageIcon("images/Clubs6.png"), new ImageIcon("images/Clubs7.png"), new ImageIcon("images/Clubs8.png"), new ImageIcon("images/Clubs9.png"), new ImageIcon("images/Clubs10.png"), new ImageIcon("images/Clubs11.png"), new ImageIcon("images/Clubs12.png"), new ImageIcon("images/Clubs13.png") 
	,new ImageIcon("images/Diamonds1.png"), new ImageIcon("images/Diamonds2.png"), new ImageIcon("images/Diamonds3.png"), new ImageIcon("images/Diamonds4.png"), new ImageIcon("images/Diamonds5.png"), new ImageIcon("images/Diamonds6.png"), new ImageIcon("images/Diamonds7.png"), new ImageIcon("images/Diamonds8.png"), new ImageIcon("images/Diamonds9.png"), new ImageIcon("images/Diamonds10.png"), new ImageIcon("images/Diamonds11.png"), new ImageIcon("images/Diamonds12.png"), new ImageIcon("images/Diamonds13.png") 		
	,new ImageIcon("images/Hearts1.png"), new ImageIcon("images/Hearts2.png"), new ImageIcon("images/Hearts3.png"), new ImageIcon("images/Hearts4.png"), new ImageIcon("images/Hearts5.png"), new ImageIcon("images/Hearts6.png"), new ImageIcon("images/Hearts7.png"), new ImageIcon("images/Hearts8.png"), new ImageIcon("images/Hearts9.png"), new ImageIcon("images/Hearts10.png"), new ImageIcon("images/Hearts11.png"), new ImageIcon("images/Hearts12.png"), new ImageIcon("images/Hearts13.png")
	,new ImageIcon("images/Spades1.png"), new ImageIcon("images/Spades2.png"), new ImageIcon("images/Spades3.png"), new ImageIcon("images/Spades4.png"), new ImageIcon("images/Spades5.png"), new ImageIcon("images/Spades6.png"), new ImageIcon("images/Spades7.png"), new ImageIcon("images/Spades8.png"), new ImageIcon("images/Spades9.png"), new ImageIcon("images/Spades10.png"), new ImageIcon("images/Spades11.png"), new ImageIcon("images/Spades12.png"), new ImageIcon("images/Spades13.png")
	}; 
	private ImageIcon BackSide=new ImageIcon("images/b2fv.png");
	private int SecretCard;
	private int BM = 0;
	private JLabel BettingMoney= new JLabel("$"+Integer.toString(BM));
	private int money=850;
	private JLabel Mymoney= new JLabel("You have "+Integer.toString(money));
	private int turn = 2;
	private JLabel MyCard[]= new JLabel[11];
	private JLabel DealerCard[]= new JLabel[11];
	private JLabel MyNum= new JLabel();
	private JLabel DealerNum= new JLabel();
	private JLabel information = new JLabel();
	private Vector<Integer> Used = new Vector<Integer>();
	private Player I = new Player();
	private Player Com = new Player();
	public Input() {
		setLayout(null);
		Bet[0] = new JButton("Bet50");
		Bet[1] = new JButton("Bet10");
		Bet[2] = new JButton("Bet1");
		Deal[0] = new JButton("Hit");
		Deal[1] = new JButton("Stay");
		Deal[2] = new JButton("Deal");
		Deal[3] = new JButton("Again");
		Font font = new Font("Verdana", Font.BOLD,30);
		Font sfont = new Font("Verdana", Font.BOLD, 15);
		information.setFont(font);
		information.setSize(400,40);
		information.setLocation(550,350);
		information.setForeground(Color.WHITE);
		add(information);
		BettingMoney.setFont(font);
		BettingMoney.setSize(200,40);
		BettingMoney.setLocation(170,440);
		BettingMoney.setForeground(Color.YELLOW);
		Mymoney.setFont(font);
		Mymoney.setSize(300,40);
		Mymoney.setLocation(540,440);
		Mymoney.setForeground(Color.YELLOW);
		add(Mymoney);
		add(BettingMoney);
		
		for(int k=0; k<MyCard.length; k++) {
			MyCard[k] = new JLabel();
			MyCard[k].setSize(70,160);
			MyCard[k].setLocation(200+18*k, 250);
			add(MyCard[k]);
		}
		
		
		for(int z=0; z<DealerCard.length; z++) {
			DealerCard[z] = new JLabel();
			DealerCard[z].setSize(70,160);
			DealerCard[z].setLocation(100+18*z,100);
			add(DealerCard[z]);
		}
		
		MyNum.setFont(sfont);
		MyNum.setForeground(Color.WHITE);
		MyNum.setSize(30,30);
		MyNum.setLocation(237,250);
		DealerNum.setFont(sfont);
		DealerNum.setForeground(Color.WHITE);
		DealerNum.setSize(30,30);
		DealerNum.setLocation(140,100);
		add(MyNum);
		add(DealerNum);
		
		
		
		for(int i=0; i<Bet.length; i++) {
			Bet[i].setLocation(50+105*i, 500);
			Bet[i].setSize(70,55);
			add(Bet[i]);
			Bet[i].addActionListener(new addMoney());
		}
		for(int j=0; j<Deal.length; j++) {
			Deal[j].setLocation(465+105*j, 500);
			Deal[j].setSize(70,55);
			add(Deal[j]);
		}
		Deal[2].addActionListener(new MyDeal());
		Deal[1].addActionListener(new Result());
		Deal[0].addActionListener(new Hit());
		Deal[3].addActionListener(new Again());
		Deal[0].setEnabled(false);
		Deal[1].setEnabled(false);
		Deal[3].setEnabled(false);
		setOpaque(false);
	}
	
	private class Again implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Deal[0].setEnabled(false);
			Deal[1].setEnabled(false);
			Deal[2].setEnabled(true);
			Deal[3].setEnabled(false);
			for(int i=0; i<Bet.length; i++) {
				Bet[i].setEnabled(true);
			}
			for(int j=0; j<11; j++) {
				MyCard[j].setIcon(null);
			}
			for(int k=0; k<11; k++) {
				DealerCard[k].setIcon(null);
			}
			information.setText(null);
			MyNum.setText(null);
			I.Clear();
			Com.Clear();
			DealerNum.setText(null);
			BM=0;
			turn=2;
			BettingMoney.setText("$0");
			
		}
		
	}
	
	private class Hit implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int num = RandomCard.CardNumber(Used);
			I.addCard(num);
			MyCard[turn-1].setIcon(card[num]);
			MyNum.setText(Integer.toString(I.Score()));
			Used.add(num);
			if(I.Score()==21) {
				information.setText("Black Jack");
				money += (BM*2);
				Mymoney.setText("You have "+Integer.toString(money));
				Deal[0].setEnabled(false);
				Deal[1].setEnabled(false);
				Deal[3].setEnabled(true);
			}
			if(I.Score()>21) {
				information.setText("Player Busts");
				Deal[0].setEnabled(false);
				Deal[1].setEnabled(false);
				Deal[3].setEnabled(true);
			}
			turn++;
			
		}
		
	}
	
	private class Result implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			turn=3;
			while(Com.Score()<=15) {
				int num = RandomCard.CardNumber(Used);
				Com.addCard(num);
				DealerCard[turn-1].setIcon(card[num]);
				Used.add(num);
				turn++;
			}
			if(Com.Score()>21) {
				DealerCard[0].setIcon(card[SecretCard]);
				information.setText("Dealer Busts");
				DealerNum.setText(Integer.toString(Com.Score()));
				money += (BM*2);
				Mymoney.setText("You have "+Integer.toString(money));
				Deal[0].setEnabled(false);
				Deal[1].setEnabled(false);
				Deal[3].setEnabled(true);
			}
			else {
				if(21-I.Score()<21-Com.Score()) {
					DealerCard[0].setIcon(card[SecretCard]);
					DealerNum.setText(Integer.toString(Com.Score()));
					information.setText("You Win");
					money += (BM*2);
					Mymoney.setText("You have "+Integer.toString(money));
					Deal[0].setEnabled(false);
					Deal[1].setEnabled(false);
					Deal[3].setEnabled(true);
					
				}
				else if((21-I.Score()==21-Com.Score())) {
					DealerCard[0].setIcon(card[SecretCard]);
					DealerNum.setText(Integer.toString(Com.Score()));
					information.setText("Push");
					money += BM;
					Mymoney.setText("You have "+Integer.toString(money));
					Deal[0].setEnabled(false);
					Deal[1].setEnabled(false);
					Deal[3].setEnabled(true);
				}
				else {
					DealerCard[0].setIcon(card[SecretCard]);
					DealerNum.setText(Integer.toString(Com.Score()));
					information.setText("Sorry you lost");
					Deal[0].setEnabled(false);
					Deal[1].setEnabled(false);
					Deal[3].setEnabled(true);
				}
			}
			
		}
		
	}
	
	private class MyDeal implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			b.setEnabled(false);
			Deal[0].setEnabled(true);
			Deal[1].setEnabled(true);
			for(int i=0; i<Bet.length; i++) {
				Bet[i].setEnabled(false);
			}
			int num = RandomCard.CardNumber(Used);
			I.addCard(num);
			MyCard[turn-2].setIcon(card[num]);
			Used.add(num);
			num = RandomCard.CardNumber(Used);
			I.addCard(num);
			MyCard[turn-1].setIcon(card[num]);
			Used.add(num);
			num = RandomCard.CardNumber(Used);
			Com.addCard(num);
			SecretCard=num;
			Used.add(num);
			DealerCard[turn-2].setIcon(BackSide);
			num = RandomCard.CardNumber(Used);
			Com.addCard(num);
			Used.add(num);
			DealerCard[turn-1].setIcon(card[num]);
			MyNum.setText(Integer.toString(I.Score()));
			turn++;
			if(I.Score()>21) {
				information.setText("Player Busts");
				Deal[0].setEnabled(false);
				Deal[1].setEnabled(false);
				Deal[3].setEnabled(true);
			}
			else if(Com.Score()>21) {
				DealerCard[turn-2].setIcon(card[SecretCard]);
				information.setText("Dealer Busts");
				DealerNum.setText(Integer.toString(Com.Score()));
				Deal[0].setEnabled(false);
				Deal[1].setEnabled(false);
				Deal[3].setEnabled(true);
			}
			if(I.Score()==21) {
				information.setText("Black Jack");
				money += (BM*2);
				Mymoney.setText("You have "+Integer.toString(money));
				Deal[0].setEnabled(false);
				Deal[1].setEnabled(false);
				Deal[3].setEnabled(true);
			}
			
		}
	}
	
	
	private class addMoney implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("Bet50")) {
				if(money<50) {
					return;
				}
				BM+=50;
				money-=50;
			}
			else if(b.getText().equals("Bet10")) {
				if(money<10) {
					return;
				}
				BM+=10;
				money-=10;
			}
			else if(b.getText().equals("Bet1")) {
				if(money<1) {
					return;
				}
				BM+=1;
				money-=1;
			}
			BettingMoney.setText("$"+Integer.toString(BM));
			Mymoney.setText("You have "+Integer.toString(money));
			
		}
		
	}
}
