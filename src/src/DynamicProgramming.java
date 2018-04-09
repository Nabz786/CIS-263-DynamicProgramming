/*******************************************************
 * CIS263 Dynamic Programming Assignment
 * @author Runquan Ye, Nabeel Vali
 * @version Winter 2018
 * Used https://www.sanfoundry.com/java-program-solve-knapsack-problem-using-dp/
 * for reference
 *******************************************************/
public class DynamicProgramming {
    /** Integer array to hold weights.**/
    static int[] weight = new int[6];

    /** Integer array to hold values.**/
    static int[] value = new int[6];

    /**
     * Inits all values in the weight array
     */
    public static void initWeight() {
        weight[0] = 15;
        weight[1] = 25;
        weight[2] = 45;
        weight[3] = 30;
        weight[4] = 23;
        weight[5] = 37;
    }

    /**
     * Inits all values corresponding to weights
     */
    public static void initValue() {
        value[0] = 100;
        value[1] = 350;
        value[2] = 225;
        value[3] = 67;
        value[4] = 275;
        value[5] = 168;
    }

    /**
     * Dynamically works through knapsack
     * @param maxCap - max Capacity
     * @param value - int values
     * @param weight - weights corresponding to values
     * @return int - the final knapsack
     */
    public static int DynamicSorting(int maxCap, int value[], int weight[]) {

        /** Number of items .**/
        int totalItems = weight.length;

        /** New knapsack .**/
        int[][] knap_sack = new int[totalItems + 1][maxCap + 1];

        for (int r = 0; r <= totalItems; r++) {
            for (int c = 0; c <= maxCap; c++) {
                // 0 for capacity or no items, set element to zero
                if (r == 0 || c == 0) {
                    knap_sack[r][c] = 0;
                }
                //check if the element weight is <= the current weight
                else if (weight[r - 1] <= c) {
                    //update the table if the current value + current table value is greater than the value on the
                    //table
                    knap_sack[r][c] = Math.max(value[r - 1] + knap_sack[r - 1][c - weight[r - 1]], knap_sack[r - 1][c]);
                }
                else {
                    //update the next table value if we could not update the previous due to weight constraints
                    knap_sack[r][c] = knap_sack[r - 1][c];
                }
            }
        }

        //print out the values of the final knapsack
        for(int i = 0; i < knap_sack.length; i++){
            for(int j = 0; j < knap_sack[i].length; j++){
                System.out.format("%5s", knap_sack[i][j]);
            }
            System.out.println();
        }

        return knap_sack[totalItems][maxCap];
    }

    public static void main(String[] args) {
        initValue();
        initWeight();
        DynamicSorting(50, value, weight);
    }
}
