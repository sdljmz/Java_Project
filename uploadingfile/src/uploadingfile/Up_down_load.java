/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uploadingfile;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * @author LJMZ
 * 此类功能为提取上传文件的内容
 */
public class Up_down_load implements java.io.Serializable{
    String path = "";
    
    public void setpath(String path){
        this.path=path;
    }
    
    public String upLoad() throws FileNotFoundException, IOException{       //上传文件的步骤之一  将想要上传的文件内容提取出来
        InputStream file = new FileInputStream(this.path);
        int i=0;
        String content="";
        while((i=file.read())!=-1){
            content+=(char) i;
        }
        file.close();
        return content;
    }
  
}
