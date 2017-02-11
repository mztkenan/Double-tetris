package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CustomButton extends JButton implements MouseListener{
	ImageIcon imageIcon=new ImageIcon("button1.png");
	public CustomButton(String text) {
		super(text);
		customized();
	}
	
    private void customized(){
    	setIcon(imageIcon);
		setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 30));
		setHorizontalTextPosition(CENTER);
		setBackground(Color.CYAN.darker().darker().darker());
		setForeground(Color.WHITE);
   	    setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		imageIcon=new ImageIcon("button1.png");
		setIcon(imageIcon);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		imageIcon=new ImageIcon("button.png");
		setIcon(imageIcon);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		imageIcon=new ImageIcon("button1.png");
		setIcon(imageIcon);
	}
}
