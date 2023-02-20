import java.util.*;
public class squareMatriz{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		matrices nuevo=new matrices();
		while(sc.hasNext()){
			int nFilas=sc.nextInt();
			int nColumnas=sc.nextInt();
			int repetitions=sc.nextInt();
			int [][]matriz=new int[nFilas][nColumnas];
			int aux=0;
			while(aux<repetitions){
				matriz=new int[nFilas][nColumnas];
				for(int i=0;i<nFilas;i++)
					for(int j=0;j<nColumnas;j++)
						matriz[i][j]=sc.nextInt();
				nuevo.add(matriz);
				aux++;
			}
			aux=0;
			while(aux<repetitions/2){
				int[][] matrixRpta;
				int[][] a=nuevo.remove();
				int[][] b=nuevo.remove();
				//leerMatrices(a);
				//System.out.println("··························");
				//leerMatrices(b);
				//System.out.println("··························");
				//System.out.println("··························");
				long startTime = System.nanoTime();
				matrixRpta=multMatrix(a,b);
				long estimatedTime = System.nanoTime() - startTime;
				//leerMatrices(matrixRpta);
				System.out.println(matrixRpta.length+"\t"+estimatedTime);
				aux++;	
			}	
		}
	}

	public static int[][] multMatrix(int[][]a,int[][]b){
		int n=a.length;
		int [][]matrix=new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				int c=0;
				for(int k=0;k<n;k++){
					c=c+a[i][k]*b[k][j];
				}
				matrix[i][j]=c;
			}
		}
		return matrix;
	}	  
	public static void leerMatrices(int[][] a){
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[0].length;j++)
				System.out.print(a[i][j]+" \t");
			System.out.println();
		}
	}
}
