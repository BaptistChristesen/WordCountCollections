import java.util.*;
/**
 * Write a description of class BinarySearchArray here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BinarySearchArray<T extends Comparable<T>> implements WordCountCollection<T>
{
    private int size;
    private ArrayList<T> list;
    public BinarySearchArray(){
        list = new ArrayList<T>();
        size = 0;
    }
    
    public int size(){
        return size;
    }
    
    public boolean isEmpty(){
        return size==0;
    }

    public void add (T element){
        int high = size-1;
        int low = 0;
        int mid;
        int index = size;
        while(low<=high){
            mid = low+((high-low)/2);
            if(list.get(mid).compareTo(element) < 0){
                low = mid+1; 
            }
            else if (list.get(mid).compareTo(element) > 0){
                high = mid-1;
            }
            else if (list.get(mid).compareTo(element) == 0){
                index = mid;
                break;
            }
        }
        list.add(index, element);
        size++;
    }
    
    public T fetch(T element){
        for(T e : list){
            if(e.compareTo(element) == 0){
                return e;
            }
        }
        return null;
    }
    
    public void clear(){
        while(!isEmpty())
        {
            list.remove(size-1);
            size--;
        }
    }
    
    public List<T> createList(){
        List<T> list2 = list;
        return list2;
    }
}
