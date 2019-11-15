package ui;

import entity.Config;
import listener.MoveWindowListener;
import util.ComponentUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;

/**
 * @ClassName MainJFrame
 * @Description TODO
 * @Author pay
 * @DATE 2019/11/15 11:10
 **/
public class MainJFrame extends JFrame {
    public Config config;
    private final MoveWindowListener moveWindowListener = new MoveWindowListener();
    static {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addMouseAdapterListener(MouseAdapter mouseAdapterListener) {
        addMouseListener(mouseAdapterListener);
        addMouseMotionListener(mouseAdapterListener);
        addMouseWheelListener(mouseAdapterListener);
    }
    public MainJFrame() {
        config = ComponentUtil.readConfig();
        if(config == null) {
            config = new Config();
        }
        setLayout(null);
        // 设置透明
        setUndecorated(true);
        setBackground(new Color (0, 0, 0, 130));
        // 设置最小窗口
        setMinimumSize(new Dimension(935, 655));
        // 关闭窗体后终止程序
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ToolPanel toolPanel = new ToolPanel (this);
        add (toolPanel);
        ContentPanel contentPanel = new ContentPanel (this);
        add (contentPanel);
        // 设置界面可见
        setVisible(true);
        // Frame在窗体居中
        setLocationRelativeTo(null);
        addMouseAdapterListener(moveWindowListener);
        new ConnSettingDialog(this);
        moveWindowListener.setOnDragge (dimension -> toolPanel.refreshSize (dimension));
    }
}
