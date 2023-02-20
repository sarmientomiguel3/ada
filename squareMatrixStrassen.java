import java.util.*;
public class squareMatrixStrassen{
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
				matrixRpta=multiplyStrassen(a,b);
				long estimatedTime = System.nanoTime() - startTime;
				//leerMatrices(matrixRpta);
				System.out.println(matrixRpta.length+"\t"+estimatedTime);
				aux++;	
			}	
		}

	}

	public static void multiplyStrassen(int[][]a,int[][]b,int[][]c){
		c=new int[a.length][a.length];
		c=multiplyStrassen(a,b);

	}	  
	public static int[][] multiplyStrassen(int[][] a,int[][] b){
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
			int[][]s1=sumresMatrices(b12,b22,-1);
			//leerMatrices(s1);
			int[][]s2=sumresMatrices(a11,a12,1);
			//leerMatrices(s2);
			int[][]s3=sumresMatrices(a21,a22,1);
			//leerMatrices(s3);
			int[][]s4=sumresMatrices(b21,b11,-1);
			//leerMatrices(s4);
			int[][]s5=sumresMatrices(a11,a22,1);
			//leerMatrices(s5);
			int[][]s6=sumresMatrices(b11,b22,1);
			//leerMatrices(s6);
			int[][]s7=sumresMatrices(a12,a22,-1);
			//leerMatrices(s7);
			int[][]s8=sumresMatrices(b21,b22,1);
			//leerMatrices(s8);
			int[][]s9=sumresMatrices(a11,a21,-1);
			//leerMatrices(s9);
			int[][]s10=sumresMatrices(b11,b12,1);
			//leerMatrices(s10);
			int[][]p1;
			//leerMatrices(p1);
			int[][]p2;
			//leerMatrices(p2);
			int[][]p3;
			//leerMatrices(p3);
			int[][]p4;
			//leerMatrices(p4);
			int[][]p5;
			//leerMatrices(p5);
			int[][]p6;
			//leerMatrices(p6);
			int[][]p7;
			//leerMatrices(p7);
			p1=multiplyStrassen(a11,s1);
			//leerMatrices(p1);
			p2=multiplyStrassen(s2,b22);
			//leerMatrices(p2);
			p3=multiplyStrassen(s3,b11);
			//leerMatrices(p3);
			p4=multiplyStrassen(a22,s4);
			//leerMatrices(p4);
			p5=multiplyStrassen(s5,s6);
			//leerMatrices(p5);
			p6=multiplyStrassen(s7,s8);
			//leerMatrices(p6);
			p7=multiplyStrassen(s9,s10);
			//leerMatrices(p7);
			int[][]c11=sumresMatrices(sumresMatrices(sumresMatrices(p5,p4,1),p2,-1),p6,1);
			//leerMatrices(c11);
			int[][]c12=sumresMatrices(p1,p2,1);
			//leerMatrices(c12);
			int[][]c21=sumresMatrices(p3,p4,1);
			//leerMatrices(c21);
			int[][]c22=sumresMatrices(sumresMatrices(sumresMatrices(p5,p1,1),p3,-1),p7,-1);
			//leerMatrices(c22);
			juntar(c,c11,0,0);
			juntar(c,c12,0,c.length/2);
			juntar(c,c21,c.length/2,0);
			juntar(c,c22,c.length/2,c.length/2);
			//leerMatrices(c);
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
	public static int[][] sumresMatrices(int[][]a,int[][]b,int t){
		int [][] c=new int[a.length][a.length];
		for(int i=0;i<a.length;i++)
			for(int j=0;j<a[0].length;j++)
				c[i][j]=a[i][j]+t*b[i][j];
		return c;
	}
}

