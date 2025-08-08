public class StringIntegerPool {
    public static void main(String[] args) {
        String s1 = "Java";
        String s2 = "Java";

        System.out.println(s1.hashCode() == s2.hashCode()); // true (same object from the pool)

        String s3 = new String("Java"); // new String("Java") creates a new object in heap, even if "Java" already exists in the pool.
        String s4 = "Java";

        System.out.println(s3 == s4); // false
        System.out.println(s3.hashCode() == s4.hashCode()); // false

        System.out.println(s1.equals(s2)); // true
        System.out.println(s3.equals(s4)); // true

        String s5 = s3.intern(); //forces s5 into the String pool
        //.intern() checks the pool and adds the string if it's not there.
        System.out.println(s5.equals(s4)); // true
        System.out.println(s4 == s5); // true

    }
}
