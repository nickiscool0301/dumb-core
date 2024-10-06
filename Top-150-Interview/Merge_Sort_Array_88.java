class Merge_Sort_Array_88 {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int a = m - 1;
    int b = n - 1;
    int c = m + n -1;
    while( b >= 0) {
      if (a >= 0 && nums2[b] < nums1[a]) {
        nums1[c--] = nums1[a--];
      } else
        nums1[c--] = nums2[b--];
    }
  }
}
