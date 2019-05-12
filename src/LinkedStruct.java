
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;



public abstract class LinkedStruct extends Structure {

	// list of integer that can contains many times the same value


	protected ElementList first;  // first element
	protected ElementList last;  // last element

	// constructor

	public LinkedStruct()
	{
		first=null;
		last=null;
	}
	// accessors

	public ElementList getFirst() {
		return first;
	}

	public void setFirst(ElementList first) {
		this.first = first;
	}

	public ElementList getLast() {
		return last;
	}

	public void setDernier(ElementList last) {
		this.last = last;
	}

	public void reInit()
	{
		first=null;
		last=null;
	}
	public boolean isEmpty()
	{
		return this.first==null;
	}

	// return true if the list contains value i
	public boolean contains(int i)
	{
		ElementList ptr=this.first;
		while(ptr!=null)
		{
			if(ptr.getValue()==i)
				return true;
			ptr=ptr.getNext();
		}
		return false;
	}
	public boolean remove(int i)
	{
		if(first==null)return false;
		if(first.getValue()==i)
			first=first.getNext();
		else{
		ElementList ptr=this.first;
		ElementList prec=null;
		while(ptr.getNext()!=null)
		{
			if(ptr.getValue()==i)
			{
				prec.setNext(ptr.getNext());
				return true;
			}
		    prec=ptr;
		    ptr=ptr.getNext();
		}
		if(last.getValue()==i){
			last=prec;
			last.setNext(null);
		}
		}
		return false;
	}

	// remove all element from the list with the value i
	public void removeAll(int i)
	{
		boolean b=true;
		while (b==true)
		{
			b=this.remove(i);
		}
	}

	// enumerator

	public Iterator<ElementList> iterator()
	{
		return new myIterator();
	}

	public class myIterator implements Iterator<ElementList>
	{
        private ElementList ptr=null;

		public boolean hasNext() {
			if(first==null)     // case of an empty struct
				return false;
			if(ptr==null)    //case of the first iteration
				return true;


			return (ptr.getNext()!=null);
		}

		public ElementList next() {
			if(ptr==null)
			{
				ptr=first;
				return ptr;
			}
			else
				if(ptr.getNext()!=null)
			{

				ptr=ptr.getNext();
				return ptr;
			}
			else throw new NoSuchElementException();
		  }

		public void remove() {
			throw new UnsupportedOperationException();

		}
	}
	public Iterator<ElementList> randomIterator()
	{
		return new RandomIterator();
	}
	public class RandomIterator implements Iterator<ElementList>
	{
		Random rd=new Random();
		ElementList e=null;
		int length=this.getLength();
		int[]used;
		public RandomIterator()
		{
			used=new int[length];
			for(int j=0;j<length;j++)
				used[j]=j;
		}

		public boolean hasNext() {
			return length>0;
		}
		public ElementList next() {
			int k=rd.nextInt(length);
			e=this.getElement(used[k]);
			this.remove(k);
			return e;
		}
		public void remove() {

		}
		public void remove(int k)
		{
			for(int i=k;i<length-1;i++)
				used[i]=used[i+1];
			length--;
		}
		public ElementList getElement(int k)
		{
			ElementList ptr=first;
			int i=0;
			while(ptr!=null)
			{
				if(i==k)
					return ptr;
				ptr=ptr.getNext();
				i++;
			}
			return null;
		}
		public int getLength()
		{
			ElementList ptr=first;
			int i=0;
			while(ptr!=null)
			{
				ptr=ptr.getNext();
				i++;
			}
			return i;
		}

	}
	public void copy(Structure other)
	{
	 	other.reInit();
	 	Iterator it=this.iterator();
	 	while(it.hasNext())
	 		other.add(((ElementList) it.next()).getValue());
	}
}
