package view;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.AttributeSet.FontAttribute;
public class StartPanel extends JPanel {
	Image image=Toolkit.getDefaultToolkit().createImage("background1.png");

	CustomButton startGameButton=new CustomButton("开始游戏");
    CustomButton preferenceButton=new CustomButton("游戏设置");
    CustomButton helpButton = new CustomButton("游戏帮助");  
    CustomButton exitButton = new CustomButton("退出游戏");
    
    public StartPanel(){
    	GridBagLayout gbL=new GridBagLayout();
    	GridBagConstraints gbC=new GridBagConstraints();
    	setLayout(gbL);
    	
    	gbC.gridx=4;gbC.gridy=1;
    	gbC.gridwidth=2;gbC.gridheight=1;
    	gbC.fill=GridBagConstraints.BOTH;
    	gbC.insets=new Insets(5, 5, 5, 5);
    	gbC.ipadx=80;gbC.ipady=30;
    	gbL.setConstraints(startGameButton, gbC);
    	add(startGameButton);
    	
    	gbC.gridy=2;
    	gbL.setConstraints(preferenceButton, gbC);
    	add(preferenceButton);
    	
    	gbC.gridy=3;
    	gbL.setConstraints(helpButton, gbC);
    	add(helpButton);
    	
    	gbC.gridy=4;
    	gbL.setConstraints(exitButton, gbC);
    	add(exitButton);
    }
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	g.drawImage(image, 0, 0, this);

	}
	
	
	
	
}


