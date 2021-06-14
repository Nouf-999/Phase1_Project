import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class LockedMe {

public static void main(String[] args) throws IOException {
	
	System.out.println("\n This Is The 1st Demo For (LockedMe) Project."
			+ " \n Developed By: Nouf Zeyad , 381204896@ju.edu.sa  ");
	System.out.println();
	System.out.println("\n Please select one of the following options: (insert the option number) " 
			+ "\n (1) View Current File Names"
			+"\n (2) Files Modification Options"
			+"\n (3) Close");	
	
	Scanner key = new Scanner(System.in);
	int opt = key.nextInt();
	
	switch(opt) {
	
	 //Display a list of files
	  case 1:
	  {
						try {

							File f = new File("C:\\Users\\HB\\OneDrive\\Desktop\\Tester");

							File[] files = f.listFiles();

							System.out.println("Files are:");

							for (int i = 0; i < files.length; i++) {
								System.out.println(files[i].getName());
							}
						}
						catch (Exception e) {
							System.err.println(e.getMessage());
						}
					}
				
	    break;
	  
	  //Additional options
	  case 2:
		  System.out.println("Please select one of the following options: (insert the option number)"
				  +"\n (1) Add A File"
				  +"\n (2) Delete A File"
				  +"\n (3) Search For A File"
				  +"\n (4) Go Back To Main Context");
		  int opt2 = key.nextInt();
		  
		  //(1) Add A File
		  if(opt2==1) {
			  
			  System.out.println("Enter a file name to add : ");
			  String filename = key.next();
			  String filePath = filename + ".txt";
			  
			  Path path = Paths.get("C:\\\\Users\\\\HB\\\\OneDrive\\\\Desktop\\\\Tester\\\\"+filePath);

		        Files.createDirectories(path.getParent());

		        try {
		            Files.createFile(path);
		            System.out.println("File created successfully.");
		        } catch (FileAlreadyExistsException e) {
		            System.err.println("already exists: " + e.getMessage());
		        } 
			
		  }
		  
		  //(2) Delete A File
		  else if (opt2==2) {
			  
			  System.out.println("Enter a file name to delete : ");
			  String filename1 = key.next();
			  String filePath1 = filename1 + ".txt";
			  
			  File f1 = new File("C:\\\\Users\\\\HB\\\\OneDrive\\\\Desktop\\\\Tester\\\\"+filePath1);
			  
			  if(f1.delete()) {
			 
			  System.out.println("File deleted successfully");
			  }
		  else {
			  System.out.println("File Not Found");
		  }  
		  }
		  
		  //(3) Search For A File (Linear Search Is Used)
		  else if (opt2==3) {
			  System.out.println("Enter a file name to search for : ");
			  String filename2 = key.next();
			  String filePath2 = filename2 + ".txt";
			  
			  File dir = new File("C:\\\\\\\\Users\\\\\\\\HB\\\\\\\\OneDrive\\\\\\\\Desktop\\\\\\\\Tester");
			  String[] flist = dir.list();
		        int flag = 0;
		        if (flist == null) {
		            System.out.println("Empty directory.");
		        }
		        else {
		  
		            // Linear search in the array
		            for (int i = 0; i < flist.length; i++) {
		                String filename = flist[i];
		                //.equals() indicate that case sensitivity is considered
		                if (filename.equals(filePath2)) {
		                    System.out.println(filename + " found");
		                    flag = 1;
		                }
		            }
		        }
		  
		        if (flag == 0) {
		            System.out.println("File Not Found");
		        }
		    }
		  
		  //(4) Go Back To Main Context
		  else if (opt2==4) {
			main(args);
		  }
		  
		  //In Case User Input Is >4
		  else {
			  System.out.println("There's only 4 options.");
		  }
		  
	    break;
	  
	   //To Terminate The Program
	  case 3:
		 System.exit(0);
		    break;
		    
	  default:
		  System.out.println("There's only 3 options.");
	}
	
}

}
