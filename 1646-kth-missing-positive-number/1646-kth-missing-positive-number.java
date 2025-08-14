/**
https://www.youtube.com/watch?v=uZ0N_hZpyps

The idea here is that :

Since all the number in the array are in increasing order , 
so If NONE of the elemts is missing then for each index i we should have the value (i+1). 
Here we are considering 0 based indexing.

But if some the elements upto any index is missing , 
then we can find the number of missing elements using above logic.

No of missing numbers at index i = (Current Value at index i ) - ( Correct Value as per contiguous sequence )
= A[i]-(i+1) // At any index i

Now , we can use binary search in this question by checking if number of missing number at mid is less than K , 
that means we need to check for Kth number on right side of mid.

Otherwise , if number of missing values is greater than K , then our missing number lies in left of the array

Time Complexity : O (log(n)) // Number of array elements
Space Complexity : O(1)

Result = left (how many real numbers we've seen)
       + k (how many we still need to count to get the k-th missing)

 */

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int left = 0;
        int right = arr.length -1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            int missing = arr[mid] - (mid + 1);

            if(missing < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left + k;
    }
}