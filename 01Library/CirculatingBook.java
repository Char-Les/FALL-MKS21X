public class CirculatingBook extends LibraryBook{
    String currentHolder;
    String dueDate;

    public CirculatingBook(String a, String t, String i, String c){
	super(a,t,i,c);
	currentHolder = "";
	dueDate = "";
    }

    public String getCurrentHolder(){
	String ans = currentHolder;
	return ans;
    }
    
    public String getDueDate(){
	String ans = dueDate;
	return ans;
    }

    public boolean setCurrentHolder(String patron){
	currentHolder = patron;
	return true;
    }
    
    public boolean setDueDate(String date){
	dueDate = date;
	return true;
    }

    public void checkout(String patron, String due){
	setDueDate(due);
	setCurrentHolder(patron);
    }

    public void returned(){
	setDueDate("");
	setCurrentHolder("");
    }

    public String circulationStatus(){
	if (dueDate.equals("")){
	    return "book available on shelves";
	}
	return currentHolder + ", " + dueDate;
    }

}
