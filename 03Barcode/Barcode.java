public class Barcode implements Comparable<Barcode>{
    // instance variables
    private String _zip;
    private int _checkDigit;
    
    public static final String[] bars = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
   

    // constructors
    //precondtion: _zip.length() = 5 and zip contains only digits.
    //postcondition: throws a runtime exception zip is not the correct length
    //               or zip contains a non digit
    //               _zip and _checkDigit are initialized.
    public Barcode(String zip) {
	if (zip.length() != 5){
	    throw new IllegalArgumentException("Barcode: Length?");
	}
	try{
	    Integer a = new Integer(zip);
	}catch( NumberFormatException e){
	    throw new IllegalArgumentException("Barcode: Number?");
	}

	_zip = zip;
	_checkDigit = checkSum(_zip);
    }

    // postcondition: Creates a copy of a bar code.
    public Barcode clone(){
	Barcode a = new Barcode(_zip);
	return a;
    }
    

    // postcondition: computes and returns the check sum for _zip
    private static int checkSum(String zip){
	int sum = 0;
	for (int a = 0; a < zip.length(); a ++){
	    sum += (int)zip.charAt(a) - (int)'0';
	}
	return sum % 10;
    }

    //postcondition: format zip + check digit + Barcode 
    //ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
    public String toString(){
	String ans = _zip + _checkDigit;
	return ans += " " + toCode(_zip);
    }

    public static String toCode(String zip){
	if (zip.length() != 5){
	    throw new IllegalArgumentException("Barcode: Length");
	}
	try{
	    Integer a = new Integer(zip);
	}catch( NumberFormatException e){
	    throw new IllegalArgumentException("Barcode: Number?");
	}

	String bar = "|";
	for (int a  = 0; a < zip.length(); a++){
	    int num = zip.charAt(a) - '0';
	    bar += bars[num];
	}	  
	bar += "|";
	return bar;
    }

    public String toZip(String code){
	//length check
	if (code.length() != 32){
	    throw new IllegalArgumentException("Barcode: Length");
	}
	//guard check
	if (code.charAt(0) != '|' || code.charAt(code.length() - 1 ) != '|'){
	    throw new IllegalArgumentException("Barcode: Guardrails?");
	}
	//character check
	for (int a = 0; a < code.length(); a++){
	    if (code.charAt(a) != '|' || code.charAt(a) != ';'){
		throw new IllegalArgumentException("Barcode: Characters?");
	    }
	}
	//convert check
	String zip = code.substring(1,code.length());
	
	String a = "";
	return a;
    }

    // postcondition: compares the zip + checkdigit, in numerical order. 
    public int compareTo(Barcode other){
	return this._zip.compareTo(other._zip);
    }
}
