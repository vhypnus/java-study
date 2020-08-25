package org.monan;

import java.util.concurrent.Exchanger;

public class Test {

    public static void main(String[] args) throws NoSuchFieldException {
        sun.misc.Unsafe U = sun.misc.Unsafe.getUnsafe();
        Class<?> ek = Exchanger.class;
        System.out.println(U.objectFieldOffset
                (ek.getDeclaredField("slot")));
    }
}
