/*
    Christopher Bussen
    CPS 350 02
    Project 2

    program uses AVLTree and AVLTreeNode classes to create an AVLTree using insertion and then traverses the tree
    NOTE: preorder does not work as it should but I'm not sure how to fix it - sorry
 */

public class AVLTreeMain {
    public static void main(String[] args){
        //create new AVLTree
        AVLTree testTree = new AVLTree();

        //insert 10, 3, 8, 14, 1, 4, 6, 7, 13 into AVLTree
        testTree.insert(10);
        testTree.insert(3);
        testTree.insert(8);
        testTree.insert(14);
        testTree.insert(1);
        testTree.insert(4);
        testTree.insert(6);
        testTree.insert(7);
        testTree.insert(13);

        //use preorder and inorder traversal on the tree
        testTree.preorder();
        System.out.println();

        testTree.inorder();
        System.out.println();

        AVLTree testTree2 = new AVLTree();

        //insert 8, 7, 6, 10, 12, 9, 5
        testTree2.insert(8);
        testTree2.insert(7);
        testTree2.insert(6);
        testTree2.insert(10);
        testTree2.insert(12);
        testTree2.insert(9);
        testTree2.insert(5);

        //use preorder and inorder traversal on the tree
        testTree2.preorder();
        System.out.println();

        testTree2.inorder();


    }//end main method
}//end public class AVLTreeMain
