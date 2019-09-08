package NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Serve implements Runnable{  
    private Selector seletor;
    private ByteBuffer readBuf = ByteBuffer.allocate(1024);
    private ByteBuffer writeBuf = ByteBuffer.allocate(1024);
    
    public Serve(int port){
        try {
            //1 ������·������selector
            this.seletor = Selector.open();
            //2 ����ServerSocketͨ��
            ServerSocketChannel ssc = ServerSocketChannel.open();
            //3 ����ͨ���Ƿ�����, ������ͨ����read/write/accept/connect�����Ƿ�����
            ssc.configureBlocking(false);
            //4 ����ͨ����ַ
            ssc.bind(new InetSocketAddress(port));
            //5 ��ServerSocketͨ��ע�ᵽselector��, ָ��������accept�¼�
            ssc.register(this.seletor, SelectionKey.OP_ACCEPT);
            System.out.println("Server start");
            ConcurrentLinkedQueue c;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true){
            try {
                // select����, ��������¼�
                this.seletor.select();
                // �������, ����ѡ��key, key����ͨ��, ״̬����Ϣ
                Iterator<SelectionKey> keysIter = this.seletor.selectedKeys().iterator();
                
                // ���б���
                 while(keysIter.hasNext()){
                    SelectionKey key = keysIter.next();
                    System.out.println();
                    keysIter.remove();
                    System.out.println("key.isValid()->"+key.isValid());
                    if (key.isValid()) {
                        // �ȴ���������״̬
                        if (key.isAcceptable()) {
                        	 System.out.println("�ȴ���������״̬()");
                            accept(key);
                           
                        }
                        // �ɶ�״̬
                        if (key.isReadable()) {
                        	System.out.println("�ɶ�״̬()");
                            read(key);
                            
                        }
                        if (key.isWritable()) {
                        	System.out.println("��д״̬()");
                            write(key);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    

    private void write(SelectionKey key) {
        try {
            // ��ȡͨ��
        	
            SocketChannel sc = (SocketChannel) key.channel();
            // д�ظ��ͻ�������
            writeBuf.put("���Է���������Ӧ".getBytes());
            writeBuf.flip();
            sc.write(writeBuf);
            writeBuf.clear();
            // �޸ļ�����״̬λ, �������OP_WRITE�ᵼ���ظ�д
//            key.interestOps(SelectionKey.OP_READ);
            sc.register(this.seletor, SelectionKey.OP_READ);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void read(SelectionKey key) {
        try {
            // ��ȡͨ��
            SocketChannel sc = (SocketChannel) key.channel();
            // ��ȡ����, ����buffer. ����������˳��, ����sc�Ƿ�����Ϊ����Ч����һ��
            int count = sc.read(this.readBuf);  // readBufдʱ��ı�position��ֵ
            if (count == -1) {
                key.channel().close();
                key.cancel();  //ȡ����ͨ����selector��ע��, ֮�󲻻ᱻselect��ѯ��
                return;
            }
            // ����������ж�ȡ. ��ȡǰ��Ҫ��position��limit���и�λ
            readBuf.flip();
            // ���ݻ����������ݳ��ȴ�����Ӧ��С��byte����, ���ջ�����������
            byte[] bytes = new byte[this.readBuf.remaining()];
            // ���ջ���������
            readBuf.get(bytes);
            readBuf.clear();
            String body = new String(bytes).trim();
            System.out.println("Server��ȡ������: " + body);
            // �������OP_READ�ᵼ���ظ���
            sc.register(this.seletor, SelectionKey.OP_WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void accept(SelectionKey key) {
        try {
            // ��ȡ����ͨ��
            ServerSocketChannel ssc =  (ServerSocketChannel) key.channel();
            // ��ȡ�ͻ���ͨ��.
            SocketChannel sc = ssc.accept();
            // ���÷�����ģʽ
            sc.configureBlocking(false);
            // ���ͻ���ͨ��ע�ᵽ��·�������ϣ�ָ�������¼�
            sc.register(this.seletor, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new Thread(new Serve(8765)).start();;
    }
}
