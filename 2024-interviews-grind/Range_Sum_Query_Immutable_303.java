class NumArray {
  int[] arr;

  public NumArray(int[] nums) {
    this.arr = Arrays.copyOf(nums, nums.length);
  }

  public int sumRange(int left, int right) {
    int res = 0;
    for(int i = left; i <= right; i++) {
      res += arr[i];
    }
    return res;
  }
}

// Other solutions: use prefix sum

public class Range_Sum_Query_Immutable_303 {
  int[] arr

  public NumArray(int[] nums) {
    int arr = new int[nums.length];
    arr[0] = nums[0]
    for (int i = 1; i < nums.length; i++) {
      arr[i] += arr[i - 1] + nums[i];
    }
  }

  public int sumRange(int left, int right) {
    if (left == 0) return arr[right];
    return arr[right] - arr[left - 1];
  }
}
