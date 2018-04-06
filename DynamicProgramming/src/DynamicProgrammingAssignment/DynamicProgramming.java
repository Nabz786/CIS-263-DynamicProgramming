package DynamicProgrammingAssignment;

/*******************************************************
 * CIS263 Dynamic Programming Assignment 
 * @author Runquan Ye
 * @version Winter 2018
 ******************************************************/

public class DynamicProgramming {
	int[] weight = new int [7];
	int[] value = new int [7];
	
	public int capacity = 50;
	public int maxValue = 0;
	
	private void inputWeight(){
		weight[0] = 0;
		weight[1] = 15;
		weight[2] = 25;
		weight[3] = 45;
		weight[4] = 30;
		weight[5] = 23;
		weight[6] = 37;
	}
	
	
	
	private void inputValue(){
		value[0] = 0;
		value[1] = 100;
		value[2] = 350;
		value[3] = 225;
		value[4] = 67;
		value[5] = 275;
		value[6] = 168;
	}
	
	
	
	private void DynamicSorting(){
		int tempValue = 0;
		int tempPreValue = 0;
		int tempWeight = 0;
		int tempPreWeight = 0;
		for (int availableItem = 0; availableItem < weight.length; availableItem++){
			for (int availableCapacity = 0; availableCapacity < capacity; availableCapacity++){
				for( int i = 0; i < availableItem; i++){	
					if(weight[i] <= availableCapacity){
						if(tempPreValue == 0 && tempPreWeight == 0) {
							tempWeight = availableCapacity - weight[i];
							tempValue += value[i];
							tempPreValue = tempValue;
							tempPreWeight = tempWeight;
							maxValue = tempValue;
						}else if(tempPreValue != 0 && tempPreWeight != 0) {
							if(weight[i] <= tempWeight) {
								tempWeight = availableCapacity - weight[i];
								tempValue += value[i];
								tempPreValue = tempValue;
								tempPreWeight = tempWeight;
								maxValue = tempValue;
							}else {
								
							}
						}
					}
				}
			System.out.print(maxValue + " ");
			}
			System.out.println("");
		}
	System.out.println("Process finish!");
	}
	
	public void main(String args[]) {
		System.out.println("Process finish!");
		DynamicSorting();
	}
}
