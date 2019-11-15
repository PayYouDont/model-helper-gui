import ui.MainJFrame;
import util.StyleUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName Main
 * @Description TODO
 * @Author pay
 * @DATE 2019/11/15 9:04
 **/
public class Main {
    public static void main(String[] args){
        //show(new MainJFrame());
        new MainJFrame();
    }
    public static void show(MainJFrame frame){
        if (SystemTray.isSupported()) {// 如果系统支持托盘
            // 创建弹出式菜单
            PopupMenu menu = new PopupMenu();
            // 创建菜单项
            MenuItem setItem = new MenuItem("设置");
            setItem.addActionListener(new ActionListener () {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
            menu.add(setItem);
            MenuItem exitItem = new MenuItem("退出程序");
            exitItem.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit (0);
                }
            });
            menu.add(exitItem);
            ImageIcon imageIcon = new ImageIcon(StyleUtil.getIconBasePath()+"便签.png");
            // 创建托盘图标
            TrayIcon trayIcon = new TrayIcon(imageIcon.getImage(), "小黄条", menu);
            trayIcon.setPopupMenu(menu);
            // 获得系统托盘
            SystemTray tray = SystemTray.getSystemTray();
            try {
                tray.add(trayIcon);
            } catch (AWTException e1) {
                e1.printStackTrace();
            }
        }
    }
}
