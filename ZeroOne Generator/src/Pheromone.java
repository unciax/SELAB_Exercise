/* 
  Class Name    : Pheromone
  Author        : UnciaX
  Last Modified : 2015.07.07
*/
public class Pheromone {
	private double branch[];
	
	public Pheromone(){
		this(2);
	}
	
	public Pheromone(int branchnum){
		branch = new double[branchnum];
	}
	
	public boolean setPheromone(int index, double value){
		//設定費洛蒙  接收 : n => 字串長度, m => 1的個數
		if(index>branch.length-1) return false;
		branch[index]=value;
		return true;
	}
	
	public double getPheromone(int index){
		//取得費洛蒙
		if(index>branch.length-1) return -1;
		return branch[index];
	}
	
	public int getBranchNum(){
		return branch.length;
	}
}
