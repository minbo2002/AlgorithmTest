package flab.week4;

public class LongestPalindromicSubstring_5 {

    class Solution {  // input 배열을기준으로 target 배열값의 index 위치를 찾는 문제

        public int search(int[] nums, int target) {  // 퀵search (피벗기준)

            // [4,5,6,7,0,1,2]  left=0, right=6, target=0, output=4, mid=3

            int left = 0;  // 왼쪽index
            int right = nums.length - 1;  // right : 오른쪽 index

            while (left <= right) {
                int mid = (right + left) / 2;   // mid : 피벗 index

                //찾으면 결과 리턴
                if (nums[mid] == target) {
                    return mid;

                    // 피벗 기준으로 왼쪽 부분이 완전히 정렬된 경우
                } else if (nums[left] <= nums[mid]) {

                    // 피벗기준으로 target이 오른쪽에 있음
                    if (nums[mid] < target || nums[left] > target) {
                        left = mid + 1;  // 왼쪽을 날림

                        // 피벗기준으로 target이 왼쪽에 있음
                    } else {
                        right = mid - 1;  // 오른쪽을 날림
                    }

                    // 피벗 기준으로 오른쪽 부분이 완전히 정렬된 경우
                } else {

                    // 왼쪽 선택
                    if (target < nums[mid] || target > nums[right]) {
                        right = mid - 1;  // 오른쪽을 날림

                        // 오른쪽 선택
                    } else {
                        left = mid + 1;   // 왼쪽을 날림
                    }

                }

            }

            return -1;
        }
    }

}

