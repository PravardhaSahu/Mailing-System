/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intranetmailsystemfinal11;


import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class forgotpass implements Serializable
{
    public String uid,sec_ques,ans;
    public forgotpass(String uid,String sec_ques,String ans)
    {
        this.uid=uid;
        this.sec_ques=sec_ques;
        this.ans=ans;
    }
}
