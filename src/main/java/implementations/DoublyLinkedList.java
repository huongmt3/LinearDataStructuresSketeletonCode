package implementations;

import interfaces.LinkedList;

import java.util.Iterator;

public class DoublyLinkedList<E> implements LinkedList<E> {
        private Node<E> head, tail;
        private int size;
        public static class Node<E> {
            E element;
            Node<E> next;
            Node<E> previous;

            public Node(E element, Node<E> next, Node<E> previous) {
                this.previous = previous;
                this.element = element;
                this.next = next;
            }

            public Node(E element, Node<E> next) {
                this(element, next, null);
            }

            public Node(E element) {
                this(element, null);
            }
        }


    public DoublyLinkedList() {
    }

    @Override
    public void addFirst (E element) {
        Node<E> newNode = new Node <> (element);
        if(head==null)
        {
            head= tail= newNode;
        }
        else
        {
            newNode.next = head;
            head.previous=newNode;
            head=newNode;
        }
        size++;
    }

    @Override
    public void addLast (E element) {
        Node<E> newNode = new Node<> (element);
        if(head==null)
        {
            head = tail = newNode;
        }
        else
        {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
    }
    public void printReverse()
    {
        Node<E> current = tail;
        while (current !=null)
        {
            System.out.println(current.element);
            current = current.previous;
        }
    }

    private void ensureNonEmpty() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
    }

    @Override
    public E removeFirst() {
        ensureNonEmpty();
        E data = head.element;
        head = head.next;
        head. previous = null;
        size--;
        return data;
    }
    @Override
    public E removeLast() {
        ensureNonEmpty();
        E data = tail.element;
        tail.previous.next = null;
        tail = tail.previous;
        size--;
        return data;
    }

    @Override
    public E getFirst() {
        ensureNonEmpty();
        return head.element;
    }

    @Override
    public E getLast() {
        ensureNonEmpty();
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
            Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E data = current.element;
                current = current.next;
                return data;
            }
        };
    }
    public boolean containNode (Node<E> node)
    {
        Node<E> current = head;
        while (current!=null)
        {
            if (current==node)
            {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public Node<E> contains (E element)
    {
        Node<E> current = head;
        while (current !=null)
        {
            if (current.element.equals(element))
            {
                return current;
            }
            current = current.next;
        }
        return null;
    }
    public void insertAfter (Node<E> p, E element)
    {
        if(!containNode (p)) throw new IllegalStateException("Node does not exist in link list");
        Node<E> insertNode = new Node<>(element);
        Node<E> nextNode = p.next;
        insertNode.previous = p;
        insertNode.next = nextNode;
        p.next = insertNode;
        if (nextNode != null){
        nextNode.previous = insertNode;}
    }
    public E remove (Node<E> p)
    {
        if(!containNode (p)) throw new IllegalStateException("Node does not exist in link list");
        E data = p.element;
        if (head==p)
        {
            removeFirst();
        }
        else if (tail==p)
        {
            removeLast();
        }
        else
        {
            p.previous.next = p.next; p.next.previous = p.previous;
            size--;
        }
        return data;
    }
    public static class Participant {
        private String email;
        private String displayName;
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getDisplayName() { return displayName; }
        public void setDisplayName(String displayName) { this.displayName = displayName; }
        public Participant(String email, String displayName) {
            this.email = email;
            this.displayName = displayName;
        }
        @Override
        public String toString() {
            return displayName + " " + email;
        }
    }
    /**public Participant getParticipant(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return (Participant) current.element;
    }

    public void printParticipant(int index) {
        Participant participant = getParticipant(index);
        System.out.println(participant.getDisplayName() + " " + participant.getEmail());
    }*/

}
