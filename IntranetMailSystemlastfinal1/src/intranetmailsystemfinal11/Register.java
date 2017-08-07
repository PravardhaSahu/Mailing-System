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
public class Register implements Serializable
{
    public String uid,dob,pass,g,sq,ans;
       
    public Register(String uid,String dob,String pass,String g,String sq,String ans)
    {
        this.uid=uid;
        this.dob=dob;
        this.pass=pass;
        this.g=g;
        this.sq=sq;
        this.ans=ans;
    }
}
