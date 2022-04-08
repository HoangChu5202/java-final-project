import java.util.Arrays;

/**
 * Chapter5Demo
 */
public class Chapter5Demo {
    public static void main(String[] args) {
        String[] months = new String[12];
        months[0] = "January";
        months[1] = "February";
        months[2] = "March";
        months[3] = "April";
        months[4] = "May";
        months[5] = "June";
        months[6] = "July";
        months[7] = "August";
        months[8] = "September";
        months[9] = "October";
        months[10] = "November";
        months[11] = "December";
        Arrays.sort(months);
        // for (String month : months) {
        //     System.out.println(month);
        // }
        System.out.println(Arrays.toString(months));
        // for (int i = 0; i < months.length; i++) {
        //     System.out.println(months[i]);
        // }

        int[] nums = {6, 0, -5, 9, 12, -4};
        //Arrays.sort(nums);
        // for (int num : nums) {
        //     System.out.println(num);
        // }

        // Step 1: Assign either value to a temp variable
        int temp = nums[0];
        // Step 2: Assign the second value to the first
        nums[0] = nums[nums.length - 1];
        
        nums[nums.length - 1] = temp;
    }
}