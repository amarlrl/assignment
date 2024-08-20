package assignments;

public class removeduplicate {
	
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
	       
	       int n=arr.length;
	       int[] temp= new int[n];
	       int j=0;
	       
	       for(int i=0;i<n-1;i++) {
	    	   if(arr[i]!=arr[i+1]) {
	    		   temp[j]=arr[i];
	    		   j++;
	    	   }
	    	   
	       }
	       System.out.println("array after removing duplicate");
	       
	      for(int i=0;i<j;i++) {
	    	  System.out.print(temp[i]+" ");
	    	  
	      }
	      System.out.println();
	       System.out.println("size of array is :"+j);
	       
	       
	       
	}

}
