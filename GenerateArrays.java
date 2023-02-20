public class GenerateArrays{
	public static void main(String []args){
		//Generamos 1-100 arreglos ordenados
		for(int i=0;i<100;i++){
			for(int j=0;j<=i;j++)
				System.out.print((j+1)+" ");
			System.out.println();
		}
	}
}
