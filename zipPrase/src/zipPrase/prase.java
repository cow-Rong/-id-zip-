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
    			PlaceUtil place=new PlaceUtil();//һ��id���ļ�����ζ��һ���ݵ���Ŀ����
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
	    			System.out.println("path:"+id.getPath()+"��û���ҵ�����zip���ļ���!");
	    		}
    		}
    	}else {
    		System.out.println("path:"+path+"������Чdata�ļ���!");
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
    				//return file3;//�ҵ��ļ����е�һ������zip��Ŀ¼
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
        if (ze.isDirectory()) {//zip������ÿ����ԪidΪ���ֵ��ļ���ze��//��ze=10.98.00���ļ��������ҵ�txt��Ŀ¼�ļ�����
        	
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
