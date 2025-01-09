package my.project.mylinkedlist;

public class QueueMain {
    public static void main(String[] args) {
        QueueInterface<String> myQueue = new MyQueue<>();

        // 6개를 동시에 추가
        myQueue.push("1st");
        myQueue.push("2nd");
        myQueue.push("3rd");
        myQueue.push("4th");
        myQueue.push("5th");
        myQueue.push("6th");
        System.out.println(myQueue);

        myQueue.pop();
        System.out.println(myQueue);

        System.out.println(myQueue.getSize());

    }
}