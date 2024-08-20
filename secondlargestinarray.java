package assignments;

public class secondlargestinarray {
	
	public static void sort(int[] arr) {
		// TODO Auto-generated method stub 

		 for(int i=0;i<arr.length-1;i++){ 
	           
	         for(int j=0;j<arr.length-1-i;j++){
	        if(arr[j]>arr[j+1]){
	            int temp=arr[j];
	            arr[j]=arr[j+1];
	            arr[j+1]=temp;
	            
	        }
	        
	        }	          
	       }	
	}
	
	public static int secondlargest(int[] arr) {
		int lastindx=arr.length-1;
		int greatest=arr[lastindx];
		int res=0;
		for(int i=lastindx-1;i>=0;i--) {
			if(arr[i]<greatest) {
				 res= arr[i];	
			break;	 
			}
		}
		
		
		return res;
		
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int[] arr= {1,2,3,8,4,6,7,5,7,8};
       System.out.println("Array before sorting");
       for(int i=0;i<arr.length;i++) {
			 System.out.print(arr[i]+" ");
		 }
		 System.out.println();
       sort(arr);
       
       System.out.println("array after sorting");
       for(int i=0;i<arr.length;i++) {
			 System.out.print(arr[i]+" ");
		 }
       System.out.println();
       int result=secondlargest(arr);
       System.out.println("second largest element is:"+result);
       
	}

}
