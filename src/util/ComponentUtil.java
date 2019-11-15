package util;

import entity.Config;
import listener.ClickListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class ComponentUtil {
	public static Component getCompentByName(JPanel panel,String name) {
		Component[] components= panel.getComponents();
		for (int i = 0; i < components.length; i++) {
			Component c = components[i];
			if(c instanceof JScrollPane) {
				JScrollPane pane = (JScrollPane)c;
				c = pane.getViewport().getView();
			}
			if(name.equals(c.getName())) {
				return c;
			}
		}
		return null;
	}
	public static void refresh(Component componet) {
		if(componet !=null) {
			componet.setVisible(false);
			componet.setVisible(true);
		}
	}
	public static Border getBorder(Color color) {
		Border border = BorderFactory.createLineBorder(color);
		return border;
	}
	public static <T> T getParentToClass(Component c,Class<T> type) {
		while (c!=null) {
			if(c.getClass()==type) {
				return (T)c;
			}
			c = c.getParent();
		}
		return null;
	}
	public static void saveSetting(Config config) {
		String dirPath =getDirPath(-1);
		String json = JsonUtil.toJson(config);
		String setPath = dirPath + File.separatorChar+"setting.txt";
		File setFile = new File(setPath);
		try {
			OutputStream out = new FileOutputStream(setFile);
			FileUtil.writeString(json, out);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static String getDirPath(Integer status) {
		String dirPath = getBaseDirPath()+File.separatorChar+"setting";
		File dirFile = new File(dirPath);
		if(!dirFile.exists()||!dirFile.isDirectory()) {
			dirFile.mkdirs();
		}
		return dirPath;
	}
	private static String getBaseDirPath() {
		String dirPath = "src"+File.separatorChar+"data";
		return dirPath;
	}
	public static void emptyDir(Integer status) {
		FileUtil.delete(getDirPath(status));
	}
	public static Config readConfig() {
		String dirPath =getDirPath(-1);
		String setPath = dirPath+File.separatorChar+"setting.txt";
		File setFile = new File(setPath);
		if(!setFile.exists()) {
			return null;
		}
		String json = FileUtil.readText(setFile);
		Config config = JsonUtil.toBean(json, Config.class);
		return config;
	}
	public static JButton createImageButton(String imgName, ClickListener listener){
        ImageIcon imageIcon = new ImageIcon(StyleUtil.getIconBasePath()+imgName);
        JButton button = new JButton (imageIcon);
        button.setContentAreaFilled(false);//不绘制按钮区域
        button.setBorderPainted(false);//不绘制边框
        button.setFocusPainted (false);
        button.addMouseListener (listener);
        button.setSize (20,20);
        return button;
    }
}
