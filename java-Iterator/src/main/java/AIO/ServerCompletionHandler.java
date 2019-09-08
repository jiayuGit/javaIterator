package AIO;


import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

//第一个参数: IO操作结果; 第二个参数: 被绑定到IO操作的关联对象
public class ServerCompletionHandler implements CompletionHandler<AsynchronousSocketChannel, Server> {

    // 以下两个重载参数与CompletionHander的模板参数一致, 回调时被传入IO结果和IO操作时设置的关联对象
    @Override
    public void completed(AsynchronousSocketChannel asc, Server attachment) {
        // 完成当前连接时, 首先, 为下一个客户端能接入再次调用accept异步方法
        attachment.assc.accept(attachment, this);
        // 其次, 执行下一步的读操作
        read(asc);
    }
    @Override
    public void failed(Throwable exc, Server attachment) {
        exc.printStackTrace();
    }

    private void read(final AsynchronousSocketChannel asc) {
        //读取数据
        ByteBuffer buf = ByteBuffer.allocate(1024);
        // 第一个参数: 读操作的Buffer, 第二个参数: IO关联对象, 第三个参数:CompletionHandler<Integer, IO管理对象父类>
        asc.read(buf, buf, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer resultSize, ByteBuffer attachment) {
                //进行读取之后,重置标识位
                attachment.flip();
                //获得读取的字节数
                System.out.println("Server端" + "收到客户端的数据长度为:" + resultSize);
                //获取读取的数据
                String resultData = new String(attachment.array()).trim();
                System.out.println("Server端" + "收到客户端的数据信息为:" + resultData);
                String response = "From服务端To客户端: 于" + new Date() + "收到了请求数据"+ resultData;
                write(asc, response);
            }
            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                exc.printStackTrace();
            }
        });
    }

    private void write(AsynchronousSocketChannel asc, String response) {
        try {
            ByteBuffer buf = ByteBuffer.allocate(1024);
            buf.put(response.getBytes());
            buf.flip();
            // 写操作, 异步
            Future<Integer> future = asc.write(buf);
            // 阻塞等待结果
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}