/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intranetmailsystemfinal11;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author pravardha
 */

public class Server1 
{
    ObjectInputStream is=null;
    User us=null;
    ServerSocket ss=null;
    Socket s=null;
    PrintWriter pw=null;
    DataInputStream dis=null;
    Integer val;
    public void connect()
    {
        Boolean b=false;
        String msg="";
         try
        {
        ss=new ServerSocket(4444);
        while(true)
        {
            s=ss.accept();
            
            dis=new DataInputStream(s.getInputStream());
            val=dis.readInt();
            System.out.println("Connected" + val);
            new ServerThread1(s,val).start();
            
        }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
         
    }
        public static void main(String[] args) 
        {

           Server1 server=new Server1();
           server.connect();
        }
}
