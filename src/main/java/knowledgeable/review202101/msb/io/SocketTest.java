package knowledgeable.review202101.msb.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2021-02-24
 * Time: 18:48:39
 * Description:
 * 此程序用于延时bio的情况
 * 特点：阻塞等待数据到来
 */
public class SocketTest
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket serverSocket = new ServerSocket(8090);


        System.out.println("Step1: new ServerSocket(8090)");
        while (true)
        {
            Socket client = serverSocket.accept();
            System.out.println("Step2: client " + client.getPort());
            new Thread(new Runnable()
            {
                Socket ss;

                public Runnable setSS(Socket s)
                {
                    ss = s;
                    return this;
                }

                @Override
                public void run()
                {
                    try
                    {
                        InputStream in = ss.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
                        while (true)
                        {
                            System.out.println(bufferedReader.readLine());
                        }
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }.setSS(client)).start();
        }
    }
}
