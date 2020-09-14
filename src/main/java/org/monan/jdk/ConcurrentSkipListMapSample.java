package org.monan.jdk;

import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListMapSample {

    public static void main(String[] args) {

        /**  只能按key排序
         * Exception in thread "main" java.lang.ClassCastException: java.lang.String cannot be cast to java.util.Map$Entry
        ConcurrentSkipListMap<Long,Long> map = new ConcurrentSkipListMap(new Comparator<Map.Entry<Long,Long>>() {
            @Override
            public int compare(Map.Entry<Long,Long> o1, Map.Entry<Long,Long> o2) {
                return o1.getValue().compareTo(o2.getKey());
            }
        }) ;

        map.put(1l,10l) ;
        map.put(2l,20l) ;
        map.put(1l,30l) ;

        System.out.println(map.size()) ;**/
    }
}
