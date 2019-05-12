import java.util.Iterator;


public class LinkedSet extends LinkedStruct {

	public void add(int i)
	{
		if(contains(i)==false)
		{
			ElementList el=new ElementList(i);
			if(first==null)
			{
				this.first=last=el;
				el.setNext(null);
			}
			else
			{
				last.setNext(el);
				last=el;
			}
		}
		else
			System.out.println( i+" already exist in the list");
	}

	// add to the list the elements of other
	public void union(Structure other)
	{
		if(!other.isEmpty())
		{
			Iterator it=((LinkedStruct) other).iterator();
			while(it.hasNext())
				this.add(((ElementList) it.next()).getValue());
		}
	}

	// remove from the list the elements not contained in other
	public void inter(Structure other)
	{
		if(this.isEmpty() || other.isEmpty())
			this.reInit();
		else
		{
			LinkedSet temp=new LinkedSet();
		    Iterator it=((LinkedStruct) other).iterator();
			while(it.hasNext())
			{
				temp.add( ((ElementList) it.next()).getValue());
			}
			Iterator it2=this.iterator();
			while(it2.hasNext())
			{
				ElementList i=(ElementList) it2.next();
				if(temp.contains(i.getValue())==false)
					this.remove(i.getValue());
				else
				{
					temp.remove(i.getValue());
				}
			}
		}
	}

	// return l1 union l2
	public Structure union(Structure s1,Structure s2)
	{
		if(s1.isEmpty())
			return s2;
		if(s2.isEmpty())
			return s1;
		LinkedSet s3=new LinkedSet();
		Iterator it1=((LinkedStruct) s1).iterator();
		while(it1.hasNext())
			s3.add(((ElementList) it1.next()).getValue());
		Iterator it2=((LinkedStruct) s2).iterator();
		while(it2.hasNext())
			s3.add(((ElementList) it2.next()).getValue());
		return s3;
	}

	// return s1 inter s2			}
	public Structure inter(Structure s1,Structure s2)
	{
		LinkedSet s3=new LinkedSet();
		if(s1.isEmpty() || s2.isEmpty())
			return s3;
		Iterator it1=((LinkedSet) s1).iterator();
		while(it1.hasNext())
			s3.add( ((ElementList) it1.next()).getValue());
		Iterator it2=s3.iterator();
		while(it2.hasNext())
		{
			ElementList i=(ElementList) it2.next();
			if(s2.contains(i.getValue())==false)
			s3.remove(i.getValue());
		}
		return s3;
	}

	public String toString()
	{
		String str=new String();
		Iterator<ElementList> it=this.randomIterator();
		str+="LinkedSet: ";
		while(it.hasNext())
			str+=it.next()+",";
		return str;
	}
}

