import java.util.EmptyStackException;

public class LinkedStack<E> {

    private Entry top;
    private int size;

    class Entry {

        private Entry previous;
        private E element;

        Entry(E value) {
            this.element = value;
            this.previous = top;
        }

        public Entry getPrevious() {
            return this.previous;
        }

        public void setPrevious(Entry previous) {
            this.previous = previous;
        }

        public E getElement() {
            return this.element;
        }
    }

    public LinkedStack() {
        top = new Entry(null);
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        top = new Entry(null);
        size = 0;

    }

    public void push(E e) {
        Entry pushed = new Entry(e);
        pushed.setPrevious(top);
        top = pushed;
        size++;
    }

    public E pop() {
        if (size == 0) throw new EmptyStackException();
        Entry temp = top;
        top = top.getPrevious();
        size--;
        return temp.getElement();
    }

    public E peek() {
        if (size == 0) throw new EmptyStackException();
        return top.getElement();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (Entry cur = top; cur.getPrevious() != null ; cur = cur.getPrevious()) {
            sb.append(cur.getElement() + " ");
        }
        return sb.toString();
    }
}