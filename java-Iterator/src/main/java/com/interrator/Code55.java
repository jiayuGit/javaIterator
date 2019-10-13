package com.interrator;

public class Code55 {
    public static void main(String[] ags) {
        int[] arr = new int[]{5,1,2};
        //pathsToDitans(arr);
        //pathsToDitans(arr);
        System.out.println(arr);
        //arr = new int[]{3,2,5};
        //System.out.println(getCountSum(arr));
        int[] s1 = new int[]{1,3};
        int[] s2 = new int[]{2};
        System.out.println(findMedianSortedArrays1(s1,s2));
    }

    /**
     * 在两个有序数组中找到中位数
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 为了让搜索范围更小，我们始终让 num1 是那个更短的数组，PPT 第 9 张
        // 上述交换保证了 m <= n，在更短的区间 [0, m] 中搜索，会更快一些
        int m = nums1.length;
        int n = nums2.length;

        // 使用二分查找算法在数组 nums1 中搜索一个索引 i，PPT 第 9 张
        int left = 0;
        int right = m;

        // 因为 left_total 这个变量会一直用到，因此单独赋值，表示左边粉红色部分一共需要的元素个数
        int totalLeft = (m + n + 1) >>> 1;
        while (left < right) {
            int i = (left + right) >>> 1;
            int j = totalLeft - i;
            if (nums2[j - 1] > nums1[i]) {
                left = i + 1;
            } else {
                right = i;
            }
        }

        // 退出循环的时候，交叉小于等于一定关系成立，那么中位数就可以从"边界线"两边的数得到，原因在 PPT 第 2 张、第 3 张

        int i = left;
        int j = totalLeft - left;
        // 边界值的特殊取法的原因在 PPT 第 10 张
        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];

        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];

        // 交叉小于等于关系成立，那么中位数就可以从"边界线"两边的数得到，原因在 PPT 第 2 张、第 3 张
        // 已经找到解了，分数组之和是奇数还是偶数得到不同的结果，原因在 PPT 第 2 张
        if (((m + n) & 1) == 1) {
            return Math.max(nums1LeftMax, nums2LeftMax);
        } else {
            return (double) ((Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin))) / 2;
        }
    }


    public static double findMedianSortedArrays1(int[] s1,int[] s2){
        if (s1.length > s2.length) {
            int[] temp = s1;
            s1 = s2;
            s2 = temp;
        }
        int left = 0;
        int right = s1.length-1;
        int m = 0;
        int k = (s1.length+s2.length+1)/2;
        while(left<=right){
            m = (left+right)/2;
            int j = k-m;
            if(s1[m]<s2[j-1]){
                left=m+1;
            }else {
                right = m;
            }
        }
        int i = left;
        int j = k-i;
        int lM1 = i==0?Integer.MIN_VALUE:s1[i-1];
        int lM2 = j==0?Integer.MIN_VALUE:s2[j-1];
        int rM1 = i==s1.length?Integer.MAX_VALUE:s1[i];
        int rM2 = j==s2.length?Integer.MAX_VALUE:s2[j];
        if(((s1.length+s2.length)&1)==1){
            return Math.max(lM1,lM2);
        }else {
            return (double)(Math.max(lM1,lM2)+Math.min(rM1,rM2))/2;
        }
    }



}
