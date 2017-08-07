/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intranetmailsystemfinal11;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pravardha
 */
public class ServerThread1 extends Thread{
    private ServerSocket ss=null;
    private Socket s=null;
    private ObjectInputStream is1=null;
     public static int FILE_SIZE = 6022386;
    String username=null;
    String pass=null;
    String msg="";
    String filename="";
    boolean b=false;
    PrintWriter pw=null;
   
    Integer i;
    ServerThread1(Socket s,int i)
    {
        this.s=s;
        this.i=i;
    }

    public ServerThread1()         
    {
    }
    
    
    public void run()
    {
        if(i==1)
        {
            
            login();
        }
        if(i==2)
        {
            
            register();
        }
        if(i==3)
        {
            username_fp();
        }
        if(i==4)
        {
            seq_ques_fp();
        }
        if(i==5)
        {
            inbox_mail();
        }
        if(i==6)
        {
            compose();
        }
        if(i==7)
        {
            sent_mail();
        }
        if(i==8)
        {
            compose1();
        }
        if(i==9)
        {
            download_file();
        }
        if(i==10)
        {
            change_pas();
        }
    }
    public void login()
    {
        String msg="";
         try
         {  
             is1=new ObjectInputStream(s.getInputStream());
            User us=(User)is1.readObject();
            System.out.println(us.username+" "+us.pass);
            Database db=new Database();
            b=db.login(us.username, us.pass);
        
        if(b==true)
        {
            msg="ValidUser";
        }
        else
        {
            msg="InvalidUser";
        }
        pw=new PrintWriter(s.getOutputStream(),true);
        pw.println(msg+"\n");
         }
         catch(Exception e)
         {
             //System.out.println("error");
             e.printStackTrace();
         }
    }
    
    
    public void compose()
    {
        String msg="";
         try
         {  
           /*  BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
            String filename=br.readLine();
            System.out.println(filename);
            byte[] bytearray=new byte [ (int)FILE_SIZE];
            InputStream is = s.getInputStream();
            int bytesRead = is.read(bytearray, 0, bytearray.length); 
            System.out.println("Serverthread byteRead:"+bytesRead);
            String copyfile="g:\\Project1\\Mailfiles\\"+filename;
             
            System.out.println("serverthread:"+new String(bytearray));
             System.out.println("Cpying Not done "); 
              FileOutputStream fos = new FileOutputStream(copyfile);
              BufferedOutputStream bos = new BufferedOutputStream(fos);
              bos.write(bytearray, 0, bytearray.length);
              System.out.println("Copying Done");
             */ 
             is1=new ObjectInputStream(s.getInputStream());
            Compose c=(Compose)is1.readObject();
            System.out.println(c.sender+" "+c.reciever+" "+c.subject+" "+c.message+" "+c.sending_date+" "+c.sending_time);
            Database db=new Database();
           b=db.sendmail(c.sender,c.reciever,c.subject,c.message,c.sending_date,c.sending_time);
        
        if(b==true)
        {
            msg="MailSent";
        }
        else
        {
            msg="Mailnotsent";
        }
        pw=new PrintWriter(s.getOutputStream(),true);
        pw.println(msg+"\n");
         }
         catch(Exception e)
         {
             //System.out.println("error");
             e.printStackTrace();
         }
    }
    
