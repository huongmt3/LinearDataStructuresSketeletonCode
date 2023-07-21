/**package implementations;

import interfaces.LinkedList;
import java.util.Iterator;

public class Node<E> implements LinkedList<E> {
    public int size;
    public Node<E> head;
    public E element;
    private Node<E> tail;
    private Node<E> next;
    private Node<E> prev;
    public Node(E value) {
        this.element = value;
    }
    @Override
    public void addFirst(E element) {

    }
    @Override
    public void addLast(E element) {

    }
    @Override
    public E removeFirst() {
        return null;
    }
    @Override
    public E removeLast() {
        return null;
    }
    @Override
    public E getFirst() {
        return null;
    }
    @Override
    public E getLast() {
        return null;
    }
    @Override
    public int size() {
        return 0;
    }
    @Override
    public boolean isEmpty() {
        return false;
    }
    @Override
    public Iterator<E> iterator() {
        return null;
    }
}*/
