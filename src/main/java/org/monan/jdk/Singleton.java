package org.monan.jdk;

public class Singleton {

    public static Singleton instance = null ;

    public Integer counter ;

    public Singleton(Integer counter) {
        this.counter = counter;
    }

    public static Singleton getInstance(){
        if (instance == null){
            instance = new Singleton(5) ;
        }

        return instance ;
    }


    public class A implements Runnable {
        @Override
        public void run() {
            Singleton instance = Singleton.getInstance() ;
            if (instance.counter.intValue() == 5) { //[1]
                //todo
            }
        }
    }

    public static void main(String[] args) {
        Integer a = null ;

        if (a.intValue() == 0){
            System.out.print("not null exception");
        }
    }
}
