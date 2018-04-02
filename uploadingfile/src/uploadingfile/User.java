/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uploadingfile;

import java.util.Scanner;

/**
 * @author LJMZ
 * 此类主要用于在数据库中检测用户是否存在和往数据库中注册用户
 */
public class User {
    private String user;
    private String password;
    Interface desktop = new Interface();
    Scanner user_In = new Scanner(System.in);
    Dboperation users = new Dboperation();
    int proving;
    String user_author="";
    public User() {   
    }
    
    public String getauthor(){
        return this.user_author;
    }
    
    public int user_Proving(int err){   //验证用户密码是否正确
        desktop.interface_UserAndPassword();
        user = user_In.next();
        password = user_In.next();
        proving =users.db_Open(user,password);
        
        if(proving  == 1){
            desktop.interface_LoginSucceed();
            user_author = user;
            return 1;
        }else if(proving  == 2) {
            if(err!=3){
                 desktop.interface_LoginFaild();
            }
            return 2;
        }else {
             return 2;  
        }
    }
    
    public int user_Regist(String user_name ,String user_password){     //注册用户
        if(users.db_Proving(user_name) == 1){
            System.out.println("对不起，该用户名已被注册，请重新申请！");
            return 2;
        }else {
            users.db_Regist(user_name, user_password);
        }
          return 1;
        
    }

}
