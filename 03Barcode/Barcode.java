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
	toCode(zip);
	_zip = zip;
	_checkDigit = checkSum(_zip);
    }

    // postcondition: computes and returns the check sum for _zip
    private static int checkSum(String zip){
	int sum = 0;
	for (int a = 0; a < zip.length(); a++){
	    sum += (int)_zip.charAt(a);
	}
	return sum % 10;
    }

    //postcondition: format zip + check digit + Barcode 
    //ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
    public String toString(){
	String ans = _zip + _checkDigit;
	return ans += " " + toCode(ans);
    }

    public static String toCode(String zip){
	if (zip.length() != 5){
	    throw new RuntimeException("Barcode: Length?");
	}
	try{
	    Integer a = new Integer(zip);
	}catch( NumberFormatException e){
	    throw new RuntimeException("Barcode: Number?");
	}

	String bar = "|";
	for (int a  = 0; a < zip.length(); a++){
	    int num = zip.charAt(a) - '0';
	    bar += bars[num];
	}	  
	bar += "|";
	return bar;
    }

    public static String toZip(String code){
	if (code.length() != 32){
	    throw new IllegalArgumentException("Code Length?");
	}
	if (code.charAt(0) != '|' || code.charAt(code.length - 1) != '|'){
	    throw new IllegalArgumentException("Guardrails?");
	}
	for (int a = 0; a < code.length(); a++){
	    if (code.charAt(a) != '|' || code.charAt(a) != ':')
	}
    }

    // postcondition: compares the zip + checkdigit, in numerical order. 
    public int compareTo(Barcode other){
	return this.compareTo(other);
    }
}




//e.printStackTrace(); for debugging
