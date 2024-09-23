package many;

import java.util.Arrays;

public class ArrayExample {
  // ... means "get an array", but allows the caller to provide comma separated values
  public static int sum(int ... nums) {
//  public static int sum(int[] nums) {
    int sum = 0;
    for (int v : nums) {
      sum += v;
    }
    return sum;
  }

  public static void main(String[] args) {
    int [] nums;
    nums = new int[4]; // once created, an array has FIXED SIZE
    System.out.println("nums is " + nums);
    System.out.println("nums is " + Arrays.toString(nums));
    nums[1] = 99; // subscripts are always 0 through length-1
    System.out.println("nums is " + Arrays.toString(nums));
    System.out.println("size of nums is " + nums.length);

//    int idx = 0;
//    while (idx < nums.length) {
//      System.out.println("nums [" + idx + "] is " + nums[idx]);
////      idx = idx + 1;
////      idx += 1;
//      idx++;
//    }

//    for (int idx = 0; idx < nums.length; idx++) {
//      System.out.println("nums [" + idx + "] is " + nums[idx]);
//    }

    // enhanced for, arrays and "Iterable" types
    for (int v : nums) {
      System.out.println(v);
    }

    System.out.println("sum of 1 to 10 is " + sum(1,2,3,4,5,6,7,8,9,10));
    int [] ia = new int[]{1,2,3,4,5,6,7,8,9,10,};
    System.out.println("sum of 1 to 10 is " + sum(ia));
  }
}
