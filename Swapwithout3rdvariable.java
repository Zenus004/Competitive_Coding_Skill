public class Swapwithout3rdvariable {
    public static void main(String[] args) {
        int a = 2, b = 6;
        System.out.println("Before swap a = " + a + ", b = " + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("After swap a = " + a + ", b = " + b);
    }
}
