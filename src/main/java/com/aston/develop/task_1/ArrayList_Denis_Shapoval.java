package com.aston.develop.task_1;

import jdk.internal.util.ArraysSupport;


import java.util.*;




public class ArrayList_Denis_Shapoval<E> implements IntensiveList<E> {
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
        if(array.length>=index){
            add(index,element);
        };
        return element;
    }

    @Override
    public E remove(int index) {
        for (int i = index; i<size; i++)
            array[i] = array[i+1];
        array[size] = null;
        size--;
        if (array.length > DEFAULT_CAPACITY && size < array.length / CUT_RATE)
            resize(array.length/2); // если элементов в CUT_RATE раз меньше чем
        // длина массива, то уменьшу в два раза
        return null;
    }

    @Override
    public void clear() {
        final Object[] es = array;
        for (int to = size, i = size = 0; i < to; i++)
            es[i] = null;
    }

    @Override
    public void quickSort(Comparator comparator) {

        Arrays.sort(array, 0, size, comparator);

        comparator.compare((E) this, (E) array);
     isSorted();

    }

    @Override
    public boolean isSorted() {
        for (int i = 0; i < size - 1; i++) {
            if (((Comparable) array[i + 1]).compareTo(array[i]) < 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void split(int size) {
        checkIndex(size);
        array = Arrays.copyOfRange(array, 0, size);

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
    private void checkIndex(int index) {
        if (index >= array.length || index < 0) {
            throw new IndexOutOfBoundsException("Illegal index: " + index);
        }
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


//    @Override
//    public int compare(ArrayList_Denis_Shapoval o1, ArrayList_Denis_Shapoval o2) {
//        if(o1.size>o2.size) return 1;
//      else if (o1.size<o2.size) return -1;
//        else return 0;
//    }
    private void swap(int[] array, int ind1, int ind2) {
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }

    private void sort(E[] list, int leftIndex, int rightIndex, Comparator<E> comparator) {
        if (size == 0 || leftIndex >= rightIndex) {
            return;
        }
        E pivot = list[(leftIndex + rightIndex) / 2];
        int leftMarkerIndex = leftIndex;
        int rightMarkerIndex = rightIndex;


        while (leftMarkerIndex <= rightMarkerIndex) {
            while (comparator.compare(list[leftMarkerIndex], pivot) < 0) {
                leftMarkerIndex++;
            }
            while (comparator.compare(list[rightMarkerIndex], pivot) > 0) {
                rightMarkerIndex--;
            }
            if (leftMarkerIndex <= rightMarkerIndex) {
                E swap = list[leftMarkerIndex];
                list[leftMarkerIndex] = list[rightMarkerIndex];
                list[rightMarkerIndex] = swap;
                leftMarkerIndex++;
                rightMarkerIndex--;
            }
        }
        if (leftIndex < rightMarkerIndex) {
            sort(list, leftIndex, rightMarkerIndex, comparator);
        }
        if (rightIndex > leftMarkerIndex) {
            sort(list, leftMarkerIndex, rightIndex, comparator);
        }
    }


//    @Override
//    public int compareTo(ArrayList_Denis_Shapoval o) {
//        int lastCmp = array
//        return 0;
//    }
}
