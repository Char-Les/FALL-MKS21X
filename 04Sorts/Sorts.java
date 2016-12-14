public class Sorts{
<<<<<<< HEAD
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
	    temp = data[a];
	    for (int b = a + 1; b < data.length; b ++){
		if (temp > data[b]){
		    temp = data[b];
		    data[b] = data[a];
		    data[a] = temp;
		}
	    }
	    data[a] = temp;
	}
    }
    
    /**Insertion sort of an int array.
     *Upon completion, the elements of the array will be in increasing order.
     *@param data  the elements to be sorted.
     */
    public static void insertionSort(int[] data){
	int temp;
	for(int a = 1; a < data.length; a++){
	    temp = data[a];
	    data[a] = -1;
	    for (int b = a -1; b >=0; b --){
		print(data);
		System.out.println(temp + " " + data[b] +" " + data[b + 1] + " "+ b);
		if (temp >= data[b]){
		    data[b + 1]= data[b];
		    data[b] = temp;
		}else{
		    data[b + 1] = data[b];
		}
		System.out.println(temp + " " + data[b] +" " + data[b + 1]);
		print(data);
	    }
	}
    }

    
    public static void print(int[] a){
	for(int b = 0; b < a.length; b ++){
	    System.out.print(a[b] + " ");
	}
	System.out.println();
    }

    public static void main(String[] args){
	int[] a = {1, 7, 3, 4, 1, 5};
	print(a);
	selectionSort(a);
	print(a);
	int[] b= {1, 7, 3, 4, 1, 5};
	print(b);
	insertionSort(b);
	print(b);
	
    }
=======
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



>>>>>>> 1b8a66c4635a0c31e992128366c78bdf20453ecb
}
