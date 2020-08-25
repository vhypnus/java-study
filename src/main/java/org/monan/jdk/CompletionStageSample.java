package org.monan.jdk;

import java.util.concurrent.CompletableFuture;

public class CompletionStageSample {

    public static void main(String[] args) {
        CompletionStageSample sample = new CompletionStageSample() ;
        sample.thenApply();
        sample.applyToEither();
        sample.thenCombine();
    }

    public void thenApply() {
        CompletableFuture<String> stage = CompletableFuture.supplyAsync(() -> "hello");

        String result = stage.thenApply(s -> s + " world").join();
        System.out.println(result);
    }


    public void thenCombine() {
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "world";
        }), (s1, s2) -> s1 + " " + s2).join();
        System.out.println(result);
    }

    public void applyToEither() {
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Tom";
        }).applyToEither(CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "John";
        }), s -> "hello " + s).join();
        System.out.println(result);
    }
}
