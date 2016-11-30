public abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;

    public LibraryBook(String a, String t, String i, String c){
	setAuthor(a);
	setTitle(t);
	setISBN(i);
	callNumber = c;
    }

    public String getCallNumber(){
	String ans = callNumber;
	return ans;
    }

    public boolean setCallNumber(String c){
	callNumber = c;
	return true;
    }

    abstract void checkout(String patron, String due);
    abstract void returned();
    abstract String circulationStatus();

    public int compareTo(LibraryBook b){
	return this.getCallNumber().compareTo(b.getCallNumber());
    }
    
    public String toString(){
	return super.toString() + ", " + circulationStatus() + ", " + callNumber;
    }

    public static void main(String[] args){
	
    }
}
