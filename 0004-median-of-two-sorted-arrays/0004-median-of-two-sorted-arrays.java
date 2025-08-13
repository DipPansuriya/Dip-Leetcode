class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;

        List<Integer> list = new ArrayList<>();

        int total = nums1.length + nums2.length;

        boolean isEven = false;

        if(total % 2 == 0) {
            isEven = true;
        }

        int count = -1;

        while(i <nums1.length || j <nums2.length) {
            if (i <nums1.length && j < nums2.length) {
                if(nums1[i] < nums2[j]) {
                    list.add(nums1[i]);
                    i++;
                } else {
                    list.add(nums2[j]);
                    j++;
                }
                count++;
            } else if (i < nums1.length) {
                list.add(nums1[i]);
                i++;
                count++;
            } else {
                list.add(nums2[j]);
                j++;
                count++;
            }

            if(count == total/2) {
                break;
            }
        }

        if(isEven) {
            return (list.get(list.size()-1) + list.get(list.size()-2)) / 2.0;
        }

        return list.get(list.size()-1) * 1.0;
    }
}