package my.project.mylinkedlist;

interface QueueInterface<T> {
    void push(T item);
    T pop();
    T peek();
    int getSize();
}
