package shape;

import view.mapPanel;

public class shapeI extends absShape{              //子类
    public shapeI(mapPanel mappanel) {
		super(mappanel);
	}
	
	public void reset(int k){              //实现从基类中继承下来的抽象方法
        //给state赋一个随机数
        state = (int)(Math.random()*2);

        //根据state给小方块数组赋值
        if (state == 0){                //横着摆放
            for (int i = 0; i<4; i++){
                smallblock[i].m = 4+i+k*12;
                smallblock[i].n = 0;
            }
        }
        else {                          //竖着摆放
            for (int i = 0; i<4; i++){
                smallblock[i].m = 5+k*12;
                smallblock[i].n = i;
            }
        }
    }
    public void turn(){               //实现从基类继承下来的抽象方法
        if (state == 0)  {   //横->竖
            int m = smallblock[0].m + 1;
            int n = smallblock[0].n - 1;
            for (int i = 0; i<4; i++){
                smallblock[i].m = m;
                smallblock[i].n = n+i;
            }
            state = 1;

        }else {              //竖->横
            int m = smallblock[0].m - 1;
            int n = smallblock[0].n + 1;
            for (int i = 0; i<4; i++){
                smallblock[i].m = m + i;
                smallblock[i].n = n;
            }
            state = 0;
        }
    }

    public boolean canTurn() {
    	if(state==0){             //横着摆放
    		int m=smallblock[1].m;
    		int n=smallblock[1].n-1;
    		if(map[m][n]==0&&map[m][n+2]==0&&map[m][n+3]==0)
    			return true;
    		else 
    			return false;
    	}
    	else if(state==1){        //竖着摆放
    		int m=smallblock[1].m-1;
    		int n=smallblock[1].n;
    		if(m>-1&&m+3<24&&map[m][n]==0&&map[m+2][n]==0&&map[m+3][n]==0)
    			return true;
    		else
    			return false;
    	}
    	return false;
    }
}

