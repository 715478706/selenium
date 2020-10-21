package sort;

public class QuickBubble {
  public static void main(String[] args) {
	  QuickBubble qb = new QuickBubble();
	  int[] array={3,6,12,1,2};
	  qb.bubbleSort(array);
	  for(int a:array){
	  System.out.print(a+",");}
}	
  public int[] bubbleSort(int[] a){
		 int temp;
		 for(int i=0;i<a.length;i++){
			 boolean flag=true;
			 for(int j=a.length-1;j>i;--j){
				 if(a[j]<a[j-1]){
					 temp=a[j];
					 a[j]=a[j-1];
					 a[j-1]=temp;
					 flag=false;
				 }
			 }
			 if(flag){
				 return a;
			 }
		 }
		return a;
	 }
}
