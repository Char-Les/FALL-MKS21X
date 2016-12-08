public class Driver{
    public static void main(String[]args){
	Barcode a,b;
	a = new Barcode("08451");
	System.out.println(a);
	a = new Barcode("56789");
	System.out.println(a);
	a = new Barcode("00000");
	System.out.println(a);
	a = new Barcode("17324");
	System.out.println(a);
	a = new Barcode("12345");
	System.out.println(a);

	/*shouldn't work
	a = new Barcode("1234567");
	System.out.println(a);
	a = new Barcode("123");
	System.out.println(a);
	a = new Barcode("12ab5");
	System.out.println(a);*/
	
       
    }

}
