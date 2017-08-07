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
public class Update implements Serializable
 {
    public String uid, pass;
    public Update(String uid ,String pass)
    {
       this.uid=uid; 
        this.pass=pass;
    }
    
}
