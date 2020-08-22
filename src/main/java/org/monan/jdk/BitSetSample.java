package org.monan.jdk;

import java.util.BitSet;

public class BitSetSample {


    // 是否线程安排
    public static void main(String[] args) {
        BitSet bitSet  = new BitSet(10) ;
        System.out.println(bitSet.get(1));
        bitSet.set(1);
        System.out.println(bitSet.get(1));
    }
}
