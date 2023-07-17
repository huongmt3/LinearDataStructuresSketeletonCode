package implementations;

import interfaces.AbstractQueue;

import java.util.Iterator;

public class Queue<E> implements AbstractQueue<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    private static class Node<E> {
        private E element;
        private Node<E> next;
        public Node(E value) {
            this.element = value;
        }
    }
        /**public SimpleQueue() {
        }*/

        @Override
        public void offer(E element) {
            Node<E> newNode = new Node<>(element);
            if (this.head == null) {
                this.head = newNode;
            } else {
                this.tail.next = newNode;
            }
            this.tail = newNode;
            this.size++;
        }

        @Override
        public E poll() {
            if (this.head == null) {
                return null;
            }
            E element = this.head.element;
            this.head = this.head.next;
            if (this.head == null) {
                this.tail = null;
            }
            this.size--;
            return element;
        }

        @Override
        public E peek() {
            if (this.head == null) {
                return null;
            }
            return this.head.element;
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
