package com.myjava.classLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
//自定义加载类
public class MyClassLoader extends ClassLoader{
    private String path; //加载类的路径
    private String name; //类加载器的名称

    public MyClassLoader(String name,String path) {
        super();//让系统类加载器成为该类的父加载器
        this.name = name;
        this.path = path;
    }
    public MyClassLoader(ClassLoader parent, String name,String path) {
        super(parent); //显示指定的类加载器
        this.name = name;
        this.path = path;

    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.name;
    }

    /*
     * 加载我们自定义的类，通过我们自定义的这个ClassLoader
     * classLoader.Demo.java
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = readClassFileToByteArray(name);
        return this.defineClass(name,data,0,data.length);
        //return super.findClass(name);
    }
    /**
     * 获取.class文件的字节数组
     * classLoader.Demo.java - 》 F:/temp/classLoader/Demo.class
     * @param name2
     * @return
     */
    private byte[] readClassFileToByteArray(String name) {
        InputStream is = null;
        byte[] returnData = null;

        name = name.replaceAll("\\.", "/");

        String filePath = this.path + name + ".class";

        File file  = new File(filePath);

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            is  = new FileInputStream(file);
            int tmp = 0;
            while((tmp = is.read())!=-1) {
                os.write(tmp);
            }

            returnData = os.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                os.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

        return returnData;


    }
}