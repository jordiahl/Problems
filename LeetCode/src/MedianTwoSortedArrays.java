import java.util.ArrayList;

/**
 * Created by jordi on 8/17/2017.
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 Example 1:
 nums1 = [1, 3]
 nums2 = [2]

 The median is 2.0
 Example 2:
 nums1 = [1, 2]
 nums2 = [3, 4]

 The median is (2 + 3)/2 = 2.5
 *
 ************Answer
 ***** Implement the "merge" part of the merge sort
 *     Look for the half and find the number that is needed
 */
public class MedianTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int i = 0;
        int j = 0;
        ArrayList<Integer> fullArray = new ArrayList<>();
        while (i< nums1.length && j< nums2.length){

            if (nums1 [i] <= nums2[j]) {
                fullArray.add(nums1[i]);
                i++;
            }
            else {
                fullArray.add(nums2[j]);
                j++;
            }
        }

        while (i<nums1.length){
            fullArray.add(nums1[i]);
            i++;
        }
        while (j<nums2.length){
            fullArray.add(nums2[j]);
            j++;
        }

        if (fullArray.size()%2 !=0) {
            int half = fullArray.size()/2;
            return fullArray.get(half);
        }
        else {
            int half = fullArray.size()/2-1;
            double number = (double)(fullArray.get(half)+ fullArray.get(half+1))/2;
            return  number;
        }
    }

    public static void main(String[] args) {
        MedianTwoSortedArrays m2a= new MedianTwoSortedArrays();

        m2a.findMedianSortedArrays(new int []{1,2}, new int []{3,4});
    }
}
