import java.util.*;

public class MergeSinInf{
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
		int[]L=new int[n1+1];
		int[]R=new int[n2+1];
		for(i=0;i<=n1;i++)
			L[i]=a[p+i];
		for(j=0;j<=n2;j++)
			R[j]=a[q+j+1];
		i=0;
		j=0;
		int n=0;
		int m=0;
		for(int k=p;k<=r;k++){
			if(m==1){
				a[k]=L[i];
				if((i+1)==L.length){
					n=1;
					i=0;
				}
				else
					i++;

			}
			else{
				if(n==1){
					a[k]=R[j];
					if((j+1)==R.length){
						m=1;
						j=0;
					}
					else
						j++;
					continue;

				}
				if(L[i]<=R[j]){
					a[k]=L[i];
					if((i+1)==L.length){
						n=1;
						i=0;
					}
					else
						i++;
				}
				else{
					a[k]=R[j];
					if((j+1)==R.length){
						m=1;
						j=0;
					}
					else
						j++;
				}
			}	
		}
	}
}

