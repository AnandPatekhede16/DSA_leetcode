class Solution {
    public int[] twoSum(int[] nums, int target) {
       
        for(int i=1;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                int a=j-i;
                if(target==nums[a]+nums[j]){
                    return new int[]{a,j};
                }
            }
        }
      return null;
    }
}