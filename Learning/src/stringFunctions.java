public class stringFunctions {
    public static void main(String[] args) {
        String a = new String("Java");
        String b = new String("java");

        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(a.equalsIgnoreCase(b));
        System.out.println(a.indexOf('a'));
        System.out.println(a.charAt(2));
        System.out.println(a.lastIndexOf('a'));

        System.out.println("===========================");
        String s = "Shreyash";
        for (int i = 0; i < s.length(); i++) {
            System.out.println("Character at index " + i + ": " + s.charAt(i));
        }
        System.out.println("===========================");
        String str = "Shreyash";
        for (char c : str.toCharArray()) {
            System.out.println(c);
        }
        System.out.println("===========================");
        String str1 = "Shreyash";
        int i = 0;
        while (i < str1.length()) {
            System.out.println(str1.charAt(i));
            i++;
        }
    }
}