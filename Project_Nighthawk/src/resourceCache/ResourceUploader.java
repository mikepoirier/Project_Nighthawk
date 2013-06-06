/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resourceCache;

import java.io.File;
import java.io.FileFilter;

/**
 *
 * @author Mike
 */
public class ResourceUploader {
    
    private static ResourceUploader uploader = new ResourceUploader();
    private ResourceCache cache = ResourceCache.getInstance();
    private String resourceLocation = "../../Assets";   // Sets this location as
                                                        // the default. Can be
                                                        // changed.
    
    private ResourceUploader() {
        
    }
    
    /**
     * This returns the instance of the ResourceUploader.
     * @return
     */
    public static ResourceUploader getInstance() {
        return uploader;
    }
    
    /**
     * This uploads the given file into the resource cache.
     * 
     * @param fileName
     *      This is the name of the file. Make sure to include the extension.
     */
    public void upload(String fileName) {
        
        final File directory = new File(resourceLocation);
        FileFilter filter = new FileFilter() {

            @Override
            public boolean accept(File pathname) {
                if(pathname.getAbsolutePath().endsWith(".zip")) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        
        if(directory.isDirectory()) {
            File[] files = directory.listFiles(filter);
            for(int i = 0; i < files.length; i++) {
                String name = files[i].getName().substring(0, 
                        files[i].getName().length() - 4);
                if(files[i].getName().equals(fileName)){
                cache.add(name, files[i]);
                System.out.println("Adding " + files[i].getName() + 
                        " to the cache as " + name + ".");
                }
            }
        } else {
            System.err.println("String passed was not a directory!");
        }
        
    }

    /**
     * Sets the location of the assets directory.
     * @param resourceLocation
     *      The string that represents the resources directory location.
     */
    public void setResourceLocation(String resourceLocation) {
        this.resourceLocation = resourceLocation;
    }
    
}