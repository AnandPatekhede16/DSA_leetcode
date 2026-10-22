class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int n = nums.size();
        
        // 1. Find the first decreasing element (the "blue gola")
        int pivot_index = -1;
        for(int i = n - 1; i > 0; i--) {
            if(nums[i] > nums[i - 1]) {
                pivot_index = i - 1;
                break;
            }
        }
        
        // 2. If no such element found, array is sorted in descending order
        //    Just reverse the whole array and return.
        if(pivot_index == -1) {
            reverse(nums.begin(), nums.end());
            return;
        }
        
        // 3. Find the smallest element greater than nums[pivot_index] to the right
        int pivot_value = nums[pivot_index];
        int swap_index = pivot_index;
        
        for(int j = n - 1; j > pivot_index; j--) {
            if(nums[j] > pivot_value) { // Yahan pivot_value se compare karo
                swap_index = j;
                break;
            }
        }
        
        // 4. Swap the pivot with the found element
        swap(nums[pivot_index], nums[swap_index]);
        
        // 5. Reverse the suffix to get the smallest possible next permutation
        reverse(nums.begin() + pivot_index + 1, nums.end());
    }
};