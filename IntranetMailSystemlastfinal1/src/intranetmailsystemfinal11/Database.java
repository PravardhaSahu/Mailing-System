/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intranetmailsystemfinal11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Database  
{
    Connection conn;
    Statement stm;
    Statement stm1;
    ResultSet rst;
    int i;
    
    public Connection getConnection()
    {
        try
        {
          Class.forName("oracle.jdbc.OracleDriver");
         conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","mca");
         
        }
        catch(Exception e)
        {
            System.out.println("Error" + e);
        }
      return conn;      
    }
        
    public boolean register(String uid,String dob,String pass,String g,String sq,String ans)
    {
        try
        {
            conn=getConnection();
            stm= conn.createStatement();
            i=stm.executeUpdate("insert into register values(\'"+uid+"\',\'"+dob+"\',\'"+pass+"\',\'"+g+"\',\'"+sq+"\',\'"+ans+"\')");
           System.out.println("Sucessful");
           conn.close();
           
        }
        catch(Exception e)
        {
            System.out.println("Error" + e);
        }
        if(i>0)
        return true;
        else 
            return false;
    }
    public boolean update(String pass,String pass1)
    {
        try
        {
            if(pass.equals(pass1))
            {
            conn=getConnection();
            stm= conn.createStatement();
            System.out.println("Sucessful1");
            i=stm.executeUpdate("update register set pass='dii',dob='09-09-1999' where username='mini'");
           System.out.println("Sucessful2");
           conn.close();
            }
            
           
        }
        catch(Exception e)
        {
            System.out.println("Error" + e);
        }
        if(i>0)
        return true;
        else 
            return false;
        
           
    }
    
     /*public boolean update(String uid,String dob,String pass,String g)
    {
        try
        {
            conn=getConnection();
            stm= conn.createStatement();
            i=stm.executeUpdate("insert into register values(\'"+uid+"\',\'"+dob+"\',\'"+pass+"\',\'"+g+"\')");
           System.out.println("Sucessful");
           conn.close();
           
        }
        catch(Exception e)
        {
            System.out.println("Error" + e);
        }
        if(i>0)
        return true;
        else 
            return false;
    }*/
    
    public boolean login(String uid,String pass)
    {
       try
        {
            conn=getConnection();
            stm= conn.createStatement();
           rst=stm.executeQuery("select username,pass from register where username=\'"+uid+"\' and pass = \'"+pass+"\'");
           String user="";
           String pas="";
           while(rst.next())
        {
             user=rst.getString("username");
             pas=rst.getString("pass");
            System.out.println("DataBase"+user+""+pas);
        }
                   
        
        if(uid.equals(user) && pass.equals(pas))
        {
            i=1;
        }
        else
        {
            i=0;
        }
        
      }
        catch(Exception e)
        {
            System.out.println("Error" + e);
        }
        if(i>0)
        return true;
        else 
        return false;
 
    }
    
   public String forgot_pass(String uid,String sec_ques,String ans)
   {
       String sec_q="",answer="",password="";
       int i=0;
            try
            {
               conn=getConnection();
               stm= conn.createStatement();
               rst=stm.executeQuery("select sq,ans,pass from register where username=\'"+uid+"\'   ");
               while(rst.next())
               {
                  
                  
                   answer=rst.getString("ans");
                   password=rst.getString("pass");
                   
               }
               if(answer.equals(ans))
               {
                return password;   
                   
               }
           
            }
            catch(Exception e)
            {
                System.out.println("Error" + e);
            }
         return "Wrong Details";
   }
   

    public boolean username1(String uid)
    {
                   
        int i=0;
        String user_name="";
        try
        {
        conn=getConnection();
        stm=conn.createStatement();
        rst=stm.executeQuery("select username from register where username=\'"+uid+"\'");
        while(rst.next())
        {  
            user_name=rst.getString("username");
            System.out.println(user_name);
        }
        conn.close();
        if(user_name.equals(uid))
          i=1;  
        }
        catch(Exception e)
        {
            System.out.println("Error "+ e);
        }
        
        if(i>0)
            return true;
        else 
            return false;        
      
        
    }


    public String forgot_passsq(String uid)
    {
        String sec_ques="";
        try
        {
            conn=getConnection();
            stm=conn.createStatement();
            rst=stm.executeQuery("select sq from register where username=\'"+uid+"\' ");
            while(rst.next())
            {
                sec_ques=rst.getString("sq");
                System.out.println(sec_ques);
            }
            
           conn.close();
        }
        catch(Exception e)
        {
            System.out.println("Error" +e);
        }
        return sec_ques;
    }
    public boolean sendmail(String sender,String reciever,String subject,String message,String sending_date,String sending_time)
    {
        try
        {
            conn=getConnection();
            stm= conn.createStatement();
            i=stm.executeUpdate("insert into user_inbox(sender,reciever,subject,message,sending_date,sending_time) values(\'"+sender +"\',\'"+reciever+"\',\'"+subject+"\',\'"+message+"\',\'"+sending_date+"\',\'"+sending_time+"\')");
           System.out.println("Sucessful");
           conn.close();
           
           
        }
        catch(Exception e)
        {
            System.out.println("Error" + e);
        }
        if(i>0)
        return true;
        else 
            return false;
    }
    /*public boolean sendmail(String sender,String reciever,String subject,String message,String sending_date,String sending_time)
    {
        try
        {
            conn=getConnection();
            stm= conn.createStatement();
            i=stm.executeUpdate("insert into user_inbox(sender,reciever,subject,message,sending_date,sending_time) values(\'"+sender +"\',\'"+reciever+"\',\'"+subject+"\',\'"+message+"\',\'"+sending_date+"\',\'"+sending_time+"\')");
           System.out.println("Sucessful");
           conn.close();
           
           
        }
        catch(Exception e)
        {
            System.out.println("Error" + e);
        }
        if(i>0)
        return true;
        else 
            return false;
    }
    }*/
    public ArrayList<Mail> fetchdata(String username)
 {
     ArrayList<Mail> myList=new ArrayList<Mail>();
     try
        {
           String sender,sub,msg,date,time,filename;
           System.out.println("DataBase Active");
            Class.forName("oracle.jdbc.OracleDriver");
            Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","mca");
            Statement stm= conn.createStatement();
            System.out.println("Database");
            String sql="select sender,subject,message,sending_date,sending_time from user_inbox where reciever=\'"+username +"\'";
            ResultSet rs=stm.executeQuery(sql);
           
           int i=0;
           {
              while(rs.next())
               {
                   sender=rs.getString("sender");
                   sub=rs.getString("subject");
                   date=rs.getString("sending_date");
                   time=rs.getString("sending_time");
                   msg=rs.getString("message");
                   
                   Mail mail=new Mail(sender,sub,msg,date,time);
                   myList.add(mail);
               }  
                   for(i=0;i<myList.size();i++)
                   {
                       Mail m=myList.get(i);
                       System.out.println(m.sender+" "+m.subject+" "+m.date+" "+m.time);
                   }
                   
                   
               
           }
           conn.close();
           stm.close();
        }
        catch(Exception e)
        {
          e.printStackTrace();
        }
     return myList;
     }  
    public int fetch_mailid(String sender,String sub,String date,String time)
    {
        int mail_id=0;
        try
        {
            conn=getConnection();
            stm=conn.createStatement();
            rst=stm.executeQuery("select sq from user_inbox where sender=\'"+sender+"\',sub=\'"+sub+"\',sender=\'"+date+"\',sender=\'"+time+"\' ");
            if(rst.next())
            {
                mail_id=rst.getInt("Message_id");
                System.out.println(mail_id);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return mail_id;
        
    }

    
 public ArrayList<Mail> fetchsentmail(String username)
 {
     ArrayList<Mail> myList=new ArrayList<Mail>();
     try
        {
           String sender,sub,msg,date,time,filename;
           System.out.println("DataBase Active");
            Class.forName("oracle.jdbc.OracleDriver");
            Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","mca");
            Statement stm= conn.createStatement();
            System.out.println("Database");
            String sql="select reciever,subject,message,sending_date,sending_time,filename from user_inbox where sender=\'"+username +"\'";
            ResultSet rs=stm.executeQuery(sql);
           //here sender variable consist of reciever
           int i=0;
           {
              while(rs.next())
               {
                   sender=rs.getString("reciever");
                   sub=rs.getString("subject");
                   date=rs.getString("sending_date");
                   time=rs.getString("sending_time");
                   msg=rs.getString("message");
                   filename=rs.getString("filename");
                   Mail mail=new Mail(sender,sub,msg,date,time);
                   myList.add(mail);
               }  
                   for(i=0;i<myList.size();i++)
                   {
                       Mail m=myList.get(i);
                       System.out.println(m.sender+" "+m.subject+" "+m.date+" "+m.time);
                   }
                   
                   
               
           }
           conn.close();
           stm.close();
        }
        catch(Exception e)
        {
          e.printStackTrace();
        }
     return myList;
     } 
 public boolean changepassword(String uid,String pass)
 {
   try
        {
            conn=getConnection();
            stm= conn.createStatement();
            i=stm.executeUpdate("update register set pass=\'"+pass +"\' where username=\'"+uid +"\'");
           System.out.println("Sucessful");
           conn.close();
           
        }
        catch(Exception e)
        {
            System.out.println("Error" + e);
        }
        if(i>0)
        return true;
        else 
            return false;
    }  
 }
