import java.util.*;

/**
 * Write a description of class BinarySearchTree here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BinarySearchTree<T extends Comparable<T>> implements WordCountCollection<T>
{
    private BinaryNode<T> root;
    private int size;
    public BinarySearchTree(){
        root = null;
        size=0;
    }
    
    public int size(){
        return size;
    }
    
    public boolean isEmpty(){
        return size==0;
    }

    public void add (T element){
        root = add(element, root);
        size++;
    }
    
    private BinaryNode<T> add(T element, BinaryNode<T> tree)
    {
        if(tree == null){
            tree = new BinaryNode(element);
        }
        else if(element.compareTo(tree.getInfo()) <= 0){
            tree.setLeft(add(element, tree.getLeft()));
        }
        else{
            tree.setRight(add(element, tree.getRight()));
        }
        return tree;
    }
    
    public T fetch(T element){
        return fetch(element, root);
    }
    private T fetch(T element, BinaryNode<T> tree){
        if(tree == null){
            return null;
        }
        else if(element.compareTo(tree.getInfo()) < 0){
            return fetch(element, tree.getLeft());
        }
        else if(element.compareTo(tree.getInfo()) > 0){
            return fetch(element, tree.getRight());
        }
        else{
            return tree.getInfo();
        }
    }
    // Removes all elements in this collection
    public void clear(){
        root = null;
        size=0;
    }
    
    public List<T> createList(){
        List<T> treeList = new ArrayList<T>();
        inorderTraverse(root, treeList);
        return treeList;
    }
    
    private void inorderTraverse(BinaryNode<T> tree, List<T> list){
        if(tree!=null){
            inorderTraverse(tree.getLeft(), list);
            list.add(tree.getInfo());
            inorderTraverse(tree.getRight(),list);
        }
    }
}
