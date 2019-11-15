/**   
* @Title: Config.java 
* @Package com.payudon.entity 
* @Description: TODO(     ) 
* @author peiyongdong  
* @date 2019年1月15日 上午11:30:32 
*/
package entity;

import java.awt.*;
import java.io.Serializable;

/** 
* @ClassName: Config 
* @Description: TODO(     ) 
* @author peiyongdong
* @date 2019年1月15日 上午11:30:32 
*  
*/

public class Config implements Serializable{
	/** 
	* @Fields serialVersionUID : TODO(     ) 
	*/ 
	private static final long serialVersionUID = 1L;
	//数据库配置
	private String user;
	private String password;
	private String dataBaseName;
	//界面ui配置
	//置顶
	private boolean waysOnTop = false;
	//嵌入桌面
	private boolean isEmbed = false;
	//正常界面
	private boolean isNormal = true;
	//极简模式
	private boolean isMinimalist = false;
	//透明
	private boolean transparent = true;
	//文字大小
	private Integer size = 20;
	//文字间距
	private Integer spacing = 1;
	//文字颜色
	private Color color = Color.white;
	//字体
	private Integer fontCode = 0;//269微软雅黑
	//隐藏界面热键
	private Integer hideKeyCode = null;
	//开机启动
	private boolean isStartAtLogin = false;
	//贴近边缘自动隐藏界面
	private boolean isAutoHide = false;
    public Font getFont() {
        Font font;
        if(fontCode!=null) {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            font = ge.getAllFonts()[fontCode];
            font =  new Font(font.getFontName(), font.getStyle(), size);
        }else {
            font = new Font(null, 0, 20);
        }
        return font;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDataBaseName() {
        return dataBaseName;
    }

    public void setDataBaseName(String dataBaseName) {
        this.dataBaseName = dataBaseName;
    }

    public boolean isWaysOnTop() {
        return waysOnTop;
    }

    public void setWaysOnTop(boolean waysOnTop) {
        this.waysOnTop = waysOnTop;
    }

    public boolean isEmbed() {
        return isEmbed;
    }

    public void setEmbed(boolean embed) {
        isEmbed = embed;
    }

    public boolean isNormal() {
        return isNormal;
    }

    public void setNormal(boolean normal) {
        isNormal = normal;
    }

    public boolean isMinimalist() {
        return isMinimalist;
    }

    public void setMinimalist(boolean minimalist) {
        isMinimalist = minimalist;
    }

    public boolean isTransparent() {
        return transparent;
    }

    public void setTransparent(boolean transparent) {
        this.transparent = transparent;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getSpacing() {
        return spacing;
    }

    public void setSpacing(Integer spacing) {
        this.spacing = spacing;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Integer getFontCode() {
        return fontCode;
    }

    public void setFontCode(Integer fontCode) {
        this.fontCode = fontCode;
    }

    public Integer getHideKeyCode() {
        return hideKeyCode;
    }

    public void setHideKeyCode(Integer hideKeyCode) {
        this.hideKeyCode = hideKeyCode;
    }

    public boolean isStartAtLogin() {
        return isStartAtLogin;
    }

    public void setStartAtLogin(boolean startAtLogin) {
        isStartAtLogin = startAtLogin;
    }

    public boolean isAutoHide() {
        return isAutoHide;
    }

    public void setAutoHide(boolean autoHide) {
        isAutoHide = autoHide;
    }

    @Override
    public String toString() {
        return "Config{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", dataBaseName='" + dataBaseName + '\'' +
                ", waysOnTop=" + waysOnTop +
                ", isEmbed=" + isEmbed +
                ", isNormal=" + isNormal +
                ", isMinimalist=" + isMinimalist +
                ", transparent=" + transparent +
                ", size=" + size +
                ", spacing=" + spacing +
                ", color=" + color +
                ", fontCode=" + fontCode +
                ", hideKeyCode=" + hideKeyCode +
                ", isStartAtLogin=" + isStartAtLogin +
                ", isAutoHide=" + isAutoHide +
                '}';
    }
}
