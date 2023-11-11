import java.util.*;


interface IPolynomialSolver 
{
	public void setPolynomial(char PolyInput, int[][] terms);
	public String print(char PolyInput);
	public void clearPolynomial(char PolyInput);
	public float evaluatePolynomial(char PolyInput, float value);
	public int[][] add(char PolyInput1, char PolyInput2);
	public int[][] subtract(char PolyInput1, char PolyInput2);
	public int[][] multiply(char PolyInput1, char PolyInput2);
}


class Node 
{
    int data;
    int _pow;
    Node next;
}


class SingleLinkedList 
{

    public Node head;


    public void show() 
	{
        Node node_three = head;
        int CounterI = 0, CounterJ = size();

        System.out.print("[");

        while (node_three != null) 
		{
            System.out.print(node_three.data);
            if (CounterI != CounterJ - 1) 
			{
                System.out.print(", ");
                CounterI++;
            }
            node_three = node_three.next;
        }
        System.out.print("]");
    }


    public void add(int _elem, int _pow) 
	{
        Node node = new Node();
        node.data = _elem;
        node._pow = _pow;
        node.next = null;

        if (head == null) 
			head = node;
		else
		{
            Node Node_N = head;
            while (Node_N.next != null) Node_N = Node_N.next;
            Node_N.next = node;
        }

    }


    public void add(Object _elem) 
	{

        Node node = new Node();
        node.data = (int) _elem;
        node.next = null;

        if (head == null) 
			head = node;
		else 
		{
            Node Node_N = head;
            while (Node_N.next != null) 
				Node_N = Node_N.next;
            Node_N.next = node;
        }
    }


    public void add(int _index, Object _elem) 
	{
        if (_index < 0)
            throw new NullPointerException();
		
        Node node = new Node();
        node.data = (int) _elem;
        node.next = null;
		
        if (_index == 0) 
		{
            Node node_three = head;
            node.next = head;
            head = node;
        } 
		else 
		{
            Node Node_N = head;
            for (int CounterI = 0; CounterI < _index - 1; CounterI++) 
				Node_N = Node_N.next;
			
            node.next = Node_N.next;
            Node_N.next = node;
        }

    }

    
	public int size() 
	{
        Node node_three = head;
        int CounterI = 0;
        while (node_three != null) 
		{
            node_three = node_three.next;
            CounterI++;
        }
        return CounterI;
    }

    
	public void set(int _index, Object _elem) 
	{
        if (_index < 0)
            throw new NullPointerException();
		
        Node Node_N = head;
        for (int CounterI = 0; CounterI < _index; CounterI++) 
			Node_N = Node_N.next;
		
        Node_N.data = (int) _elem;
    }


    public void clear() 
	{
        if (size() == 0) return;
        Node Node_N = head;
        while (Node_N.next != null) 
		{
            Node node_three = Node_N;
            Node_N = Node_N.next;
            node_three.next = null;
        }
        head = null;
    }


    public boolean isEmpty() 
	{
        if (0 == size()) 
			return true;
        else 
			return false;
    }


    public Object get(int _index) 
	{
        if (_index < 0)
            throw new NullPointerException();
		
        Node node_three = head;
        while (_index > 0) 
		{
            node_three = node_three.next;
            _index--;
        }

        return 
			node_three.data;
    }


    public void remove(int _index) 
	{
        if (_index < 0)
            throw new NullPointerException();
		
        Node Node_N = head;
        if (_index == 0) 
		{
            Node p = head;
            Node_N = Node_N.next;
            head = Node_N;
            p.next = null;

        } 
		else 
		{
            for (int CounterI = 0; CounterI < _index - 1; CounterI++) 
				Node_N = Node_N.next;
			
            Node M, node_three;
            M = Node_N.next;
            node_three = M.next;
            Node_N.next = node_three;
			
            M.next = null;
        }
    }


    public boolean contains(Object node_two) 
	{
        Node node_three = head;
        for (int CounterI = 0; CounterI < size(); CounterI++) 
		{
            if (node_three == null) 
				return false;
            
			else if (node_three.data == (int) node_two) 
				return true;
            
			else 
				node_three = node_three.next;
        }
        return false;
    }
}


public class PolySolution implements IPolynomialSolver 
{
    static HashMap Map_W = new HashMap();
	
	
    public  void setPolynomial(char PolyInput, int[][] terms) 
    {
        SingleLinkedList list = new SingleLinkedList();
		
        for (int CounterI = 0 ; CounterI < terms.length ; CounterI++) 
            list.add(terms[CounterI][0], terms[CounterI][1]);
        
        Map_W.put(PolyInput, list);
    }

    
   
