package listener;

import util.ComponentUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;


/** 
* @ClassName: MyFocusListener 
* @Description: TODO(     ) 
* @author peiyongdong
* @date 2018年7月20日 下午4:51:27 
*  
*/
public class MyFocusListener implements FocusListener{

	/** 
	 * <p>Title: focusGained</p> 
	 * <p>Description: </p> 
	 * @param e 
	 * @see FocusListener#focusGained(FocusEvent)
	 * @throws
	 * @author peiyongdong
	 * @date 2018年7月20日 下午4:51:48
	 */
	@Override
	public void focusGained(FocusEvent e) {
		Component c = e.getComponent();
		if(c instanceof JComponent) {
			if(c instanceof JTextArea) {
				c = c.getParent().getParent();
			}
			((JComponent)c).setBorder(ComponentUtil.getBorder(new Color(51, 135, 255)));
		}
	}

	/**
	 * <p>Title: focusLost</p>
	 * <p>Description: </p>
	 * @param e
	 * @see FocusListener#focusLost(FocusEvent)
	 * @throws 
	 * @author peiyongdong
	 * @date 2018年7月20日 下午4:51:48
	 */
	@Override
	public void focusLost(FocusEvent e) {
		Component c = e.getComponent();
		if(c instanceof JComponent) {
			if(c instanceof JTextArea) {
				c = c.getParent().getParent();
			}
			((JComponent)c).setBorder(ComponentUtil.getBorder(Color.gray));
		}
	}
	
}
