import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jordi on 8/16/2017.
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:
 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1]
 *
 *
 *************      Answer
 ****   Add the number to a map
 *      Subtract the number from the target and assign it as variable "rest"
 *      Search if the hashmap contains the number:
 *          If it does return the array
 *          If not assign the number to the hashmap
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] original = nums.clone();
        Arrays.sort(nums);
        int bound = nums.length;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < bound; j++) {
                if (nums[i] + nums[j] > target) {
                    bound = j;
                    break;
                }
                if (nums[i] + nums[j] == target) {
                    return findIndexes(nums[i], nums [j], original);
                }
            }
        }

        return nums;
    }


    public int[] findIndexes(int numb1, int numb2, int[] original) {
        int[] retAr = new int[2];
        int index = 0;
        for (int i = 0; i < original.length; i++) {
            if (original[i] == numb1 || original[i] == numb2) {
                retAr[index] = i;
                index++;
                if (index == 2){
                    return  retAr;
                }
            }
        }
        return retAr;
    }

    /**
     * THIS IS THE ACTUAL ANSWER
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumHashing(int[] nums, int target) {
        Map<Integer, Integer> map =  new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums [i];
            if (map.containsKey(complement)) {
                return new int [] {map.get(complement), i};
            }
            map.put(nums[i],  i);
        }
        return  null;
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int answer[] = ts.twoSumHashing(new int[]{1, 2, 3, 4, 5}, 9);
        for (int i :
                answer) {
            System.out.println(i);
        }
    }

}
