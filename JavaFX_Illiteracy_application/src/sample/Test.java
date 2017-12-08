package sample;

public class Test {
    private int test = 0;

    public static void main(String[] args) {
       Test test = new Test();
       test.adding();

    }

    public void adding(){
        test++;
        System.out.println(test);
    }
}
