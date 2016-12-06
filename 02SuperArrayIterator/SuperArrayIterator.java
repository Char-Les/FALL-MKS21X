import java.util.*;
public class SuperArrayIterator implements Iterator<String>{
    private int start, end;
    private SuperArray array;

    public SuperArrayIterator(int start, int end, SuperArray Array){
	this.start = start;
	this.end = end;
	array = Array;
    }

    public String next(){
	if(hasNext()){
	    start++;
	    return array.get(start - 1);
	}else{
	    throw new NoSuchElementException();
	}
    }

    public boolean hasNext(){
	return start < end;
    }

    public void remove(){
	throw new UnsupportedOperationException();
    }

    public static void main(String[]args){

    }
 }


