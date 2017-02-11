package shape;

import static org.junit.Assert.*;

import org.junit.Test;
import org.objenesis.instantiator.basic.NewInstanceInstantiator;

import view.mapPanel;
import view.test;

public class shapeITest {
	shapeI testShap;
	@Test
	public void testCanMoveLeft1() {
		int style=0;
		testShap=new shapeI(new mapPanel(style,new test()));
		for (int i = 0; i < 4; i++) {
			testShap.smallblock[i].m=11;
			testShap.smallblock[i].n=2+i;
		}
		int testMap[][]=new int[24][18];
		testMap[10][2]=1;
		testShap.setMap(testMap);
		
		assertFalse(testShap.canMoveLeft());
	}
	@Test
	public void testCanMoveLeft2() {
		int style=0;
		testShap=new shapeI(new mapPanel(style,new test()));
		for (int i = 0; i < 4; i++) {
			testShap.smallblock[i].m=14;
			testShap.smallblock[i].n=2+i;
		}
		int testMap[][]=new int[24][18];
		testShap.setMap(testMap);
		
		assertTrue(testShap.canMoveLeft());
	}
	@Test
	public void testCanMoveLeft3() {
		int style=1;
		testShap=new shapeI(new mapPanel(style,new test()));
		for (int i = 0; i < 4; i++) {
			testShap.smallblock[i].m=2;
			testShap.smallblock[i].n=2+i;
		}
		int testMap[][]=new int[24][18];
		testMap[1][2]=1;
		testShap.setMap(testMap);
		
		assertFalse(testShap.canMoveLeft());
	}
	@Test
	public void testCanMoveLeft4() {
		int style=1;
		testShap=new shapeI(new mapPanel(style,new test()));
		for (int i = 0; i < 4; i++) {
			testShap.smallblock[i].m=2;
			testShap.smallblock[i].n=2+i;
		}
		int testMap[][]=new int[24][18];
		testMap[16][2]=1;
		testShap.setMap(testMap);
		
		assertTrue(testShap.canMoveLeft());
	}
	@Test
	public void testCanMoveLeft5() {
		int style=1;
		testShap=new shapeI(new mapPanel(style,new test()));
		for (int i = 0; i < 4; i++) {
			testShap.smallblock[i].m=17;
			testShap.smallblock[i].n=2+i;
		}
		int testMap[][]=new int[24][18];
		testMap[16][2]=1;
		testShap.setMap(testMap);
		
		assertFalse(testShap.canMoveLeft());
	}

	@Test
	public void testCanMoveLeft6() {
		int style=1;
		testShap=new shapeI(new mapPanel(style,new test()));
		for (int i = 0; i < 4; i++) {
			testShap.smallblock[i].m=17;
			testShap.smallblock[i].n=2+i;
		}
		int testMap[][]=new int[24][18];
		testMap[4][2]=1;
		testShap.setMap(testMap);
		
		assertTrue(testShap.canMoveLeft());
	}

}
