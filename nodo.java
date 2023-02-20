public class nodo{
	nodo sgte;
	int[][] elem;
	nodo(){
		elem=null;
		sgte=null;
	}
	public int[][] getNodo(){
		return elem;
	}
	public void add(int[][] a){
		elem=a;
	}

}
