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
	  throw new RuntimeException(Barcode: Length);
      }
      try{
      Integer a = Integer(zip);
      }catch( NumberFormatException() e){
	  throw new RuntimeException(Barcode: Number?);
      }

      _zip = zip;
      _checkdigit = checksum();

  }

// postcondition: Creates a copy of a bar code.
  public Barcode clone(){}


// postcondition: computes and returns the check sum for _zip
  private int checkSum(){
      int sum = 0;
      
  }

//postcondition: format zip + check digit + Barcode 
//ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
  public String toString(){}


// postcondition: compares the zip + checkdigit, in numerical order. 
  public int compareTo(Barcode other){}
    
}
