import java.util.*;

public class ISort{
	public static void main(String[]args){
		Scanner sc= new Scanner(System.in);
		while(sc.hasNext()){
			int sizeArray=sc.nextInt();
			int numArrays=sc.nextInt();
			for(int i=0;i<numArrays;i++){
				int[] source=new int[sizeArray];
				for(int j=0;j<sizeArray;j++){
					int n=sc.nextInt();
					source[j]=n;
				}
				long startTime=System.nanoTime();
				int []target=sort(source);
				long estimatedTime=System.nanoTime()-startTime;
				System.out.println(sizeArray+" "+estimatedTime);
			}	
		}
	}
	public static int[] sort(int[] arr){
		for(int i=1;i<arr.length;i++){
			int key=arr[i];
			int j=i-1;
			while(j>=0&&arr[j]>key){
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=key;
		}
		return arr;
	}
}
