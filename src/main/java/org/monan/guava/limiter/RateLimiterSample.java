package org.monan.guava.limiter;

import com.google.common.util.concurrent.RateLimiter;

public class RateLimiterSample {

    public static void main(String[] args) {

        /**
         * 使用RateLimiter的静态方法创建一个限流器，设置每秒放置的令牌数为5个。
         * 返回的RateLimiter对象可以保证1秒内不会给超过5个令牌，并且以固定速率进行放置，
         * 达到平滑输出的效果。
         */
        //        RateLimiter r = RateLimiter.create(5);
//        while (true) {
//            System.out.println("get 1 tokens: " + r.acquire() + "s");
//        }

        RateLimiter r = RateLimiter.create(2);
        while (true) {
            System.out.println("get 1 tokens: " + r.acquire(1) + "s");
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
            }
            System.out.println("get 1 tokens: " + r.acquire(1) + "s");
            System.out.println("get 1 tokens: " + r.acquire(1) + "s");
            System.out.println("get 1 tokens: " + r.acquire(1) + "s");
            System.out.println("end");
        }
    }
}
