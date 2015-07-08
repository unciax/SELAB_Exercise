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
		System.out.printf("�п�J�r����סG");
		strlen = input.nextInt();
		System.out.printf("�п�J�@���ӼơG");
		numOfOne = input.nextInt();
		//System.out.printf("��ܶO���X�}�C:\n  1.�w�]�}�C(������0.5)\n  2.�ϥ��ɮ׸��J\n\n �A�����:");
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
							phero[h][w].setPheromone(0, 0.5);//�V�U(���q)	
							phero[h][w].setPheromone(1, 0.5);//�V�k(���q)
						}
					}
					System.out.println(zog.generate(strlen, numOfOne, phero));
				} catch (FileNotFoundException e) {
					System.out.printf("���~:phero.in���s�b��ؿ����C\n");
					e.printStackTrace();
				}

				
				break;
			default:
				System.out.printf("���~:�L���ﶵ\n");
		}
	}

}
