import java.util.LinkedList;

public class MyLinkedList<E> {
    private int size = 0;
    private Node<E> first;
    private Node<E> last;

    public void clear(){
        first = null;
        last = null;
        size = 0;
    }

    public int Size() {
        return size;
    }

    public Node<E> getIndexByNode(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        } else {
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }
    }
    public Object get(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        } else {
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node.value;
        }
    }

    public void remove(int index){
        Node<E> node = getIndexByNode(index);
        Node<E> nodeNext = node.next;
        Node<E> nodePrevious = node.prev;
        if (nodeNext != null) {
            nodeNext.prev = nodePrevious;
        } else {
            last = nodePrevious;
        }
        if (nodePrevious != null) {
            nodePrevious.next = nodeNext;
        } else {
            first = nodeNext;
        }
        size--;
    }

    public void add(E element){
      if (size == 0){
          Node<E> node = new Node<>(null, element, null);
          first = node;
          last = node;
      } else {
          Node<E> previousLast = last;
          last = new Node<>(previousLast, element, null);
          previousLast.next = last;
      }
      size++;
    }


    private static class Node<E> {

        Node<E> prev;
        E value;
        Node<E> next;

        public Node(Node<E> prev, E value, Node<E> next ) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public String toString() {
        Node<E> node = first;
        String result = "";
        for (int i = 0; i < size; i++) {
            result += node.value.toString() + " ";
            node = node.next;
        }
        return result.strip();
    }
}



