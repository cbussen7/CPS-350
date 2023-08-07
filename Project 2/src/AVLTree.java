/*
    Christopher Bussen
    CPS 350 02
    Project 2

    program has methods for AVL trees
 */

public class AVLTree {
    AVLTreeNode root;

    public AVLTree(){
        root = null;
    }

    public void preorder(){
        preorder(root);
    }
    private void preorder(AVLTreeNode head){
        if(head != null){
            //print current value
            System.out.print(head.key + " ");

            //go to left
            preorder(head.left);

            //go to right
            preorder(head.right);
        }
    }//end preorder method

    public void inorder(){
        inorder(root);
    }
    private void inorder(AVLTreeNode head){
        if(head != null){
            //go to left
            inorder(head.left);

            //print current value
            System.out.print(head.key + " ");

            //go to right
            inorder(head.right);
        }
    }//end inorder method

    public void insert(int value){
        root = insert(value, root);
    }
    private AVLTreeNode insert(int value, AVLTreeNode node){
        if(node == null){
            node = new AVLTreeNode(value);
        }
        else if(value < node.key){
            node.left = insert(value, node.left);

            node.factor = getHeight(node.left) - getHeight(node.right);

            if(node.factor == 2){
                if(value < node.left.key){
                    node = rightRotation(node);
                }
                else{
                    node = leftRightRotation(node);
                }
            }
        }
        else if(value > node.key){
            node.right = insert(value, node.right);

            node.factor = getHeight(node.right) - getHeight(node.left);

            if(node.factor == 2){
                if(value > node.right.key){
                    node = leftRotation(node);
                }
                else{
                    node = rightLeftRotation(node);
                }
            }
        }
        else{
            node.height = getMaxHeight(getHeight(node.left), getHeight(node.right)) + 1;
        }

        return node;
    }

    private AVLTreeNode rightRotation(AVLTreeNode node){
        AVLTreeNode tmp = node.left.left;
        node.left.left = tmp.right;
        tmp.right = node.left;
        node.height = getMaxHeight(getHeight(node.left), getHeight(node.right)) + 1;
        tmp.height = getMaxHeight(getHeight(tmp.left), node.height) + 1;
        return tmp;
    }

    private AVLTreeNode leftRotation(AVLTreeNode node){
        AVLTreeNode tmp = node.right.right;
        node.right.right = tmp.left;
        tmp.left = node.right;
        node.height = getMaxHeight(getHeight(node.left), getHeight(node.right)) + 1;
        tmp.height = getMaxHeight(getHeight(tmp.right), node.height) + 1;
        return tmp;
    }

    private AVLTreeNode leftRightRotation(AVLTreeNode node){
        node.left = leftRotation(node.left);
        return rightRotation(node);
    }

    private AVLTreeNode rightLeftRotation(AVLTreeNode node){
        node.right = rightRotation(node.right);
        return leftRotation(node);
    }

    private int getHeight(AVLTreeNode node){
        if(node == null){
            return -1;
        }
        else{
            return node.height;
        }
    }

    private int getMaxHeight(int leftNodeHeight, int rightNodeHeight){
        if(leftNodeHeight > rightNodeHeight){
            return leftNodeHeight;
        }
        else{
            return rightNodeHeight;
        }
    }
}//end public class AVLTree
