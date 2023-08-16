package implementations;

import interfaces.AbstractQueue;

import java.util.Iterator;

public class Queue<E> implements AbstractQueue<E> {
    Node<E> head;
    Node<E> tail;
    int size;
    private static class Node<E> {
        E element;
        Node<E> next;
        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
        public Node(E element){
            this(element, null);
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
        public void enqueue(E element) {
            Node<E> newNode = new Node<> (element);
            if (this.head == null)
                this.head = newNode;
            else {
                Node<E> current = this.head;
                while (current.next != null){
                    current = current.next;
                }
                current.next = newNode;
            }
            this.size++;
        }
        @Override
        public boolean isEmpty() {
        return head == null;
    }

        private void ensureNonEmpty(){
            if (isEmpty()) throw  new IllegalStateException("Cannot poll because queue is empty");
        }
        @Override
        public E dequeue(){
            ensureNonEmpty();
            E element = this.head.element;
            this.head = this.head.next;
            size--;
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
