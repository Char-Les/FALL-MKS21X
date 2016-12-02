import java.util.Iterator;
public class SuperArrayIterator implements Iterator<String>{
    private int start, end;

    public SuperArrayIterator(int start, int end){
	this.start = start;
	this.end = end;
    }

    public String next(){
	if(hasNext()){
	    start++;
	    return start - 1;
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
 
 }


