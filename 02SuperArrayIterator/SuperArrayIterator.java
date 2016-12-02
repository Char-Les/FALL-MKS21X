import java.util.Iterator;
public class SuperArrayIterator implements Itorator<String>{
    private int start, end;

    public IntIterator(int start, int end){
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
	throw new UnsupportedOperationException()
    }
 
   }

}
