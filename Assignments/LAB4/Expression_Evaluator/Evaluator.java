import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


interface ILinkedList 
{
    public void add(int _index, Object _element);
    public void add(Object _element);
    public Object get(int _index);
    public void set(int _index, Object _element);
    public void clear();
    public boolean isEmpty();
    public void remove(int _index);
    public int size();
    public ILinkedList sublist(int _fromIndex, int _toIndex);
    public boolean contains(Object _obj);
}


interface IStack 
{
    public Object pop();
    public Object peek();
    public void push(Object _element);
    public boolean isEmpty();
    public int size();
}


interface IExpressionEvaluator 
{
    public String infixToPostfix(String _expression);
    public int evaluate(String _expression);
}


public class Evaluator implements IExpressionEvaluator 
{
    public static String []identifier = new String [3];
    
    public class MyStack implements IStack 
    {
        public class SingleLinkedList implements ILinkedList 
        { 
            public class Node
            { 
                Object objVal; 
                Node next; 
				
                public Node(Object objVal, Node newnode ) 
                { 
                    this.next = newnode; 
                    this.objVal = objVal; 
                }
            } 
         
            Node head; 
            Node tail; 
            int size; 
            
            public SingleLinkedList () 
            { 
                head = null; 
                tail = null; 
                size = 0;
            } 
             
            public void add(int _index, Object _element) 
            { 
                Node node = new Node(_element, null); 
                Node node_1; 
                Node node_2; 
                node_1 = head; 
                boolean flag = false;
                
                if((_index > size) || (_index < 0))
                { 
                    System.out.println("Error");
                    flag = true; 
                } 
                else if(0 == _index)
                {
                    node.next = head;
                    head = node;
					
                    if (0 == size) 
						tail = node;
					
                    size++;
                }
                else if(size == _index)
                {
                    if (0 == size) 
                        head = tail = node;
                    else 
                    {
                        tail.next = node;
                        tail = node;
                    }
                    size++;
                }
                else
                {
                    for(int i = 0 ; i < _index-1 ; i++) 
                        node_1 = node_1.next;
					
                    node.next=node_1.next; 
                    node_1.next=node; 
                    size++;
                }
            } 
            
            public void add(Object _element)
            { 
                Node node = new Node(_element, null); 
                if (0 == size) 
                { 
                    head = node; 
                    tail = node;
                    tail.next = null;
                    size++; 
                }
                else
                { 
                    node.next = null; 
                    tail.next = node; 
                    tail = node; 
                    size++; 
                } 
            } 
            
            public Object get(int _index) 
            { 
                Node node;
                node = head; 
                if((_index > size-1) || (_index<0)) 
                     return null;
                
                else
                { 
                    for(int i = 0 ; i < _index ; i++) 
                        node = node.next; 
                }  
                return  node.objVal; 
            } 
            
            public void set(int _index, Object _element) 
            { 
                if((_index > size-1) || (_index<0))
                { 
                    System.out.println("Error"); 
                    return; 
                } 
                 
                Node node = new Node(_element, null); 
               
                if(0 == _index)
                { 
                    node.next = head.next; 
                    head = node; 
                }
                else if(1 == _index)
                { 
                    Node node_1; 
                    Node node_2; 
                    node_1 = head; 
                    node_2 = node_1.next; 
                    node.next = node_2.next; 
                    head.next = node;     
                }
                else
                { 
                    Node node_1; 
                    Node node_2; 
                    node_1 = head; 
                    
                    for(int i=0 ; i < _index-1 ; i++)
                        node_1 = node_1.next; 
                         
                    node_2 = node_1.next; 
                    node_1.next = node; 
                    
                    if (null == node_2.next)  
                        node.next = null; 
                    else  
                        node.next = node_2.next; 
                } 
            } 
             
            public void clear()
            { 
                head = null; 
                tail = null; 
                size = 0; 
            } 
             
            public boolean isEmpty()
            { 
                if(null == head) 
                    System.out.println("True"); 
                else 
                    System.out.println("False"); 
                return (null == head); 
            } 
            
            public void remove(int _index) 
            { 
                if((size == 0) || (_index > size-1) || (_index < 0))
                {
                    System.out.println("Error");
                    return;
                }
                else if(0 == _index)
                        head=head.next;
                
                else
                {                     
                    Node node_1; 
                    Node node_2; 
                    node_1 = head; 
                    
                    for(int i = 0 ; i < _index-1 ; i++) 
                        node_1 = node_1.next; 
                    
                    node_2 = node_1.next; 
                    node_1.next = node_2.next;
                    size--;
                }
            }
            
            public int size() 
            { 
                return size; 
            } 
            
