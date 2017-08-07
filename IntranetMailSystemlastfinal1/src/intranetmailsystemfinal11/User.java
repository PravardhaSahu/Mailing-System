/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intranetmailsystemfinal11;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pravardha
 */
public class User implements Serializable
{
    public String username;
    public String pass;
    public User(String username,String pass)
    {
        this.username=username;
        this.pass=pass;
    }
    
}
