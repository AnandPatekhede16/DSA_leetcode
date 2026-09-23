class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        
        // If total sum is less than x, impossible
        if (total < x) return -1;
        
        // If total sum equals x, remove all elements
        if (total == x) return n;
        
        // Target sum of the remaining subarray
        int target = total - x;
        
        // Sliding window to find longest subarray with sum = target
        int maxLength = -1;
        int currentSum = 0;
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            currentSum += nums[right];
            
            // Shrink window if sum exceeds target
            while (currentSum > target && left <= right) {
                currentSum -= nums[left];
                left++;
            }
            
            // Check if we found the target sum
            if (currentSum == target) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }
        
        return maxLength == -1 ? -1 : n - maxLength;
    }
}