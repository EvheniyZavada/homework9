
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MyArrayList<E> {
    private Object[] array = new Object[10];
    private int size = 0;

    public void add(Object value){
        array [size] = value;
        size++;
        if (array.length == size) {
            Object[] newArray = new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }
    public String toString(){
        String res = "";
        for (Object obj: array) {
            if (obj != null){
                res += obj + " ";
            }
        }
        return res.trim();
    }

    public void remove(int index){
        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    public int size() {
        return size;
    }

    public Object get(int index){

        return array[index];
    }
    public void clear(){
       array = new Object[10];
       size = 0;
    }
}
