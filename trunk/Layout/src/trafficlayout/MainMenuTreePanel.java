package trafficlayout;

import java.util.Enumeration;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;


public abstract class MainMenuTreePanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	protected JTree mainMenu;
	protected JScrollPane scrollPane;
	
	public MainMenuTreePanel() 
	{
		
	}
	
	public abstract void initiate();
	public abstract void render();
	
	public void expandAll(JTree tree) 
	{
	    TreeNode root = (TreeNode) tree.getModel().getRoot();
	    expandAll(tree, new TreePath(root));
	}

	private void expandAll(JTree tree, TreePath parent) 
	{
		TreeNode node = (TreeNode) parent.getLastPathComponent();
		if (node.getChildCount() >= 0) 
		{
			for (@SuppressWarnings("unchecked")
			Enumeration <TreeNode> e = node.children(); e.hasMoreElements();) 
			{
				TreeNode n = (TreeNode) e.nextElement();
				TreePath path = parent.pathByAddingChild(n);
				expandAll(tree, path);
			}
	    }
	    tree.expandPath(parent);
	    // tree.collapsePath(parent);
	  }
}
