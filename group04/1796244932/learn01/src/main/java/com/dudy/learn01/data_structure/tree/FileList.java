package com.dudy.learn01.data_structure.tree;
import java.io.File;

/**
 * @author dudy
 *
 */
public class FileList {
	public static void list(File f) {	
		if(f.isDirectory()){
			System.out.println("目录:" + f.getName());
			File[] files = f.listFiles();
			for(int i = 0; i< files.length ; i++){
				list(files[i]);
			}
		} 
		
		if(f.isFile()){
			System.out.println("文件: " + f.getName());
		}
	}

	public static void main(String[] args) {
		list(new File("D:/duizhang"));
	}
	
}