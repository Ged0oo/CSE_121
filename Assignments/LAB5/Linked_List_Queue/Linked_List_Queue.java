import java.util.Scanner;

interface ILinkedBased { }

interface IQueue {
    void enqueue(Object item);

    Object dequeue();

    boolean isEmpty();

    int size();
}

public class LinkedListQueue implements IQueue, ILinkedBased {
    public class Node {
        Object data;
        Node next;
    }

    Node front = null;
    Node rear = null;

    public static void main(String[] args) {
        int x, p = 0;
        Object q = -99;

        LinkedListQueue queue = new LinkedListQueue();
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
                    queue.display();
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

    public void enqueue(Object item) {
        Node newNode = new Node();
        newNode.data = item;
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public Object dequeue() {
        try {
            if (front == null) {
                return -99;
            } else {
                Object dequeuedData = front.data;
                front = front.next;
                if (front == null) {
                    rear = null;
                }
                return dequeuedData;
            }
        } catch (Exception e) {
            return 0;
        }
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        int size = 0;
        Node currentNode = front;
        while (currentNode != null) {
            size++;
            currentNode = currentNode.next;
        }
        return size;
    }

    public void display() {
        Object[] array = new Object[100];
        Node currentNode = front;
        int k = 0;
        while (currentNode != null) {
            array[k] = currentNode.data;
            k++;
            currentNode = currentNode.next;
        }
        System.out.print("[");
        int i = k - 1;
        while (i >= 0) {
            if (i > 0) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.print(array[i]);
            }
            i--;
        }
        System.out.print("]");
    }
}
