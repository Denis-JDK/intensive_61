package com.aston.develop.task_1;

import jdk.internal.util.ArraysSupport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;



public class ArrayList_Denis_Shapoval<E> implements IntensiveList<E>{
    private final int INIT_SIZE = 16;
    private final int CUT_RATE = 4;
    private Object[] array = new Object[DEFAULT_CAPACITY];
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENTDATA = {};
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};


    public int size() {
        return size;
    }

    @Override
    public void add(E element) {
        if(size == array.length-1)
            resize(array.length*2); // увеличу в 2 раза, если достигли границ
        array[size++] = element;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
       // modCount++;
        final int s;
        Object[] elementData;
        if ((s = size) == (elementData = this.array).length)
            elementData = grow();
        System.arraycopy(elementData, index,
                elementData, index + 1,
                s - index);
        elementData[index] = element;
        size = s + 1;
    }

    @Override
    public E get(int index) {
        return (E) array[index];
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public E remove(int index) {
        for (int i = index; i<size; i++)
            array[i] = array[i+1];
        array[size] = null;
        size--;
        if (array.length > INIT_SIZE && size < array.length / CUT_RATE)
            resize(array.length/2); // если элементов в CUT_RATE раз меньше чем
        // длина массива, то уменьшу в два раза
    }

    @Override
    public void clear() {

    }

    @Override
    public void quickSort(Comparator<E> comparator) {

    }

    @Override
    public boolean isSorted() {
        return false;
    }

    @Override
    public void split(int size) {

    }

    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }
    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    private Object[] grow(int minCapacity) {
        int oldCapacity = array.length;
        if (oldCapacity > 0 || array != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            int newCapacity = ArraysSupport.newLength(oldCapacity,
                    minCapacity - oldCapacity, /* minimum growth */
                    oldCapacity >> 1           /* preferred growth */);
            return array = Arrays.copyOf(array, newCapacity);
        } else {
            return array = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
        }
    }
    private Object[] grow() {
        return grow(size + 1);
    }
}