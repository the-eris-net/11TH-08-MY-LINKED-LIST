package my.project.mylinkedlist;

public class MyStack<T> implements StackInterface<T> {
    private final MyLinkedList<T> linkedList = new MyLinkedList<>();

    @Override
    public void push(T item) {
        linkedList.add(item);
    }

    @Override
    public T pop() {
        T ret = top();
        linkedList.delete(linkedList.getSize() - 1);
        return ret;
    }

    @Override
    public T top() {
        return linkedList.get(linkedList.getSize() - 1);
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public String toString() {
        return linkedList.toString();
    }
}
