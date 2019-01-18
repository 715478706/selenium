package sort;

public class AAAA {
	private static void swap(int[] arrays, int i, int j) {
        int temp;
        temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;
    }
	public static void main(String[] args) {
		int[] arrays={78,45,56};
	
		 int i=0;
		  int j =2;
		  System.out.println(j);
		  int key=arrays[i];
		  while(i!=j){
			  while(key<=arrays[j] && j>i){
				  j--;
				  System.out.println("j:"+j);
			  }
			  swap(arrays,i,j);
			for(int a:arrays){
				System.out.print(a+" ");
			}
			while(key>=arrays[i] &&i<j){
				i++;
				System.out.println();
				System.out.println("i:"+i);
			}
			swap(arrays,i,j);
			for(int a:arrays){
				System.out.print(a+" ");
			}
		  }
		  
	      
	}
}

