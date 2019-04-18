package LinkList;
//Moulue Huang
//Class 274 - 05
//Project #3- LinkedList
//Due October 18,2018

public class LinkedList {
	
	private Node head;
	
	public LinkedList()
	{
		head = null;
	}
	public void display()
	{
		Node cur = head;
		int count = 0;
		while (cur != null) 
		{
			if (count == 10) {
				count = 0;
				System.out.println("");
			}
			cur.display();
			cur = cur.getNext();
			count+=1;
		}
	}
	public int avg() {
		Node cur = head;
		int sum = 0;
		for(int i = 0; i < size(); i++) {
			sum += cur.getValue();
			cur = cur.getNext();
		}
		int answer = (int)( sum / size() );
		return answer;
	}
	
	public int remove(int position) {
		int count = 0;
		Node prev = head;
		Node cur = head;
		
		while(cur != null) { 
			if(position == count ) {
				prev.setNext(cur.getNext());
				return cur.getValue();
			}
			count++;
			prev = cur; 
			cur = cur.getNext(); 
		}
		return -1;
	}

	
	public int find(int x) {
		int position = 1; 
		Node cur = head;
		while(cur != null) {
			if( x == cur.getValue() ) {
				return position;
			}
			position ++;
			cur = cur.getNext();
		}
		return -1;
	}
				
	public int size()
	{
		int count = 0;
		Node cur = head;
		while (cur != null)
		{
			count ++;
			cur = cur.getNext();
		}
		return count;
	}
	public int add(int x) {
		Node prev = head;
		Node cur = head;
        Node temp = new Node(x);
        int count = 0;
        boolean found = false;
        if (head == null) 
        {
            head = temp;
        }
        else if (temp.getValue() <= head.getValue()) 
        {
            temp.setNext(head);
            head = temp;
        }
        else 
        {
            //prev = head;
            cur = head.getNext();
            while(cur != null) 
            {
                if (temp.getValue() >= prev.getValue() && temp.getValue() <= cur.getValue()) 
                {
                    prev.setNext(temp);
                    temp.setNext(cur);
                    found = true;
                    break;
                }
                else {
                    prev = cur;
                    cur = cur.getNext();
                    count = count + 1;
                }
            }
            if (found == false) 
            {
                prev.setNext(temp);
            }
				
		}
        return count;
	}
}
