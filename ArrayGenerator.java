import java.util.*;
import java.io.*;
public class ArrayGenerator{
	public static void main(String[]args){
		//Si no ingresa un numero producira un error
		if(args.length==0){
			//Uso de generator de arreglos <tamaño del arreglo><repeticiones por default 1>
			System.err.println("Usage: $java ArrayGenerator <array size> <repetitionsdefault is 1>");
			System.exit(1);
		}
		//Se ingresan dos argumentos args[0] y args[1]
		//ingresamos el tamaño del arreglo
		int arraysize = Integer.parseInt(args[0]);
		//numero de repiticiones
		int repetitions = args.length==1?1:Integer.parseInt(args[1]);
		System.out.println(arraysize+" "+repetitions);
		for(int i=0;i<repetitions;i++){
			print(System.out,generateArray(arraysize));
		}
	}
	public static int [] generateArray(int size){
		int[] array= new int[size];
		List<Integer> l= new ArrayList<Integer>();
		for(int i=0;i<size;i++){
			l.add(i+1);
		}
		for(int i=0;i<size;i++){
			int idx=(int)(Math.random()*(size-i));
			array[i]=l.remove(idx);
		}
		return array;		
	}
	public static void print (PrintStream out,int[]a){
		int  i;
		for(i=0;i<a.length-1;i++)
			out.print(a[i]+" ");
		out.println(a[i]);
	}

}
