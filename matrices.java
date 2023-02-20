public class matrices{
	nodo matrices;
	matrices(){
		matrices=null;
	}
	public void add(int a[][]){
		nodo aux=new nodo();
		aux.add(a);
		aux.sgte=matrices;
		matrices=aux;
	}
	public int[][] remove(){
		nodo aux=matrices;
		int[][] a ={{1,2,3},{1,2,3}};
		if(aux!=null){
			a=aux.getNodo();
			aux=aux.sgte;
			matrices=aux;	
		}
		return a;
	}
}
