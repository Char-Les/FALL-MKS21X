import java.util.*;

public class Sorts{
    /**EDIT THIS METHOD TO MATCH YOUR NAME 
     */
    public static String name(){
	return "10.Weng.Charles"; 
    }

    /**Selection sort of an int array. 
     *Upon completion, the elements of the array will be in increasing order.
     *@param data  the elements to be sorted.
     */
    public static void selectionSort(int[] data){
	for (int a = 0; a < data.length - 1; a ++){
	    int min = a;
	    for (int b = a; b < data.length; b ++){
		if (data[min] > data[b]){
		    min = b;
		}
	    }
	    int temp = data[min];
	    data[min] = data[a];	
	    data[a] = temp;
	}
    }
    /**Insertion sort of an int array.
     *Upon completion, the elements of the array will be in increasing order.
     *@param data  the elements to be sorted.
     */
    public static void insertionSort(int[] data){
	for(int a = 1; a < data.length; a++){
	    int temp = data[a];
	    int place = a; 
	    while ( place > 0 && temp > data[place]){
		data[place] = data[place - 1];
		place --;
	    }
	    data[place] = temp;
	}
    }
    
    
    /**Insertion sort of an int array.
     *Upon completion, the elements of the array will be in increasing order.
     *@param data  the elements to be sorted.
     */
    public static void bubbleSort(int[] data){
	boolean swap = true;
	for (int a = 0; a < data.length - 1 && swap; a ++){
	    swap = false;
	    for (int b = 0; b < data.length - a - 1; b++){
		if (data[b] > data[b + 1]){
		    int temp = data[b + 1];
		    data[b + 1] = data[b];
		    data[b] = temp;
		    swap = true;
		}
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
	int[] a = {1,8,0,1,4,3,9,8,5,0,9,4,8,1,9,8,4};
	print(a);
	selectionSort(a);
	print(a);
	int[] b=  {1,8,0,1,4,3,9,8,5,0,9,4,8,1,9,8,4};
	print(b);
	insertionSort(b);
	print(b);
	int[] c = {1,8,0,1,4,3,9,8,5,0,9,4,8,1,9,8,4};
	print(c);
	bubbleSort(c);
	print(c); 
	

	long start, end;
	if (args.length < 3){
	    System.out.println("java Sorts arraySize [0sort/1sel/2ins/3bub] [0rand/1up/2down/3lim]");
	    System.exit(1);
	}

	Random rand = new Random();
	int[] data = new int[Integer.parseInt(args[0])];
	for(int count = 0; count < Integer.parseInt(args[0]); count ++){
	    if (args[2].compareTo("0") == 0){
		data[count] = rand.nextInt(Integer.parseInt(args[0]));
	    }
	    if (args[2].compareTo("1") == 0){
		data[count] = count;
	    }
	    if (args[2].compareTo("2") == 0){
		data[count] = Integer.parseInt(args[0]) - count;
	    }
	    if (args[2].compareTo("3") == 0){
		data[count] = rand.nextInt(10);
	    }
	}

	start = System.currentTimeMillis();
	if(args[1].compareTo("0") == 0){
	    Arrays.sort(data);
	}
	if(args[1].compareTo("1") == 0){
	    selectionSort(data);
	}
	if(args[1].compareTo("2") == 0){
	    insertionSort(data);
	}
	if(args[1].compareTo("3") == 0){
	    bubbleSort(data);
	}

	end = System.currentTimeMillis();

	System.out.println(end - start);
    }
    
}
