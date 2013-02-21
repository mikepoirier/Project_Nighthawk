/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resourceCache;

// import javax.
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import javax.imageio.ImageIO;
import utilities.Cache;

/**
 *
 * @author Mike
 */
public class ResourceCache {

    private static ResourceCache rCache;
    private Cache<String, File> cache;
    private String resourceLocation = "../../Assets";   // Sets this location as
    // the default. Can be
    // changed.

    private ResourceCache() {
        cache = new Cache<>(100);
    }

    public void setResourceLocation(String resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public static ResourceCache getInstance() {
        if (rCache == null) {
            rCache = new ResourceCache();
        }

        return rCache;
    }

    public void add(String key, File value) {
        cache.put(key, value);
    }

    public File get(String key) {
        return cache.get(key);
    }

    public int size() {
        return cache.size();
    }

    public boolean clear() {
        boolean cleared = false;
        if (cache.size() == 0) {
            cleared = true;
        } else {
            cache.clear();
            cleared = true;
        }
        return cleared;
    }

    /**
     * This uploads the given file into the resource cache.
     *
     * @param fileName This is the name of the file. Make sure to include the
     * extension.
     */
    public void upload(String fileName) {

        final File directory = new File(resourceLocation);
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.getAbsolutePath().endsWith(".zip")) {
                    return true;
                } else {
                    return false;
                }
            }
        };

        if (directory.isDirectory()) {
            File[] files = directory.listFiles(filter);
            for (int i = 0; i < files.length; i++) {
                String name = files[i].getName().substring(0,
                        files[i].getName().length() - 4);
                if (files[i].getName().equals(fileName)) {
                    rCache.add(name, files[i]);
                    System.out.println("Adding " + files[i].getName()
                            + " to the cache as " + name + ".");
                    return;
                }
            }
            System.out.println("Error! File " + fileName + " not found!");
        } else {
            System.out.println("String passed was not a directory!");
        }

    }

    public BufferedImage[] parseImages(String name) {
        
        File file = get(name);
        
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
            
            return null;
        } catch (IOException ex) {
            Logger.getLogger(ResourceCache.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } finally {
            return bufferedImages.toArray(new BufferedImage[bufferedImages.size()]);
        }
    }
}
