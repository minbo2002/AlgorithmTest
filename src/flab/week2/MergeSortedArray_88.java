package flab.week2;

/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
Merge nums1 and nums2 into a single array sorted in non-decreasing order.
The final sorted array should not be returned by the function,
but instead be stored inside the array nums1.
To accommodate this, nums1 has a length of m + n,
where the first m elements denote the elements that should be merged,
and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

ex1)
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]

Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

ex2)
Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]

Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].

ex3)
Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]

Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1.
The 0 is only there to ensure the merge result can fit in nums1.

Constraints)
nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[j] <= 109

 */

import java.util.Arrays;

public class MergeSortedArray_88 {

    class Solution {

        public void merge(int[] nums1, int m, int[] nums2, int n) {

            int index = 0;

            // m 인덱스 부터 nums2의 값을 순서대로 넣어준 뒤 정렬
            for(int i=m; i<nums1.length; i++) {
                nums1[i] = nums2[index++];
            }

            Arrays.sort(nums1);
        }


        public void merge2(int[] nums1, int m, int[] nums2, int n) {

            int [] x = new int[n+m];  // 1,2,3  2,5,6,1
            int one = 0;
            int two = 0;

            for(int a=0; a<m+n; a++) {

                if(one!=m && two!=n) {

                    if(nums1[one]<=nums2[two]) {
                        x[a]=nums1[one];
                        one++;
                    }else {
                        x[a]=nums2[two];
                        two++;
                    }

                }else if(one!=m) {
                    x[a]=nums1[one];
                    one++;
                }else {
                    x[a]=nums2[two];
                    two++;
                }
            }

            for(int i=0; i<m+n; i++) {
                nums1[i]=x[i];
            }
        }
    }


}
