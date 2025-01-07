package my.project.mylinkedlist;

public interface LinkedListInterface<T> extends Iterable<T> {
    void add(T data);

    T get(int index);

    void delete(int index);

    int getSize();
}

