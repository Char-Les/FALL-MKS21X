import java.util.*;
public class SuperArray implements Iterable<String>{
    private String[] data;
    private int size;

    public SuperArray(int n){
	if (n < 0){
	    throw new IllegalArgumentException("Array Construction: " + n);
	}
	data = new String[n];
	size = 0;
    }
    public SuperArray(){
	data = new String[10];
	size = 0;
    }

    public Iterator<String> iterator(){
	return new SuperArrayIterator(0, size, this);
    }
    
    //returns size
    public int size(){
	int a = size;	
	return a;
    }
    //sets the size
	public boolean setSize(int n){
		size = n;
	return true;
	}
    //returns the number at the index
    public String get(int index){
	if ((index < 0 || index >= size())){
	    throw new IndexOutOfBoundsException("get: " + index);
	}
	return data[index];
    }
    //adds n to the end of the array
    public boolean add(String n){
	if (size < data.length){
	    data[size] = n;
		size ++;
	}
	else{
	    grow();
	    add(n);
	}
	return true;
    }
    //for add in case the array is too small
    private void grow(){
	String[] temp = new String[size * 2 + 1];
	for (int a  = 0; a < data.length; a++){
	    temp[a] = data[a];
	}
	data = temp;
    }
    //returns the array as a string
    public String toString(){
	String a = "[ ";
	if (size != 0){
	    a = a + "\"" + data[0] + "\"";
	}
	for (int b = 1; b < size; b++){
	    a = a + ", " + "\"" + data[b] + "\"";
	}
	a = a + "]";
	return a;
    }
    //returns the entire array with the empty spaces as  
    public String toStringDebug(){
	String a = "[ ";
	if (size != 0){
	    a = a + "\"" + data[0] + "\"";
	}
	else {
	    a += "_";
	}
	for (int b = 1; b < data.length; b++){
	    a = a +", ";
	    if (b < size){
		a += "\"" + data[b] + "\"";
	    }
	    else{
		a += "_";
	    }
	}
	a = a + "]";
	return a;
    }
    //resets the array of all its elements
    public void clear(){
	String[] temp = new String[data.length];
	data = temp;
	size = 0;
    }
    
    //checks if the array is empty
    public boolean isEmpty(){
	if (size == 0){
	    return true;
	}
	String[] temp = new String[size];
	for(int a = 0; a < size; a++){
	    if (data[a] != temp[a]){
		return false;
	    }
	}
	return true;
    }
    //python pop + replace funtion
    public String set(int index, String n){
	if ((index < 0 || index >= size())){
	    throw new IndexOutOfBoundsException("set: " + index + ", " + n);
	}
	String ans = data[index];
	data[index] = n;
	return ans;
    }
    //adds a number at the index
    public void add(int index, String n){
	if ((index < 0 || index > size())){
	    throw new IndexOutOfBoundsException("add: " + index + ", " + n);
	}
	int a = 0;
	String[] temp = new String[data.length + 1];
	for(;a < index;a++){
	    temp[a]=data[a];
	}
	temp[a] = n;
	a++;
	for(;a<temp.length;a++){
	    temp[a]=data[a-1];
	}
	data = temp;
	size ++;
    }
    //removes the number at the index
    public String remove(int index){
	if ((index < 0 || index >= size())){
	    throw new IndexOutOfBoundsException("remove: " + index);
	}
	String ans = data[index];
	int a = 0;
	String[] temp = new String[data.length - 1];
	for(;a < index;a++){
	    temp[a]=data[a];
	}
	for(;a<temp.length;a++){
	    temp[a]=data[a+1];
	}
	data = temp;
	size = size - 1;
	return ans;
    }
    //returns data
    public String[] toArray(){
	String[] ans = new String[size];
	for (int a = 0; a < size; a++){
	    ans[a] = data[a];
	}
	return ans;
    }
    //returns the first index of an element
    public int indexOf(String i){
	for(int a = 0;a < size; a++){
	    if (data[a].compareTo(i) == 0){
		return a;
	    }
	}
	return -1;
    }
    //returns the last index of an element
    public int lastIndexOf(String i){
	for(int a = size - 1 ;a >= 0; a -= 1){
	    if (data[a].compareTo(i) == 0){
		return a;
	    }
	}
	return -1;
    }
    //trims off extra values
    public void trimToSize(){
	String[] temp = new String[size];
	for(int a = 0; a < size ; a++){
	    temp[a] = data[a];
	}
	data = temp;
    }
    //tests the functions
    public static void main(String[]args){
	SuperArray s = new SuperArray();
	SuperArray t = new SuperArray(15);
	System.out.println(t.size());
	t.setSize(10);
	System.out.println(t.size());
	System.out.println(s.size());
	System.out.println(s);
	System.out.println(s.toStringDebug());
	for(int a= 0; a < 15; a++ ){
	    s.add("" + a);
	}
    System.out.println(s.toStringDebug());
	System.out.println(s.set(0,"15"));
	System.out.println(s.get(0));
	s.add(7,"32");
	System.out.println(s.toStringDebug());
	System.out.println(s.remove(7));
	System.out.println(s.toStringDebug());
	System.out.println(s.indexOf("3"));
	System.out.println(s.lastIndexOf("15"));
	s.trimToSize();
	System.out.println(s);
	System.out.println(s.isEmpty());
	System.out.println(t.isEmpty());
    s.clear();
	System.out.println(s.isEmpty());
}
}
