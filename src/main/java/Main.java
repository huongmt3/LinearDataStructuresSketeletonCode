/**import implementations.Stack;*/
import implementations.Queue;
import implementations.SinglyLinkedList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
/**import java.util.Queue;*/



public class Main {
    public static void main(String[] args) {}
        /**============================
         * |     Test Array List       |
         * ============================*/
        public static void testArrayList() {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
            list.add(5);
            System.out.println("Original List: " + list);
            System.out.println("Size of List: " + list.size());
            System.out.println("Element at index 2: " + list.get(2));
            System.out.println("Removing element at index 2: " + list.remove(2));
            System.out.println("List after removing element at index 2: " + list);
            System.out.println("List after adding element 6 at index 2: " + list);
        }
        /**========================
         * |     Test Stack       |
         * ========================*/
        public static void testStack() {
            Stack<Integer> stack = new Stack<>();

            stack.push(1);
            stack.push(2);
            stack.push(3);

            System.out.println(stack.peek()); // 3

            int element = stack.pop();
            System.out.println(element); // 3

            System.out.println(stack.size()); // 2

            boolean isEmpty = stack.isEmpty();
            System.out.println(isEmpty); // false

            Iterator<Integer> iterator = stack.iterator();
            while (iterator.hasNext()) {
                int value = iterator.next();
                System.out.println(value);
            }
        }
        /**========================
         * |     Test Queue       |
         * ========================*/
        public static void testQueue() {
            Queue<String> queue = new Queue<>();
            /**Add elements to the queue*/
            queue.offer("Hello");
            queue.offer("World");
            queue.offer("!");
            /**Print out size of the queue*/
            System.out.println(queue.size()); // 3
            /**Peek at the queue's front element*/
            System.out.println(queue.peek()); // Hello
            /** Poll the queue's front element*/
            System.out.println(queue.poll()); // Hello
            /**Re-check the queue's size*/
            System.out.println(queue.size()); // 2
            /**Iterate through the queue and print out*/
            for (String element : queue) {
                System.out.println(element);
            }
        }
        /**===================================
         * |     Test SinglyLinkedList       |
         * ===================================*/
        public static void testSinglyLinkedList() {
            SinglyLinkedList<String> list = new SinglyLinkedList<>();
            /**Add elements to the linked list*/
            list.addFirst("Hello");
            list.addLast("World");
            list.addLast("!");
            /**Check the SLL's size*/
            System.out.println(list.size()); //3
            /**Get the SLL's first element*/
            System.out.println(list.getFirst()); //Hello
            /**Get the SLL's last element*/
            System.out.println(list.getLast()); //!
            /**Remove the SLL's first element*/
            System.out.println(list.removeFirst()); //Hello
            /**Re-check the SLL's size*/
            System.out.println(list.size()); //2
            /**Iterate through the SLL and print out*/
            for (String element : list) {
                System.out.println(element);
            }
        }
    }