            public ILinkedList sublist(int _fromIndex, int _toIndex) 
            { 
                Node node; 
                node = head; 
                SingleLinkedList ls = new SingleLinkedList(); 
                if( (_fromIndex < 0) ||
					(_toIndex < 0)   ||
					(_fromIndex > size-1) ||
					(_toIndex > size-1) ||
					(_fromIndex >_toIndex))
                    System.out.println("Error"); 
                
                else
                { 
                    for(int i = 0 ; i < _fromIndex ; i++) 
                        node = node.next; 

                    for(int j = 0 ; j < _toIndex-_fromIndex ; j++) 
                    { 
                        ls.add(node.objVal); 
                        node = node.next; 
                    } 
                    ls.add(node.objVal); 
                } 
                return ls; 
            } 
             
            public boolean contains(Object _obj) 
            { 
                Node node; 
                node = head; 
                if(null == node)
                    return false;
                else
                {
                    while(node != null) 
                    { 
                        if((int)node.objVal == (int)_obj)
                            return true; 
                        else
                            node = node.next; 
                    }
                    return false; 
                } 
            }
        }
        
        SingleLinkedList obj = new SingleLinkedList(); 
        
        public Object pop()
        {
            Object popped = null;
            if (obj.head != null)
            {
                popped = obj.head.objVal;
                obj.head = obj.head.next;
                obj.size--;
            }
            return popped;    
            
        }
        
        public Object peek()
        {
             if (obj.head == null) 
                  return null;

            else 
                return obj.head.objVal;
        }
        
        public void push(Object _element)
        {
            obj.add(0, _element);
        }
        
        public boolean isEmpty()
        {
            if(0 == obj.size())
                return true;
            else 
                return false;
        }
        
        public int size()
        {
            return obj.size();
        }
    }
    
    public  boolean areBracketsBalanced(String expr)
    {
        int i = 0;
        MyStack stack = new MyStack();
        
        while (i < expr.length())
        {
            char ch = expr.charAt(i);
            if ((ch != '(' && ch != '[' && ch != '{') &&
			    (ch != ')' && ch != ']' && ch != '}')) 
            {
                i++;
                continue;
            } 
  
            if (ch == '(' || ch == '[' || ch == '{') 
            {
                stack.push(ch);
                i++;
                continue;
            }
  
            if (stack.isEmpty())
                return false;
            
            char check;
            switch (ch) 
            {
                case ')':
                    check = (char)stack.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;
      
                case '}':
                    check = (char)stack.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;
      
                case ']':
                    check = (char)stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
            i++;
        }
        return (stack.isEmpty());
    }
    
    static int Prec(char ch)
    {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;
        
            case '*':
            case '/':
                return 2;
        
            case '^':
                return 3;
        }
        return -1;
    }
    
    static boolean isOperator(char ch)
    {
        if(ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch =='^')
            return true;
        return false;
  }
    
