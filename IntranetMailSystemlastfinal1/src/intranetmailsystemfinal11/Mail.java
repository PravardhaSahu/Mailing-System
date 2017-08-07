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
public class Mail implements Serializable
{
    String sender,subject,message,date,time,filename;
  public Mail(String sender,String subject,String message,String date,String time)
  {
      this.sender=sender;
      this.subject=subject;
      this.message=message;
      this.date=date;
      this.time=time;
      
  }
}
