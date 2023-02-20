public class Palindrome{
	public static void main(String []args){
		Scanner sc=new Scanner(System.in);
		int[] arr={5,4,3,4,5};
		System.out.println(esPalindrome(arr));
	}
	public static boolean esPalindrome(int[] arr){
		int izq=0;
		int der=arr.length-1;
		while((izq<der)&&(arr[izq]==arr[der])){
			izq=izq+1;
			der=der-1;
		}
		if(izq>=der)
			return true;
		else
			return false;
	}
}
