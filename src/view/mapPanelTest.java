package view;

import java.awt.event.*;
import java.util.Iterator;
import java.awt.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.mockito.Mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.objenesis.instantiator.basic.NewInstanceInstantiator;

import shape.absShape;
import shape.shapeI;


public class mapPanelTest {
	KeyEvent e;
	mapPanel testPanel=new mapPanel(0, new test());
	absShape dqfk1=mock(absShape.class);  //使用mockito框架创建模拟对象
	absShape dqfk2=mock(absShape.class);
	@Rule
	public ExpectedException expectedEx=ExpectedException.none();
	
	@Test
	public void testKeyPressed1() {
	e=new KeyEvent(new Button("click"), 1, 20, 1, KeyEvent.VK_DOWN);
	testPanel.keyPressed(e);
	assertEquals(testPanel.interval, 100);
	
	}
	@Test
	public void testKeyPressed2() {
		expectedEx.expect(Exception.class);                      //设置希望获得的异常类型
		expectedEx.expectMessage("1turn");                    //设置希望获得的异常信息子串
		e=new KeyEvent(new Button("click"), 1, 20, 1, KeyEvent.VK_W);
		when(dqfk1.canTurn()).thenReturn(true);				//模拟可以旋转，返回TRUE
		doThrow(new Exception("1turn")).when(dqfk1).turn();//模拟旋转，抛出异常
		testPanel.setDqfk(dqfk1, dqfk2);
		testPanel.keyPressed(e);
	}


	@Test
	public void testKeyPressed3() {
		e=new KeyEvent(new Button("click"), 1, 20, 1, KeyEvent.VK_W);
		when(dqfk1.canTurn()).thenReturn(false);   //模拟不可以旋转，返回FALSE
		testPanel.setDqfk(dqfk1, dqfk2);
		testPanel.keyPressed(e);
		verify(dqfk1,never()).turn();
	}
	@Test
	public void testKeyPressed4() {
		expectedEx.expect(Exception.class);                      //设置希望获得的异常类型
		expectedEx.expectMessage("2turn");                    //设置希望获得的异常信息子串
		e=new KeyEvent(new Button("click"), 1, 20, 1, KeyEvent.VK_UP);
		when(dqfk2.canTurn()).thenReturn(true);				//模拟可以旋转，返回TRUE
		doThrow(new Exception("2turn")).when(dqfk2).turn();//模拟旋转发出异常
		testPanel.setDqfk(dqfk1, dqfk2);
		testPanel.keyPressed(e);
	}


	@Test
	public void testKeyPressed5() {
		e=new KeyEvent(new Button("click"), 1, 20, 1, KeyEvent.VK_UP);
		when(dqfk2.canTurn()).thenReturn(false);   //模拟不可以旋转，返回FALSE
		testPanel.setDqfk(dqfk1, dqfk2);
		testPanel.keyPressed(e);
		verify(dqfk2,never()).turn();
	}
	@Test
	public void testKeyPressed6() {
		expectedEx.expect(Exception.class);                      //设置希望获得的异常类型
		expectedEx.expectMessage("1moveleft");                    //设置希望获得的异常信息子串
		e=new KeyEvent(new Button("click"), 1, 20, 1, KeyEvent.VK_A);
		when(dqfk1.canMoveLeft()).thenReturn(true);				//模拟可以左移，返回TRUE
		doThrow(new Exception("1moveleft")).when(dqfk1).moveLeft();//模拟左移发出异常
		testPanel.setDqfk(dqfk1, dqfk2);
		testPanel.keyPressed(e);
	}


	@Test
	public void testKeyPressed7() {
		e=new KeyEvent(new Button("click"), 1, 20, 1, KeyEvent.VK_A);
		when(dqfk1.canMoveLeft()).thenReturn(false);
		testPanel.setDqfk(dqfk1, dqfk2);
		testPanel.keyPressed(e);
		verify(dqfk1,never()).moveLeft();
	}
	@Test
	public void testKeyPressed8() {
		expectedEx.expect(Exception.class);                      //设置希望获得的异常类型
		expectedEx.expectMessage("2moveleft");                    //设置希望获得的异常信息子串
		e=new KeyEvent(new Button("click"), 1, 20, 1, KeyEvent.VK_LEFT);
		when(dqfk2.canMoveLeft()).thenReturn(true);				//模拟可以左移，返回TRUE
		doThrow(new Exception("2moveleft")).when(dqfk2).moveLeft();//模拟左移发出异常
		testPanel.setDqfk(dqfk1, dqfk2);
		testPanel.keyPressed(e);
	}


