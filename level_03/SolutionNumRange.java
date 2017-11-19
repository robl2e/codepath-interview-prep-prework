public class SolutionNumRange {
	public int numRange(ArrayList<Integer> a, int b, int c) {
	    if (a.isEmpty()) return 0;
	    
	    int counter = 0;
	    
	    for (int i = 0; i < a.size(); i++) {
	        int num = a.get(i);
	        if (isInRange(num, b, c)) {
	            counter++;
	        }
	        
	        if (num <= b || (num > b && num < c)) {
	            int sumCount = sumCounter(a, i, b, c);
	            counter = counter + sumCount;
	        }
	    }
	    
	    return counter;
	}
	
	private boolean isInRange(int num, int min, int max) {
	    return num >= min && num <= max;
	}
	
	private int sumCounter(ArrayList<Integer> a,
	    int index, int min, int max) {
        int counter = 0;
        int sum = a.get(index);
        
        for (int i = index+1; i < a.size(); i++) {
            int num = a.get(i);
            sum = sum + num;
            if (isInRange(sum, min, max)) {
                counter++;
            }
            
            if (sum > max) {
                return counter;
            }
        }
        return counter;   
	}
}
