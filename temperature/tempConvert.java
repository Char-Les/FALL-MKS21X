public class tempConvert{
    public static double CtoF(double C){
	return C * 9 / 5 + 32;
    }
    
    public static double FtoC(double F){
	return (F - 32) * 5 / 9; 
    }
    
    public static void main(String[] args){
	System.out.println(CtoF(-40.0));
	System.out.println(CtoF(100.0));
	System.out.println(FtoC(212.0));
    }
}
