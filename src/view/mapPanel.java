package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import org.omg.CORBA.INTERNAL;

import shape.absShape;
import shape.shapeI;
import shape.shapeT;
import shape.shapeLeftL;
import shape.shapeRightL;
import shape.shapeLeftZ;
import shape.shapeRightZ;
import shape.shapeSquare;

public class mapPanel extends JPanel implements KeyListener, Runnable {
	public static final int ROWS = 18, COLS = 24;
	public static final int FastInterval = 100, SlowInterval = 500;

	private int interval = SlowInterval; // 线程调用重绘方法的时间间隔
	private int vanishLines; // 消行行数
	private int score1; // 分数1
	private int score2; // 分数2
	private int style;
	private test _testframe = null;
	private boolean isPause = false;
	public absShape[] dqfk = new absShape[2]; // 基类引用引用子类对象,当前方块
	private Image[] pic = new Image[2]; // 两方的填充方块图片
	private Image background;

	public int[][] map = new int[COLS][ROWS]; // 24列,18行

	public void setDqfk(absShape setdqfk1, absShape setdqfk2) {
		dqfk[0] = setdqfk1;
		dqfk[1] = setdqfk2;
	}
	public void setPause(boolean isPause){
			this.isPause=isPause;
	}
	public int getInterval(){
		return interval;
	}
	public int getStyle(){
		return style;
	}

	public void setRandomShape(int i) {
		int shapeStyle = (int) (Math.random() * 6);// 随机形状
		switch (shapeStyle) { // 待修改合为一个函数
		case (0):
			dqfk[i] = new shapeI(this);
			break;
		case (1):
			dqfk[i] = new shapeLeftZ(this);
			break;
		case (2):
			dqfk[i] = new shapeRightZ(this);
			break;
		case (3):
			dqfk[i] = new shapeLeftL(this);
			break;
		case (4):
			dqfk[i] = new shapeRightL(this);
			break;
		case (5):
			dqfk[i] = new shapeT(this);
			break;
		case (6):
			dqfk[i] = new shapeSquare(this);
			break;
		}
		dqfk[i].setMap(map);
		dqfk[i].reset(i);
	}

