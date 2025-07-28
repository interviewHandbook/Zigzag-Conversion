package com.interviewprep.leetcode.medium.zigzagconversion;

public class SecondApproach {

	public static void main(String[] args) {
		
		SecondApproach sa = new SecondApproach();
		String zigzag = sa.convert("PAYPALISHIRING", 3);
		
		System.out.println(zigzag);
	}

	
	public String convert(String s, int numRows) {


		if( numRows < 2) {

			return s;
		}
		
		StringBuilder zigzag = new StringBuilder();

		StringBuilder[] rows = new StringBuilder[numRows];
		for(int i=0; i<numRows; i++) {

			rows[i] = new StringBuilder();
		}

		boolean allRows = true;

		int diag = numRows-2;
		int numCols = s.length();
		int rowIdx = 0;


		for(int charIdx=0; charIdx<numCols; charIdx++  ) {

			if(diag == 0) {

				allRows = true;
				diag = numRows-2;
			}

			if(allRows) {

				// populate all rows of this column
				rows[rowIdx] = rows[rowIdx].append(Character.toString(s.charAt(charIdx)));
				rowIdx++;

				if(rowIdx == numRows) {

					allRows = false;
					rowIdx = 0;
				}
			}
			else {

				rows[diag] = rows[diag].append(Character.toString(s.charAt(charIdx)));
				diag--;

			}

		} // endfor


		// now read the matrix to return the required string
		for(int i=0; i<numRows; i++) {

			zigzag = zigzag.append(rows[i]);
		}


		return zigzag.toString();
	}
}
