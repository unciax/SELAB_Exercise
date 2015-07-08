/* 
  Class Name    : ZeroOneGenerator
  Author        : UnciaX
  Last Modified : 2015.07.07
*/
public class ZeroOneGenerator {
	
	Pheromone phero[][]; // �O���X
	int now_x,now_y; // ���Ʀ�m
	double defaultPhero = 0.5; //�w�]�O���X��
	
	String generate( int n , int m ){
		// ���ͤ@��0-1�r��æ^��  ���� : n => �r�����, m => 1���Ӽ�	
		
		// ���͹w�]�O���X�}�C
		int height=m;
		int width=n-height;
		phero = new Pheromone[height+1][width+1];
		for(int h=0;h<=height;h++){
			for(int w=0;w<=width;w++){
				phero[h][w] = new Pheromone(2);
				if(h!=height)	phero[h][w].setPheromone(0,  defaultPhero);//�V�U
				else phero[h][w].setPheromone(0, 0);//�V�U(���q)
				if(w!=width) phero[h][w].setPheromone(1, defaultPhero);//�V�k	
				else phero[h][w].setPheromone(1, 0);//�V�k(���q)
			}
		}
		
		return generate(n,m,phero);
	}
	
	String generate( int n , int m , Pheromone phero[][]){
		 // ���ͤ@��0-1�r��æ^��  ���� : n => �r�����, m => 1���Ӽ�, phero => �O���X�}�C
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
		//���L��ܪk
	    int i, currentPostion=0;
	    double randValue, probPostion[];
	    // �إߤ@�ӦW���uprobPostion�v���}�C���o�U���v���϶�
	    probPostion = new double[n];
	    probPostion[0] = theArray[0];
	    for(i=1;i<n;i++){
	        probPostion[i]=probPostion[i-1]+theArray[i];
	    }
	    // ���o�@�ӽd��[0,1)���ü�
	    randValue = (Math.random()*9+1.0)/10.0;
	    // �P�_�üƩҦb�϶�
	    for(i=0;i<n;i++)
	    {
	        if(randValue<probPostion[i])
	        {
	            currentPostion = i;
	            break;
	        }
	    }
	    // �^�ǯ��ޭ�
	    return currentPostion;
	}
}