	public mapPanel(int style, test testframe) {
		pic[0] = Toolkit.getDefaultToolkit().getImage("A.png");
		pic[1] = Toolkit.getDefaultToolkit().getImage("B.png");
		background = Toolkit.getDefaultToolkit().getImage("PlayBackgound.jpg");
		this.style = style; // 对战模式，情侣模式
		this._testframe = testframe;

		for (int i = 0; i < 2; i++) {
			setRandomShape(i);
		}
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(background, 0, 0, 630, 500, this);
		// 绘制整体的24*18的格子
		g.setColor(Color.black);
		for (int i = 0; i < 25; i++) {
			g.drawLine(i * 25, 0, i * 25, 18 * 25);
		}
		for (int j = 0; j < 19; j++) {
			g.drawLine(0, j * 25, 24 * 25, j * 25);
		}
		g.setColor(Color.red);
		g.drawLine(12 * 25, 0, 12 * 25, 18 * 25);
		// 绘制当前方块
		g.setColor(Color.orange);
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) { // 绘制当前方块中的小方块数组中的每一个小方块
				int m = dqfk[i].smallblock[j].m;
				int n = dqfk[i].smallblock[j].n;
				// g.fill3DRect(m*25,n*25,25,25,true);
				g.drawImage(pic[i], m * 25, n * 25, 25, 25, this);
			}
		}

		// 绘制map中为1的位置,障碍物
		g.setColor(Color.cyan);
		for (int i = 0; i < 24; i++) {
			for (int j = 0; j < 18; j++) {
				if (map[i][j] == 1) {
					g.fill3DRect(i * 25, j * 25, 25, 25, true);
					g.drawImage(pic[0], i * 25, j * 25, 25, 25, this);
				}
			}
		}
	}

	public void keyPressed(KeyEvent e) {
		// 1是右边，0是左边
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			// 旋转
			if (dqfk[1].canTurn())
				dqfk[1].turn();
			this.repaint(); // 立刻刷新
			break;
		case KeyEvent.VK_DOWN:
			// 加速
			interval = FastInterval;
			break;
		case KeyEvent.VK_LEFT:
			if (dqfk[1].canMoveLeft())
				dqfk[1].moveLeft();
			this.repaint(); // 立刻刷新
			break;
		case KeyEvent.VK_RIGHT:
			if (dqfk[1].canMoveRight())
				dqfk[1].moveRight();
			this.repaint(); // 立刻刷新
			break;
		case KeyEvent.VK_W:
			if (dqfk[0].canTurn())
				dqfk[0].turn();
			this.repaint(); // 立刻刷新
			break;
		case KeyEvent.VK_S:
			interval = FastInterval;
			break;
		case KeyEvent.VK_A:
			if (dqfk[0].canMoveLeft())
				dqfk[0].moveLeft();
			this.repaint(); // 立刻刷新
			break;
		case KeyEvent.VK_D:
			if (dqfk[0].canMoveRight())
				dqfk[0].moveRight();
			this.repaint(); // 立刻刷新
			break;
		default:
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		// 还原速度
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_DOWN)
			interval = SlowInterval;
		if (key == KeyEvent.VK_S)
			interval = SlowInterval;
	}

	public int vanish(int playArea) { // a表示左边还是右边
		int end = COLS; // 消行终止点
		int start = 0; // 消行起始点
		if (style == 0) // 情侣模式,待修改，styl不应为dqfk
		{
			start = 0;
			end = COLS;
			playArea = 2;
		} else // (dqfk[1].style==1) //对战模式
		{
			if (playArea == 0) {
				start = 0;
				end = COLS / 2;
			} else if (playArea == 1) {
				start = 13;
				end = COLS;
			}
		}
		int lines = 0;
		for (int i = 0; i < ROWS; i++) {
			if (canvanish(i, playArea)) {// PlayArea可能为0左边，1右边，2表示情侣模式共同计分
				lines++;
				for (int j = i; j >= 1; j--) {
					for (int k = start; k < end; k++) {
						map[k][j] = map[k][j - 1];
					}
				}
			}
		}
		return lines * 10; // 返回分数，行数*10
	}

	// 判断是否能消行
	public boolean canvanish(int row, int PlayArea) {
		int start = 0; // start表示判断消行起始位置
		int end = COLS; // isRight表示在左边或是右边
		if (PlayArea == 0) {// PlayArea可能为0左边，1右边，2表示情侣模式共同计分
			start = 0;
			end = 12;
		} else if (PlayArea == 1) {
			start = 12;
			end = COLS;
		}
		for (; start < end; start++) {
			if (map[start][row] == 0) {// 这一行有空格，不能消行
				return false;
			}
		}
		return true;// 这一行无空格，能消行
	}

	public boolean gameover() throws InterruptedException // 游戏结束
	{
		for (int i = 0; i < COLS; i++)
			if (map[i][0] == 1) {
				_testframe.overDialog.setVisible(true);
				_testframe.t.destroy();
				return false;
			}
		return true;
	}

	public void run() {
		boolean isGameContinuing = true; // 游戏是否结束
		while (true) {
			if (isPause) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				for (int i = 0; i < 2; i++) {
					if (i == 1)
						isGameContinuing = true;
					if (dqfk[i].canMoveDown())
						dqfk[i].moveDown(); // 自动下落
					else {
						// 记载当前方块的四个小方块的最终位置信息到二维数组上
						for (int j = 0; j < 4; j++) {
							int m = dqfk[i].smallblock[j].m;
							int n = dqfk[i].smallblock[j].n;
							map[m][n] = 1;
						}

						vanishLines = vanish(i);
						if (dqfk[0].style == 0) // 情侣模式的话两个分数一起加
						{
							score1 += vanishLines;
							score2 += vanishLines;
							this._testframe.control.score1.setText(score1 + "");
							this._testframe.control.score2.setText(score2 + "");
						} else // 对战模式分开加
						{
							if (i == 0)
								score1 += vanishLines;
							else
								score2 += vanishLines;
							this._testframe.control.score1.setText(score1 + "");
							this._testframe.control.score2.setText(score2 + "");
						}

						try {
							isGameContinuing = gameover();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if (isGameContinuing != false) // 游戏未结束,重新定位一个下落的方块
							setRandomShape(i);
					}
				}
				this.repaint();
				try {
					Thread.sleep(interval);
				} catch (InterruptedException ex) {
				}
			}

		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}