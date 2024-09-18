package com.codegym.list;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MyList <E> {
    private int size = 0;
    private final int Default_Capacity = 10;
    private Object elements[];
    public MyList(){
        elements= new Object[Default_Capacity];
    }
    private void ensureCapacity(){
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements,newSize);
    }
    public void add(E e){
        if (size == elements.length){
            ensureCapacity();
        }
        elements[size++] = e;
    }
    public E get(int i) {
        if (i>size || i<0) {
        throw new IndexOutOfBoundsException("Index: " + i + ",Size " + i);
        }
        return (E)elements[i];
    }
}
