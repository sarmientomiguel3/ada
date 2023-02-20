import java.util.*;
public class BinarySearch{
	public static void main(String []args){
		Scanner sc=new Scanner(System.in);
		int[] arr;
		int buscado=Integer.parseInt(args[0]);
		int k=1;
		int posicion=-1;
		while(sc.hasNext()){
			arr=new int[k];
			for(int i=0;i<arr.length;i++)
				arr[i]=sc.nextInt();
			k++;
			long startTime=System.nanoTime();
			posicion=searchBin(arr,buscado);
			long estimatedTime=System.nanoTime()-startTime;
			System.out.println(arr.length+"\t"+estimatedTime+"\t"+posicion);
		}
	}
	public static int searchBin(int[] arr,int buscado){
		int izq=0;
		int der=arr.length-1;
		return searchBin(arr,buscado,izq,der);
	}
	public static int searchBin(int[]arr,int buscado,int izq,int der){
		int p=(izq+der)/2;
		if(buscado==arr[p])
			return p;
		if(der==izq)
			return -1;
		if(buscado>arr[p]){
				return searchBin(arr,buscado,p+1,der);
		}
		else
			if(izq!=p)
				return searchBin(arr,buscado,izq,p-1);
			else
				return -1;
	}
}
