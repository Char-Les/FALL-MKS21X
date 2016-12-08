public class Driver{
    public static void main(String[]args){
	for (int a = 0; a < 10; a ++){
	    System.out.println(a + "  " + Barcode.bars[a]);
	}
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

	b = a.clone();

	/*shouldn't work
	a = new Barcode("1234567");
	System.out.println(a);
	a = new Barcode("123");
	System.out.println(a);
	a = new Barcode("12ab5");
	System.out.println(a);*/
	
	
       
    }

}
