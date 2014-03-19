/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.uc.dei.ipj.grupoa.EJB;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.ejb.Stateless;
import javax.servlet.http.Part;

/**
 *
 * @author alvaro
 */
@Stateless
public class UploadBean {
    
    
    private RandomName randomName;

    private String path;
    //Upload a file 
    public void upload( Part file) throws IOException {
      try (InputStream inputStream = file.getInputStream()) {
            File f = new File("a");
            path = f.getAbsolutePath().substring(0, f.getAbsolutePath().length() - 1);
            path = path + randomName.getRandomName(30) + ".mp3";
            File d = new File(path);
            try (FileOutputStream outputStream = new FileOutputStream(d)) {
                byte[] buffer = new byte[4096];
                int bytesRead = 0;
                while (true) {
                    bytesRead = inputStream.read(buffer);
                    if (bytesRead > 0) {
                        outputStream.write(buffer, 0, bytesRead);
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
}
