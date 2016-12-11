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
	    throw new IllegalArgumentException("toCode: Length");
	}
	try{
	    Integer a = new Integer(zip);
	}catch( NumberFormatException e){
	    throw new IllegalArgumentException("toCode: Number?");
	}
	zip += checkSum(zip);

	String bar = "|";
	for (int a  = 0; a < zip.length(); a++){
	    int num = zip.charAt(a) - '0';
	    bar += bars[num];
	}	  
	bar += "|";
	return bar;
    }

    private static int findMatch(String bar){
	for (int b = 0; b < bars.length; b++){
	    if (bars[b].compareTo(bar) == 0){
		    return b;
		}
	}
	throw new IllegalArgumentException("toZip: InvalidConversion?");
    }
    
    public static String toZip(String code){
	//length check
	if (code.length() != 32){
	    throw new IllegalArgumentException("toZip: Length");
	}
	//guard check
	if (code.charAt(0) != '|' || code.charAt(code.length() - 1 ) != '|'){
	    throw new IllegalArgumentException("toZip: Guardrails?");
	}
	//character check
	for (int a = 0; a < code.length(); a++){
	    if (code.charAt(a) != '|' && code.charAt(a) != ':'){
		throw new IllegalArgumentException("toZip: Characters?");
	    }
	}
	//convert check
	String zipCode = code.substring(1,code.length() - 1);
	int zip = 0;
	for (int a = 0; a < zipCode.length(); a += 5){
	    String check = zipCode.substring(a, a+5);
	    zip = zip * 10 + findMatch(check);
	}
	//checkSum check
	if (zip % 10 != checkSum(zip / 10 + "")){
	    throw new IllegalArgumentException("toZip: CheckSum?");
	}
	zip /= 10;
	return "" + zip;
    }

    // postcondition: compares the zip + checkdigit, in numerical order. 
    public int compareTo(Barcode other){
	return this._zip.compareTo(other._zip);
    }
    
    
}
