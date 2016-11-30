import java.util.ArrayList;
import java.util.Collections;

public class Library {
	ArrayList<LibraryBook> bookList;
  public Library () {
		bookList = new ArrayList<LibraryBook> ();
	}

	/**
	 * adds the given book to the library
	 * @param book
	 */
	public void addBook (LibraryBook book) {
		bookList.add(book);
	}

	/**
	 * prints all books in the library
	 */
	public void printLibrary () {
		System.out.println ("\nListing of books in the library\n");
		for (LibraryBook book: bookList)
			System.out.println (book);
		System.out.println ("End of book listing\n");
	}

	/**
	 * locates a book in the library
	 * @param book book being search in the library
	 * @return book object if book is found
	 *         null otherwise
	 */
	public LibraryBook findBook (LibraryBook book) {
		int index = Collections.binarySearch(bookList, book);
		if (index >= 0)
			return bookList.get(index);
		else
			return null;
	}

	/**
	 * sort books in the library by call number
	 */
	public void sortLibrary () {
		Collections.sort(bookList);
	}

	/**
	 * performs processing for checking a book out of the library
	 * @param patron  person checking out book
	 * @param dueDate date book is due to be returned
	 * @param callNum call number of book
	 */
	public void checkout (String patron, String dueDate, String callNum) {
		LibraryBook searchItem = new CirculatingBook ("", "", "", callNum);
		LibraryBook book = findBook(searchItem);
		if (book == null)
				System.out.println ("Book " + callNum + " not found -- checkout impossible\n");
		else
				book.checkout (patron, dueDate);
	}

	/**
	 * processes checked-out book that is being returned
	 * @param callNum call number of book being returned
	 */
	public void returned (String callNum) {
		LibraryBook searchItem = new CirculatingBook ("", "", "", callNum);
		LibraryBook book = findBook(searchItem);
		if (book == null)
			System.out.println ("Book " + callNum + " not found -- return impossible\n");
		else
			book.returned ();
	}

	/**
	 * main testing program
	 * @param args  not used
	 */
	public static void main (String args[]) {

		Library lib = new Library ();

		// set up library
		lib.addBook(new ReferenceBook("author:me", "title:Unicorn", "ISBN:2", "Call:32","Collection:Kiwi"));
		lib.addBook(new ReferenceBook("author:you", "title:Ponies", "ISBN:1450", "Call:123","Collection:Orange"));
		lib.addBook(new CirculatingBook("author:I", "title:Michael", "ISBN:89", "Call:1434"));
		lib.addBook(new CirculatingBook("author:her", "title:Lee", "ISBN:5", "Call:41243"));		    

		// sort books by call number
		lib.sortLibrary();

		// print library
		lib.printLibrary();

		// some users check out and return books
		lib.checkout("Donald Duck", "March 1, 2012", "Call:1434");
		System.out.print("FAIL: ");//try to check out already checked out
		lib.checkout("Donald Duck", "March 6, 2012", "Call:1434");
		lib.checkout("Minnie Mouse", "April 1, 2012", "Call:41243");

		System.out.print("FAIL: "); //try to check out rBook
		lib.checkout("Goofy", "February 28, 2012", "Call:32");
		lib.returned("Call:41243");
		System.out.print("FAIL: ");//try to return returned book
		lib.returned("Call:41243");
		System.out.print("FAIL: ");//try to return rBook
		lib.returned("Call:123");
		lib.checkout("Goofy", "March 28, 2012", "Call:41243");
		// print final status of library
		lib.printLibrary();
	}
}
