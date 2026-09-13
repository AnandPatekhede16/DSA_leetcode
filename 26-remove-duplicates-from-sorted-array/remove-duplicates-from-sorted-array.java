class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        
        // i = slow pointer (position for next unique element)
        // j = fast pointer (scanning through array)
        int i = 0;
        
        for (int j = 1; j < nums.length; j++) {
            // If we find a new unique element
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        
        // i is index of last unique element
        // Number of unique elements = i + 1
        return i + 1;
    }
}