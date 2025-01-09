package my.project.mylinkedlist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyLinkedList<T> implements LinkedListInterface<T> {
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;


    @Override
    public void add(T data) {
        addIfEmptyElse(data);
        size++;
    }

    private void addIfEmptyElse(T data) {
        if (head == null) {
            head = new Node<>(data);
            tail = head;
            return;
        }
        tail.setNext(new Node<>(data));
        tail = tail.getNext();
    }

    @Override
    public T get(int targetIndex) {
        if (checkValidBound(targetIndex)) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> currentNode = head;
        int currentIndex = 0;
        while (currentIndex < targetIndex) {
            currentNode = currentNode.getNext();
            currentIndex++;
        }
        return currentNode.getData();
    }

    @Override
    public void delete(int targetIndex) {
        if (checkValidBound(targetIndex)) {
            throw new IndexOutOfBoundsException();
        }
        if (targetIndex == 0) {
            deleteIfIndexIsZero();
            return;
        }
        deleteIfIndexIsNotZero(targetIndex);
    }

    private void deleteIfIndexIsNotZero(int targetIndex) {
        Node<T> current = head;
        int currentIndex = 0;
        /*
         * targetIndex - 1이 일종의 방어로직을 하게 되서 current.getNext()가 null이 되는 경우는 없다.
         */
        while (currentIndex < targetIndex - 1) {
            current = current.getNext();
            currentIndex++;
        }
        /*
         * current.getNext().getNext() == null이라는 것은 현재 지정된 삭제하기전의 앞 노드(current)의 다음 노드(삭제할 노드)가 마지막 노드였다는 것이므로 tail을 current로 변경한다.
         */
        if (current.getNext().getNext() == null) {
            tail = current.getNext();
        }
        /*
         * 사실 상 원하는 로직
         */
        current.setNext(current.getNext().getNext());
        size--;
    }

    private void deleteIfIndexIsZero() {
        head = head.getNext();
        size--;
    }

    private boolean checkValidBound(int targetIndex) {
        return targetIndex < 0 || targetIndex >= size;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        List<String> result = new ArrayList<>();
        Node<T> current = head;
        while (current != null) {
            result.add(current.getData().toString());
            current = current.getNext();
        }
        return String.join(" -> ", result);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.getData();
                current = current.getNext();
                return data;
            }
        };
    }
}
