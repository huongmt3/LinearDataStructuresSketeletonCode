package implementations;

import interfaces.LinkedList;

import java.util.Iterator;

public class DoublyLinkedList<E> implements LinkedList<E> {
    private DoublyLinkedList.Node<E> head;
    private DoublyLinkedList.Node<E> tail;
    private DoublyLinkedList.Node<E> next;
    private DoublyLinkedList.Node<E> prev;
    private int size;
    private static class Node<E> {
        private DoublyLinkedList.Node<E> head;
        private DoublyLinkedList.Node<E> tail;
        private E element;
        private DoublyLinkedList.Node<E> next;
        private DoublyLinkedList.Node<E> prev;
        private int size;
        public Node(E value) {
            this.element = value;
        }
        public void DoublyLinkedList() {
        }
    }
    @Override
    public void addFirst(E element) {
        DoublyLinkedList.Node<E> newNode = new DoublyLinkedList.Node<>(element);
        if (this.head != null) {
            newNode.next = this.head;
        }
        this.head = newNode;
        this.size++;
    }
    @Override
    public void addLast(E element) {
        DoublyLinkedList.Node<E> newNode = new DoublyLinkedList.Node<>(element);
        if (this.head == null) {
            this.head = newNode;
        } else {
            DoublyLinkedList.Node<E> current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        this.size++;
    }
    private void ensureNonEmpty() {
         if (this.size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
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
        DoublyLinkedList.Node<E> current = this.head;
        while (current.next.next != null) {
            current = current.next;
        }
        E element = current.next.element;
        current.next = null;
        this.size--;
        return element;
    }
   /** @Override
    public E removeLast() {
        ensureNonEmpty();
        E data = tail.element;
        Node<E> temp = tail;

    }*/
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
        DoublyLinkedList.Node<E> current = this.head;
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

    public void removeElement(E element) {
        ensureNonEmpty();
        if (head.element.equals(element)) {
            head = head.next;
            size--;
            return;
        }
        DoublyLinkedList.Node<E> current = head.next;
        DoublyLinkedList.Node<E> prev = head;
        while (current != null) {
            if (current.element.equals(element)) {
                prev.next = current.next;
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }
}
