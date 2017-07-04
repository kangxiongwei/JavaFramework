package service.demo;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * Thrift服务器
 * <p>
 * Created by kangxiongwei on 2017/7/4.
 */
public class HelloServiceServer {

    /**
     * 启动 Thrift 服务器
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        TServerSocket serverTransport = null;
        try {
            // 设置服务端口为 7911
            serverTransport = new TServerSocket(7911);
            // 设置协议工厂为 TBinaryProtocol.Factory
            TBinaryProtocol.Factory proFactory = new TBinaryProtocol.Factory();
            // 关联处理器与 Hello 服务的实现
            TProcessor processor = new Hello.Processor(new HelloServiceImpl());
            TThreadPoolServer.Args params = new TThreadPoolServer.Args(serverTransport);
            params.processor(processor);
            params.protocolFactory(proFactory);
            TServer server = new TThreadPoolServer(params);
            System.out.println("Start server on port 7911...");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        } finally {
            serverTransport.close();
        }
    }


}
