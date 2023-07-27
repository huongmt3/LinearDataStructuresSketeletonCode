/**import implementations.Stack;*/
import implementations.DoublyLinkedList;
import implementations.Queue;
import implementations.SinglyLinkedList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
/**import java.util.Queue;*/



public class Main {
    public static void main(String[] args) {
        testDoublyLinkedList();
    }
    public static void welcome() {
        System.out.println("Hello everyone!");
        introduce();
    }
    public static void introduce() {
        System.out.println("My full name is Ma Thu Huong");
        System.out.println("You can call me Huong");
    }
    /**DoublyLinkedList<String> list = new DoublyLinkedList<>();
     list.addLast("Hello");
     list.addLast("this is");
     list.addLast("normal");
     list.addLast("list");

     for (String element : list) {
     System.out.println("Original DLL: " + element);
     }*/
    /** Function call
     list.reverse();

     System.out.println("");
     for (String element : list) {
     System.out.println("The reversed Linked List is " + element);
     }*/


    /**
     * ============================
     * |     Test Array List       |
     * ============================
     */
    public static void testArrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        /*Add elements to the list*/
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        /*Print out list*/
        System.out.println("Original List: " + list);
        /*Print out list's size*/
        System.out.println("Size of List: " + list.size());
        /*Get element at index 2*/
        System.out.println("Element at index 2: " + list.get(2));
        /*Remove element at index 2*/
        System.out.println("Removing element at index 2: " + list.remove(2));
        /*Print out list after remove element*/
        System.out.println("List after removing element at index 2: " + list);
        /*Add element at index 2*/
        list.add(6, 2);
        /*Print out list after add element*/
        System.out.println("List after adding element 6 at index 2: " + list);
    }

    /**
     * ========================
     * |     Test Stack       |
     * ========================
     */
    public static void testStack() {
        Stack<Integer> stack = new Stack<>();
        /*Push numbers onto the stack*/
        stack.push(1);
        stack.push(2);
        stack.push(3);
        /*Print out the stack*/
        System.out.println("Original Stack: " + stack);
        /*Print out stack's size*/
        System.out.println("OS size: " + stack.size());
        /*Peek at the stack's top element*/
        System.out.println("The stack's top element is " + stack.peek()); // 3
        /*Pop the top element off the stack and print it out*/
        int element = stack.pop();
        System.out.println("This element will be remove: " + element); // 3
        /*Print out stack's size*/
        System.out.println("New Stack size: " + stack.size()); // 2
        /*Check if the stack is empty or not*/
        boolean isEmpty = stack.isEmpty();
        System.out.println("The stack is empty. True or False?: " + isEmpty); // false
        /*Iterate through the stack and print out*/
        Iterator<Integer> iterator = stack.iterator();
        System.out.println("New Stack: " + stack);
        stack.push(4);
        System.out.println("New Stack After add 4: " + stack);
    }

    /**
     * ========================
     * |     Test Queue       |
     * ========================
     */
    public static void testQueue() {
        Queue<String> queue = new Queue<>();
        /*Add elements to the queue*/
        queue.offer("Hello");
        queue.offer("World");
        queue.offer("!");
        /*Print out the queue*/
        for (String element : queue) {
            System.out.println("Original Queue: " + element);
        }
        /*Print out size of the queue*/
        System.out.println("This queue has " + queue.size() + " elements"); // 3
        /*Peek at the queue's front element*/
        System.out.println("The first element in this queue is " + queue.peek()); // Hello
        /* Poll the queue's front element*/
        System.out.println("This element will be polled " + queue.poll()); // Hello
        /*Re-check the queue's size*/
        System.out.println("After poll, this queue has " + queue.size() + " elements left"); // 2
        /*Iterate through the queue and print out*/
        for (String element : queue) {
            System.out.println("New Queue: " + element);
        }
        queue.offer("Hello");
        for (String element : queue) {
            System.out.println("New Queue After Offer 'Hello': " + element);
        }
    }

    /**
     * ===================================
     * |     Test SinglyLinkedList       |
     * ===================================
     */
    public static void testSinglyLinkedList() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        /*Add elements to the linked list*/
        list.addFirst("Hello");
        list.addLast("World");
        list.addLast("!");
        /*Print out the SLL*/
        for (String element : list) {
            System.out.println("Original SLL: " + element);
        }
        /*Check the SLL's size*/
        System.out.println("This list has " + list.size() + " elements"); //3
        /*Get the SLL's first element*/
        System.out.println("The first element of this list is the word " + list.getFirst()); //Hello
        /*Get the SLL's last element*/
        System.out.println("The last element of this list is " + list.getLast()); //!
        /*Remove the SLL's first element*/
        System.out.println("Now I will remove the word " + list.removeFirst() + "from this list"); //Hello
        /*Re-check the SLL's size*/
        System.out.println("After remove, this list has " + list.size() + " elements"); //2
        /*Iterate through the SLL and print out*/
        for (String element : list) {
            System.out.println("New SLL: " + element);
        }
    }

    /**
     * ===================================
     * |     Test DoublyLinkedList       |
     * ===================================
     */
    public static void testDoublyLinkedList() {
        DoublyLinkedList<DoublyLinkedList.Participant> participantList = new DoublyLinkedList<>();
        DoublyLinkedList.Participant participant1 = new DoublyLinkedList.Participant("huong@gmail.com", "Ma Thu Huong");
        DoublyLinkedList.Participant participant3 = new DoublyLinkedList.Participant("tra@gmail.com", "Le Thi Hong Tra");
        DoublyLinkedList.Participant participant2 = new DoublyLinkedList.Participant("ngan@gmail.com", "Ly Thi Kim Ngan");
        participantList.addFirst(participant2);
        participantList.addFirst(participant1);
        participantList.addLast(participant3);
        Iterator<DoublyLinkedList.Participant> participantIterator = participantList.iterator();
        System.out.println("Original List:");
        while (participantIterator.hasNext()) {
            System.out.println(participantIterator.next());
        }
        System.out.println();
        System.out.println("First participant in the list: ");
        System.out.println(participantList.getFirst());
        System.out.println();
        System.out.println("Last participant in the list: ");
        System.out.println(participantList.getLast());

        /**DoublyLinkedList.Node<DoublyLinkedList.Participant> participantToRemove = participantList.contains(participant1);*/
        if (participantList.contains(participant2) == null)
            System.out.println("This participant cannot be remove because does not exist in the list.");
        else{
            System.out.println();
            System.out.println("Participant " +participant2+ " exists in the list.");
            participantList.remove(participantList.contains(participant2));
            System.out.println();
            System.out.println("Removed successfully.");
        }
        System.out.println();
        System.out.println("List after removing the participant:");
        participantIterator = participantList.iterator();
        while (participantIterator.hasNext()) {
            System.out.println(participantIterator.next());
        }

        DoublyLinkedList.Participant participant4 = new DoublyLinkedList.Participant("nhan@gmail.com", "Ly Thi Thanh Nhan");
        participantList.insertAfter(participantList.contains(participant1), participant4);
        System.out.println();
        System.out.println("List after adding the participant:");
        participantIterator = participantList.iterator();
        while (participantIterator.hasNext()) {
            System.out.println(participantIterator.next());
        }
    }
}