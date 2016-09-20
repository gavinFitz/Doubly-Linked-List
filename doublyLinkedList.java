import java.util.*;

public class doublyLinkedList
{
    public static void main(String args[] ) throws Exception
{
		Scanner myscanner = new Scanner(System.in);
		//enter the length of the list
        int num = Integer.parseInt(myscanner.nextLine());
		Link[] array = new Link[num];
        for (int i = 0; i < num; i++)
		{
        	array[i] = new Link(myscanner.nextLine());
        }

        for (int x = 0; x < num; x++)
        {
			int nextI = x + 1;
			int prevI = x - 1;
			if (nextI <= num -1)
			{
				array[x].next = array[nextI];

			}
			if (prevI >= 0)
			{
				array[x].previous = array[prevI];
			}
		}

        LinkedList mylist = new LinkedList();

        if(num>0)
		{
            mylist.first=array[0];
            mylist.last=array[num-1];
        }

		if(check(mylist))
		{
	   	  System.out.println("TRUE");
		}

		else if(!check(mylist))
		{
		     System.out.println("FALSE");
		}

		else
		{
		     System.out.println("empty");
		}
    }

    public static boolean check(LinkedList mylist) // this for checking if the link can go forwards and back with no mistake
	{

        Link[] checklist = new Link[100];
        Link forwards = mylist.first;

        int counter1 = 0;
        while(forwards.next != null)
        	{
            	checklist[counter1]=forwards;
            	forwards=forwards.next;
           		for(int i=0;i<counter1;i++)
            	{
                	if(forwards==checklist[i])
                	{
                    	return false;
                	}
            	}
            	counter1++;
        	}
        Link[] checklist2 = new Link[100];
        int counter2=0;
        Link backwards = mylist.last;

        while(backwards.previous != null)
        	{
          	 	checklist2[counter2]=backwards;
           	 	backwards=backwards.previous;
            	for(int i=0;i<counter2;i++)
            	{
                	if(backwards==checklist2[i])
                	{
                    	return false;
              	  	}
            	}
            counter2++;
        }

            return true;

    }
}

class Link // creates a string link
{
	public String data;
	public Link next;
	public Link previous;

    public Link(String input)
    	{
       	 	data=input;
        	next=null;
        	previous=null;
    	}
    public String print()
    {
    	String printStr = "";
		if (next == null)
			printStr = printStr + " ->(null)"; // if next is null it will show this

		if (previous == null)
			printStr = printStr + " <-(null)"; // if previous is null the it will be printed

		printStr = printStr + "[" + data + "]"; // data will be printed

		return printStr;
    }

}

class LinkedList
{
	public Link first;
    public Link last;

	public LinkedList()
	{
		first=null;
       	last=null;
	}

	public boolean isEmpty( )
		{
			return (first==null);
		}

    public void insertHead(Link insert)
    	{
        	if(isEmpty())
        		{
            		first=insert;
            		last=insert;
        		}
        	else
       		{
            	first.previous=insert;
            	insert.next=first;
            	first=insert;
        	}
    }
}


