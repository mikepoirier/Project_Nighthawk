/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics2D;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.*;

/**
 *
 * @author Mike
 */
public class Animation {

    BufferedImage[] images;

    public BufferedImage[] getImages() {
        return images;
    }

    public void addImages(String fileName) {

        if (fileName == null) {
            System.err.println("No file path was passed into Animation.");
        }

        FileFilter ff = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.getAbsolutePath().endsWith(".zip")) {
                    return true;
                } else {
                    return false;
                }
            }
        };

        if (!ff.accept(new File(fileName))) {
            System.err.println("Imported file is not a .zip file.");
        }

        try {
            ZipInputStream zis = new ZipInputStream(
                    new FileInputStream(fileName));
            byte[] buffer = new byte[4096];
            ZipEntry ze;
            while ((ze = zis.getNextEntry()) != null) {
                System.out.println("Extracting: " + ze);
                try {
                    FileOutputStream fos = new FileOutputStream(ze.getName());
                    int numBytes;
                    while ((numBytes = zis.read(buffer, 0, buffer.length)) != -1) {
                        fos.write(buffer, 0, numBytes);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                zis.closeEntry();
            }
        } catch (Exception e) {
            System.out.println("Error in addImages()");
            e.printStackTrace();
        }

    }
}
