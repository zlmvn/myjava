package com.myjava.nio;



import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by flyap on 2018/8/23.
 */
public class NIOtest {
    //通道管理器
    private Selector selector;
     /*
     * 获得一个通道，并通道进行初始化
     *
     * */

    public  void  initServer(int port) throws IOException {
        //获得通道
        ServerSocketChannel socketChannel=ServerSocketChannel.open();
        //设置通道为非阻塞
        socketChannel.configureBlocking(false);
        //将通道对应的serverSocket绑定到port 端口
        socketChannel.socket().bind(new InetSocketAddress(port));
        //获得一个通道管理器
        this.selector=Selector.open();
        // 将通道管理器和该通道绑定，并为该通道注册SelectionKey.OP_ACCEPT事件,注册该事件后，
        // 当该事件到达时，selector.select()会返回，如果该事件没到达selector.select()会一直阻塞。
        socketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }
    /*
    * 采用轮寻得方式监听是否有需要处理的事件如果有进行处理
    * */
    public  void lisen() throws IOException {
        System.out.println("服务已启动");
        while (true){
            selector.select();
            Iterator<?> ite= (Iterator<?>) this.selector.selectedKeys().iterator();
            while (ite.hasNext()){
                SelectionKey key = (SelectionKey) ite.next();
                //删除已选的key 以防重复处理
                ite.remove();
                handeler(key);
            }
        }
    }

    public  void handeler(SelectionKey key)throws  IOException{
        //客户端请求连接事件
        if(key.isAcceptable()){
            handlerAccept(key);
            //获得可读的事件

        }


    }
    public void  handlerAccept(SelectionKey key) throws IOException {
        ServerSocketChannel server= (ServerSocketChannel) key.channel();
        //获得和客户端的连接通道
        SocketChannel channel=server.accept();
        //设置成非阻塞
        channel.configureBlocking(false);
        //在这里可以给客户但发送信息
        System.out.println("新的客户端连接");
        //和客户端连接成功之后，给客户端设置可读权限
        channel.register(this.selector,SelectionKey.OP_ACCEPT);
    }

   /*
   *
   *
   * 处理读的事件
   *
   * */
    public  void  handelerRead(SelectionKey key) throws IOException {
        //服务器可读消息得到时间发生的socket 通道
        SocketChannel channel = (SocketChannel) key.channel();
        //创建读的缓冲区
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        int read=channel.read(buffer);
        if(read>0){
            byte[] data=buffer.array();
            String msg=new String(data).trim();
            System.out.println("服务端收到消息："+msg);
            //会写数据
            ByteBuffer outBuffer=ByteBuffer.wrap("好的".getBytes());
            channel.write(outBuffer);//将消息发给客户端
        }
        System.out.println("客户端关闭");
        key.cancel();
    }

    /*
    * 启动服务端调试
    *
    *
    * */

    public static void main(String[] args) throws IOException {
        NIOtest server=new NIOtest();
        server.initServer(8801);
        server.lisen();
    }


}
