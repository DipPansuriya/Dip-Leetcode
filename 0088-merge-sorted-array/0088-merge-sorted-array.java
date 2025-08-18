class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while(i >= 0 && j >= 0) {
            if(nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }

            k--;
        }

        while(i >= 0) {
            nums1[k] = nums1[i];
            i--;
            k--;
        }

        while(j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}

/** Meta Varient

public class MergeThreeSorted {

    public static int[] mergeThree(int[] A, int[] B, int[] C) {

        int i = 0, j = 0, k = 0;

        int n = A.length, m = B.length, p = C.length;

        int[] out = new int[n + m + p];
        int t = 0;

        while (i < n || j < m || k < p) {
            // pick the smallest current value among A[i], B[j], C[k]
            
            int ai = (i < n) ? A[i] : Integer.MAX_VALUE;
            int bj = (j < m) ? B[j] : Integer.MAX_VALUE;
            int ck = (k < p) ? C[k] : Integer.MAX_VALUE;

            if (ai <= bj && ai <= ck) { out[t++] = A[i++]; }
            else if (bj <= ai && bj <= ck) { out[t++] = B[j++]; }
            else { out[t++] = C[k++]; }
        }
        return out;
    }


    public static void main(String[] args) {
        int[] A = {1,1,2,2,3,4};
        int[] B = {3,3,4,5,6};
        int[] C = {2,3,7,8,9,10};

        System.out.println(Arrays.toString(mergeThree(A,B,C)));
        // [1,1,2,2,2,3,3,3,3,4,4,5,6,7,8,9,10]
    }
}
 */