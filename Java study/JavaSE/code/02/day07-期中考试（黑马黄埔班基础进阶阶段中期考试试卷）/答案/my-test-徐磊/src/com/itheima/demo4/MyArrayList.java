package com.itheima.demo4;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<E> {
    private Object[] elementData = {};
    private int size; // 记录元素个数，记录下个位置
    private int DEFAULT_CAPACITY = 10;

    public boolean add(E e) {
        // 1、判断是否需要扩容。
        if(size == elementData.length) {
            grow();
        }
        elementData[size++] = e;
        return true;
    }


    public E get(int index) {
        // 做越界判断。
        checkIndex(index);
        // 根据索引提取数据
        return (E) elementData[index];
    }

    public E remove(int index) {
        checkIndex(index);
        E e = (E) elementData[index];
        // 删除数据应该要考虑是否需要进行元素移位操作。
        int moveFlag = size - index - 1;
        if(moveFlag != 0) {
            // 把数据进行移位操作。
           /* arraycopy(Object src,  int  srcPos,
                        Object dest, int destPos,
                        int length)*/
            System.arraycopy(elementData,
                    index + 1, elementData, index,
                    moveFlag);
        }
        // 把当前最后一个数据改成null
        elementData[--size] = null;
        return e;
    }

    public int size(){
        return size;
    }

    public void forEach(MyConsumer<E> action) {
        Objects.requireNonNull(action);
        for (int i = 0; i < size; i++) {
            action.accept((E) elementData[i]);
        }
    }

    public void checkIndex(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index + " out of max length " + size);
        }
    }

    /**
     * 扩容
     */
    private void grow() {
        if(size == 0) {
            elementData = new Object[DEFAULT_CAPACITY];
        }else {
            // 后几次扩容:变成原来的1.5倍
            elementData = Arrays.copyOf(elementData, elementData.length + (elementData.length >> 1));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            E e = (E) elementData[i];
            sb.append(e).append(i == size - 1 ? "" : ", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
