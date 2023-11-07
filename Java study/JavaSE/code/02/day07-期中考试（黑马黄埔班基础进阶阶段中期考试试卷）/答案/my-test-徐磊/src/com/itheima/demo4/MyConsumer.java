package com.itheima.demo4;
@FunctionalInterface
public interface MyConsumer<E> {
    void accept(E e);
}
