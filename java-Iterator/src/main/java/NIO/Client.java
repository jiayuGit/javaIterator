package NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
	 public static void main(String[] args) throws IOException {
	        SocketChannel sc = null;
	        ByteBuffer writeBuf = ByteBuffer.allocate(1024);
	        ByteBuffer readBuf = ByteBuffer.allocate(1024);
	        try {
	            //����ͨ��
	            sc = SocketChannel.open();
	            //��������
	            sc.connect(new InetSocketAddress("127.0.0.1", 8765));
	            // ���沽�������selector��ѯ����
	            while(true){
	                //����һ���ֽ����飬Ȼ��ʹ��ϵͳ¼�빦�ܣ�
	                byte[] bytes1 = new byte[1024];
	                System.in.read(bytes1);  //����
	                //�����ݷŵ���������
	                writeBuf.put(bytes1);
	                //�Ի��������и�λ
	                writeBuf.flip();
	                //д������
	                sc.write(writeBuf);
	                //��ջ�����
	                writeBuf.clear();
	                
	                // ���շ������Ӧ
	                sc.read(readBuf);
	                readBuf.flip();
	                byte[] bytes2 = new byte[readBuf.remaining()];
	                readBuf.get(bytes2);
	                readBuf.clear();
	                String body = new String(bytes2);
	                System.out.println("Client��ȡ����: " + body);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            sc.close();
	        }
	    }
}

