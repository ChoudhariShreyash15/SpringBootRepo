package Number;

public class secondMax {
    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 34, 1};

        Integer max = null;
        Integer secondMax = null;

        for (int num : arr) {
            if (max == null || num > max) {
                secondMax = max;
                max = num;
            } else if ((secondMax == null || num > secondMax) && num != max) {
                secondMax = num;
            }
        }

        if (secondMax != null) {
            System.out.println("Second maximum: " + secondMax);
        } else {
            System.out.println("No second maximum found.");
        }
    }
}
