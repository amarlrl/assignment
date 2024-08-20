package assignments;

public class outermatrix {
	
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
 int[][] mat= {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
 
 for (int i = 0; i < 4; i++) {
     System.out.print(mat[0][i] + " ");
 }
 

 // Print the last column
 for (int i = 1; i < 4; i++) {
     System.out.print(mat[i][3] + " ");
 }

 // Print the last row
 for (int i = 3; i >= 0; i--) {
     System.out.print(mat[3][i] + " ");
 }

 // Print the first column
 for (int i =  2; i > 0; i--) {
     System.out.print(mat[i][0] + " ");
 }
 
 
	}

}
