/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uploadingfile;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/*
* @author LJMZ
* Serialize类：
* 用来把文件内容序列化然后将二进制数据流 然后存在固定的文件中 以便之后的上传
*/

public class Serialize {
    Scanner serialize_In = new Scanner(System.in);
    Up_down_load file = new Up_down_load();
    private String path = "";
    private String filename = "";
    
    public String getpath() {
        return this.path;
    }
    
    public void serialize_write() throws FileNotFoundException, IOException{  //将需要上传的内容序列化后写到固定的文件E:/terporary_placementfile.txt
        ObjectOutputStream ob_Out = new ObjectOutputStream(new FileOutputStream("E:/terporary_placementfile.txt")); 
        path = serialize_In.next();
        this.filename=path;
        file.setpath(path);
        filename = path;
        String content = file.upLoad();
    
        ob_Out.writeObject(content); 
        ob_Out.close();
    }
}
