package zipPrase;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class prase {

	public static void main(String[] args) throws Exception{

    	String path="E:\\datas";
    	DeviceUtil devece=new DeviceUtil();
    //	PlaceUtil place=new PlaceUtil();
    	
    	File file = new File(path);
  	
    	if(file.isDirectory()) {
    		File[] proId = file.listFiles();
    		for(File id:proId){
    			Set<File> zipPaths = new HashSet<File>();
    			PlaceUtil place=new PlaceUtil();//一个id的文件夹意味着一个据点项目数据
	    		findZipPah(id,zipPaths);
	    		if(zipPaths.size()>0) {
	    			for (File zipPath : zipPaths) {  
	    				File[] zipfile = zipPath.listFiles();
		       		 	for(File zip:zipfile){
		       		 		if(zip.isDirectory()) {		       		 			
		       		 		}else {
			       		 		System.out.println(zip.getName());
			                    readZipFile(zip.getPath());
		       		 		}

		       		    }  
	    			}  	    			
	    			
	    		}else {
	    			System.out.println("path:"+id.getPath()+"中没有找到包含zip的文件夹!");
	    		}
    		}
    	}else {
    		System.out.println("path:"+path+"不是有效data文件夹!");
    	}
	}
	    		                 
   public static void findZipPah(File file,Set<File> zipPaths) {
	   if(file.isDirectory()) {
    		File[] files = file.listFiles();
    		for(File file2:files) {
    			findZipPah(file2,zipPaths);
    			//if(file3==null) {
    			//	continue;
    			//}else {
    				//zipPaths.add(file3);
    				//return file3;//找到文件夹中第一个包含zip的目录
    			//}    			
    		}
	   }else if(file.getName().endsWith(".zip")) {
		   zipPaths.add(file.getParentFile());
		   //return file.getParentFile();
	   }
	   //return null;
	}               

	  
  public static void readZipFile(String file) throws Exception { 
      ZipFile zf = new ZipFile(file); 
      InputStream in = new BufferedInputStream(new FileInputStream(file)); 
      ZipInputStream zin = new ZipInputStream(in); 
      ZipEntry ze; 
      while ((ze = zin.getNextEntry()) != null) { 
        if (ze.isDirectory()) {//zip下面是每个网元id为名字的文件夹ze，//到ze=10.98.00的文件夹下面找到txt的目录文件解析
        	
        	DeviceUtil devece=new DeviceUtil();
        } else { 
        
          System.out.println("file - " + ze.getName() + " : " + ze.getSize() + " bytes"); 
          
          long size = ze.getSize(); 
          if (size > 0) { 
            BufferedReader br = new BufferedReader( 
                new InputStreamReader(zf.getInputStream(ze))); 
            String line; 
            while ((line = br.readLine()) != null) { 
              System.out.println(line); 
            } 
            br.close(); 
          }
          System.out.println(); 
        } 
      } 
      zin.closeEntry(); 
    } 


}
