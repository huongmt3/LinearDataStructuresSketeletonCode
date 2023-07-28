package implementations;

import interfaces.List;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 4;
    private Object[] elements;
    private int size;
    public ArrayList(){
        elements = new Object[DEFAULT_CAPACITY];
    }
        /**grow method*/
        private Object[] grow() {
            return Arrays.copyOf(elements, elements.length * 2);
        }
        /**Boolean add (E element)*/
        @Override
        public boolean add(E element) {
            if (elements.length == size)
                elements = grow();
            elements[size++] = element;
            return true;
        }
    /**checkIndex method*/
    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of bounds: "+ index + " out of" + size);
    }
    /**Boolean add (int index, E element):*/
    @Override
    public boolean add(int index, E element) {
        checkIndex(index);
        if (elements.length == size)
            elements = grow();
        for (int i = size; i >= index + 1; i--)
            elements[i] = elements[i-1];
        elements[index] = element;
        size++;
        return true;
    }
        /**The insert (int index, E element) method
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
        }*/
        private E getElement(int index) {return (E)elements[index];}
        /**E get(int index)*/
        @Override
        public E get(int index){
            checkIndex(index);
            return getElement(index);
        }
        /**E set(int index, E element)*/
        @Override
        public E set(int index, E element){
            checkIndex(index);
            elements[index] = element;
            return null;
        }
        /**shrink*/
        private Object[] shrink() {
            return Arrays.copyOf(elements, elements.length / 2);
        }
        /**getCapacity*/
        public int getCapacity() { return elements.length;}
        /**ensureCapacity*/
        private void ensureCapacity(){ if (size < elements.length / 3) shrink(); }
        @Override
        public int size() {return size;}
        @Override
        public boolean contains(E element) {return indexOf(element) != -1;}
        @Override
        public boolean isEmpty() {return size ==0;}

        /**shift method
        private void shift(int index) {
            for (int i = index; i < size - 1; i++) {
                elements[i] = elements[i + 1];
            }
            elements[size - 1] = null;
        }*/
        /**E remove (int index)*/
        @Override
        public E remove(int index) {
            checkIndex(index);
            E element = getElement(index);
            for (int i = index; i < size -1; i++)
                elements[i] = elements[i+1];
            size--;
            /*shift(index);*/
            ensureCapacity();
            return element;
        }
    /**toString*/
        public String toString(){
            StringBuilder result = new StringBuilder();
            result.append("[");
            for (int i = 0; i < size; i++){
                if (i==size-1)result.append(elements[i]+ "]");
                else result.append(elements[i] + ",\n");
            }
            return result.toString();
        }
        /**Iterator <E>*/
        @Override
        public int indexOf(E element) {
            return 0;
        }
        @Override
        public Iterator<E> iterator() {
            return new Iterator<>() {
                private int index = 0;
                @Override
                public boolean hasNext() {
                    return index < size;
                }
                @Override
                public E next() {
                    E element = getElement(index);
                    index++;
                    return element;
                }
            };
        }
        public static class Student {
            private int id;
            private String name;
            private int age;
            private double grade;
            public Student(int id, String name, int age, double grade) {
                toString();
            }
            public int getId() {return id;}
            public void setId(int id) { this.id = id;}
            public String getName() {return name;}
            public void setName(String name) {this.name = name;}
            public int getAge() {return age;}
            public void setAge(int age) {this.age = age;}
            public double getGrade() {return grade;}
            public void setGrade(double grade) {this.grade = grade;}
            public String toString() {return "ID: " + id + "| Name: " + name + "| Age: " + age + "| Grade: " + grade;}
    }
}

