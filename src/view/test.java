package view;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class test extends JFrame implements ActionListener{
	    Image image=Toolkit.getDefaultToolkit().createImage("background.jpg");
	    Thread t=null;
	    
	    StartPanel start=new StartPanel();	
	    ModelPanel model=new ModelPanel();
	    PreferencePanel preference=new PreferencePanel();
	    HelpPanel help=new HelpPanel();
	    BackgroundChoose bgchoose=new BackgroundChoose();
	    Container con=this.getContentPane();
	    PlayControl control=new PlayControl(this);
	    mapPanel playMap=null;
	    GameOverDialog overDialog=new GameOverDialog();
	    
	    BorderLayout bLayout=new BorderLayout();
	    
	   public test() {
			
	    	con.add(start);
			
			start.startGameButton.addActionListener(this);
			start.preferenceButton.addActionListener(this);
			start.helpButton.addActionListener(this);
			start.exitButton.addActionListener(this);
			
			start.startGameButton.addMouseListener(start.startGameButton);
			start.preferenceButton.addMouseListener(start.preferenceButton);
			start.helpButton.addMouseListener(start.helpButton);
			start.exitButton.addMouseListener(start.exitButton);
			
			model.back.addActionListener(this);
			model.coupleButton.addActionListener(this);
			model.fightButton.addActionListener(this);
			model.back.addMouseListener(model.back);
			model.coupleButton.addMouseListener(model.coupleButton);
			model.fightButton.addMouseListener(model.fightButton);
			
			help.back.addActionListener(this);
			help.back.addMouseListener(help.back);
			
			preference.back.addActionListener(this);
			preference.background.addActionListener(this);
			preference.degree.addActionListener(this);
			preference.music.addActionListener(this);
			preference.back.addMouseListener(preference.back);
			preference.background.addMouseListener(preference.background);
			preference.degree.addMouseListener(preference.degree);
			preference.music.addMouseListener(preference.music);
			
            bgchoose.Button1.addActionListener(this);
            bgchoose.Button2.addActionListener(this);
            bgchoose.Button3.addActionListener(this);
            bgchoose.back.addActionListener(this);
            bgchoose.Button1.addMouseListener(bgchoose.Button1);
            bgchoose.Button2.addMouseListener(bgchoose.Button2);
            bgchoose.Button3.addMouseListener(bgchoose.Button3);
            bgchoose.back.addMouseListener(bgchoose.back);
            
            
            control.pause.addActionListener(this);
            control.restart.addActionListener(this);
            control.back.addActionListener(this);
            control.exit.addActionListener(this);  
		}

		
	   public static void main(String[] args) {
			
			test testFrame=new test();
			testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			testFrame.setSize(800,600);
			testFrame.setVisible(true);
			testFrame.setResizable(false);
			testFrame.setTitle("史上最牛俄罗斯方块");	
		}
	   
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==start.startGameButton){
				remove(start);
			    con.add(model);
			    }
			if(e.getSource()==start.preferenceButton){
				remove(start);
				con.add(preference);
			}
			if (e.getSource()==start.helpButton){ 
				remove(start);
				con.add(help);
			}
			if (e.getSource()==start.exitButton) 
				System.exit(0);
			
			if (e.getSource()==model.back) {
				remove(model);
				con.add(start);
			}
			if (e.getSource()==model.fightButton) {
				remove(model);
				playMap=new mapPanel(1,this); 
				
                setLayout(bLayout);
                add(new JLabel("                         "), BorderLayout.WEST);
                add(new JLabel("    "), BorderLayout.EAST);
                add(control,BorderLayout.SOUTH);
                add(playMap,BorderLayout.CENTER);
                
                
            	playMap.addKeyListener(playMap);
                //开始线程
                t=new Thread(playMap);
                t.start();
                playMap.requestFocus(); 
			}
			if (e.getSource()==model.coupleButton) {
                remove(model);
                playMap=new mapPanel(0,this);
 
                setLayout(bLayout);
                add(new JLabel("                         "), BorderLayout.WEST);
                add(new JLabel("    "), BorderLayout.EAST);
                add(new JLabel("    \n  "), BorderLayout.NORTH);
                add(control,BorderLayout.SOUTH);
                add(playMap,BorderLayout.CENTER);
                 
            	playMap.addKeyListener(playMap);
                //开始线程
                t=new Thread(playMap);
                t.start();
                playMap.requestFocus();
			}
			if (e.getSource()==preference.background) {
				remove(preference);
				con.add(bgchoose);
			}
			if (e.getSource()==preference.music) {
				
			}
			if (e.getSource()==preference.degree) {
			
			}
			if (e.getSource()==preference.back) {
				remove(preference);
				con.add(start);
			}
			if(e.getSource()==help.back){
				remove(help);
				con.add(start);
			}
			
			if (e.getSource()==bgchoose.Button1) {
                start.image=Toolkit.getDefaultToolkit().createImage("background1.png");
                model.image=Toolkit.getDefaultToolkit().createImage("background1.png");
                preference.image=Toolkit.getDefaultToolkit().createImage("background1.png");
                bgchoose.image=Toolkit.getDefaultToolkit().createImage("background1.png");
                help.image=Toolkit.getDefaultToolkit().createImage("background1.png");
                
			}
            if (e.getSource()==bgchoose.Button2) {
            	 start.image=Toolkit.getDefaultToolkit().createImage("background2.png");
                 model.image=Toolkit.getDefaultToolkit().createImage("background2.png");
                 preference.image=Toolkit.getDefaultToolkit().createImage("background2.png");
                 bgchoose.image=Toolkit.getDefaultToolkit().createImage("background2.png");
                 help.image=Toolkit.getDefaultToolkit().createImage("background2.png");
                
			}
            if (e.getSource()==bgchoose.Button3) {
            	 start.image=Toolkit.getDefaultToolkit().createImage("background3.png");
                 model.image=Toolkit.getDefaultToolkit().createImage("background3.png");
                 preference.image=Toolkit.getDefaultToolkit().createImage("background3.png");
                 bgchoose.image=Toolkit.getDefaultToolkit().createImage("background3.png");
                 help.image=Toolkit.getDefaultToolkit().createImage("background3.png");
                
			}
            if (e.getSource()==bgchoose.back) {
            	remove(bgchoose);
				con.add(start); 
			}
            if (e.getSource()==control.pause) {
            	playMap.setPause(true);
    		}
    		if (e.getSource()==control.restart) {
    			playMap.setPause(false);
    		}
    		if (e.getSource()==control.back) {
    			playMap.setPause(true);
    			con.removeAll();
    		
    			con.add(start); 
   			 validate();//刷新所有组件
   			 repaint();//重新绘制
    		}
    		if (e.getSource()==control.exit) {
    			System.exit(0);
    		}
            
			 validate();//刷新所有组件
			 repaint();//重新绘制
			
		}
	

}
