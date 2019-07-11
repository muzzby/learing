package src.main.java.synchronizedl;

public class SynchronizedTest {
    public static void main(String[] args){
        // t1,t2持有不同的对象
        Test t1 = new Test();
        t1.start();
        Test t2 = new Test();
        t2.start();
    }
}
