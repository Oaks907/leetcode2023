package org.example.week.contest;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/10/29 11:00
 **/
public class MinimumEqualSumofTwoArraysAfterReplacingZeros {

    public long minSum(int[] nums1, int[] nums2) {
        int nums1ZeroCount = 0;
        int nums2ZeroCount = 0;

        Long nums1ValCount = 0L;
        Long nums2ValCount = 0L;

        for (int i : nums1) {
            if (i == 0) {
                nums1ZeroCount++;
            } else {
                nums1ValCount += i;
            }
        }

        for (int i : nums2) {
            if (i == 0) {
                nums2ZeroCount++;
            } else {
                nums2ValCount += i;
            }
        }

        if (nums1ZeroCount != 0 && nums2ZeroCount != 0) {
            return Math.max(nums1ValCount + nums1ZeroCount, nums2ValCount + nums2ZeroCount);
        } else if (nums1ZeroCount != 0) {
            if (nums1ValCount + nums1ZeroCount > nums2ValCount) {
                return -1;
            } else {
                return nums2ValCount;
            }
        } else if (nums2ZeroCount != 0) {
            if (nums2ValCount + nums2ZeroCount > nums1ValCount) {
                return -1;
            } else {
                return nums1ValCount;
            }
        } else {
            if (nums1ValCount.equals(nums2ValCount)) {
                return nums1ValCount;
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) {

        int[] arr1 ={0,17,20,17,5,0,14,19,7,8,16,18,6};
        int[] arr2 = {21,1,27,19,2,2,24,21,16,1,13,27,8,5,3,11,13,7,29,7};

        MinimumEqualSumofTwoArraysAfterReplacingZeros exe = new MinimumEqualSumofTwoArraysAfterReplacingZeros();
        System.out.println(exe.minSum(arr1, arr2));
    }
}
