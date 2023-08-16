/**import implementations.Stack;*/
import implementations.*;
import implementations.Queue;
import implementations.Stack;
import implementations.Message;
import static implementations.Message.inputMess;
import static implementations.Message.transferMess;
import static implementations.Message.processMess;



public class Main {
    public static void main(String[] args) {
        System.out.println("Enter set of messages: ");
        System.out.println("Each message can be only up to 250 characters and will be separated by a newline character.");
        System.out.println("Type 'end' if you want to end the import of messages.");
        try {
            StringBuilder messCollection = new StringBuilder();
            String inputtedMess = inputMess();
            while (!inputtedMess.equalsIgnoreCase("end")){
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
            System.out.println("Total execution time: \u001B[35m" + time + "\u991B[0m ms.");
        }
        catch (IllegalArgumentException error){
            System.out.println("\u001B[31mMessage is empty.\nProcess terminated.\u001B[0m");
        }
        catch (IllegalStateException error){
            System.out.println("\u001B[31mMessage exceeds the limit of 250 characters.\nProcess terminated.\u001B[0m");
        }
    }
}