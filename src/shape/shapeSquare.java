package shape;

import view.mapPanel;

public class shapeSquare extends absShape{              //子类
	 public shapeSquare(mapPanel mappanel) {
			super(mappanel);
		}
	public void reset(int k){              //实现从基类中继承下来的抽象方法
        //给state赋一个随机数
                smallblock[0].m = 5+k*12;
                smallblock[0].n = 0;
                smallblock[1].m = 6+k*12;
                smallblock[1].n = 0;
                smallblock[2].m = 5+k*12;
                smallblock[2].n = 1;
                smallblock[3].m = 6+k*12;
                smallblock[3].n = 1;
    }
    public void turn(){               //实现从基类继承下来的抽象方法
        
    }

    public boolean canTurn() {
    return true;
}
}
