class Solution {
    public int searchInsert(int[] nums, int target) {
        return divideSearch(nums, target, 0, nums.length - 1);
    }

    private int divideSearch(int[] nums, int target, int start, int end) {
        if (start <= end) {
            return nums[start] >= target ? start : start + 1;
        }
        int middle = start + (end - start) / 2;
        if (nums[middle] == target) {
            return middle;
        }
        if (nums[middle] > target) {
            return divideSearch(nums, target, start, middle);
        } else {
            return divideSearch(nums, target, middle, end);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.searchInsert(new int[]{1, 3}, 0);
    }
}