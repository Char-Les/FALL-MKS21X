public class Book{
    private String author;
    private String title;
    private String ISBN;

    public Book(){
	author = "";
	title = "";
	ISBN = "";
    }

    public Book(String a, String t, String i){
	author = a;
	title = t;
	ISBN = i;
    }

    public String getAuthor(){
	String ans = author;
	return ans;
    }
    
    public String getTitle(){
	String ans = title;
	return ans;
    }
    
    public String getISBN(){
	String ans = ISBN;
	return ans;
    }

    public boolean setAuthor(String a){
	author = a;
	return true;
    }
    
    public boolean setTitle(String t){
	title = t;
	return true;
    }
    
    public boolean setISBN(String i){
	ISBN = i;
	return true;
    }

    public String toString(){
	return title + ", " + author + ", " + ISBN;
    }

    public static void main(String[] args){
	Book a = new Book("aa", "bb", "cc");
	System.out.println(a);
    }
}
