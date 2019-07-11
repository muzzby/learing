package src.main.java.cas;

/**
 * @author byway
 */
public class Cas2 {

    private static int count = 0;
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //每个线程让count自增100次
                    for (int i = 0; i < 100; i++) {
                        /**
                         * 说明：synchronized 加锁
                         *
                         *
                         1、普通同步方法，锁是当前实例对象
                         2、静态同步方法，锁是当前类的 class 对象
                         3、同步方法块，锁是括号里面的对象
                         Cas2 对象需要好好理解，如果是this可以吗？
                         如果不可以，如果通过this来实现，见Cas3
                         */
                        synchronized (Cas2.class){
                            count++;
                        }
                    }
                }
            }).start();
        }
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(count);
    }
}
