import implementations.Queue;
import implementations.Stack;
import implementations.Message;
import org.junit.jupiter.api.Test;
/*import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.fail;*/

import static implementations.Message.inputMess;
import static implementations.Message.transferMess;
import static implementations.Message.processMess;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class Main {
    public static void main(String[] args) {
        appTest();
    }

    public static void appTest() {
        System.out.println("Enter set of messages: ");
        System.out.println("Each message can be only up to 250 characters and will be separated by a newline character.");
        System.out.println("Type 'end' if you want to end the import of messages.");
        try {
            StringBuilder messCollection = new StringBuilder();
            String inputtedMess = inputMess();
            while (!inputtedMess.equalsIgnoreCase("end")) {
                System.out.println("Message length: \u001B[32m" + inputtedMess.length() + "\u001B[0m characters.");
                messCollection.append(inputtedMess).append("\n");
                inputtedMess = inputMess();
            }
            System.out.println();
            long start = System.currentTimeMillis();
            String[] messData = messCollection.toString().split("\n");
            Queue<Message> transferredMess = transferMess(messData);
            Stack<Message> processedMess = processMess(transferredMess);
            System.out.println("Message in stack to be processed: ");
            for (Message mess : processedMess)
                System.out.println("\u001B[35m" + mess.destMess + "\u001B[0m");
            long end = System.currentTimeMillis();
            long time = end - start;
            System.out.println("Total execution time: \u001B[35m" + time + "\u001B[0m ms.");
        } catch (IllegalArgumentException error) {
            System.out.println("\u001B[31mMessage is empty.\nProcess terminated.\u001B[0m");
        } catch (IllegalStateException error) {
            System.out.println("\u001B[31mMessage exceeds the limit of 250 characters.\nProcess terminated.\u001B[0m");
        } catch (OutOfMemoryError error) {
            System.out.println("\u001B[31mThe StringBuilder object is too large.\nProcess terminated.\u001B[0m");
        }
    }


    /*@Test
    public void testEmptyMessage() {
        try{
            String sourceMess = "";
            Message message = new Message();
            message.transfer(sourceMess);
        } catch (IllegalArgumentException error) {
        System.out.println("\u001B[31mMessage is empty.\nProcess terminated.\u001B[0m");
        }
    }*/

    public static class MessageTest {

        @Test
        public void testMultipleMessages() {
            String[] messages = { "Message 1", "Message 2", "Message 3" };
            Queue<Message> transferredMess = Message.transferMess(messages);
        }
        @Test
        public void testTransferInteger() {
            Message message = new Message();
            int buffers = message.transfer("helloo");
        }
        @Test
        public void testTransfer() {
            String sourceMess = "Test the integrity of the message content after being transferred using JUnit";
            Message message = new Message();
            message.transfer(sourceMess);
            /*assertEquals(sourceMess, message.destMess.toString()); thua*/
        }
    }


    /*public static void buffersTest() {
        File file = new File("C:\\Users\\ADMIN\\Desktop\\1649\\1649\\Linear Data Structures Sketeleton Code\\src\\main\\java\\implementations\\test.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("The file test.txt could not be found.");
            System.exit(1);
        }
        String[] messages = new String[1232];
        int i = 0;
        while (scanner.hasNextLine()) {
            messages[i] = scanner.nextLine();
            i++;
        }
        appTest();
        processMessages(messages);
    }

    private static void processMessages(String[] messages) {
        for (String message : messages) {
            System.out.println(message);
        }
    }*/

}
