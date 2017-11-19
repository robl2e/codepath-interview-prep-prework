## AMORTIZED2

What is the time complexity of the following code :

        int j = 0;
        for(i = 0; i < n; ++i) {
            while(j < n && arr[i] < arr[j]) {
                j++;
            }
        }
        
        
  
 Solution:
 
```
O(n)
```