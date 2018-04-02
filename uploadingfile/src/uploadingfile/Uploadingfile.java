/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uploadingfile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author LJMZ
 * 本项目共7个类
 * 此类是本项目的主类
 * 1.Interface类用于打印一些提示信息
 * 2.Dboperation类用于和数据库交互
 * 3.User类用于验证登录和注册用户
 * 4.Serialize类用于文件序列化
 * 5.Up_down_load类和Realize_up_down类用于上传和下载文件的具体操作
 * int类型返回值参考：
 * 1   正常
 * 2   异常
 */
public class Uploadingfile {

    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        Scanner judge = new Scanner(System.in);
        Interface desktop = new Interface();
        User user = new User();
        Serialize serialize = new Serialize();
        Realize_up_domwn upload = new Realize_up_domwn();
        Realize_up_domwn download = new Realize_up_domwn();
        String user_author="";
        int option;
        int count = 1;
        int proving;
        int feedback;
        String path = "";
       
        
        desktop.interface_initial();
        option = judge.nextInt();
 
        if (option == 1) {      //选项为1 则是登录用户
            proving = user.user_Proving(count);     //输入用户名和密码，检测是否存在该用户，count来标记输入错入的次数
            user_author = user.getauthor();         //获得用户名，后面如果上传文件的话需要用到
                while(count < 3){       //输入用户密码正确
                    if(proving == 1) {  //登陆成功
                        desktop.interface_Login();
                        
                        option=judge.nextInt();     //如果上传文件那么输入1 下载文件输入2
                        if(option == 1){
                            desktop.interface_Upload();
                            serialize.serialize_write();
                            path = serialize.getpath();
                            upload.upp(path,user_author);    
                        }else{  
                            desktop.interface_download();
                            download.downn();
                            desktop.interface_Downsucceed();
                        }    
                        
                        System.exit(0);
                    }else {        //用户密码输入错误或不存在此用户，count加1 ，继续输入
                        count += 1;
                        proving = user.user_Proving(count);
                    }
                }
               if(count == 3) {     //输入用户密码错误三次后退出程序
                    desktop.interface_Faild();   
               }

        }else {     //选项为2 是注册用户
            String user_Name = "";
            String user_Password1 = "";
            String user_Password2 = "";
            int flag = 1;
            int count1 = 0;
            while(flag == 1) {    
                desktop.interface_UserRegisterName();
                user_Name = judge.next();
                desktop.interface_UserRegisterPassword1();
                user_Password1 = judge.next();
                desktop.interface_UserRegisterPassword2();
                user_Password2 = judge.next();
                if(user_Password1.equals(user_Password2)) {     //两次输入的密码相同
                    int falg;
                    flag=user.user_Regist(user_Name,user_Password1);    
                    if(flag == 1){  //退出循环
                        desktop.interface_UserRegisterSucceed();
                        flag = 0;
                    }
                }else {         //两次输入的密码不同
                    desktop.interface_UserRegisterfaild();
                    count1 += 1;
                }
                if(count1 == 3) {       //如果注册时两次输入的密码不相同3次，那么退出程序
                    desktop.interface_RegistFildT();
                }
            }
            
           
        }
    }
    
}
