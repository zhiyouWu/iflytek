package com.iflytek;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WavToPcm {

    public static void WavToPcm(String src,String target) {
        try {
            FileInputStream fis = new FileInputStream(src);
            FileOutputStream fos = new FileOutputStream(target);
            byte[] buf = new byte[1024 * 4];
            int size = fis.read(buf);
            fos.write(buf, 44, size-44);
            size = fis.read(buf);
            while (size != -1) {
                fos.write(buf, 0, size);
                size = fis.read(buf);
            }
            fis.close();
            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String args[]){
        WavToPcm("C:\\Users\\20785\\Downloads\\Java_iat1019_5b7e899e\\sample\\MscInvisibleDemo\\yyy.wav","C:\\Users\\20785\\Downloads\\Java_iat1019_5b7e899e\\sample\\MscInvisibleDemo\\2.pcm");
    }

}
