import java.util.Scanner;

class Node 
{
    Object element;
    Node nextNode;
}

class SingleLinkedList 
{
    public int size = 0;
    public Node head;

    public void add(Object element) 
	{
        Node node = new Node();
        node.element = element;
        node.nextNode = null;

        if (null == head)
            head = node;
        else 
		{
            Node tempNode = head;
            while (null != tempNode.nextNode)
                tempNode = tempNode.nextNode;
            tempNode.nextNode = node;
        }
        size++;
    }

    public void add(int index, Object element) 
	{
        Node tempNode = head;
        Node afterNode = new Node();
        Node node = new Node();
        node.element = element;

        int i = 0;
        if (0 == index) 
		{
            head = node;
            node.nextNode = tempNode;
        } 
		else 
		{
            while (i < (index - 1))
			{
                tempNode = tempNode.nextNode;
                i++;
            }
            afterNode = tempNode.nextNode;
            tempNode.nextNode = node;
            node.nextNode = afterNode;
        }
        size++;
    }

    public Object get(int index) 
	{
		int i = 0;
        Node tempNode = head;
		
        while (i < index) 
		{
            tempNode = tempNode.nextNode;
            i++;
        }
		
        return tempNode.element;
    }

    public void set(int index, Object element) 
	{
		int i = 0;
        Node tempNode = head;
        
        while (i < index) 
		{
            tempNode = tempNode.nextNode;
            i++;
        }
		
        tempNode.element = element;
    }

    public void remove(int index) 
	{
		int i = 0;
        Node tempNode = head;
        
        if (index == 0)
            head = tempNode.nextNode;
		
        else 
		{
            while (i < index - 1) 
			{
                tempNode = tempNode.nextNode;
                i++;
            }
            tempNode.nextNode = tempNode.nextNode.nextNode;
        }
		
        size--;
    }

    public int size() 
	{
        return size;
    }

    public void clear() 
	{
        head = null;
        size = 0;
    }

    public boolean isEmpty() 
	{
        return (null == head);
    }

    public boolean contains(Object element) 
	{
        Node tempNode = head;
		boolean flag = false;
        		
        for (int i = 0; i < size; i++) 
		{
            if (tempNode.element.equals(element))
                flag = true;

            tempNode = tempNode.nextNode;
        }
		
        return flag;
    }

    public void printTorf(boolean state) 
	{
        if (state)
            System.out.print("True");
        else
            System.out.print("False");
    }

    public void printSinglell() 
	{
        int i = 0;

        if (null == head)
            System.out.print("[]");
		
        else 
		{
            Node tempNode = head;
            System.out.print("[");
			
            while (tempNode.nextNode != null)
			{
                System.out.print(tempNode.element);
				
                if (i < size - 1)
                    System.out.print(", ");
                
				tempNode = tempNode.nextNode;
                i++;
            }
			
            System.out.print(tempNode.element);
            System.out.print("]");
        }
    }
}

interface IStack 
{
    public Object pop();
    public Object peek();
    public void push(Object element);
    public boolean isEmpty();
    public int size();
}


public class MyStack implements IStack 
{
    SingleLinkedList _stack = new SingleLinkedList();

    public void push(Object element) 
	{
        _stack.add(0, element);
    }

    public Object pop() 
	{
        Object _element = _stack.get(0);
        _stack.remove(0);
        return _element;
    }

    public Object peek() 
	{
        return _stack.get(0);
    }

    public boolean isEmpty() 
	{
        return _stack.isEmpty();
    }

    public int size() 
	{
        return _stack.size();
    }

    public static void main(String[] args) 
	{
        MyStack myStack = new MyStack();
        Scanner _scan = new Scanner(System.in);
		
        String str = _scan.nextLine().replaceAll("\\[|\\]", "");
        String[] _str = str.split(", ");

        if ((1 == _str.length) && (_str[0].isEmpty()))
            myStack = new MyStack();
		
        else 
		{
            for (int i = 0 ; i < _str.length ; i++)
				myStack._stack.add(Integer.parseInt(_str[i]));
        }

        String operation = _scan.nextLine();
        int _element;

        switch (operation) 
		{
            case "push":
                _element = Integer.parseInt(_scan.nextLine());
                myStack.push(_element);
                myStack._stack.printSinglell();
                break;

            case "pop":
                if (myStack._stack.size() == 0) 
                    System.out.print("Error");
				else 
				{
                    myStack.pop();
                    myStack._stack.printSinglell();
                }
                break;

            case "peek":
                if (myStack._stack.size() == 0)
                    System.out.print("Error");
                else
                    System.out.print(myStack.peek());
                break;

            case "isEmpty":
                myStack._stack.printTorf(myStack.isEmpty());
                break;

            case "size":
                System.out.print(myStack.size());
                break;
        }
    }
}