/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uploadingfile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

/**
 * @author LJMZ
 * 此类负责文件上传和下载的主要部分
 */
public class Realize_up_domwn {
    Up_down_load file = new Up_down_load();
    Scanner judge = new Scanner(System.in);
    Serialize lis = new Serialize();
    Dboperation downLoad = new Dboperation();
    Interface desktop = new Interface();
    String filename="";

    public void upp(String path,String author) throws IOException{      //上传文件
        Dboperation upLoad = new Dboperation();
        FileInputStream fis = new FileInputStream("E:/terporary_placementfile.txt");
        byte[] fcontent = new byte[fis.available()];
        BufferedInputStream bis = new BufferedInputStream(fis);
        bis.read(fcontent);
        if((path.lastIndexOf("/")+1) != 0){     //将路径去掉只留下文件名
            path=path.substring(path.lastIndexOf("/")+1);
        } else {
             path=path.substring(path.lastIndexOf(":")+1);
        }

        if(upLoad.db_chachong(path, author) == 1){
            System.out.println("456");
           desktop.interface_Uploadchongfu();
        }
        upLoad.db_Up(path,fcontent ,author);
        desktop.interface_UploadSucceed();
    }
    
    public void downn() throws FileNotFoundException, IOException, ClassNotFoundException{         //下载文件
        String file_name = judge.next();
        String file_author = judge.next();
        downLoad.db_DownLoad(file_name, file_author);
        byte[] neirong = downLoad.getneirong();
        FileOutputStream filee = new FileOutputStream("E://"+file_name);
        BufferedOutputStream write_File = new BufferedOutputStream(filee);
        write_File.write(neirong);
        write_File.flush();
        write_File.close();
        FileInputStream fiss = new FileInputStream("E://"+file_name);
        ObjectInputStream ois = new ObjectInputStream(fiss);
        String aa = (String) ois.readObject();
        fiss.close();
        ois.close();
        FileWriter zhuanhua = new FileWriter("E://"+file_name);
        zhuanhua.write(aa);
        zhuanhua.flush();
        zhuanhua.close();
    }
}
