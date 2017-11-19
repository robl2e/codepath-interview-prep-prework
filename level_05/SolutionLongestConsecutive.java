public class SolutionLongestConsecutive {
	public int longestConsecutive(final List<Integer> a) {
	    if (a.isEmpty()) return 0;
	    if (a.size() == 1) return 1;
	    
	    // Sort Array
	    Collections.sort(a);
	    
	    int longSeq = 0;
	    int seqStartIndex = 0;
	   	int duplicateCount = 0;

	    for (int i = 0; i < a.size(); i++) {
	        int curNum = a.get(i);
	        
	        // Handle end of list
	        if (isEnd(i, a.size())) {
	            int len = calcSeqLen(seqStartIndex, i, duplicateCount);
	            longSeq = Math.max(len, longSeq);
	            break;
	        }
	        
	        // Compare current and next numbers
	        int nextNum = a.get(i+1);
	        if (curNum == nextNum) {
				duplicateCount++;
	        } else if (!isConsecutive(curNum, nextNum)) {
	            int len = calcSeqLen(seqStartIndex, i, duplicateCount);
	            longSeq = Math.max(len, longSeq);
	            
	            // reset for next seq
	            seqStartIndex = reset(i+1, a.size());
	            duplicateCount = 0;
	        }
	    }
	    
	    return longSeq;
	}
	
	public int calcSeqLen(int sIndex, int eIndex, int duplicateCount) {
	    return (eIndex - sIndex) + 1 - duplicateCount;
	}
	
	public boolean isConsecutive(int num1, int num2) {
	    return num1 + 1 == num2;
	}
	
	public boolean isEnd(int index, int len) {
	    return index == len-1;
	}
	
	public int reset(int newSeqIndex, int len) {
	    if (newSeqIndex >= len) {
	        return len - 1;
	    }
	    return newSeqIndex;
	}
}