    public void register()
    {
         String msg="";
         try
         {  
             is1=new ObjectInputStream(s.getInputStream());
            Register reg=(Register)is1.readObject();
             Database ob=new Database();
            boolean b=ob.register(reg.uid,reg.dob,reg.pass,reg.g,reg.sq,reg.ans);
        
        if(b==true)
        {
            msg="Registered";
        }
        else
        {
            msg="Not Registered";
        }
        pw=new PrintWriter(s.getOutputStream(),true);
        pw.println(msg+"\n");
         }
         catch(Exception e)
         {
             //System.out.println("error");
             e.printStackTrace();
         }
    }
    public void username_fp()
    {
        try
        {
         BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
            username=br.readLine();
           System.out.println(username);
            Database ob= new Database();
            boolean b=ob.username1(username);
            
             if(b==true)
        {
            msg="User";
        }
        else
        {
            msg="Not User";
        }
        pw=new PrintWriter(s.getOutputStream(),true);
        pw.println(msg+"\n");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void seq_ques_fp()
    {
        try
        {
       BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
       username=br.readLine();
       System.out.println(username);
       Database ob= new Database();
       String sec_ques=ob.forgot_passsq(username);
       pw=new PrintWriter(s.getOutputStream(),true);
        pw.println(sec_ques+"\n");
        //password
        is1=new ObjectInputStream(s.getInputStream());
        forgotpass fp=(forgotpass)is1.readObject();
        Database ob1=new Database();
        String b= ob1.forgot_pass(fp.uid,fp.sec_ques,fp.ans);
        pw=new PrintWriter(s.getOutputStream(),true);
        System.out.println(b);
        pw.println(b+"\n");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void forgot_pass()
    {
        try
        {
        is1=new ObjectInputStream(s.getInputStream());
        forgotpass fp=(forgotpass)is1.readObject();
        Database ob=new Database();
        String b= ob.forgot_pass(fp.uid,fp.sec_ques,fp.ans);
        pw=new PrintWriter(s.getOutputStream(),true);
        System.out.println(b);
        pw.println(b+"\n");
        }
        catch(Exception e)
        {
           e.printStackTrace();
        }
    }
    public void inbox_mail()
    {
        ArrayList<Mail> myList;
        try
        {   
                if(s!=null)
                {
                BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
                username=br.readLine();
                System.out.println(username);
                
                Database ob=new Database();
                myList=ob.fetchdata(username);
                System.out.println("Server Active");
                ObjectOutputStream objectOutput = new ObjectOutputStream(s.getOutputStream());
                objectOutput.writeObject(myList);
                
                
                
                }
            }
            catch(Exception e)
            {
               e.printStackTrace();
            }
    }
    public void sent_mail()
    {
        ArrayList<Mail> myList;
        try
        {   
                if(s!=null)
                {
                BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
                username=br.readLine();
                System.out.println(username);
                
                Database ob=new Database();
                myList=ob.fetchsentmail(username);
                System.out.println("Server Active");
                ObjectOutputStream objectOutput = new ObjectOutputStream(s.getOutputStream());
                objectOutput.writeObject(myList);
                
                
                
                }
            }
            catch(Exception e)
            {
               e.printStackTrace();
            }
    }
    
    public void compose1()
    {
        try
        {
       int p;
             String filename="";
            DataInputStream dis=new DataInputStream(s.getInputStream());
            p=dis.readInt();
            //
            System.out.println("Connected" + p);
            System.out.println("ServerThread outside if");
            if(p==1)
            {
                System.out.println("Serverthread inside if");
             BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
             filename=br.readLine();
             System.out.println(filename);
             //br.close(); 
              //taking file from client
               InputStream is = s.getInputStream();
               byte[] mybytearray = new byte[6022386];
               int bytesRead = is.read(mybytearray, 0, mybytearray.length); 
               System.out.println("Serverthread byteRead:"+bytesRead);
              String copyfile="g:\\Project1\\Mailfiles\\"+filename;
              
               int current = bytesRead;

            do {
                bytesRead =
                 is.read(mybytearray, current, (mybytearray.length-current));
                 if(bytesRead >= 0) current += bytesRead;
                } while(bytesRead > -1);

              //sending file in folder
              System.out.println("serverthread:"+new String(mybytearray));
              
              FileOutputStream fos = new FileOutputStream(copyfile);
              BufferedOutputStream bos = new BufferedOutputStream(fos);
              bos.write(mybytearray, 0, bytesRead);
              
              
              
            }
            System.out.println("Outside if:2");
             is1=new ObjectInputStream(s.getInputStream());
            Compose c=(Compose)is1.readObject();
            System.out.println(c.sender+" "+c.reciever+" "+c.subject+" "+c.message+" "+c.sending_date+" "+c.sending_time+""+filename);
            Database db=new Database();
           // b=db.sendmail(c.sender,c.reciever,c.subject,c.message,c.sending_date,c.sending_time,filename);
        
        if(b==true)
        {
            msg="MailSent";
        }
        else
        {
            msg="Mailnotsent";
        }
        pw=new PrintWriter(s.getOutputStream(),true);
        pw.println(msg+"\n");
      
        
         }
         catch(Exception e)
         {
             //System.out.println("error");
             e.printStackTrace();
         }
        
    }
    public void download_file()
    {
        try
               {
                BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
                String filename=br.readLine();
                System.out.println(filename);
                
                 String filepath="G:\\Project1\\Mailfiles\\"+filename;
                 File doc = new File(filepath);
                 
                 
                 
                byte[] bytearray=new byte [ (int)doc.length()];
    
                FileInputStream fin=new FileInputStream(doc);
                BufferedInputStream bin=new BufferedInputStream(fin);

                bin.read(bytearray,0,bytearray.length);
                
               
                 
                  
                  
                  System.out.println(doc.length());
                  System.out.println(bytearray.length);
                   OutputStream bout = s.getOutputStream();
                   bout.write(bytearray, 0,bytearray.length);
                   bout.flush();
                   System.out.println("File Transfered");
               }
               catch(Exception e)
               {
                   e.printStackTrace();
               }  
    }
    public void change_pas()
    {
       String msg="";
         try
         {  
             is1=new ObjectInputStream(s.getInputStream());
            Update up=(Update)is1.readObject();
             Database ob=new Database();
            boolean b=ob.changepassword(up.uid,up.pass);
        
        if(b==true)
        {
            msg="User";
        }
        else
        {
            msg="Not User";
        }
        pw=new PrintWriter(s.getOutputStream(),true);
        pw.println(msg+"\n");
         }
         catch(Exception e)
         {
             //System.out.println("error");
             e.printStackTrace();
         }  
    }
}
