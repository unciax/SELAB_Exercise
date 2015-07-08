/* 
  Class Name    : ZeroOneGenerator
  Author        : UnciaX
  Last Modified : 2015.07.07
*/
public class ZeroOneGenerator {
	
	Pheromone phero[][]; // 費洛蒙
	int now_x,now_y; // 螞蟻位置
	double defaultPhero = 0.5; //預設費洛蒙值
	
	String generate( int n , int m ){
		// 產生一個0-1字串並回傳  接收 : n => 字串長度, m => 1的個數	
		
		// 產生預設費洛蒙陣列
		int height=m;
		int width=n-height;
		phero = new Pheromone[height+1][width+1];
		for(int h=0;h<=height;h++){
			for(int w=0;w<=width;w++){
				phero[h][w] = new Pheromone(2);
				if(h!=height)	phero[h][w].setPheromone(0,  defaultPhero);//向下
				else phero[h][w].setPheromone(0, 0);//向下(不通)
				if(w!=width) phero[h][w].setPheromone(1, defaultPhero);//向右	
				else phero[h][w].setPheromone(1, 0);//向右(不通)
			}
		}
		
		return generate(n,m,phero);
	}
	
	String generate( int n , int m , Pheromone phero[][]){
		 // 產生一個0-1字串並回傳  接收 : n => 字串長度, m => 1的個數, phero => 費洛蒙陣列
		String result="";
		int height=m;
		int width=n-height;
		while(now_x!=width || now_y!=height){
			double totalchance = phero[now_y][now_x].getPheromone(0) + phero[now_y][now_x].getPheromone(1);
			double theArray[] = new double[2];
			int selected;
			if(phero[now_y][now_x].getPheromone(0)!=0) theArray[0]=(phero[now_y][now_x].getPheromone(0)/totalchance);
			else theArray[0]=0;
			if(phero[now_y][now_x].getPheromone(1)!=0) theArray[1]=phero[now_y][now_x].getPheromone(1)/totalchance;
			else theArray[1]=0;
			selected = single_select(theArray,2);
			switch(selected){
				case 0:
					result = result + "1";
					now_y++;
					break;
				case 1:
					result = result + "0";
					now_x++;
					break;
			}
		}
		
		return result;
	}
	
	int single_select(double theArray[],int n)
	{
		//輪盤選擇法
	    int i, currentPostion=0;
	    double randValue, probPostion[];
	    // 建立一個名為「probPostion」的陣列取得各機率的區間
	    probPostion = new double[n];
	    probPostion[0] = theArray[0];
	    for(i=1;i<n;i++){
	        probPostion[i]=probPostion[i-1]+theArray[i];
	    }
	    // 取得一個範圍為[0,1)的亂數
	    randValue = (Math.random()*9+1.0)/10.0;
	    // 判斷亂數所在區間
	    for(i=0;i<n;i++)
	    {
	        if(randValue<probPostion[i])
	        {
	            currentPostion = i;
	            break;
	        }
	    }
	    // 回傳索引值
	    return currentPostion;
	}
}