	@Test
	public void testKeyPressed9() {
		e=new KeyEvent(new Button("click"), 1, 20, 1, KeyEvent.VK_LEFT);
		when(dqfk2.canMoveLeft()).thenReturn(false);
		testPanel.setDqfk(dqfk1, dqfk2);
		testPanel.keyPressed(e);
		verify(dqfk2,never()).moveLeft();
	}
	@Test
	public void testKeyPressed10() {
		expectedEx.expect(Exception.class);                      //设置希望获得的异常类型
		expectedEx.expectMessage("1moveright");                    //设置希望获得的异常信息子串
		e=new KeyEvent(new Button("click"), 1, 20, 1, KeyEvent.VK_D);
		when(dqfk1.canMoveRight()).thenReturn(true);				//模拟可以右移，返回TRUE
		doThrow(new Exception("1moveright")).when(dqfk1).moveRight();//模拟右移发出异常
		testPanel.setDqfk(dqfk1, dqfk2);
		testPanel.keyPressed(e);
	}


	@Test
	public void testKeyPressed11() {
		e=new KeyEvent(new Button("click"), 1, 20, 1, KeyEvent.VK_D);
		when(dqfk1.canMoveRight()).thenReturn(false);
		testPanel.setDqfk(dqfk1, dqfk2);
		testPanel.keyPressed(e);
		verify(dqfk1,never()).moveRight();
	}
	@Test
	public void testKeyPressed12() {
		expectedEx.expect(Exception.class);                      //设置希望获得的异常类型
		expectedEx.expectMessage("2moveright");                    //设置希望获得的异常信息子串
		e=new KeyEvent(new Button("click"), 1, 20, 1, KeyEvent.VK_RIGHT);
		when(dqfk2.canMoveRight()).thenReturn(true);				//模拟可以右移，返回TRUE
		doThrow(new Exception("2moveright")).when(dqfk2).moveRight();//模拟右移发出异常
		testPanel.setDqfk(dqfk1, dqfk2);
		testPanel.keyPressed(e);
	}


	@Test
	public void testKeyPressed13() {
		e=new KeyEvent(new Button("click"), 1, 20, 1, KeyEvent.VK_RIGHT);
		when(dqfk2.canMoveRight()).thenReturn(false);
		testPanel.setDqfk(dqfk1, dqfk2);
		testPanel.keyPressed(e);
		verify(dqfk2,never()).moveRight();
	}

	@Test
	public void testCanVanish1(){
		int a=0;int row=1;
		for (int i = 0; i < testPanel.COLS/2; i++) {
			testPanel.map[i][row]=1;
		}
		assertTrue(testPanel.canvanish(row, a));
	}
	@Test
	public void testCanVanish2(){
		int a=0;int row=1;
		for (int i = 0; i < testPanel.COLS/2-1; i++) {
			testPanel.map[i][row]=1;
		}
		assertFalse(testPanel.canvanish(row, a));
	}
	@Test
	public void testCanVanish3(){
		int a=1;int row=1;
		for (int i = 0; i < testPanel.COLS; i++) {
			testPanel.map[i][row]=1;
		}
		assertTrue(testPanel.canvanish(row, a));
	}
	@Test
	public void testCanVanish4(){
		int a=1;int row=1;
		for (int i = 0; i < testPanel.COLS/2-1; i++) {
			testPanel.map[i][row]=1;
		}
		assertFalse(testPanel.canvanish(row, a));
	}
	
	@Test
	public void testVanish1(){
		testPanel.dqfk[0].style=0;
		for (int i = 0; i < testPanel.COLS; i++) {
			for (int j = 0; j < 2; j++) {
				testPanel.map[i][j]=1;
			}
		}
		
		assertEquals(testPanel.vanish(1), 20);
	}
	@Test
	public void testVanish2(){
		testPanel.dqfk[0].style=1;
		for (int i = 0; i < testPanel.COLS/2; i++) {
			for (int j = 0; j < 3; j++) {
				testPanel.map[i][j]=1;
			}
		}
		assertEquals(testPanel.vanish(0), 30);
	}
	@Test
	public void testVanish3(){
		testPanel.dqfk[0].style=1;
		for (int i =testPanel.COLS/2 ; i < testPanel.COLS; i++) {
			for (int j = 0; j < 4; j++) {
				testPanel.map[i][j]=1;
			}
		}
		assertEquals(testPanel.vanish(1), 40);
	}

}
