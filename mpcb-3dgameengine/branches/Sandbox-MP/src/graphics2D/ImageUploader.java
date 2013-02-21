/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics2D;

/**
 *
 * @author Mike
 */
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import javax.imageio.ImageIO;
import resourceCache.ResourceCache;

public class ImageUploader {
    
    private static ImageUploader iu = new ImageUploader();
    private ResourceCache rc = ResourceCache.getInstance();

    private java.util.Map<String, BufferedImage> images = new HashMap<>();

    public Map<String, BufferedImage> getImages() {
        return images;
    }
    
    private ImageUploader() {}
    
    public static ImageUploader getInstance(){
        return iu;
    }
    
//    public BufferedImage retireveImage(String name) throws IOException {
//        return ImageIO.read(rc.get(name));
//    }

    public void init(String imagesDirectory) {
        final File f = new File(imagesDirectory);
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

        if (f.isDirectory()) {
            File[] files = f.listFiles(ff);
            for (int i = 0; i < files.length; i++) {
                BufferedImage[] zipImages = parseZipFile(files[i]);
                for (int j = 0; j < zipImages.length; j++) {
                    String name = files[i].getName().replaceAll(".zip", 
                            Integer.toString(j));
                    System.out.println("Adding image " + name + 
                            " to images map.");
                    
                    images.put(name, zipImages[j]);
                }
            }
        }
    }

    public BufferedImage[] parseZipFile(File file) {

//        BufferedImage[] bufferedImages = null;
        List<BufferedImage> bufferedImages = new ArrayList<>();

        try {
            ZipFile zf = new ZipFile(file);
            ZipInputStream zis = new ZipInputStream(new FileInputStream(file));
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            ZipEntry ze;

            for (int i = 0; (ze = zis.getNextEntry()) != null; i++) {
                System.out.println("Extracting: " + ze);
                int entrySize = (int) ze.getSize();

                BufferedInputStream bis = new BufferedInputStream(
                        zf.getInputStream(ze));
                byte[] finalByteArray = new byte[entrySize];

                int chunkSize = 0;
                int bytesRead = 0;

                while (true) {
                    //Read chunk to buffer
                    chunkSize = bis.read(buffer, 0, bufferSize);
                    if (chunkSize == -1) {
                        break;
                    }

                    //Write that chunk to the finalByteArray
                    System.arraycopy(buffer, 0, finalByteArray, bytesRead, chunkSize);

                    bytesRead += chunkSize;
                }
                bis.close();
                
                // Takes the byte array made from the file in the .zip container
                // and reads it into a BufferedImage
                BufferedImage bi = ImageIO.read(new ByteArrayInputStream(finalByteArray));
                
                System.out.println("Entry size: " + finalByteArray.length);
                
                // Adds the BufferedImage to the images map.
                bufferedImages.add(bi);
            }
        } catch (Exception e) {
            System.err.println("Error parsing zip file. " + e);
            e.printStackTrace();
        } finally {
            //Takes the List, converts it to an Array and then returns it.
            return bufferedImages.toArray(new BufferedImage[bufferedImages.size()]);
        }
    }
}
