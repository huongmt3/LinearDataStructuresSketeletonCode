/**import implementations.Stack;*/
import implementations.Queue;
import implementations.SinglyLinkedList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
/**import java.util.Queue;*/



public class Main {
    public static void main(String[] args) {

    }
        /**============================
         * |     Test Array List       |
         * ============================*/
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
        /**========================
         * |     Test Stack       |
         * ========================*/
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
        /**========================
         * |     Test Queue       |
         * ========================*/
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
        /**===================================
         * |     Test SinglyLinkedList       |
         * ===================================*/
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
    }
