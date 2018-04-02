/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uploadingfile;

import java.util.Scanner;

/**
 * @author LJMZ
 * 此类用于打印一些提示信息
 */
public class Interface {
    public Interface() {
         
    }
    
    void interface_initial(){
         System.out.println("******************");
         System.out.println("****1.登陆用户****");
         System.out.println("******************");
         System.out.println("****2.注册用户****");
         System.out.println("******************");

    }
    void interface_UserAndPassword(){
        System.out.println("请输入账户和密码：（账号和密码是由字母和数字组成  用空格或回车分隔）");
    }
    
    void interface_UserRegisterName(){
        System.out.println("请输入您需要注册的账户： （账户只能由字母和数字组成)");
    }
    
    void interface_UserRegisterPassword1(){
        System.out.println("请输入密码： （密码只能由字母和数字组成)");
    }
    
    void interface_UserRegisterPassword2(){
        System.out.println("请再次输入密码：");
    }
    
    void interface_UserRegisterSucceed(){
        System.out.println("账户注册成功！");
    }
    
    void interface_UserRegisterfaild(){
        System.out.println("两次输入的密码不同，请重新注册！");
    }
    
    void interface_LoginSucceed(){
         System.out.println("登陆成功！");
    }
    
    void interface_LoginFaild(){
         System.out.println("抱歉，没有该用户！");
         System.out.println("");
    }
     
    void interface_Login(){
        System.out.println("请输入您需要上传文件还是下载文件？(1.上传文件   (2.下载文件");
    }
    
    void interface_Upload(){
        System.out.println("请输入需要上传的文件的绝对路径：");
    }
    
    void interface_download(){
         System.out.println("请输入需要下载的文件的名称和上传人的名字（用空格或回车隔开，默认下载到C:\\Users）：");
    }
    
    void interface_Faild(){
         System.out.println("抱歉，三次输入均错误，程序关闭...");
         System.exit(0);
    }
    
    void interface_RegistFildT(){
         System.out.println("抱歉，三次输入均错误，程序关闭...");
         System.exit(0);
    }
    
     void interface_Downsucceed(){
         System.out.println("文件下载成功！退出程序...");
         System.exit(0);
    }
    void interface_UploadSucceed(){
        System.out.println("文件上传成功，程序关闭");
        System.exit(0);
    }
    void interface_Uploadchongfu(){
        System.out.println("此文件此用户已经上传过一次，不可继续上传");
        System.exit(0);
    }
}
