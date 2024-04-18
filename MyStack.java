package ua.goit.polymorpism.Module9.HomeWork9;

import java.util.Arrays;

import java.util.Arrays;

public class MyStack<T> {

    private T[] stack;


    public MyStack() {
        stack = (T[]) new Object[0];
    }

    public void push(T value) {
        int len = this.stack.length;
        this.stack = Arrays.copyOf(this.stack, len + 1);
        this.stack[len] = value;
    }

    public void remove(int index) {
        if ((index >= this.stack.length) || (index < 0)) {
            throw new IndexOutOfBoundsException();
        }
        int indexForNewArr = 0;
        T[] tempArr = (T[]) new Object[this.stack.length - 1];
        for (int i = 0; i < this.stack.length; i++) {
            if (i == index) {
                continue;
            }
            tempArr[indexForNewArr++] = this.stack[i];
        }
        this.stack = Arrays.copyOf(tempArr, tempArr.length);

    }

    public void clear() {
        this.stack = (T[]) new Object[0];
    }

    public int size() {
        return this.stack.length;
    }

    public T peek() {
        if (this.stack.length == 0) {
            throw new IndexOutOfBoundsException();
        }
        return this.stack[this.stack.length - 1];
    }

    public T pop() {
        T deletedValue;
        if (this.stack.length == 0) {
            throw new IndexOutOfBoundsException();
        }
        deletedValue = this.stack[this.stack.length - 1];
        this.stack = Arrays.copyOfRange(this.stack, 0, this.stack.length - 1);
        return deletedValue;

    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(this.stack, 0, this.stack.length));
    }
}
