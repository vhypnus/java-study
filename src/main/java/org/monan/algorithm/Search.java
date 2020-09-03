package org.monan.algorithm;

public class Search {

    public int binarySearch(int[] a,int val){
        int s = 0 ;
        int e = a.length ;
        int m = (s+e)/2 ;
        while(s<=e){

            if (a[m] == val) {
                break ;
            } else if (a[m] > val){
                e = m ;
            } else {
                s = m ;
            }
            m = (s+e) /2 ;

        }

        return m ;

    }
}
