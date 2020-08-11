package org.monan.classloader;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

public class MonanClassLoader extends ClassLoader {

    private String path ;

    public MonanClassLoader(ClassLoader parent,  String path) {
        super(parent);
        this.path = path;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {


            synchronized (getClassLoadingLock(name)) {
                Class c = findLoadedClass(name) ;
                if (c == null) {
                    if (getParent() != null ){
                        try {
                            c = getParent().loadClass(name) ;
                        } catch(ClassNotFoundException e) {
                            System.out.println("parent not found class.");
                        }

                    }

                    if (c == null){
                        c = findClass(name) ;
                    }
                }
                return c ;
            }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        String filepath = path + "/"+name.replace(".", "/") + ".class";;
        System.out.println(filepath);

        Class c = null ;
        try(FileInputStream fis = new FileInputStream(filepath) ;
            ByteArrayOutputStream baos = new ByteArrayOutputStream( )) {

            FileChannel fileChannel = fis.getChannel() ;

            WritableByteChannel wbc = Channels.newChannel(baos) ;

            ByteBuffer buffer= ByteBuffer.allocateDirect(1023) ;
            while(true){
                int size = fileChannel.read(buffer) ;
                if (size > 0 ){
                    buffer.flip() ;
                    wbc.write(buffer) ;
                    buffer.clear() ;
                } else {
                    break ;
                }
            }

            c = defineClass(name,baos.toByteArray(),0,baos.size())  ;


            //to close
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return c ;
    }
}
