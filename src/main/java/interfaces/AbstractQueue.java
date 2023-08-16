package interfaces;

public interface AbstractQueue<E> extends Iterable<E> {
    void offer(E element);
    E poll();

    void enqueue(E element);

    E dequeue();

    E peek();
    int size();
    boolean isEmpty();
}
