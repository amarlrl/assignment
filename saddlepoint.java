package assignments;

import java.util.Scanner;

public class saddlepoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);
		
		System.out.println("enter the no. of rows");
		int row=sc.nextInt();
		System.out.println("enter the no. of columns");
		int col=sc.nextInt();
		
		int[][] mat=new int[row][col];
		
		System.out.println("enter the elements of the matrix");
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				mat[i][j]=sc.nextInt();
			}
		}
			
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
		
		
		boolean found=true;
		for(int i=0;i<row;i++) {
			int minrowvalue=mat[i][0];
			int mincolindex=0;
			
			//finding the minimum one in column
			for(int j=1;j<col;j++) {
				if(mat[i][j]<minrowvalue) {
					minrowvalue=mat[i][j];
					mincolindex=j;
				}
			}
			
			boolean issaddlepoint=true;
			
			//now in the same col check if it is max
			for(int k=0;k<row;k++) {
				if(mat[k][mincolindex]>minrowvalue) {
					issaddlepoint=false;
					break;
				}
			}
			
			if(issaddlepoint) {
				System.out.println("saddle point found at index:"+i+","+mincolindex+" value"+" "+minrowvalue);
				found=true;
			}
			
			
			
				
			
		}
		
		
		if(found == false) {
			System.out.println("no saddle point in the matrix");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
