package flab.week3;

/*
https://velog.io/@ddongh1122/LeetCode-33.-Search-in-Rotated-Sorted-Array
참고
 */

public class SearchInRotatedSortedArray_33 {
    // 피벗 기준으로 정렬된 배열을 섞는다.
    // 피벗을 기준으로 각자 정렬을 유지하므로 이진 탐색으로 피벗의 index를 찾을수있다.
    // 배열의 첫번째값을 기준으로 중간값이 첫번째 값보다 크면 start = mid + 1
    //                       중간값이 첫번째 값보다 작다면, end = mid - 1
    // 피벗의 index를 찾고난뒤에 피벗을 기준으로 정렬이 되어있으므로 이진탐색 가능

    class Solution {
        public int search(int[] nums, int target) {

            int left = 0;
            int right = nums.length - 1;

            while (left <= right) {

                int mid = (right + left) / 2;

                // 찾으면 결과 리턴
                if (nums[mid] == target) {
                    return mid;

                // 왼쪽 부분이 완전히 정렬된 경우
                } else if (nums[left] <= nums[mid]) {

                    // 오른쪽 선택
                    if (nums[mid] < target || nums[left] > target) {
                        left = mid + 1;

                        // 왼쪽 선택
                    } else {
                        right = mid - 1;
                    }

                // 오른쪽 부분이 완전히 정렬된 경우
                } else {

                    // 왼쪽 선택
                    if (target < nums[mid] || target > nums[right]) {
                        right = mid - 1;

                    // 오른쪽 선택
                    } else {
                        left = mid + 1;
                    }
                }
            }
            return -1;
        }
    }
}
