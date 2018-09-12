package com.myjava.tomcat;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

public class TomcatCore {
 
	public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		System.out.println("Hellow,I'm MyTomcat ,and I'm in the initialization... ");
		Thread.sleep(3000);
		System.out.println("Now,I have finished the initialization .");
		Thread.sleep(1000);
		System.out.println("Now I will start  the Servlet.");
		//读取配置文件获取Servlet的项目路径名及类包路径名
		FileReader reader = new FileReader("./TomcatConf.txt");
        BufferedReader br = new BufferedReader(reader);
        String path = br.readLine();
        String className = br.readLine();
        br.close();
        reader.close();
        
        //根据已获取Servlet的项目路径名及类包路径名通过URL类加载器加载文件系统中的某个.class
        File file = new File(path);   
        URL url = file.toURI().toURL();//这里取文件系统的URL地址
        @SuppressWarnings("resource")
		URLClassLoader loader = new URLClassLoader(new URL[]{url});//创建持有我们所部署的"web项目"路径的URL类加载器，以使Tomcat之外的"web"纳入Tomcat的classpath之中。
        Class<?> tidyClazz = loader.loadClass(className); //利用反射加载类
        MyServletIn serv=(MyServletIn)tidyClazz.newInstance();//转化为Servlet接口执行service操作。
        serv.service();//当然，实际的tomcat并不在这里调用service，而仅仅是进入事件循环，在有浏览器请求时才调用service。	
	}
}
