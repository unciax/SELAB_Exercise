import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ZeroOneGeneratorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZeroOneGenerator zog = new ZeroOneGenerator();
		Scanner input = new Scanner(System.in);
		File f = new File("C:\\phero.in");
		int strlen,numOfOne,func;
		System.out.printf("請輸入字串長度：");
		strlen = input.nextInt();
		System.out.printf("請輸入一的個數：");
		numOfOne = input.nextInt();
		//System.out.printf("選擇費洛蒙陣列:\n  1.預設陣列(全部為0.5)\n  2.使用檔案載入\n\n 你的選擇:");
		//func = input.nextInt();
		func=1;
		switch(func){
			case 1:
				System.out.println(zog.generate(strlen, numOfOne));
				break;
			case 2:
				try {
					Scanner dinput = new Scanner(f);
					Pheromone phero[][];
					phero = new Pheromone[numOfOne+1][strlen-numOfOne+1];
					for(int h=0;h<=numOfOne;h++){
						for(int w=0;w<=strlen-numOfOne;w++){
							phero[h][w] = new Pheromone(2);
							phero[h][w].setPheromone(0, 0.5);//向下(不通)	
							phero[h][w].setPheromone(1, 0.5);//向右(不通)
						}
					}
					System.out.println(zog.generate(strlen, numOfOne, phero));
				} catch (FileNotFoundException e) {
					System.out.printf("錯誤:phero.in不存在於目錄中。\n");
					e.printStackTrace();
				}

				
				break;
			default:
				System.out.printf("錯誤:無此選項\n");
		}
	}

}
