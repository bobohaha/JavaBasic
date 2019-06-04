import java.io.File;  
  
public class RenameFiles {   
    public void ChangeFileName(File file){  
     String dirPath = file.getAbsolutePath();//Ä¿Â¼Â·¾¶  
     if(file.isDirectory()){      
           File[] files =file.listFiles();  
           for (int i = 0; i < files.length; i++) {
        	   File f = files[i];
               String toFileName = dirPath+"\\"+"pao_356_383_"+(i*2+1)+".png";  
               File finalName = new File(toFileName);  
               f.renameTo(finalName);  
		}
       }  
     }  
  
    public static void main(String[] args) {   
        File file = new File("D:\\test");  
        new RenameFiles().ChangeFileName(file);  
     }   
      
    }   

