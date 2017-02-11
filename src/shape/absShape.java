package shape;

import view.mapPanel;

//小方块类
//待修改，mappanel可以用公共变量

public abstract class absShape{
	public SmallBlock [] smallblock=new SmallBlock[4];//小方块数组
	public int state;//状态
	public int style;//游戏模式,0情侣模式，1对战模式
	public int [][]map;
	int which;//用于随机产生那个方块具有特效
	absShape(mapPanel mappanel){
		for(int i=0;i<4;i++){
			smallblock[i]=new SmallBlock();
		}
		for(int i=0;i<4;i++){
        	smallblock[i].x=0;
        } 
		setStyle(mappanel);
	}
	public void setMap(int [][]map){
		this.map=map;
	}
	public void setStyle(mapPanel mappanel) {
		this.style=mappanel.style;
		
	}
	abstract public void reset(int k);//重置,k=0为左，k=1为右
	abstract public void turn();//旋转
	abstract public boolean canTurn();//是否能旋转
	//是否能向左移动
	public boolean canMoveLeft(){
		int i;
		for(i=0;i<4;i++){
			int m=smallblock[i].m-1;
			int n=smallblock[i].n;
			if(style==0)//情侣模式
			{
				if(m<0||m>23||n<0||n>17||map[m][n]==1)
					break;
			}
			else//对战模式
			{
				if(m<11){
					if(m<0||m>11||n<0||n>17||map[m][n]==1)
						break;	
						
				}
				else{
					m-=12;
					if(m<0||m>11||n<0||n>17||map[m][n]==1)
						break;			
				}
			
			}
		}
		if(i<4) return false;
		else return true;
	}
	//是否能向右移动
	public boolean canMoveRight(){
		int i;
		for(i=0;i<4;i++){
			int m=smallblock[i].m+1;
			int n=smallblock[i].n;
			if(style==0)//情侣模式
			{
				if(m<0||m>23||n<0||n>17||map[m][n]==1)
					break;
			}
			else//对战模式
			{
				if(m<13){
					if(m<0||m>11||n<0||n>17||map[m][n]==1)
						break;
				}
				else{
					m-=12;                               //待修复
					if(m<0||m>11||n<0||n>17||map[m][n]==1)
						break;		
				}
				
			}
		}
		if(i<4) return false;          //待修复
		else return true;
	}
	//是否能下移
	public boolean canMoveDown(){
		int i;
		for(i=0;i<4;i++){
			int m=smallblock[i].m;
			int n=smallblock[i].n+1;
			if(style==0)//情侣模式
			{
				if(m<0||m>23||n<0||n>17||map[m][n]==1)
					break;
			}
			else//对战模式
			{
				if(m<12){
					if(m<0||m>11||n<0||n>17||map[m][n]==1)
						break;
				}
				else{
					//m-=12;
					if(m<12||m>23||n<0||n>17||map[m][n]==1)
						break;	
				}
				
			}
		}
		if(i<4) return false;
		else return true;
	}
	//左移
	public void moveLeft(){
		for(int i=0;i<4;i++){
			smallblock[i].m--;
		}
	}
	//右移
	public void moveRight(){
		for(int i=0;i<4;i++){
			smallblock[i].m++;
		}
	}
	//下移
	public void moveDown(){
		for(int i=0;i<4;i++){
			smallblock[i].n++;
		}
	}
}







/*public abstract class absShape{
	public SmallBlock [] smallblock=new SmallBlock[4];//小方块数组
	int state;//状态
	int style=0;//游戏模式
	int [][]map;
	absShape(){
		for(int i=0;i<4;i++){
			smallblock[i]=new SmallBlock();
		}
	}
	public void setMap(int [][]map){
		this.map=map;
	}
	abstract public void reset(int k);//重置,k=0为左，k=1为右
	abstract public void turn();//旋转
	abstract public boolean canTurn();//是否能旋转
	
	//是否能向左移动
	public boolean canMoveLeft(){
		int i;
		for(i=0;i<4;i++){
			int m=smallblock[i].m-1;
			int n=smallblock[i].n;
			if(style==0)//情侣模式
			{
				if(m<0||m>23||n<0||n>17||map[m][n]==1)
					break;
			}
			else//对战模式
			{
				if(m<12){
					if(m<0||m>11||n<0||n>17||map[m][n]==1)
						break;
				}
				else{
					m-=12;
					if(m<0||m>11||n<0||n>17||map[m][n]==1)
						break;	
				}
				
			}
		}
		if(i<4) return false;
		else return true;
	}
	//是否能向右移动
	public boolean canMoveRight(){
		int i;
		for(i=0;i<4;i++){
			int m=smallblock[i].m+1;
			int n=smallblock[i].n;
			if(style==0)//情侣模式
			{
				if(m<0||m>23||n<0||n>17||map[m][n]==1)
					break;
			}
			else//对战模式
			{
				if(m<12){
					if(m<0||m>11||n<0||n>17||map[m][n]==1)
						break;
				}
				else{
					m-=12;
					if(m<0||m>11||n<0||n>17||map[m][n]==1)
						break;	
				}
				
			}
		}
		if(i<4) return false;
		else return true;
	}
	//是否能下移
	public boolean canMoveDown(){
		int i;
		for(i=0;i<4;i++){
			int m=smallblock[i].m;
			int n=smallblock[i].n+1;
			if(style==0)//情侣模式
			{
				if(m<0||m>23||n<0||n>17||map[m][n]==1)
					break;
			}
			else//对战模式
			{
				if(m<12){
					if(m<0||m>11||n<0||n>17||map[m][n]==1)
						break;
				}
				else{
					m-=12;
					if(m<0||m>11||n<0||n>17||map[m][n]==1)
						break;	
				}
				
			}
		}
		if(i<4) return false;
		else return true;
	}
	//左移
	public void moveLeft(){
		for(int i=0;i<4;i++){
			smallblock[i].m--;
		}
	}
	//右移
	public void moveRight(){
		for(int i=0;i<4;i++){
			smallblock[i].m++;
		}
	}
	//下移
	public void moveDown(){
		for(int i=0;i<4;i++){
			smallblock[i].n++;
		}
	}
}
*/



