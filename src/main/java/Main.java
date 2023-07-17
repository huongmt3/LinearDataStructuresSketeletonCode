import implementations.Stack;

import java.util.ArrayList;
import java.util.Iterator;


public class Main {
    public static void main(String[] args) {
        public static void testArrayList{
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
        public static void testStack{
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
        public static void testQueue{

        }
    }
}
