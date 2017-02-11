package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class HelpPanel extends JPanel {
	Image image=Toolkit.getDefaultToolkit().createImage("background1.png");
	
	JTextArea helpText=new JTextArea(1,50);
	
	CustomButton back = new CustomButton("主菜单");

	
	public HelpPanel(){
		GridBagLayout gbL=new GridBagLayout();
		GridBagConstraints gbC=new GridBagConstraints();
		setLayout(gbL);
		
		gbC.gridx=2;gbC.gridy=1;
	   	gbC.gridwidth=1;gbC.gridheight=1;
	   	
	 	gbC.insets=new Insets(10, 5, 5, 5);
	   	
	   
	   	helpText.setFont(new Font("黑体", Font.BOLD, 20));
	   	helpText.setLineWrap(true);
	   	helpText.append("情意浓浓，战火不断\n\n");
	   	helpText.append("游戏介绍：\n\n");
	   	helpText.append("本游戏是一款以《疯狂动物城》为主题的双人俄罗斯方块。游戏分为两种模式，情侣模式和对战模式。不选择游戏模式进入游戏，默认为进入情侣模式，情侣模式是两个人使用同一个框，同时下落两个方块，每个人控制一个，配合消行、积分，激发特效，避开分裂特效。分裂特效一旦因为疏忽而被激发，即切换到对战模式，对战模式为两个框，两人分别控制自己的方块，完成消行、积分，激发特效的功能。\n");
	   	helpText.append("游戏操作:\n\n");
	   	helpText.append("玩家1：   A左移   D右移  S加速下落\n");
	   	helpText.append("玩家2：   ←左移  →右移  ↓加速下落\n\n");
	   	helpText.append("出现特效，要消掉特效所在的一行才可激发。\n");
	   	helpText.setBackground(Color.CYAN.darker().darker());
	   	helpText.setForeground(Color.WHITE);
	   	gbL.setConstraints(helpText, gbC);
	   	add(helpText);
	   	
	   	gbC.ipadx=80;gbC.ipady=30;
	   	gbC.fill=GridBagConstraints.BOTH;
	   	gbC.gridx=2;gbC.gridy=3;
		gbL.setConstraints(back, gbC);
	   	add(back);
	   	validate();
	   	
	   	
	}
    protected void paintComponent(Graphics g) {
    	
	 g.drawImage(image, 0, 0, this);

	}
}