    public String infixToPostfix(String _expression)
    {
        String result = new String("");
        int counter=0, i=0, j=0;      

		// Error Check for Leading Operators
		// Checks if the expression starts with an invalid operator
        if ((_expression.charAt(0) == '*') || 
		    (_expression.charAt(0) == '/') || 
			(_expression.charAt(0) == '^'))
            return "Error";
        
		// Iterates through each character of the input expression
		// loop until it encounters an operator or reaches the end of the string.
        while(j < _expression.length())
        {    
			// execute error when gettig to end of expression
            if(j == _expression.length()) 
                return "Error";
			
			// looks for the first occurrence of an operator to determine the end of the first operand
            char v = _expression.charAt(j);
            if(isOperator(v))
                break;
            
            j++;
        }
        
		// for managing operators 
        MyStack stack = new MyStack();
        
		// core of the algorithm of converting infix postfix
        while (i < _expression.length())
        {
            boolean flag = true;
            boolean found = true;
            char c = _expression.charAt(i);
        
			// If the current character is a letter or digit add to the result
            if (Character.isLetterOrDigit(c))
                result += c;
    
			// Parenthesis Handling
			// If opening parenthesis then push onto stack
            else if (c == '(')
                stack.push(c);

            else if (c == ')')
            {   
				// catch if two operators are placed consecutively without any operand in between
                if (isOperator(_expression.charAt(i-1)))
                    return "Error";
                
				// pop from stack and add to result until opening parenthesis
                while (!stack.isEmpty() && (char)stack.peek() != '(')
                    result += (char)stack.pop();
                
				// once breaking loop then their is opening parenthesis
                stack.pop();
            }
            
            else 
            {
				// the first character in the expression is a plus sign
                if((i == 0) && (c == '+'))
					// unary + at beginning doesn't affect the result
                    flag = false;
					
                // handles if two consecutive minus signs --                   
                if((c == '-') && (_expression.charAt(i+1) == '-'))
                {
					// if the consecutive minus are at the beginning
                    if (i == 0)
                    {
						// skip the second minus sign in the sequence
                        flag = false;
                        i++;
                    }
					
					// if the character preceding the current '-' is either a minus or plus sign
                    else if((_expression.charAt(i-1)=='-') || (_expression.charAt(i-1)=='+'))
                    {
                        flag = false;
                        
                        if(i != 0)
                        {
							// Pushes a plus sign
                            stack.push('+');
                            i++;
                        }
                        
                        else i++;
                    }
					
					// if the character preceding the current '-' is one of the specified operators (/ * ^).
                    else if((_expression.charAt(i-1)=='/') || 
					        (_expression.charAt(i-1)=='*') || 
							(_expression.charAt(i-1)=='^'))
                    {
                        flag = false;
                        i++;
                    }
                    else
                    {
                        flag = false;
                        if(i != 0)
                        {
                            found = false;
                            i++;
                        }
                        else i++;
                    }
                }
                
				// if + followed by - or + followed by another +
                if(c == '+')
                {
					// + followed by -
                    if(_expression.charAt(i+1) == '-')
                    {
                        flag = false;
                        stack.push('-');
                        i++;
                    }
					
					// + followed by another +
                    if(_expression.charAt(i+1) == '+')
                    {
                        flag = false;
                        if(i != 0)
                        {
                            found = false;
                            i++;
                        }
                        else 
                            i++;
                    }
                }
                
				// if - is followed by + sign
                if(c == '-')
                {
                    if(_expression.charAt(i+1) == '+')
                    {
                        flag = false;
                        stack.push('-');
                        i++;
                    }
                }
                
				// if the current character is an operator (+, -, *, /, ^)
				// catch situations where an operator is immediately followed by another operator that has higher precedence
                if (isOperator(c) && (_expression.charAt(i+1) == '*' || _expression.charAt(i+1) == '/' || _expression.charAt(i+1) == '^'))
                {
                    return "Error";
                }
               
			   
			    // The stack is not empty
				// current operator precedence less than or equal to the precedence of the operator at the top of the stack
                // flag and found are equal.
				// operators popped from stack and appended to the result in correct order based precedence
				while (!stack.isEmpty() && Prec(c)<= Prec((char)stack.peek()) && (flag == found))
                    result += (char)stack.pop();
                
                if(!found )
                {
					// converts unary minus into unary plus.
                    if(_expression.charAt(i) == '-')
                        stack.push('+');
					
					// pushes the original character onto the stack.
                    else 
                        stack.push(_expression.charAt(i));
                }
                
				// pushes the original character c onto the stack
                if(flag)
					stack.push(c);
            }
            i++;
        }
        
        while (!stack.isEmpty())
            result += (char)stack.pop();
        
        return result;
    }
    
    public int evaluate(String _expression)
    {
        MyStack stack = new MyStack();
        for(int i=0 ; i < _expression.length() ; i++)
        {
            char c = _expression.charAt(i);
            
            if(c == 'a')
                stack.push(Integer.parseInt(identifier[0]));
            
            if(c == 'b')
                stack.push(Integer.parseInt(identifier[1]));
            
            if(c == 'c')
                stack.push(Integer.parseInt(identifier[2]));
            
            if(isOperator(c))
            {
                int val1 = (int)stack.pop();
				int val2;
                
                if (true != stack.isEmpty())
                    val2 = (int)stack.pop();
                 
                else
                    val2 = 0;
                 
                switch(c)
                {
                    case '+':
                        stack.push(val2+val1);
                        break;
                     
                    case '-':
                        stack.push(val2- val1);
                        break;
                     
                    case '/':
                        stack.push(val2/val1);
                        break;
                     
                    case '*':
                        stack.push(val2*val1);
                        break;
                        
                    case '^':
                        stack.push((int)Math.pow(val2,val1));
                        break;
                }
            }
        }
        return (int)stack.pop();
    }
    
    public static void main(String[] args) 
    {        
       try
       {
            Evaluator obj = new Evaluator();
            Scanner scan = new Scanner(System.in); 
            String str = scan.nextLine();
            
            identifier[0] = scan.nextLine().replaceAll("a=", "");
            identifier[1] = scan.nextLine().replaceAll("b=", "");
            identifier[2] = scan.nextLine().replaceAll("c=", "");
            
            if(!obj.areBracketsBalanced(str))
                System.out.println("Error");
			
            else
            {
                System.out.println(obj.infixToPostfix(str));
                if(obj.infixToPostfix(str) != "Error")
                    System.out.println(obj.evaluate(obj.infixToPostfix(str)));
            }
        }
        catch(Exception e)
        {
            System.out.println("Error"); 
        }            
    }         
}