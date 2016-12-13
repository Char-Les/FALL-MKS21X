public class Sorts{
    /**EDIT THIS METHOD TO MATCH YOUR NAME 
     */
    public static String name(){
	return "10.Weng.First"; 
    }

    /**Selection sort of an int array. 
     *Upon completion, the elements of the array will be in increasing order.
     *@param data  the elements to be sorted.
     */
    public static void selectionSort(int[] data){
	int temp;
	for (int a = 0; a < data.length - 1; a ++){
	    temp = data[0];
	    for (int b = a + 1; b < data.length; b ++){
		if (temp > data[b]){
		    temp = data[b];
		    data[b] = data[0];
		}
	    }
	    data[0] = temp;
	}
    }
    
    public static void main(String[] args){
	
    }
}
