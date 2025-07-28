package com.interviewprep.leetcode.medium.zigzagconversion;


public class FirstApproach {

	public static void main(String[] args) {
		
		FirstApproach fa = new FirstApproach();
		String zigzag = fa.convert("PAYPALISHIRING", 4);
		
		System.out.println(zigzag);
		
	}
	
	
	public String convert(String s, int numRows) {

		if( numRows < 2) {

			return s;
		}
		String zigzag = "";

		int numCols = s.length();
		String[][] strMatrix = new String[numRows][numCols];

		boolean allRows = true;
		int charIdx = 0;
		int diag = numRows-2;
		
		// remove all the null values
		initiateMatrix(strMatrix, numRows, numCols);

		for(int col=0; col<numCols; col++  ) {

			if(diag == 0) {

				allRows = true;
				diag = numRows-2;
			}

			if(charIdx > s.length()-1) {

				printMatrix(strMatrix, numRows, numCols);
				break;
			}
			
			// populate all rows of this column
			if(allRows) {
				for(int row=0; row<numRows && charIdx < s.length(); row++) {

					strMatrix[row][col] = Character.toString(s.charAt(charIdx));	
					charIdx++;
				}
				allRows = false;			 
			} 
			else {

				strMatrix[diag--][col] = Character.toString(s.charAt(charIdx));	
				charIdx++;
			}

		} // endfor

		
		// now read the matrix to return the required string
		for(int row=0; row<numRows; row++) {

			for(int col=0; col<numCols; col++  ) {

				zigzag = zigzag + strMatrix[row][col] ;
			}

		}

		return zigzag;
	}
	 
	// initiate the matrix with empty string
	 private void initiateMatrix(String strMatrix[][], int numRows, int numCols) {
		 for(int row=0; row<numRows; row++) {
			 
			 for(int col=0; col<numCols; col++  ) {
				 
				 strMatrix[row][col] = "";
			 }
			 
		 }
	 }
	 
	 // print the given matrix
	 private void printMatrix(String strMatrix[][], int numRows, int numCols) {
		 for(int row=0; row<numRows; row++) {
			 
			 for(int col=0; col<numCols; col++  ) {
				 
				 System.out.print( strMatrix[row][col] + "\t");
			 }
			 System.out.println("");
		 }
	 }
	 
}
