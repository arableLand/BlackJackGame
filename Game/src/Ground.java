import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Ground extends JPanel {
	private ImageIcon img = new ImageIcon("images/table.JPG");
	private Image table = img.getImage();
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(table, 0, 0, getWidth(), getHeight(), this);
	}

}
