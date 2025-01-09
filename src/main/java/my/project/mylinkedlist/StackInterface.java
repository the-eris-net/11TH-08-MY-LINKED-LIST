package my.project.mylinkedlist;

public interface StackInterface<T> {
    void push(T item);
    T top();
    T pop();
    int getSize();
}
