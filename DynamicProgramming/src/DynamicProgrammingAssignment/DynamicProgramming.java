package DynamicProgrammingAssignment;

/*******************************************************
 * CIS263 Dynamic Programming Assignment 
 * @author Runquan Ye
 * @version Winter 2018
 ******************************************************/

public class DynamicProgramming {
	static int[] weight = new int [7];
	static int[] value = new int [7];
	
	public static int capacity = 50;

	
	public static void inputWeight(){
		weight[0] = 0;
		weight[1] = 15;
		weight[2] = 25;
		weight[3] = 45;
		weight[4] = 30;
		weight[5] = 23;
		weight[6] = 37;
	}
	
	
	
	public static void inputValue(){
		value[0] = 0;
		value[1] = 100;
		value[2] = 350;
		value[3] = 225;
		value[4] = 67;
		value[5] = 275;
		value[6] = 168;
	}
	
	
	
	public static void DynamicSorting(){
		int tempValue = 0;
		int tempPreValue = 0;
		int tempWeight = 0;
		int tempPreWeight = 0;
		
		System.out.print("   ");
		for (int availableCapacity = 0; availableCapacity <= capacity; availableCapacity++){
			System.out.print(availableCapacity + " ");
		}
		System.out.println("");

		
		for (int availableItem = 0; availableItem <= weight.length; availableItem++){
			System.out.print(availableItem + "| ");
			for (int availableCapacity = 0; availableCapacity <= capacity; availableCapacity++){
				for( int i = 0; i < availableItem; i++){	
					if(weight[i] <= availableCapacity){
						if(tempPreValue == 0 && tempPreWeight == 0) {
							tempWeight = availableCapacity - weight[i];
							tempValue += value[i];
							tempPreValue = tempValue;
							tempPreWeight = tempWeight;
						}else if(tempPreValue != 0 && tempPreWeight != 0) {
							if(weight[i] <= tempWeight) {
								tempWeight = availableCapacity - weight[i];
								tempValue += value[i];
								tempPreValue = tempValue;
								tempPreWeight = tempWeight;
							}
						}
					}
				}
			System.out.print(tempValue + " ");
			}
			System.out.println("");
		}
	System.out.println("Process finish!");
	}
	
	public static void main(String args[]) {
		inputWeight();
		inputValue();
		System.out.println(weight[5]);
		DynamicSorting();
	}
}
