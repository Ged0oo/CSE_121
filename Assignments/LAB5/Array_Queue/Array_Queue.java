import java.util.Scanner;

interface IArrayBased { }

interface IQueue {
    void enqueue(Object item);

    Object dequeue();

    boolean isEmpty();

    int size();
}

public class ArrayQueue implements IQueue, IArrayBased {
    private int capacity;
    private int front;
    private int rear;
    private int currentSize;
    private int[] queue;

    ArrayQueue(int capacity) {
        this.front = 0;
        this.rear = -1;
        this.currentSize = 0;
        this.capacity = capacity;
        this.queue = new int[capacity];
    }

    public void enqueue(Object item) {
        if (currentSize == capacity) {
            System.out.println("Error");
            return;
        }

        if (rear == capacity - 1) {
            rear = -1;
        }

        queue[++rear] = (int) item;
        currentSize++;
    }

    public Object dequeue() {
        if (isEmpty()) {
            System.out.println("Error");
            return -100000;
        }

        int temp = queue[front++];
        if (front == capacity) {
            front = 0;
        }
        currentSize--;
        return temp;
    }

    public boolean isEmpty() {
        return (currentSize == 0);
    }

    public int size() {
        return currentSize;
    }

    public void display() {
        System.out.print("[");
        int i = size() - 1;
        while (i >= 0) {
            if (i > 0)
                System.out.print(queue[i] + ", ");
            else
                System.out.print(queue[i]);
            i--;
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        int x, p = 0;
        Object q = -100000;
        ArrayQueue queue = new ArrayQueue(500);
        Scanner sc = new Scanner(System.in);
        String sin = sc.nextLine();
        if (sin.equals("[]")) {
            p = 1;
        } else {
            String[] s = sin.replaceAll(" ", "").replaceAll("\\[", "").replaceAll("]", "").split(",");
            x = s.length;
            for (int i = s.length - 1; i >= 0; i--) {
                queue.enqueue(Integer.parseInt(s[i]));
            }
        }

        String key = sc.nextLine();

        if (key.equals("enqueue")) {
            Object m;
            m = sc.nextInt();
            queue.enqueue(m);
            queue.display();
        } else if (key.equals("dequeue")) {
            Object u;
            if (p == 0) {
                u = queue.dequeue();
                if (u == q) {
                    System.out.print("Error");
                } else {
                    int[] arr = new int[queue.size()];

                    for (int i = arr.length - 1; i >= 0; i--) {
                        arr[i] = (int) queue.dequeue();
                    }

                    System.out.print("[");
                    int i = 0;
                    while (i < arr.length) {
                        if (i < arr.length - 1)
                            System.out.print(arr[i] + ", ");
                        else
                            System.out.print(arr[i]);
                        i++;
                    }
                    System.out.print("]");
                }
            } else {
                System.out.print("Error");
            }
        } else if (key.equals("isEmpty")) {
            try {
                boolean c = queue.isEmpty();
                System.out.print(c ? "True" : "False");
            } catch (Exception e) {
                System.out.print("True");
            }
        } else if (key.equals("size")) {
            int r = queue.size();
            System.out.print(r);
        }
    }
}
