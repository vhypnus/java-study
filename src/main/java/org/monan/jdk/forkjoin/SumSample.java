package org.monan.jdk.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class SumSample extends RecursiveTask<Integer> {
    private Integer start ;

    private Integer end ;

    private Integer threadHold = 5;

    public SumSample(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        Integer sum = 0 ;
        if(end -start > threadHold) {
            SumSample l = new SumSample(start,threadHold) ;
            SumSample r = new SumSample(threadHold+1,end) ;
            l.fork() ;
            r.fork() ;
            sum = l.join() +r.join() ;
        } else {

            for (int i = start ; i< end ;i ++){
                sum += i ;
            }

        }
        return sum ;
    }

    public static void main(String[] args) {
        SumSample task = new SumSample(0,100) ;
        ForkJoinPool forkjoin = ForkJoinPool.commonPool() ;
        Future<Integer> sum = forkjoin.submit(task) ;
        try {
            System.out.println(sum.get())  ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
