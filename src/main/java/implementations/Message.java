package implementations;

import java.util.Scanner;

public class Message {
    char[] messBuffer = new char[50];
    Queue<Character> messQueue = new Queue<>();
    public StringBuilder destMess = new StringBuilder();

    /**===================================================
     * |transfer c from source message --> message queue |
     * ===================================================*/
    public int transfer(String sourceMess) {
        int i = 0, count = 0;
        try {
            /* Transfer the characters from the source message to the messBuffer array.*/
            while (i < sourceMess.length()) {
                for (int j = 0; j < messBuffer.length; j++) {
                    if (i < sourceMess.length()) {
                        char c = sourceMess.charAt(i);
                        messBuffer[j] = c;
                        i++;
                    } else break;
                }
                /*Transfer the characters from the messBuffer array to the messQueue queue.*/
                for (int j = 0; j < messBuffer.length; j++) {
                    if (messBuffer[j] != '\0') {
                        messQueue.enqueue(messBuffer[j]);
                        messBuffer[j] = '\0';
                    } else break;
                }
                count++;
            }
            /*Transfer the characters from the messQueue queue to the destMess StringBuilder object.*/
            while (!messQueue.isEmpty()) {
                char queuedChar = messQueue.dequeue();
                destMess.append(queuedChar);
            }
            System.out.println("Message transferred: \n\u001B[36m" + destMess + "\u001B[0m");
        } catch (Exception error) {
            System.out.println("Error: " + error);
        }
        return count;
    }

    /**
     * ==================================
     * | Transferring queue of messages |
     * ==================================
     */
        public static Queue<Message> transferMess(String[] messData) {
            Queue<Message> transferredMess = new Queue<>();
            int totalBuffers = 0;
            for (String md : messData) {
                Message message = new Message();
                int buffers = message.transfer(md);
                System.out.println("Number of buffers used: \u001B[36m" + buffers + "\u001B[0m.");
                transferredMess.enqueue(message);
                totalBuffers += buffers;
            }
            System.out.println("Total number of buffers used to transfer \u001B[36m" + messData.length
                    + "\u001B[0m messages: \u001B[36m" + totalBuffers + "\u001B[0m.\n");
            return transferredMess;
        }

    /**
     * ================================
     * | Processing stack of messages |
     * ================================
     */
    public static Stack<Message> processMess(Queue<Message> transferredMess) {
        Stack<Message> processedMess = new Stack<>();
        while (!transferredMess.isEmpty()) {
            Message queuedMess = transferredMess.dequeue();
            processedMess.push(queuedMess);
        }
        return processedMess;
    }
    /**
     * ==========================================
     * | Exceptions thrown in inputting message |
     * ==========================================
     */
    public static String inputMess() throws IllegalArgumentException, IllegalStateException{
        Scanner scanner = new Scanner(System.in);
        String sourceMess = scanner.nextLine();
        if (sourceMess.length() == 0){
            System.out.println("Message length: \u001B[32m" + 0 + "\u001B[0m characters.");
            throw new IllegalArgumentException();
        }
        else if (sourceMess.length() > 250){
            System.out.println("Message length: \u001B[32m" + sourceMess.length() + "\u001B[0m characters.");
            throw new IllegalStateException();
        }
        return sourceMess;
    }
}