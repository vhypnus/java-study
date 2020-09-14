package org.monan.jdk;


public class VolatileSample implements Runnable {

    public boolean stop = false;

    @Override
    public void run() {
        try {
            Thread.sleep(500l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        stop = true ;
        System.out.println("thread out.stop flag ==>"+stop);
    }

    public static void main(String[] args) {
        VolatileSample counter = new VolatileSample();
        Thread t = new Thread(counter);
        t.start();

        while (true) {
            if (counter.stop) {
                System.out.println("flag ==>" + counter.stop);
                break;
            }
        }

        System.out.println("main thread out");
    }
}
