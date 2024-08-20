package assignments;

public class leader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   int[] arr= {1,2,7,4,6,5,1};
   int n=arr.length;
//   int[] temp=new int[n];
//   int k=0;
//   
//   for(int i=0;i<n;i++) {
//	   for(int j=i+1;j<n;j++) {
//		   if(arr[i]<arr[j]) {
//			   break;
//		   }
//		   if(j==n-1) {
//			   temp[k]=arr[i];
//			   k++;
//		   }
//	   }
//	  
//   }
//   
// for(int i=0;i<temp.length;i++) {
//	 System.out.print(temp[i]+" ");
// }
		
	int rightmost=arr[n-1];
	System.out.print(rightmost+" ");
	
	for(int i=n-2;i>=0;i--) {
		if(arr[i]>rightmost) {
			rightmost=arr[i];
			System.out.print(rightmost+" ");
		}
	}
		
		
	}

}
