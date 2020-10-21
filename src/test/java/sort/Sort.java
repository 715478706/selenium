package sort;

public class Sort {
 int d[];
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
 
 public int partition(int[] a,int left,int right){
	int k=a[left];
	while(left<right){
		while(left<right&&a[right]>=k){
			right--;
			a[left]=a[right];
		}
		while(left<right&&a[left]<=k){
			left++;
			a[right]=a[left];
		}
	}
	a[left]=k;
	return left;
 }
 
 public int[] quickSort(int[] a,int left,int right){
	 if(left<right){
		 int res=partition(a,left,right);
		 quickSort(a,left,res-1);
		 quickSort(a,res+1,right);
	 }
	return a;
 }
 
 public int binarySearch(int[] d,int t,int low,int hight){
	int index=0;
	int m=low+hight/2;
	if(d[m]==t){
		index=m;
	}else if(d[m]<t){
		binarySearch(d,t,m+1,hight);
	}else{
		binarySearch(d,t,low,m-1);
	}
	 return index;
 }
 
 
 public static void main(String[] args) {
	int[] d;
	int[] data={11,22,2,5,6,16};
	Sort s=new Sort();
	
//	data=s.bubbleSort(data);
//	for(int i=0;i<data.length;i++){
//		System.out.println(data[i]);
	
		d=s.quickSort(data, 0, data.length-1);
		for(int i=0;i<d.length;i++){
			System.out.println(data[i]);
		}
		System.out.println("  ");
		System.out.println(s.binarySearch(data, 5, 0, data.length-1));
	}
}























