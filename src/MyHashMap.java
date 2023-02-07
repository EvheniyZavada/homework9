import java.util.Arrays;
import java.util.Objects;

public class MyHashMap<K,V> {
    private static final double LOAD_CAPACITY = 0.75;
    private Node<K,V> [] array = new Node[16];

    private int size = 0;

    public int size() {
        return size;
    }

    public void clear(){
        array = new Node[16];
        size = 0;
    }

    public void put(K key, V value){
        if (size >= array.length * LOAD_CAPACITY){
            increaseArray();
        }
        boolean put = put(key,value,array);
        if (put){
            size++;
        }
    }

    private boolean put(K key, V value, Node<K,V>[] anotherArr){
        int pos = getPosition(key, anotherArr.length);
        Node<K,V> currentEl = anotherArr[pos];
        if (currentEl == null){
            Node<K,V> node = new Node<>(key, value, null);
            anotherArr[pos] = node;
            return true;
        } else {
            while (true) {
                if (currentEl.key.equals(key)) {
                    currentEl.value = value;
                    return false;
                }
                if (currentEl.next == null){
                    currentEl.next = new Node<>(key,value,null);
                    return true;
                }
                currentEl = currentEl.next;
            }
        }
    }

    public void remove(Object key){
        int pos = getPosition(key, array.length);
        Node<K,V> currentEl = array[pos];
        while (currentEl != null){
            if (currentEl.key.equals(key)){
                if (currentEl.next == null){
                    currentEl.key = null;
                    currentEl.value = null;
                    size--;
                }else {
                    currentEl.key = null;
                    currentEl.value = null;
                    array[pos] = currentEl.next;
                    size--;
                }
            }
            currentEl = currentEl.next;
        }

    }

    public Object get(Object key){
        int pos = getPosition(key, array.length);
        Node<K,V> currentEl = array[pos];
        while (currentEl != null){
            if (currentEl.key.equals(key)){
                return currentEl.value;
            }
            currentEl = currentEl.next;
        }
        return null;
    }

    private int getPosition(Object key, int arrayLength){
        return Math.abs(key.hashCode() % arrayLength);
    }
    private void increaseArray(){
        Node<K,V>[] newArray = new Node[array.length * 2];
        for (Node<K,V> node: array) {
            Node<K,V> currentEl = node;
            while (currentEl != null){
                put(currentEl.key, currentEl.value, newArray);
                currentEl = currentEl.next;
            }
        }
        array = newArray;
    }

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                res += array[i] + " ";
            }
        }
        return res.strip();
    }

    private static class Node<K,V>{
         private K key;
         private V value;
         private Node <K,V> next;

        public Node(K key, V value, Node<K,V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?, ?> node = (Node<?, ?>) o;
            return Objects.equals(key, node.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }

        @Override
        public String toString() {
            return key + " = " + value;
        }
    }

}
