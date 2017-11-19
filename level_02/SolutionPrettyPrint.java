public class SolutionPrettyPrint {
	public ArrayList<ArrayList<Integer>> prettyPrint(int a) {
	    if (a == 1) {
	        ArrayList<ArrayList<Integer>> matrix 
	            = new ArrayList<ArrayList<Integer>>();
	        
	        ArrayList<Integer> list = new ArrayList<>();
	        list.add(a);
	        matrix.add(list);
	        return matrix;
	    }
	    
	   ArrayList<ArrayList<Integer>> topMatrix 
	        = new ArrayList<ArrayList<Integer>>();
	   int numRows = a + (a-1);
	   int halfNumRows = numRows/2 + 1; //round-up
	   
	   for (int r = 0; r < halfNumRows; r++) {
	       ArrayList<Integer> row = createRow(a, r, numRows);
	       topMatrix.add(row);
	       a--;
	   }
	   
	   ArrayList<ArrayList<Integer>> fullMatrix = 
	        new ArrayList<ArrayList<Integer>>();
	        
	   for (int i = 0; i < topMatrix.size(); i++) {
	        ArrayList<Integer> row = topMatrix.get(i);
	        fullMatrix.add(row);
	   }
	   
	   // Skip last row
	   for (int i = topMatrix.size()-2; i >= 0; i--) {
	        ArrayList<Integer> row = topMatrix.get(i);
	        fullMatrix.add(row);    
	   }
	   
	   return fullMatrix;
	}
	
	private ArrayList<Integer> createRow(int a, int rowIndex, int maxLen) {
		ArrayList<Integer> row = new ArrayList<>();
		int numCols = a + (a-1);
		
		for (int col = 0; col < numCols; col++) {
			row.add(a);
		}
		
		if (maxLen == row.size()) return row;
		
		// prepend numbers to list
		int prefixNum = a+1;
		for (int i = 0; i < rowIndex; i++) {
			row.add(0, prefixNum);
			prefixNum++;
		}
		
		prefixNum = a+1; //reset
		// append numbers to list
		for (int i = 0; i < rowIndex; i++) {
			row.add(prefixNum);
			prefixNum++;
		}

		return row;
	}
}
