import java.util.*;

public class BSTTester {
    public static void main(String[] args){
        LinkedBinarySearchTree<Integer> BST = new LinkedBinarySearchTree<Integer>();
        BST.addElement(11);
        BST.addElement(6);
        BST.addElement(8);
        BST.addElement(19);
        BST.addElement(4);
        BST.addElement(10);
        BST.addElement(5);
        BST.addElement(17);
        BST.addElement(43);
        BST.addElement(49);
        BST.addElement(31);
        //For Coursemology Q1
        System.out.println(inOrder(BST.root, new ArrayList<Integer>()));
        System.out.println(preOrder(BST.root, new ArrayList<Integer>()));
        System.out.println(postOrder(BST.root, new ArrayList<Integer>()));
        System.out.println(levelOrder(BST));
        // For Coursemology Q2
        System.out.println(BST);

        // For Coursemology Q3
        ArrayList<Integer> preOrder = new ArrayList<Integer>(Arrays.asList(11, 6, 4, 5, 8, 10, 19, 17, 43, 31, 49));
        ArrayList<Integer> inOrder = new ArrayList<Integer>(Arrays.asList(4, 5, 6, 8, 10, 11, 17, 19, 31, 43, 49));
        System.out.println(constructTree(preOrder, inOrder));
    }

    // Q1: Complete the inOrder Traversal here
    public static ArrayList<Integer> inOrder(BinaryTreeNode curr, ArrayList<Integer> result) {
        inOrderHelper(curr, result);
        return result;
    }   

    public static void inOrderHelper(BinaryTreeNode curr, ArrayList<Integer> result) {    
        if (curr == null) {
            return;
        }
        inOrderHelper(curr.left, result);
        result.add((Integer) curr.element);
        inOrderHelper(curr.right, result);
    }

    // Q1: Complete the preOrder Traversal here
    public static ArrayList<Integer> preOrder(BinaryTreeNode curr, ArrayList<Integer> result){
        preOrderHelper(curr, result);
        return result;
    }

    public static void preOrderHelper(BinaryTreeNode curr, ArrayList<Integer> result) {
        if (curr == null) {
            return;
        }
        result.add((Integer) curr.element);
        preOrderHelper(curr.left, result);
        preOrderHelper(curr.right, result);
    }

    // Q1: Complete the postOrder Traversal here
    public static ArrayList<Integer> postOrder(BinaryTreeNode curr, ArrayList<Integer> result){
        postOrderHelper(curr, result);
        return result;
    }

    public static void postOrderHelper(BinaryTreeNode curr, ArrayList<Integer> result) {
        if (curr == null) {
            return;
        }
        postOrderHelper(curr.left, result);
        postOrderHelper(curr.right, result);
        result.add((Integer) curr.element);
    }

    // Q1: Complete an iterative levelOrder Traversal here
    public static ArrayList<Integer> levelOrder(LinkedBinarySearchTree<Integer> BST){
        ArrayList<BinaryTreeNode> nodes = new ArrayList<BinaryTreeNode>();
        ArrayList<Integer> results = new ArrayList<Integer>();
        nodes.add(BST.root);
        while (!nodes.isEmpty()) {
            BinaryTreeNode node = nodes.remove(0);
            if (node != null) {
                results.add((Integer) node.element);
                nodes.add(node.left);
                nodes.add(node.right);
            } else {
            }
        }
        return results;
    }

    // Q3: Complete the following method to construct a tree from the pre and in order traversals
    // You may add your own auxillary methods
    public static LinkedBinarySearchTree<Integer> constructTree(ArrayList<Integer> preOrder, ArrayList<Integer> inOrder){
        if (preOrder.size() == 0) {
            return null;
        }
        LinkedBinarySearchTree<Integer> bst = new LinkedBinarySearchTree<Integer>(preOrder.get(0));
        LinkedBinarySearchTree<Integer> leftTree = null;
        LinkedBinarySearchTree<Integer> rightTree = null;
        if (preOrder.size() == 1) {
            return bst;
        } 

        for (int i = 0; i < inOrder.size(); i++) {
            if (inOrder.get(i) == preOrder.get(0)) {
                ArrayList<Integer> left = new ArrayList<Integer>(inOrder.subList(0, i));
                ArrayList<Integer> right = new ArrayList<Integer>(inOrder.subList(i + 1, inOrder.size()));

                ArrayList<Integer> leftPre = new ArrayList<Integer>(preOrder.subList(1, left.size() + 1));
                ArrayList<Integer> rightPre = new ArrayList<Integer>(preOrder.subList(left.size() + 1, preOrder.size()));

                leftTree = constructTree(leftPre, left);
                rightTree = constructTree(rightPre, right);
            }
        }
        if (leftTree != null) {
            bst.root.left = leftTree.root;
        } else {
            bst.root.left = null;
        }

        if (rightTree != null) {
            bst.root.right = rightTree.root;
        } else {
            bst.root.right = null;
        }
        
        return bst;
    }
}
