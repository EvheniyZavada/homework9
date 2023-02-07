import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class MyQueue{

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
            return Arrays.toString(array);
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
        public Object peek(){
            if (size != 0) {
                return array[0];
            } else{
                throw new IndexOutOfBoundsException();
            }
        }
        public Object poll(){
            if (size != 0) {
                Object obj = get(0);
                remove(0);
                return obj;
            } else {
                throw new IndexOutOfBoundsException();
            }

        }
    }



