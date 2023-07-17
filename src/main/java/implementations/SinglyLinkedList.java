package implementations;

import interfaces.LinkedList;

import java.util.Iterator;

public class SinglyLinkedList<E> implements LinkedList<E> {
    private Node<E> head;
    private int size;
    private static class Node<E> {
        private Node<E> head;
        private E element;
        private Node<E> next;

        public Node(E value) {
            this.element = value;
        }

        public void LinkedList() {
        }
    }
    @Override
    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element);
        if (this.head != null) {
            newNode.next = this.head;
        }
        this.head = newNode;
        this.size++;
    }

    @Override
    public void addLast(E element) {
        Node<E> newNode = new Node<>(element);
        if (this.head == null) {
            this.head = newNode;
        } else {
            Node<E> current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        this.size++;
    }

    @Override
    public E removeFirst() {
        if (this.head == null) {
            return null;
        }
        E element = this.head.element;
        this.head = this.head.next;
        this.size--;
        return element;
    }

    @Override
    public E removeLast() {
        if (this.head == null) {
            return null;
        }
        Node<E> current = this.head;
        while (current.next.next != null) {
            current = current.next;
        }
        E element = current.next.element;
        current.next = null;
        this.size--;
        return element;
    }

    @Override
    public E getFirst() {
        if (this.head == null) {
            return null;
        }
        return this.head.element;
    }

    @Override
    public E getLast() {
        if (this.head == null) {
            return null;
        }
        Node<E> current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        return current.element;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = head;
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
