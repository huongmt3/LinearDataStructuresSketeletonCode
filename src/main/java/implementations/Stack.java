package implementations;

import interfaces.AbstractStack;

import java.util.Iterator;

public class Stack<E> implements AbstractStack<E> {
    private Node<E> top;
    private int size;
    private static class Node<E> {
        Node<E> previous;
        E element;
         Node<E> next;
        public Node (E element) {this(element, null);}
        public Node (E element, Node<E> previous){
        this.element = element;
        this.previous = previous;
        }
    }

    public Stack (){
        this.top = null;
        this.size = 0;
    }
    /**Push element onto the stack*/
    @Override
    public void push(E element) {
        Node<E> newNode = new Node<> (element);
        newNode.previous = top;
        top = newNode;
        this.size++;
    }
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
    /**Ensures that the stack is not empty*/
    private void ensureNonEmpty() {
        if (this.size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
    }
    /**Pops element off the stack*/
    @Override
    public E pop() {
        ensureNonEmpty();
        E element = this.top.element;
        Node<E> temp = this.top.previous;
        this.top.previous = null;
        this.top = temp;
        this.size--;
        return element;
    }
    /**Returns the element at the top of the stack without removing it*/
    @Override
    public E peek() {
        ensureNonEmpty();
        return this.top.element;
    }

    @Override
    public int size() {
        return this.size;
    }



    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = top;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E element = current.element;
                this.current = this.current.previous;
                return element;
            }
        };
    }
    static int linearSearch(int[]arr, int x)
    {
        int n = arr.length;
        for (int i = 0; i < n; i++)
            if (arr[i] == x) return i;
        return -1;
    }
}
