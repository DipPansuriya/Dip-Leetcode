class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        maxHeap.addAll(map.keySet());

        int[] result = new int[k];
        int idx = 0;

        while(!maxHeap.isEmpty() && k > 0) {
            result[idx++] = maxHeap.poll();
            k--;
        }

        return result;
    }
}

/*** Quick Select for Meta

class Solution {
    Map<Integer, Integer> map;
    int[] unique;

    public void swap(int a, int b) {
        int tmp = unique[a];
        unique[a] = unique[b];
        unique[b] = tmp;
    }

    private int partition(int left, int right) {
        int pivot_freq = map.get(unique[right]);

        int store_idx = left;

        for(int i =left ; i<=right; i++) {
            if(map.get(unique[i]) < pivot_freq) {
                swap(store_idx, i);
                store_idx++;
            }
        }

        swap(store_idx, right);

        return store_idx;
    }

    private void quickSelect(int left, int right, int k_smallest) {

        if(left == right) {
            return;
        }

        int pivot_idx = partition(left, right);

        if(pivot_idx == k_smallest) {
            return;
        } else if (k_smallest < pivot_idx ) {
            quickSelect(left, pivot_idx - 1, k_smallest);
        } else {
            quickSelect(pivot_idx + 1, right, k_smallest);
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        } 

        int n = map.size();
        unique = new int[n];

        int i =0; 

        for(int num : map.keySet()) {
            unique[i++] = num;
        }

        System.out.println(Arrays.toString(unique));

        quickSelect(0, n - 1, n - k);

        return Arrays.copyOfRange(unique, n - k, n);
    }
}

 */