import java.util.*;
public class squareMatrixRecursive{
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
				matrixRpta=multiplyRecursive(a,b);
				long estimatedTime = System.nanoTime() - startTime;
				//leerMatrices(matrixRpta);
				System.out.println(matrixRpta.length+"\t"+estimatedTime);
				aux++;	
			}	
		}
	}

	public static void multiplyRecursive(int[][]a,int[][]b,int[][]c){
		c=new int[a.length][a.length];
		c=multiplyRecursive(a,b);

	}	  
	public static int[][] multiplyRecursive(int[][] a,int[][] b){
		int n=a.length;
		int[][] c =new int[a.length][a.length];
		if(n==1){
			c[0][0]=a[0][0]*b[0][0];
			return c;
		//System.out.println(c[0][0]);
		}
		else{
			int m=a.length/2;
			int[][] a11=new int[m][m];
			copybiarray(a11,a,0,0);
			//leerMatrices(a11);			
			int[][] a12=new int[m][m];
			copybiarray(a12,a,0,m);
			//leerMatrices(a12);
			int[][] a21=new int[m][m];
			copybiarray(a21,a,m,0);
			//leerMatrices(a21);
			int[][] a22=new int[m][m];
			copybiarray(a22,a,m,m);	
			//leerMatrices(a22);	
			int[][] b11=new int[m][m];
			copybiarray(b11,b,0,0);	
			//leerMatrices(b11);
			int[][] b12=new int[m][m];
			copybiarray(b12,b,0,m);
			//leerMatrices(b12);
			int[][] b21=new int[m][m];
			copybiarray(b21,b,m,0);
			//leerMatrices(b21);
			int[][] b22=new int[m][m];
			copybiarray(b22,b,m,m);
			//leerMatrices(b22);
			int[][] c11=sumaMatrices(multiplyRecursive(a11,b11),multiplyRecursive(a12,b21));
			//leerMatrices(c11);			
			int[][] c12=sumaMatrices(multiplyRecursive(a11,b12),multiplyRecursive(a12,b22));
			//leerMatrices(c12);
			int[][] c21=sumaMatrices(multiplyRecursive(a21,b11),multiplyRecursive(a22,b21));
			//leerMatrices(c21);
			int[][] c22=sumaMatrices(multiplyRecursive(a21,b12),multiplyRecursive(a22,b22));
			//leerMatrices(c22);
			juntar(c,c11,0,0);
			juntar(c,c12,0,c.length/2);
			juntar(c,c21,c.length/2,0);
			juntar(c,c22,c.length/2,c.length/2);
			return c; 
		}				
	}
	public static void copybiarray(int[][]des,int[][]org,int x,int y){
		for(int i=0;i<des.length;i++){
			System.arraycopy(org[i+x],y,des[i],0,des[0].length);
		}
	}
	public static void juntar(int[][]dest,int[][]orig,int x,int y){
		for (int i=0;i<orig.length;i++){
			System.arraycopy(orig[i],0,dest[i+x],y,orig[i].length);
		}
	}
	public static void leerMatrices(int[][] a){
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[0].length;j++)
				System.out.print(a[i][j]+" \t");
			System.out.println();
		}
		System.out.println("+++++++++++++++++++++++++++++");
	}
	public static int[][] sumaMatrices(int[][]a,int[][]b){
		int [][] c=new int[a.length][a.length];
		for(int i=0;i<a.length;i++)
			for(int j=0;j<a[0].length;j++)
				c[i][j]=a[i][j]+b[i][j];
		return c;
	}
}

