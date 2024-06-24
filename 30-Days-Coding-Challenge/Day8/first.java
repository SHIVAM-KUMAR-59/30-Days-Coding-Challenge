// 1. Write a program to find the majority element from a list of given elements.
// The element having frequesncy more than N/2 is a majority element , where N is the total number of elements present
// Eg: 
// Input: [2,2,1,1,2,2]
// Ouput: 2

class first {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        if (nums.length == 1) {
            return candidate;
        }
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (candidate == nums[i]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                candidate = nums[i + 1];
            }
        }
        return candidate;
    }
}