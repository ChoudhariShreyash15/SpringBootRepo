public class SumOfArray {
    public static void main(String[] args){
        int[] n = {10,20,30,40,50};
        int sum = 0;
        for (int i=0; i<n.length; i++)
            sum = sum + n[i];
        System.out.println("Sum is: " + sum);
    }
}
