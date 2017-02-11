package view;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class PreferencePanel extends JPanel{
	Image image=Toolkit.getDefaultToolkit().createImage("background1.png");
	
	CustomButton background=new CustomButton("背景设置");
    CustomButton music = new CustomButton("音效设置");
    CustomButton degree = new CustomButton("难度设置");
    CustomButton back = new CustomButton("主菜单");
    
    
    public PreferencePanel(){
       GridBagLayout gbL=new GridBagLayout();
  	   GridBagConstraints gbC = new GridBagConstraints();
  	   setLayout(gbL);
  	   
  	    gbC.gridx=2;gbC.gridy=2;
     	gbC.gridwidth=2;gbC.gridheight=2;
     	gbC.fill=GridBagConstraints.BOTH;
     	gbC.insets=new Insets(5, 5, 5, 5);
     	gbC.ipadx=80;gbC.ipady=30;
     	gbL.setConstraints(background, gbC);
     	add(background);
     	
     	gbC.gridy=4;
     	gbL.setConstraints(music, gbC);
     	add(music);
     	
     	gbC.gridy=6;
     	gbL.setConstraints(degree, gbC);
     	add(degree);
    	
     	gbC.gridy=8;
     	gbL.setConstraints(back, gbC);
     	add(back);
    }
    
protected void paintComponent(Graphics g) {
    	
	  g.drawImage(image, 0, 0, this);

	}
}
