package ui;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName ContentPanel
 * @Description TODO
 * @Author pay
 * @DATE 2019/11/15 16:45
 **/
public class ContentPanel extends JSplitPane {
    private final JFrame mJframe;
    private JPanel leftPanel;
    private JPanel rightPanel;
    public ContentPanel(final JFrame mJframe) {
        this.mJframe = mJframe;
        setBounds (mJframe.getX ()+2,mJframe.getY ()+30,mJframe.getWidth ()-4,mJframe.getHeight ()-32);
        setContinuousLayout (true);//设置操作监听
        setDividerSize (1);//设置分割线大小
        setDividerLocation (getWidth ()/5);//设置分割大小
        setOpaque (false);
        init ();
    }
    private void init(){
        leftPanel = new JPanel ();
        leftPanel.setBackground (Color.lightGray);
        setLeftComponent (leftPanel);
        rightPanel = new JPanel ();
        rightPanel.setBackground (Color.PINK);
        setRightComponent (rightPanel);
    }
}
