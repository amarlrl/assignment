package assignments;

public class diagonalsum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[][] mat= {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		 int sum=0;
		 for(int i=0;i<4;i++) {
			 for(int j=0;j<4;j++) {
				 if(i==j) {
					 sum +=mat[i][j];				 }
			 }
		 }
		 
		 System.out.println("diagonal sum is:"+sum);
	}

}