    public  String print(char PolyInput) 
    {        
        SingleLinkedList list = (SingleLinkedList)Map_W.get(PolyInput);
		String STR_Res = "";
		Node node_three = list.head;
		
		for(int CounterI=0 ; CounterI<list.size()-2 ; CounterI++) 
		{
			if(node_three.data != 0)
			{
				if(node_three.data==1) 
					STR_Res += "x^" + node_three._pow;
				
				else 
					STR_Res += node_three.data+"x^" + node_three._pow;
			}
			
			node_three = node_three.next;

			if(node_three.data> 0 && STR_Res!="")
				STR_Res += "+";
		}

		if(node_three.data!=0 && node_three._pow==1)
		{
			if(node_three.data==1)
				STR_Res += "x";
			
			else
				STR_Res += node_three.data+"x";
			  
			node_three=node_three.next;

			if(node_three.data>0 && STR_Res!="")
				STR_Res += "+";
		}

		else 
		{
			node_three=node_three.next;
			if(node_three.data>0 && STR_Res!="")
				STR_Res += "+";
		}

		if(node_three.data!=0)
			STR_Res += node_three.data;

		return STR_Res;   
    }


	public void clearPolynomial(char PolyInput) 
	{
        SingleLinkedList list = (SingleLinkedList) Map_W.get(PolyInput);
        list.clear();
        list.show();
    }

     
	public  float evaluatePolynomial(char PolyInput, float value) 
	{
        float STR_Res = 0;
        SingleLinkedList list = (SingleLinkedList) Map_W.get(PolyInput);
        Node node_three = list.head;
		
        for (int CounterI = 0; CounterI < list.size(); CounterI++) 
		{
            STR_Res += (float) (node_three.data * Math.pow((double) value, (double) node_three._pow));
            node_three = node_three.next;
        }

        return STR_Res;
    }

    
	public int[][] add(char PolyInput1, char PolyInput2) 
	{
        SingleLinkedList ListOne = (SingleLinkedList) Map_W.get(PolyInput1);
        SingleLinkedList ListTwo = (SingleLinkedList) Map_W.get(PolyInput2);
        SingleLinkedList ListThree = new SingleLinkedList();
        
        Node node_one = ListOne.head;
        Node node_two = ListTwo.head;
		Node node_three = ListThree.head;

        int _size = ListOne.size();
        if (ListOne.size() > ListTwo.size())
		{
            _size = _size - (ListOne.size() - ListTwo.size());
            for (int CounterI = 0 ; CounterI < ListOne.size() - ListTwo.size() ; CounterI++) 
			{
                ListThree.add(node_one.data, node_one._pow);
                node_one = node_one.next;
            }
        } 
		
		else if (ListTwo.size() > ListOne.size()) 
		{
            _size = _size - (ListTwo.size() - ListOne.size());
            for (int CounterI = 0; CounterI < ListTwo.size() - ListOne.size(); CounterI++) 
			{
                ListThree.add(node_two.data, node_two._pow);
                node_two = node_two.next;
            }
        }
		
        for (int CounterI = 0; CounterI < _size; CounterI++) 
		{
            int d = node_one.data + node_two.data;
            ListThree.add(d, node_one._pow);
            node_one = node_one.next;
            node_two = node_two.next;
        }

        Map_W.put('R', ListThree);
        return convertToArray(ListThree);
    }


    public int[][] subtract(char PolyInput1, char PolyInput2) 
	{
        SingleLinkedList ListOne = (SingleLinkedList) Map_W.get(PolyInput1);
        SingleLinkedList ListTwo = (SingleLinkedList) Map_W.get(PolyInput2);
        SingleLinkedList ListThree = new SingleLinkedList();

        Node node_one = ListOne.head;
        Node node_two = ListTwo.head;
		Node node_three = ListThree.head;

        int _size = ListOne.size();
        if (ListOne.size() > ListTwo.size()) 
		{
            _size = _size - (ListOne.size() - ListTwo.size());
            for (int CounterI = 0; CounterI < ListOne.size() - ListTwo.size(); CounterI++) 
			{
                ListThree.add(node_one.data, node_one._pow);
                node_one = node_one.next;
            }
        } 
		else if (ListTwo.size() > ListOne.size()) 
		{
            _size = _size - (ListTwo.size() - ListOne.size());
            for (int CounterI = 0; CounterI < ListTwo.size() - ListOne.size(); CounterI++) 
			{
                ListThree.add(node_two.data, node_two._pow);
                node_two = node_two.next;
            }
        }
        for (int CounterI = 0; CounterI < _size; CounterI++) 
		{
            int d = node_one.data - node_two.data;
            ListThree.add(d, node_one._pow);
            node_one = node_one.next;
            node_two = node_two.next;

        }

        Map_W.put('R', ListThree);
        return convertToArray(ListThree);
    }
  

