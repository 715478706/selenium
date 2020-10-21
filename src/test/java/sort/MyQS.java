package sort;

public class MyQS {
	public static void main(String[] args) {
		MyQS qs =new MyQS();
		int[] arrays={15,56,45,78,2,3};
		qs.paixu(arrays,0,5);
	}
	
	public void snp(int[] arrays){
		for(int array:arrays){
			System.out.print(array+" ");
		}
	}
	private void swap(int[] arrays, int i, int j) {
        int temp;
        temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;
    }
  public void paixu(int[] arrays ,int start,int end){
	  int i=start;
	  int j =end;
	  int key=arrays[i];
	  while(i!=j){
		  while(key<=arrays[j] && j>i){
			  j--;
			  System.out.println("j:"+j);
		  }
		  swap(arrays,i,j);
		snp(arrays);
		while(key>=arrays[i] &&i<j){
			i++;
			System.out.println();
			System.out.println("i:"+i);
		}
		swap(arrays,i,j);
		System.out.println();
		snp(arrays);
	  }
	  paixu(arrays,start,j-1);
	  paixu(arrays,i+1,end);
  }
}




















