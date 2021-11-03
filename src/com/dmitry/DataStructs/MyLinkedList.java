package com.dmitry.DataStructs;

import java.util.Random;

public class MyLinkedList<T> {
    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    public MyLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    public MyNode<T> getHead() {
        return head;
    }
    public MyNode<T> getTail() {
        return tail;
    }

    @Override
    public MyLinkedList<T> clone() {
        MyLinkedList<T> newLL = new MyLinkedList<>();
        MyNode<T> curr = head;
        for (int i = 0; i < size; i++) {
            newLL.addLast(curr.value);
            if(i!=size-1) {
                curr = curr.next;
            }
        }
        return newLL;
    }

    public void randomMe() {
        Random random = new Random();
        MyLinkedList<T> newLL = new MyLinkedList<>();
        int iMax = size;
        for (int i = 0; i < iMax; i++) {
            int currPos = random.nextInt(size);
            MyNode<T> current = get(currPos);
            newLL.addLast(current.value);
            remove(currPos);
        }
        size = newLL.size;
        head = newLL.head;
        tail = newLL.tail;
    }

    public void randomMeCard() {
        Random random = new Random();
        MyLinkedList<T> newList = new MyLinkedList<>();
        MyNode<T> current = head;
        for (int i = 0; i < size; i++) {

            int ratio = random.nextInt(2);

            switch (ratio) {
                case 0:
                    newList.addFirst(current.value);
                    break;
                case 1:
                    newList.addLast(current.value);
                    break;
            }

            if(current.next!=null) {
                current = current.next;
            }
        }
        head = newList.head;
        tail = newList.tail;
    }

    public boolean addLast(T value) {
        MyNode<T> newNode = new MyNode<>();
        newNode.value = value;

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            MyNode<T> last = tail;
            last.next = newNode;
            tail = newNode;
        }

        this.size++;
        return true;
    }

    public boolean addFirst(T value) {
        MyNode<T> newNode = new MyNode<>();
        newNode.value = value;

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            MyNode<T> first = head;
            newNode.next = first;
            head = newNode;
        }

        this.size++;
        return true;
    }

    public MyNode<T> get(int index) {
        MyNode<T> current = head;

        int i = 0;
        while (i < index) {
            current = current.next;
            i++;
        }

        return current;
    }

    public T getValue(int index) {
        MyNode<T> current = head;

        int i = 0;
        while (i < index) {
            current = current.next;
            i++;
        }

        return current.value;
    }

    public boolean remove(int index) {
        if (index == 0) {
            head = head.next;
            size--;
            return true;
        }

        if (index == size - 1) {
            MyNode<T> penultimateElement = get(index - 1);
            penultimateElement.next = null;
            size--;
            return true;
        }

        MyNode<T> penultimateElement = get(index - 1);
        MyNode<T> nextExistingElement = penultimateElement.next.next;
        penultimateElement.next = nextExistingElement;

        size--;
        return true;
    }

    public int getCount() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(T value) {
        for (int i = 0; i < size; i++) {
            MyNode<T> current = get(i);

            if (current.value == value) {
                return true;
            }
        }

        return false;
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        MyNode<T> current = head;

        while (current != null) {
            result.append(current.value).append("  ");
            current = current.next;
        }

        return result.toString();
    }

    private class MyNode<T> {
        public T value;
        private MyNode<T> next;

        public MyNode(T value, MyNode<T> next) {
            this.value = value;
            this.next = next;
        }

        public MyNode() {
        }

        @Override
        public String toString() {
            return "MyNode{" +
                    "value=" + value +
                    ", next=" + (next == null ? " " : next.value) +
                    '}';
        }


    }


}
