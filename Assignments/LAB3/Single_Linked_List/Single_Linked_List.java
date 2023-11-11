import java.util.*;


interface ILinkedList 
{
	public void add(int _index, Object element);
	public void add(Object element);
	public Object get(int _index);
	public void set(int _index, Object element);
	public void clear();
	public boolean isEmpty();
	public void remove(int _index);
	public int size();
	public ILinkedList sublist(int StartIndex, int EndIndex);
	public boolean contains(Object _obj);
}


class Node
{
	int data;
	Node next;
}


public class SingleLinkedList implements ILinkedList 
{
    static Node  head;
	
	
	public void add(int _index, Object element)
	{
		if(_index < 0)
		throw new NullPointerException();

		Node _node = new Node();
		_node.data =(int)element;
		_node.next = null;

		if(_index == 0)
		{
			Node n_node = head;
			_node.next = head;
			head=_node;
		}
		else
		{
			Node N_Node = head;

			for(int CounterI=0 ; CounterI<_index-1 ; CounterI++)
				N_Node = N_Node.next;     
			
			_node.next = N_Node.next;
			N_Node.next = _node; 
		} 

	}
  

    public void add(Object element)
	{
        Node _node = new Node();
        _node.data = (int)element;
        _node.next = null;
        
        if(head == null) head = _node;
        else
		{
           Node N_Node = head;
           while(N_Node.next != null) N_Node = N_Node.next;
           N_Node.next=_node;
        }
    }
      

    public Object get(int _index) 
	{
		if(_index<0)
			throw new NullPointerException();
		
		Node n_node = head;
		while(_index>0) 
		{
			n_node = n_node.next;
			_index--;
		}

		return n_node.data ;
	}
   
   
    public void set(int _index, Object element)
	{
		if(_index < 0)
		throw new NullPointerException();
		Node N_Node = head;
		for(int CounterI = 0 ; CounterI<_index ; CounterI++)
			N_Node = N_Node.next;      
		N_Node.data = (int)element;
	}
    
	
	public void clear()
	{
		if(size() == 0) return;  
		Node N_Node = head;
		while(N_Node.next != null)
		{
			Node n_node = N_Node;
			N_Node = N_Node.next;
			n_node.next = null; 
		}
		head = null;
	}
    
	
    public boolean isEmpty()
	{
        if(0 == size()) 
			return true;
        else 
			return false;            
    }
    
 
    public void remove(int _index)
	{
		if(_index < 0)
			throw new NullPointerException ();
	
		Node N_Node = head;
		if(_index == 0)
		{
			Node node_p = head;
			N_Node = N_Node.next;
			head = N_Node;
			node_p.next = null;
		}
		else
		{
			for(int CounterI=0 ; CounterI<_index-1 ; CounterI++)
				N_Node = N_Node.next;      
			
			Node Node_M, n_node;
			Node_M = N_Node.next;
			n_node = Node_M.next;
			N_Node.next = n_node;
			Node_M.next = null;
		}  
	}
	 
	 
	public int size()
	{
		Node n_node = head;
		int CounterI = 0;
		while(n_node != null) 
		{
			n_node = n_node.next;
			CounterI++;
		}
		return CounterI;
	}


	public boolean contains(Object _obj) 
	{
		Node n_node= head;
		for(int CounterI = 0 ; CounterI<size() ; CounterI++) 
		{
			if(n_node == null) 
				return false;
			
			else if(n_node.data == (int)_obj)
				return true;
			
			else
				n_node = n_node.next;     
		}
		return false;
	}
    
    
	public ILinkedList sublist(int StartIndex, int EndIndex) 
	{
        if(StartIndex > EndIndex || (StartIndex<0 || StartIndex>=size() || EndIndex<0 || EndIndex>=size()))
            throw new NullPointerException();
      
        Node N_Node = head;
        int CounterI = 0;
		
        for(CounterI = 0; CounterI < StartIndex; CounterI++)
            N_Node = N_Node.next;

		SingleLinkedList sub = new SingleLinkedList();
        head = N_Node;
         
        for (int CounterJ = CounterI ; CounterJ < EndIndex ; CounterJ++)
		{
            sub.add(N_Node.data);
            N_Node = N_Node.next;
        }
         
        N_Node.next = null;
        return sub;
	}


	public  void show() 
	{
        Node n_node = head;
        int CounterI = 0, CounterJ = size();
        System.out.print("[");        
        while(n_node != null)
		{
            System.out.print(n_node.data);
            if(CounterI != CounterJ-1)
			{
                System.out.print(", ");
                CounterI++;
            }
            n_node = n_node.next;
        }
        System.out.print("]");
    }
    

	public static void main(String[] args) 
	{
		SingleLinkedList values = new SingleLinkedList();
		int VarX;
		Object Y_Obj;
		
		Scanner input = new Scanner(System.in);
		String StringInput = input.nextLine().replaceAll("\\[|\\]", "");
		String[] str = StringInput.split(", ");
		String StrOption = input.nextLine();
	
		if (str.length != 1 || !(str[0].isEmpty())) 
		{
			for(int CounterI = 0; CounterI < str.length; ++CounterI)
			values.add ( Integer.parseInt(str[CounterI]));
		}
		try 
		{ 
			switch(StrOption) 
			{
				case "add" :
				{
					VarX = input.nextInt();
					values.add(VarX); 
					values.show();
					break;
				}
				
				case "addToIndex" :
				{
					VarX = input.nextInt();
					Y_Obj = input.nextInt();
					values.add(VarX,Y_Obj);
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
					Y_Obj = input.nextInt();      
					values.set(VarX,Y_Obj);
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
					boolean e = values.isEmpty();
					if(e == true) System.out.print("True"); 
					else System.out.print("False");    
					break;
				}
				
				case "get" : 
				{
					VarX = input.nextInt();
					Object Obj_V = values.get(VarX);
					System.out.print(Obj_V);
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
					Y_Obj = input.nextInt();
					boolean bool = values.contains(Y_Obj);
					
					if(bool == true) 
						System.out.print("True"); 
					else 
						System.out.print("False"); 
					
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