class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);

        for(int num : nums) {
            maxHeap.add(num);
        }

        while(k > 1) {
            maxHeap.poll();
            k--;
        }

        return maxHeap.peek();
    }
}

/** QuickSelect for Meta

class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length -1, nums.length - k);
    }

    private int quickSelect(int[] nums, int left, int right, int k) {
        if(left == right) {
            return nums[left];
        }

        int pIdx = partition(nums, left, right);

        if(pIdx == k) {
            return nums[k];
        } else if (pIdx < k) {
            return quickSelect(nums, pIdx + 1, right, k);
        } else {
            return quickSelect(nums, left, pIdx - 1, k);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int s_idx = left;
        int pivot = nums[right];

        for(int i=left; i <= right; i++) {
            if(nums[i] < pivot) {
                swap(nums, s_idx, i);
                s_idx++;
            }
        }

        swap(nums, s_idx, right);

        return s_idx;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}

 */