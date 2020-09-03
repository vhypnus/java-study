package org.monan.jdk.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompleteFutureSample {

    public static void main(String[] args) {
        CompletableFuture future = CompletableFuture.runAsync(()->{

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("testtask is running") ;
        }) ;

//        try {
//            future.get() ;
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

        System.out.println("i am done ") ;

    }
}
