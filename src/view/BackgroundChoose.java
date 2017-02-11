package view;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class BackgroundChoose extends JPanel{
	Image image=Toolkit.getDefaultToolkit().createImage("background1.png");
	
	CustomButton Button1=new CustomButton("主题一");
    CustomButton Button2=new CustomButton("主题二");
    CustomButton Button3=new CustomButton("主题三");  
    CustomButton back=new CustomButton("主菜单");
    
    public BackgroundChoose() {
        
        	GridBagLayout gbL=new GridBagLayout();
        	GridBagConstraints gbC=new GridBagConstraints();
        	setLayout(gbL);
        	
        	gbC.gridx=4;gbC.gridy=1;
        	gbC.gridwidth=2;gbC.gridheight=1;
        	gbC.fill=GridBagConstraints.BOTH;
         	gbC.insets=new Insets(5, 5, 5, 5);
           	gbC.ipadx=80;gbC.ipady=30;
        	gbL.setConstraints(Button1, gbC);
        	add(Button1);
        	
        	gbC.gridy=2;
        	gbL.setConstraints(Button2, gbC);
        	add(Button2);
        	
        	gbC.gridy=3;
        	gbL.setConstraints(Button3, gbC);
        	add(Button3);
        	
        	gbC.gridy=4;
        	gbL.setConstraints(back, gbC);
        	add(back);
        }
        protected void paintComponent(Graphics g) {
        	super.paintComponent(g);
        	g.drawImage(image, 0, 0, this);

    	}
 
}
