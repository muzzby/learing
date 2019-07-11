package cas;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * @author byway
 */
public class Cas3 implements Runnable{
    private static int count = 0;
    @Override
    public void run() {
        synchronized (this){
            for(int i = 0 ; i < 100; i++){
                count++;
            }
        }
    }

    public static void main(String[] args) {
        Cas3 cas3 = new Cas3();
        Thread t1 = new Thread(cas3,"A");
        Thread t2 = new Thread(cas3,"B");
        t1.start();
        t2.start();
        try{
            Thread.sleep(1000L);
            System.out.println(count);
        }catch (Exception e){
            log.println(e.getCause());
        }
    }
}
