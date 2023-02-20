import java.util.*;

public class MergeConInf{
	static int maxValue=100000;
	public static void main(String[]args){
		int[] n={6,5,4,3,2,1};
		n=mergeSort(n);
		for(int i=0;i<n.length;i++)
			System.out.print(n[i]+" ");
	}
	public static int[] mergeSort(int[] a){
		int p=0;
		int r=a.length-1;
		int q=(p+r)/2;
		//p-q,q+1-r
		int n=r-p+1;	
		mergeSort(a,p,r);
		return a;
	}
	public static void mergeSort(int[]a,int p,int r){
		if(p<r){
			int q=(p+r)/2;
			mergeSort(a,p,q);
			mergeSort(a,q+1,r);			
			merge(a,p,q,r);
		}
		else
			return;
	}
	public static void merge(int[]a,int p,int q,int r){
		int n1=q-p;
		int n2=r-q-1;
		int i=0;
		int j=0;
		int[]L=new int[n1+2];
		int[]R=new int[n2+2];
		for(i=0;i<=n1;i++)
			L[i]=a[p+i];
		for(j=0;j<=n2;j++)
			R[j]=a[q+j+1];
		i=0;
		j=0;
		L[n1+1]=maxValue;
		R[n2+1]=maxValue;
		int m=0;
		for(int k=p;k<=r;k++){
			if(L[i]<=R[j]&&L[i]!=maxValue){
				a[k]=L[i];
				i++;
			}
			else{
				a[k]=R[j];
				j++;
			}

		}
	}
}

