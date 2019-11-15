package ui;

import util.ComponentUtil;
import util.StyleUtil;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName ToolPanel
 * @Description TODO
 * @Author pay
 * @DATE 2019/11/15 14:11
 **/
public class ToolPanel extends JPanel{
    private JButton logoBtn,colseBtn,minimizeBtn,maximizeBtn;
    private ImageIcon logoIcon;
    private int btnMargin = 20;
    private final JFrame mJframe;
    public ToolPanel(final JFrame mJframe) {
        this.mJframe = mJframe;
        setLayout (null);
        setName ("tool");
        setOpaque (false);
        setSize (mJframe.getWidth (),30);
        setBackground (Color.white);
        logoBtn = ComponentUtil.createImageButton ("logo.png",null);
        logoBtn.setLocation (btnMargin,5);

        colseBtn = ComponentUtil.createImageButton ("close.png", e ->  System.exit(0));
        maximizeBtn = ComponentUtil.createImageButton ("maximize.png",e -> {
            ImageIcon imageIcon = (ImageIcon) maximizeBtn.getIcon ();
            if(imageIcon.toString ().indexOf ("maximized")!=-1){
                imageIcon = new ImageIcon (StyleUtil.getIconBasePath ()+"maximize.png");
                minimize ();
            }else {
                imageIcon = new ImageIcon (StyleUtil.getIconBasePath ()+"maximized.png");
                maximize ();
            }
            maximizeBtn.setIcon (imageIcon);
        });
        minimizeBtn = ComponentUtil.createImageButton ("minimize.png",e -> {
            mJframe.setExtendedState(JFrame.ICONIFIED);
        });
        setBtnLocation ();
        add (logoBtn);
        add (colseBtn);
        add (maximizeBtn);
        add (minimizeBtn);
    }
    private void minimize(){
        refreshSize (new Dimension(935, 655));
        mJframe.setLocationRelativeTo(null);
    }
    private void maximize(){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle bounds = new Rectangle(dimension);
        refreshSize (dimension);
        mJframe.setBounds (bounds);
    }
    public void refreshSize(Dimension dimension){
        mJframe.setSize (dimension);
        setSize (mJframe.getWidth (),getHeight ());
        setBtnLocation ();
    }
    private void setBtnLocation(){
        logoBtn.setLocation (10,5);
        colseBtn.setLocation (getWidth ()-colseBtn.getWidth ()-btnMargin,5);
        maximizeBtn.setLocation (colseBtn.getLocation ().x-maximizeBtn.getWidth ()-btnMargin,5);
        minimizeBtn.setLocation (maximizeBtn.getLocation ().x-minimizeBtn.getWidth ()-btnMargin,5);
    }
}
