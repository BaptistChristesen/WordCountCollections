import java.util.*;

/**
 * Write a description of class LinkedList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LinkedList<T extends Comparable<T>> implements WordCountCollection<T>
{
    private int size;
    private LLNode<T> front, rear;
    
    public LinkedList(){
        size = 0;
        front = null;
        rear = null;
    }
    
    public int size(){
        return size;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }

    public void add (T element){
        LLNode<T> temp = new LLNode<T>(element);
        if(rear == null){
            front = temp;
        }
        else{
            rear.setLink(temp);
        }
        rear = temp;
        size++;
    }
    
    public T fetch(T element){
        LLNode<T> currNode = front;
        while(currNode != null){
            T e = currNode.getInfo();
            if(e.compareTo(element) == 0){
                return e;
            }
            currNode = currNode.getLink();
        }
        return null;
    }

    public void clear(){
        front = null;
        rear = null;
        size = 0;
    }
    
    public List<T> createList(){
        LLNode<T> k = front;
        List<T> list = new ArrayList<T>();
        while(k != null){
            list.add(k.getInfo());
            k = k.getLink();
        }
        return list;
    }
}
