package coreservlets;

import java.io.*;

public class GetWebRoot {
	public static String getWebRoot() {
		String classPathRoot = GetWebRoot.class.getResource("/").getFile();
		File classPath = new File(classPathRoot);
		while(true) {
			classPath = classPath.getParentFile();
			if (classPath.getName().equals("WEB-INF")) {
				classPath = classPath.getParentFile();
				break;
			}
		}
		String webRoot = classPath.getAbsolutePath();
		return webRoot;
	}
}
