package AIO;


import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    //线程池
    private ExecutorService executorService;
    //异步通道线程组
    private AsynchronousChannelGroup threadGroup;
    //服务器通道
    public AsynchronousServerSocketChannel assc;

    public Server(int port){
        try {
            //创建一个线程池
            executorService = Executors.newCachedThreadPool();
            //使用线程池创建异步通道线程组, 该线程组在底层支持着我们的异步操作
            threadGroup = AsynchronousChannelGroup.withCachedThreadPool(executorService, 1);
            //使用 异步通道线程组 创建服务器通道
            assc = AsynchronousServerSocketChannel.open(threadGroup);
            //给通道绑定端口
            assc.bind(new InetSocketAddress(port));
            System.out.println("server start");
            // 下面的accept不会阻塞 , 一个accept只能接收一个连接请求
            // accept第一个参数: 被绑定到IO操作的关联对象(子类), 第二个参数 CompletionHandler<AsynchronousSocketChannel, 关联对象(父类)>, 操作成功后执行的回调句柄
            // 如果接受了一个新的连接, 其结果AsynchronousSocketChannel会被绑定与assc通道到相同的AsynchronousChannelGroup
            assc.accept(this, new ServerCompletionHandler());
            // 这里为了避免程序结束, 异步通道线程组结束就不会执行回调了
            Thread.sleep(Integer.MAX_VALUE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Server(8765);
    }

}
