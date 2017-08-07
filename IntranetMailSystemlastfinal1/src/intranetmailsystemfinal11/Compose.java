/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intranetmailsystemfinal11;

import java.io.Serializable;

/**
 *
 * @author pravardha
 */
public class Compose implements Serializable
{
    public String sender;
    public String reciever;
    public String subject;
    public String message;
    public String sending_date;
    public String sending_time;
  
    
    public Compose(String sender,String reciever,String subject,String message,String sending_date,String sending_time)
    {
        this.sender=sender;
        this.reciever=reciever;
        this.subject=subject;
        this.message=message;
        this.sending_date=sending_date;
        this.sending_time=sending_time;
        //this.filename=filename;
    }
}
