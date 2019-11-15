package ui;

import listener.MoveListener;
import util.ComponentUtil;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName ConnSettingDialog
 * @Description TODO
 * @Author pay
 * @DATE 2019/11/15 17:29
 **/
public class ConnSettingDialog extends JDialog {
    private final JFrame mJframe;
    private final MoveListener moveListener= new MoveListener ();
    static {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ConnSettingDialog(final JFrame mJframe) {
        this.mJframe = mJframe;
        mJframe.setEnabled (false);
        //设置透明
        setUndecorated(true);
        setBackground(new Color (0,0,0,130));
        //设置最小窗口
        setSize(720,405);
        dispose();
        setVisible(true);
        setLocationRelativeTo(null);
        addMoveListener();
        JButton button = ComponentUtil.createImageButton ("close.png",e -> {
            this.dispose();
            mJframe.setEnabled(true);
        });
        button.setLocation (getWidth ()-20,0);
        add (button);
    }
    public void addMoveListener() {
        addMouseListener(moveListener);
        addMouseMotionListener(moveListener);
        addMouseWheelListener(moveListener);
    }

}
