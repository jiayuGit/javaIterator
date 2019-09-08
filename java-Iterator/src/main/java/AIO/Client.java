package AIO;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.LockSupport;

public class Client {

    private AsynchronousSocketChannel asc ;
    public Client() throws Exception {
        asc = AsynchronousSocketChannel.open();
    }

    public void connect() throws InterruptedException, ExecutionException{
        // get()阻塞
        asc.connect(new InetSocketAddress("127.0.0.1", 8765)).get();
    }

    public void write(String request){
        try {
            // get()阻塞
            asc.write(ByteBuffer.wrap(request.getBytes())).get();
            read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void read() throws IOException {
        ByteBuffer buf = ByteBuffer.allocate(1024);
        try {
            // get()阻塞
            asc.read(buf).get();
            buf.flip();
            byte[] respByte = new byte[buf.remaining()];
            buf.get(respByte);
            System.out.println(new String(respByte,"utf-8").trim());
            // 关闭
            asc.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        Client c1 = new Client();
        Client c2 = new Client();
        c1.connect();
        c2.connect();

        c1.write("aa");
        c2.write("bbb");
    }
}