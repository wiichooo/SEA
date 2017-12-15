/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package softestandantrop;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 *
 * @author DAVID
 */
public class CustomIconRenderer extends DefaultTreeCellRenderer {
    ImageIcon EstandarizacionIcon;
    ImageIcon RondaIcon;
    ImageIcon AntropIcon;
    public CustomIconRenderer() {
        EstandarizacionIcon = new ImageIcon(CustomIconRenderer.class.getResource("/icons/16/Favorite Add.png"));
        RondaIcon = new ImageIcon(CustomIconRenderer.class.getResource("/icons/16/Group 4.png"));
        AntropIcon = new ImageIcon(CustomIconRenderer.class.getResource("/icons/16/User 4.png"));
    }
    public Component getTreeCellRendererComponent(JTree tree,
      Object value,boolean sel,boolean expanded,boolean leaf,
      int row,boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, 
          expanded, leaf, row, hasFocus);
        int nodeObj = ((CustomMutableTreeNode)value).getTipo();
        // check whatever you need to on the node user object
        if (nodeObj==1) {
            setIcon(EstandarizacionIcon);
        } else if (nodeObj==2) {
            setIcon(RondaIcon);
        }else if (nodeObj==3) {
            setIcon(AntropIcon);
        }
        return this;
    }
}
