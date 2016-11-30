public class ReferenceBook extends LibraryBook{
    private String collection;

    public ReferenceBook (String a, String t, String i, String c, String col){
	super(a,t,i,c);
	collection = col;
    }

    public String getCollection(){
	String ans = collection;
	return ans;
    }

    public boolean setCollection(String col){
	collection = col;
	return true;
    }

    public void checkout(String patron, String due){
	System.out.println("cannot check out a reference book");
    }

    public void returned(){
	System.out.println("reference book could not have been checked out -- return impossible");
    }

    public String circulationStatus(){
	return "non-circulating reference book";
    }

    public String toString(){
	return super.toString() + ", " + collection;
    }
    
    public static void main(String[] args){
	ReferenceBook r = new ReferenceBook("author","title","ISBN","callN","collection");
	r.checkout("a", "");
	r.returned();
	System.out.println(r);
    }
}