    public  int[][] multiply(char PolyInput1, char PolyInput2) 
	{
        SingleLinkedList ListOne = (SingleLinkedList) Map_W.get(PolyInput1);
        SingleLinkedList ListTwo = (SingleLinkedList) Map_W.get(PolyInput2);
        SingleLinkedList ListThree = new SingleLinkedList();
		
        Node node_three = ListOne.head;
        Node Node_N = ListTwo.head;
        Node sop = ListThree.head;

        int size1 = ListOne.size(), size2 = ListTwo.size();
        for (int CounterI = 0; CounterI < size1; CounterI++)
		{
            Node_N = ListTwo.head;
            for (int CounterJ = 0; CounterJ < size2; CounterJ++) 
			{
                int coefR = node_three.data * Node_N.data;
                int expR = node_three._pow + Node_N._pow;
                ListThree.add(coefR, expR);
                Node_N = Node_N.next;
            }

            node_three = node_three.next;
        }
        Map_W.put('R', ListThree);
        return convertToArray(ListThree);

    }
	
	
   public static int[][] convertToArray(SingleLinkedList list) 
	{
        int size = list.size();
        Node node_three = list.head;
        int[][] arr = new int[size][2];
        for (int CounterI = 0; CounterI < size; ++CounterI) 
		{
            arr[CounterI][0] = node_three.data;
            arr[CounterI][1] = node_three._pow;
            node_three = node_three.next;
        }
        return arr;
    }


    public static int[][] convert(String StringInput) throws Exception 
	{
        StringInput = StringInput.replaceAll("\\[|\\]", "");
        String[] arr = StringInput.split(",");
        int[][] terms = new int[arr.length][2];
        
		if (arr.length == 0 || arr[0].isEmpty()) 
            throw new Exception();
        
		for (int CounterI = 0; CounterI < arr.length; ++CounterI) 
		{
            terms[CounterI][0] = Integer.parseInt(arr[CounterI]);
            terms[CounterI][1] = arr.length - CounterI - 1;
        }

        return terms;
    }


	static void removeDuplicates(char PolyInput) 
	{
        SingleLinkedList ListThree = (SingleLinkedList) Map_W.get(PolyInput);
        Node ptr1, ptr2, dup;
        ptr1 = ListThree.head;

        while (ptr1 != null && ptr1.next != null) 
		{
            ptr2 = ptr1;
            while (ptr2.next != null) 
			{
                if (ptr1._pow == ptr2.next._pow) 
				{
                    ptr1.data = ptr1.data + ptr2.next.data;
                    dup = ptr2.next;
                    ptr2.next = ptr2.next.next;
                } 
				else
                    ptr2 = ptr2.next;
            }
            ptr1 = ptr1.next;
        }
    }

    
	public static void main(String[] args) 
	{
        Scanner input = new Scanner(System.in);
        PolySolution GotPoly = new PolySolution();
		
		int[][] PursedArray;
        int[][] retArr;
		
		boolean _size;
        int res;
        
        while (input.hasNext()) 
		{
            String option = input.nextLine(); //set, add, sub, mul, print, eval, clear
            char PolyInput; //A or B or C
            try 
			{
                switch (option) 
				{
                    case "set": 
					{
                        PolyInput = input.nextLine().charAt(0);
                        if (PolyInput != 'A' && PolyInput != 'B' && PolyInput != 'C') 
                            throw new Exception();
						else 
						{
                            String StringInput = input.nextLine();
                            PursedArray = convert(StringInput);
                            GotPoly.setPolynomial(PolyInput, PursedArray);
                        }
                    }
                    ;
                    break;
					
                    case "print": 
					{
                        PolyInput = input.nextLine().charAt(0);
                        String re = GotPoly.print(PolyInput);
                        System.out.println(re);
                    }
                    ;
                    break;
					
                    case "eval": 
					{
                        PolyInput = input.nextLine().charAt(0);
                        float value = input.nextFloat();
                        res = GotPoly.evaluatePolynomial(PolyInput, value);
                        System.out.print(res);
                    }
                    ;
                    break;
					
                    case "clear": 
					{
                        PolyInput = input.nextLine().charAt(0);
                        GotPoly.clearPolynomial(PolyInput);
                    }
                    ;
                    break;
					
                    case "add": 
					{
                        char PolyInput1 = input.nextLine().charAt(0);
                        char PolyInput2 = input.nextLine().charAt(0);

                        GotPoly.add(PolyInput1, PolyInput2);
                        String h = GotPoly.print('R');
                        System.out.println(h);
                    }
                    ;
                    break;

                    case "sub": 
					{
                        char PolyInput1 = input.nextLine().charAt(0);
                        char PolyInput2 = input.nextLine().charAt(0);

                        GotPoly.subtract(PolyInput1, PolyInput2);
                        String h = GotPoly.print('R');
                        System.out.println(h);
                    }
                    ;
                    break;
					
                    case "mult": 
					{
                        PolyInput = input.nextLine().charAt(0);
                        char PolyInput1 = input.nextLine().charAt(0);
                        retArr = GotPoly.multiply(PolyInput, PolyInput1);
                        removeDuplicates('R');
                        String re = GotPoly.print('R');
                        System.out.print(re);
                    };
                    break;
					
                    default:
                        throw new Exception();
                }
            } 
			catch (Exception e)
			{
                System.out.print("Error");
                return;
            }
        }
    }
}