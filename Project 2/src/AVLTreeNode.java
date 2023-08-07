/*
    Christopher Bussen
    CPS 350 02
    Project 2

    program has methods for AVL tree nodes
 */

public class AVLTreeNode {
        int key;			// an integer value
        int factor;		    // the balance factor
        AVLTreeNode left;	// reference to the left child
        AVLTreeNode right;	// reference to the right child
        AVLTreeNode parent;	// reference to the parent
        int height;

        AVLTreeNode()
        {
            key = 0;
            height = 0;
            left = right = parent = null;
        }

        AVLTreeNode(int v)
        {
            key = v;
            height = 0;
            left = right = parent = null;
        }
    }//end public class AVLTreeNode
