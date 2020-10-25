package sort;

public class Sort {
	public int index=0;
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

 public int binarySearch(int[] d,int key,int low,int hight){
	int m=(low+hight)/2;
	System.out.println(low+" <-->"+hight);
//	2	5	6	11	16	22
	if(d[m]==key){
		System.out.println("m -->"+m);
		index=m;
		return m;
	}else if(d[m]<key){
		binarySearch(d,key,m+1,hight);
	}else if(d[m]>key){
		binarySearch(d,key,low,m-1);
	}
	 return index;
 }

 public static void main(String[] args) {
	int[] data={11,22,2,5,6,16};
	Sort s=new Sort();
	data=s.bubbleSort(data);
//	for(int i=0;i<data.length;i++){
//		System.out.println(data[i]);
//	}
	System.out.println("index:"+s.binarySearch(data, 5, 0, data.length-1));
	}
}























