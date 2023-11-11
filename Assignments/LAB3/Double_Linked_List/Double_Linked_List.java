import java.util.*;
import java.math.*;


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
	public ILinkedList sublist(int fromIndex, int toIndex);
	public boolean contains(Object o);
}

class Node
{
	Object data;
	Node prev;
	Node next;
}

public class DoubleLinkedList implements ILinkedList 
{
	Node head;
	Node tail;
   
    public  void show() 
	{
        Node _node = head;
        int CounteI = 0, CounteJ = size();
        
        System.out.print("[");
        
        while(_node != null) 
		{
            System.out.print(_node.data);
            if(CounteI != CounteJ-1)
			{
                System.out.print(", ");
                CounteI++;
            }
            _node=_node.next;
        }
        System.out.print("]");
    }
      
  
    public void add(int _index, Object _element)
    {
		if(_index<0)
			throw new NullPointerException();
		
		Node node = new Node();
		node.data = _element;
		node.next = node.prev = null;
	
	   if(_index==size()) add(_element);
		   
	   
	    else if(_index==0)
		{
		    Node _node = head;
		    node.next = head;
		    node.prev = null;
		    _node.prev = node;
		    head = node;
	    }
		else 
		{
		   
		   Node _Node = head;
		   for(int CounteI=0;CounteI<_index-1;CounteI++) _Node = _Node.next; 
		   node.next = _Node.next;
		   node.prev = _Node;
		   _Node.next = node; 
	    }
	}  


	public void add(Object _element) 
	{
		Node node = new Node();
		node.data = _element;
		if(size() == 0) 
		{
			head = tail = node;
			node.next=node.prev = null;
		}
		else 
		{
			node.next = null;
			node.prev = tail;
			tail.next = node;
			tail = node;
		}
	}
  
  
    public Object get(int _index) 
	{
        if(_index<0)
            throw new NullPointerException();
		
        Node _node = head;
        while(_index>0) 
		{
            _node = _node.next;
            _index--;
        }
		
        return _node.data ;    
    }
	
    
	public void set(int _index, Object _element)
	{
        if(_index<0)
            throw new NullPointerException();
		
        Node _Node = head;
        for(int CounteI=0;CounteI<_index;CounteI++) _Node = _Node.next;    
        _Node.data=_element;
    }
     
 
	public void clear()
	{
        if(size()==0) return;  
        Node _Node = head;
        while(_Node.next!=null)
		{
            Node _node=_Node;
           _Node=_Node.next;
           _node.next=null;
           _node.prev=null;
        }
        head=null;
    }
    
	
    public boolean isEmpty()
	{
        if(size()==0)  return true;
        else  return false;
    }
    
	
    public void remove(int _index)
	{
		if(_index<0)
			throw new NullPointerException ();
	
        Node _Node = head;
        if(_index == 0)
		{
            Node p = head;
            _Node = _Node.next;
            head = _Node;
            _Node.prev = null;
            p.next = null;
        }
		else if(_index == size()-1)
		{
            Node t = tail;
            Node s = t.prev;
            tail = s;
            s.next = null;
            t.prev = null;
     
        }
		else
		{
			for(int CounteI=0 ; CounteI<_index-1 ; CounteI++) _Node = _Node.next;              
			
			Node M,_node;
			M = _Node.next;
			_node = M.next;
			
			_Node.next = _node;
			_node.prev = _Node;    
			
			M.next = null;
			M.prev = null;
        }  
        
    }
    
	
    public int size()
	{
        Node _node= head;
        int CounteI=0;
        while(_node!=null) 
		{
            _node=_node.next;
            CounteI++;
        }
        return CounteI;
    }
  

    public boolean contains(Object o) 
	{
		Node _node= head;
		for(int CounteI=0 ; CounteI<size(); CounteI++) 
		{
			if(_node==null) return false;
			else if(_node.data==o) return true;
			else _node=_node.next;    
		}
		return false;
    }
    
	
	public ILinkedList sublist(int fromIndex, int toIndex) 
	{
		if(fromIndex > toIndex || (fromIndex<0 || fromIndex>=size() || toIndex<0 || toIndex>=size()))
			throw new NullPointerException();
		
		Node _Node = head;
		int CounteI = 0;
		for (CounteI = 0; CounteI < fromIndex; CounteI++) _Node = _Node.next;
		
		DoubleLinkedList sub = new DoubleLinkedList();
		_Node.prev = null;
		head = _Node;
		
		for (int CounteJ = CounteI; CounteJ < toIndex; CounteJ++)
		{
			sub.add(_Node.data);
			_Node = _Node.next;
		}
		
		_Node.next = null;
		return sub;
	}
    
	public static void main(String[] args) 
	{
		DoubleLinkedList values = new DoubleLinkedList();
		int VarX;
		Object _obj;
		Scanner input = new Scanner(System.in);
		String sin = input.nextLine().replaceAll("\\[|\\]", "");
		String[] s = sin.split(", ");
		String option = input.nextLine();
	
		if (s.length != 1 || !(s[0].isEmpty())) 
		{
			for(int CounteI = 0; CounteI < s.length; ++CounteI)
			{
				values.add ( Integer.parseInt(s[CounteI]));
			}
		}
		try 
		{ 
			switch(option) 
			{
				case "add" :
				{
					VarX = input.nextInt();
					values.add(VarX); 
					values.show();
					break;
				}
				
				case "addToIndex":
				{
					VarX = input.nextInt();
					_obj = input.nextInt();
					values.add(VarX,_obj);
					values.show();
					break;
				}
				
				case "size" :
				{
					
					int Val = values.size();
					System.out.print(Val);
					break;
				}
				
				case "set" :
				{
					VarX = input.nextInt();
					_obj = input.nextInt();      
					values.set(VarX,_obj);
					values.show();
					break;
				}
				
				case "clear" :
				{
					values.clear();
					values.show();
					break;
				}
				
				case "isEmpty" :
				{
					boolean bool = values.isEmpty();
					if(bool == true) System.out.print("True"); 
					else System.out.print("False");     
					break;
				}
				
				case "get" :
				{
					VarX = input.nextInt();
					Object v = values.get(VarX);
					System.out.print(v);
					break;
					
				}
				
				case "remove" :
				{
					VarX = input.nextInt();
					values.remove(VarX);
					values.show(); 
					break;
				}
				
				case "contains" :
				{
					_obj = input.nextInt();
					boolean _bool = values.contains(_obj);
					if(_bool == true) System.out.print("True"); 
					else System.out.print("False");    
					break;
				}
				
				case "sublist" :
				{
					int a = input.nextInt();
					int b = input.nextInt();
					values.sublist(a, b);
					values.show(); 
					break;
				}
			}         
		} 
		catch( NullPointerException ex) 
		{
			System.out.print("Error");  
		}
	}
}