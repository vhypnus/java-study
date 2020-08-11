package org.monan.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Application {

    public static void main(String[] args) {
        testClassLoader();
    }

    public static void testClassLoader() {
        ClassLoader parent = MonanClassLoader.class.getClassLoader() ;
        String path =  "/home/monan/github/java-study/data" ;
        ClassLoader classLoader = new MonanClassLoader(parent,path) ;


        String classname = "HelloWorld" ;
        try {
            Class c = classLoader.loadClass(classname) ;
            Object obj = c.newInstance() ;

            Method method = obj.getClass().getMethod("hello") ;
            method.invoke(obj) ;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
