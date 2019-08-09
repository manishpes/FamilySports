package com.manish.sports;

/*********************************
 * Every member of a family plays a Sport Hockey or Cricket find the nth generation and mth sibling sports 
 *
 * If Head of the family plays Hockey (H) and left child of Hockey(H) parent will play Cricket(C) 
 * and right child will play Hockey(H) and left child of every Cricket(C) parent will play Hockey and 
 * right child will play cricket(C)
 *  
 **********************************/
/**
 * @author manish
 *
 */
public class FamilySports {

    public static int generation = 3;
    public static int sibling = 6;
    public static int req = 0;

    public static void main(String[] args) {
        Tree root = new Tree("H");
        formTree(root, 0);
    } 
    public static void  formTree ( Tree node, int height ){
        if (node == null) {
           return;
        }
        if(height == generation) {
            req = req+1;
        }
        if(height > generation) {
            return;
        }
        if(height == generation && req == sibling) {
            System.out.println("Son "+node.data);
            return;
        }
        if(node.data.equals("H")) {
            node.left = new Tree("C");
            node.right = new Tree("H");
        }else {
            node.left = new Tree("H");
            node.right = new Tree("C");
        }
        formTree(node.left, height+1);
        formTree(node.right, height+1);
        return;
    }
}

class Tree{
    String data;
    Tree left;
    Tree right;
    public Tree(String data){
        this.data=data;
        left=right=null;
    }

}
