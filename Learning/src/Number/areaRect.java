package Number;

public class areaRect {
    int areaRect(int l,int b){
        int area = l * b;
        return area;
    }

    public static void main(String[] args){
        areaRect a = new areaRect();
        int b = a.areaRect(10,20);
        System.out.println(b);
    }
}
