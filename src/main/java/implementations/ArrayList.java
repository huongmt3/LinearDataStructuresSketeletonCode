package implementations;

import interfaces.List;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E> implements List<E> {
    @Override
    public int size() {
        return 0;
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }
    @Override
    public boolean contains(E element) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public static final int DEFAULT_CAPACITY = 4;
    private Object[] elements;
    private int size;
    public ArrayList(){
        this.elements = new Object[DEFAULT_CAPACITY];
    }


    private E getElement(int index) {
        if (index < 0 || index > this.size) {
            return null;
        } else return get(index);
    }
    /**public static void main(String[] args) {
        }*/
        /**grow method*/
        private Object[] grow() {
            int oldCapacity = elements.length;
            int newCapacity = oldCapacity * 2;
            if (newCapacity < 0) {
                throw new OutOfMemoryError();
            }
            return Arrays.copyOf(this.elements, this.elements.length * 2);
        }
        /**Boolean add (E element)*/
        @Override
        public boolean add(E element) {
            if (this.size == this.elements.length){
                this.elements = grow();
            }
            this.elements[this.size++] = element;
            return true;
        }
        /**The insert (int index, E element) method*/
        private void insert(int index, E element) {
            if (this.size == this.elements.length){
                this.elements = grow();
            }
            E lastElement = this.getElement(this.size -1);
            for (int i = this.size - 1; i > index; i--){
                this.elements[i] = this.elements[i - 1];
            }
            this.elements[this.size] = lastElement;
            this.elements[index] = element;
            this.size++;
        }
        /**E get(int index)*/
        @Override
        public E get(int index){
            checkIndex(index);
            return this.getElement(index);
        }
        /**private E getElement(int index){
            return (E) this.elements[index];
        }*/

        /**E set (int index, E element)*/
        @Override
        public E set(int index, E element){
            checkIndex(index);
            E oldElement = this.getElement(index);
            this.elements[index] = element;
            return oldElement;
        }
        /**shrink*/
        private Object[] shrink() {
            return Arrays.copyOf(this.elements, this.elements.length / 2);
        }
        /**ensureCapacity*/
        private void ensureCapacity(){
            if (this.size < this.elements.length / 3) {
                this.elements = shrink();
            }
        }
        /**shift method*/
        private void shift(int index) {

        }
        /**E remove (int index)*/
        @Override
        public E remove(int index) {
            this.checkIndex(index);
            E element = this.getElement(index);
            this.elements[index] = null;
            this.size--;
            shift(index);
            ensureCapacity();
            return element;
        }
        /**Boolean add (int index, E element):*/
        @Override
        public boolean add(int index, E element) {
            checkIndex(index);
            insert(index, element);
            return true;
        }
        /**checkIndex method*/

        private void checkIndex(int index) {
            if (index < 0 || index >= this.size) {
                throw new IndexOutOfBoundsException(String.format("Index out of bounds : %d for size: %d", index, this.size));
            }
        }
        /**Iterator <E>*/

        @Override
        public Iterator<E> iterator() {
            Iterator<E> iterator = new Iterator<>() {
                private int index = 0;

                @Override
                public boolean hasNext() {
                    return this.index < size;
                }

                @Override
                public E next() {
                    return get(index++);
                }
            };
            return iterator;
        }
    }
/**
    @Override
    public boolean add(E element) {
        return false;
    }
    @Override
    public boolean add(int index, E element) {
        return false;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public E remove(int index) {
        return null;
    }



    @Override
    public Iterator<E> iterator() {
        return null;
    }
}*/
