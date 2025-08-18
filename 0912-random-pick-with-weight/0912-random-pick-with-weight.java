class Solution {

    int[] arr;
    int sum;

    public Solution(int[] w) {
        arr = new int[w.length];
        sum = 0;

        for(int i=0; i<w.length; i++) {
            sum += w[i];
            arr[i] = sum;
        }
    }
    
    public int pickIndex() {
        int left = 0;
        int right = arr.length - 1;

        int target = (int)(Math.random() * sum);

        while(left < right) {
            int mid = left + (right - left)/ 2;

            if(target < arr[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */