public class Barcode implements Comparable<Barcode>{
    // instance variables
    private String _zip;
    private int _checkDigit;
    
    public static final String one   = ":::||";
    public static final String two   = "::|:|";
    public static final String three = "::||:";
    public static final String four  = ":|::|";
    public static final String five  = ":|:|:";
    public static final String six   = ":||::";
    public static final String seven = "|:::|";
    public static final String eight = "|::|:";
    public static final String nine  = "|:|::";
    public static final String zero  = "||:::";
   

    // constructors
    //precondtion: _zip.length() = 5 and zip contains only digits.
    //postcondition: throws a runtime exception zip is not the correct length
    //               or zip contains a non digit
    //               _zip and _checkDigit are initialized.
    public Barcode(String zip) {
	if (zip.length() != 5){
	    throw new RuntimeException("Barcode: Length");
	}
	try{
	    Integer a = new Integer(zip);
	}catch( NumberFormatException e){
	    throw new RuntimeException("Barcode: Number?");
	}

	_zip = zip;
	_checkDigit = checkSum();
    }

    // postcondition: Creates a copy of a bar code.
    public Barcode clone(){
	Barcode a = new Barcode(_zip);
	return a;
    }
    

    // postcondition: computes and returns the check sum for _zip
    private int checkSum(){
	int sum = 0;
	for (int a = 0; a < _zip.length(); a ++){
	    sum += (int)_zip.charAt(a);
	}
	return sum % 10;
    }

    //postcondition: format zip + check digit + Barcode 
    //ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
    public String toString(){
	String ans = _zip + _checkDigit;
	String bar = "|";
	for (int a  = 0; a < _zip.length(); a++){
	    int num = (int)_zip.charAt(a);
	    switch (num){
	    case 1: bar += one;
		break;
	    case 2: bar += two;
		break;
	    case 3: bar += three;
		break;
	    case 4: bar += four;
		break;
	    case 5: bar += five;
		break;
	    case 6: bar += six;
		break;
	    case 7: bar += seven;
		break;
	    case 8: bar += eight;
		break;
	    case 9: bar += nine;
		break;
	    default: bar += zero;
		break;
	    }	  
	}
	bar += "|";
	return ans += " " + bar;
    }


    public String getZip(){
	String a = _zip;
	return a;
    }
    // postcondition: compares the zip + checkdigit, in numerical order. 
    public int compareTo(Barcode other){
	return this._zip.compareTo(other.getZip());
    }
}
