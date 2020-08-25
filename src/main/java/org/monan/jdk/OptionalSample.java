package org.monan.jdk;

import java.util.Optional;

public class OptionalSample {


    public static void main(String[] args) {
        Person person = null ;
        String brand = null;
        if (null != person) {
            if (null != person.getCar()) {
                if (null != person.getCar().getWheel()) {
                    brand = person.getCar().getWheel().getBrand();
                }
            }
        }

        brand = Optional.ofNullable(person) //转换为Optional进行包裹
                .map(p -> p.getCar()) //获取Car对象
       .map(car -> car.getWheel()) //获取Wheel对象
       .map(wheel -> wheel.getBrand()) //获取brand
       .orElse("玛莎拉蒂"); //如果中间有对象为null，则返回默认值"玛莎拉蒂"

        System.out.println(brand) ;
    }

    static class Wheel {
        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        private String brand;
    }


    static class Car {
        public Wheel getWheel() {
            return wheel;
        }

        public void setWheel(Wheel wheel) {
            this.wheel = wheel;
        }

        private Wheel wheel;
    }

    static class Person {
        public Car getCar() {
            return Car;
        }

        public void setCar(Car Car) {
            this.Car = Car;
        }

        private Car Car;
    }

}
