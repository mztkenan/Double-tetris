package view;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class ModelPanel extends JPanel{
   Image image=Toolkit.getDefaultToolkit().createImage("background1.png");
	
   CustomButton fightButton=new CustomButton("对战模式");
   CustomButton coupleButton=new CustomButton("情侣模式");
   CustomButton back = new CustomButton("主菜单");
   
   public ModelPanel(){
	   GridBagLayout gbL=new GridBagLayout();
	   GridBagConstraints gbC = new GridBagConstraints();
	   setLayout(gbL);
	   
	gbC.gridx=2;gbC.gridy=2;
   	gbC.gridwidth=2;gbC.gridheight=2;
   	gbC.fill=GridBagConstraints.BOTH;
   	gbC.insets=new Insets(5, 5, 5, 5);
   	gbC.ipadx=80;gbC.ipady=30;
   	gbL.setConstraints(fightButton, gbC);
   	add(fightButton);
   	
   	gbC.gridy=4;
   	gbL.setConstraints(coupleButton, gbC);
   	add(coupleButton);
   	
   	gbC.gridy=6;
   	gbL.setConstraints(back, gbC);
   	add(back);
   }
   
   protected void paintComponent(Graphics g) {
   	
	   g.drawImage(image, 0, 0, this);

	}
	
}
