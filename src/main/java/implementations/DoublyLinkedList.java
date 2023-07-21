package implementations;

import interfaces.LinkedList;

import java.util.Iterator;

public class DoublyLinkedList<E> implements LinkedList<E> {

    private DoublyLinkedList.Node<E> head;
    private DoublyLinkedList.Node<E> tail;
    private int size;

    private static class Node<E> {
        private E element;
        private DoublyLinkedList.Node<E> next;
        private DoublyLinkedList.Node<E> prev;

        public Node(E element) {
            this.element = element;
        }
    }

    public DoublyLinkedList() {
    }

    @Override
    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element);
        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
        size++;
    }

    @Override
    public void addLast(E element) {
        Node<E> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            /**tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;*/
            Node<E> current = this.head;
            while (current.next != null){
            head.next = current;
                current.next = tail;
                current.prev = tail.prev;
                current = tail.prev.next;
            tail.prev = current;}
        }
        size++;
    }

    private void ensureNonEmpty() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
    }
    public void reverse(E element){
        Node<E> temp = null;
        Node<E> current = head;
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if (temp != null) {
            head = temp.prev;
        }
    }
    @Override
    public E removeFirst() {
        /**if (head == null) {
            return null;
        }*/
        ensureNonEmpty();
        E element = head.element;
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
        size--;
        return element;
    }

    @Override
    public E removeLast() {
        /**if (head == null) {
            return null;
        }*/
        ensureNonEmpty();
        E element = tail.element;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        }
        size--;
        return element;
    }

    @Override
    public E getFirst() {
        if (head == null) {
            return null;
        }
        return head.element;
    }

    @Override
    public E getLast() {
        if (head == null) {
            return null;
        }
        return tail.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private DoublyLinkedList.Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E element = current.element;
                current = current.next;
                return element;
            }
        };
    }
}
