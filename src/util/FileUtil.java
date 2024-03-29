package util;

import java.io.*;

public class FileUtil {
	public static String writeString(String msg, String path) {
		PrintWriter out = null;
		File file = new File(path);
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			out = new PrintWriter(file);
			out.write(msg);
			out.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
		return file.getAbsolutePath();
	}
	public static String writeString(String msg, OutputStream out) {
		try {
			out.write(msg.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * @Title: copyFile
	 * @Description: TODO(复制文件)
	 * @param in
	 * @param outPaht
	 * @param fileName
	 * @return 设定文件
	 * @return String 返回类型
	 * @throws @author peiyongdong
	 * @date 2018年11月21日 下午4:01:24
	 */
	public static String copyFile(InputStream in, String outPaht, String fileName) {
		File file = new File(outPaht);
		if (!file.exists()) {
			file.mkdirs();
		}
		File outFile = new File(outPaht + File.separatorChar + fileName);
		try {
			wirteFile(in, new FileOutputStream(outFile));
			return outFile.getPath();
		} catch (IOException e) {
			e.printStackTrace();		}
		return "";
	}

	/**
	 * @Title: copyFile
	 * @Description: TODO(复制文件)
	 * @param inPath
	 * @param outPaht
	 * @param fileName 设定文件
	 * @return void 返回类型
	 * @throws @author peiyongdong
	 * @date 2018年11月21日 下午4:01:40
	 */
	public static void copyFile(String inPath, String outPaht, String fileName) {
		File file = new File(inPath);
		File outFile = new File(outPaht + File.separatorChar + fileName);
		try {
			InputStream in = new FileInputStream(file);
			wirteFile(in, new FileOutputStream(outFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Title: wirteFile
	 * @Description: TODO(复制文件)
	 * @param in
	 * @param out 设定文件
	 * @return void 返回类型
	 * @throws @author peiyongdong
	 * @date 2018年11月21日 下午4:01:52
	 */
	public static void wirteFile(InputStream in, OutputStream out) {
		wirteFile(in, out, true);
	}

	/**
	 * @Title: wirteFile
	 * @Description: TODO(复制文件)
	 * @param in
	 * @param out
	 * @param isClosed 是否关闭流如果为false需要在调用此方法后手动关闭流
	 * @return void 返回类型
	 * @throws @author peiyongdong
	 * @date 2018年11月21日 下午4:02:06
	 */
	public static void wirteFile(InputStream in, OutputStream out, boolean isClosed) {
		byte[] b = new byte[1024];
		int len = 0;
		try {
			while ((len = in.read(b)) != -1) {
				out.write(b, 0, len);
			}
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (isClosed) {
				try {
					if (out != null) {
						out.close();
					}
					if (in != null) {
						in.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static byte[] readFile(File file) throws IOException {
		FileInputStream input = new FileInputStream(file);
		byte[] inData = new byte[(int) file.length()];
		while (input.read(inData) != -1) {
		}
		input.close();
		return inData;
	}
	public static String readText(File file){
		FileInputStream input = null;
		byte[] inData = new byte[(int) file.length()];
		try {
			input = new FileInputStream(file);
			while (input.read(inData) != -1) {
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(input!=null) {
					input.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return new String(inData);
	}
	public static boolean deleteFile(File file) {
		if (file.exists() && file.isFile()) {
			if (file.delete()) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public static boolean deleteDirectory(File dir) {
		// 如果dir对应的文件不存在，或者不是一个目录，则退出
		if ((!dir.exists()) || (!dir.isDirectory())) {
			return false;
		}
		boolean flag = true;
		// 删除文件夹中的所有文件包括子目录
		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++) {
			// 删除子文件
			if (files[i].isFile()) {
				flag = deleteFile(files[i]);
				if (!flag)
					break;
			} else if (files[i].isDirectory()) {// 删除子目录
				flag = deleteDirectory(files[i]);
				if (!flag)
					break;
			}
		}
		if (!flag) {
			return false;
		}
		// 删除当前目录
		if (dir.delete()) {
			return true;
		} else {
			return false;
		}
	}
	public static boolean delete(File file) {
		if (!file.exists()) {
			return false;
		}
		if (file.isFile()) {
			return deleteFile(file);
		} else {
			return deleteDirectory(file);
		}
	}
	public static boolean delete(String filePath) {
		File file = new File(filePath);
		return delete(file);
	}
}
