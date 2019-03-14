public class BasicOperations
{
    private int a;
    private  int b;

    public BasicOperations(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int plus() {
        return a + b;
    }

    public int minus() {
        return a - b;
    }

    public int multiply() {
        return a * b;
    }

    public double division() { return (double) a / b;}
}
