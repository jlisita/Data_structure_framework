import java.util.Iterator;


public class MultiList extends LinkedStruct {

	public void add(int i)
	{
		if(first==null)
		{
			ElementList el=new ElementList(i);
			this.first=last=el;
		}
		else
		{
			if(i<=first.getValue())
			{
				ElementList e =new ElementList(i);
				e.setNext(this.getFirst());
				this.setFirst(e);
			}
			else
			{
				if(i>=last.getValue())
				{
					ElementList e=new ElementList(i);
					this.last.setNext(e);
					last=e;
				}
				else
				{
					ElementList ptr=first;
					ElementList prec=null;
					boolean b=false;
					while(ptr.getNext()!=null && b==false)
					{
						prec=ptr;
						ptr=ptr.getNext();
						if(i<ptr.getValue())
						{
							//System.out.println("insertion between "+prec+", and "+ ptr);
							ElementList e=new ElementList(i);
							prec.setNext(e);
							e.setNext(ptr);
							b=true;
						}
					}
				}
			}
		}
	}

	// add to the list the elements of other
	public void union(Structure other)
	{
		if(!other.isEmpty())
		{
			Iterator it=((MultiList) other).iterator();
			while(it.hasNext())
			{
				this.add(((ElementList) it.next()).getValue());
			}
		}
	}

	// remove from the list the elements not contained in other
	public void inter(Structure other)
	{
		if(this.isEmpty() || other.isEmpty())
			this.reInit();
		else
		{
			MultiList temp=new MultiList();
			Iterator it=((MultiList) other).iterator();
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

	// return s1 union s2
	public Structure union(Structure s1,Structure s2)
	{
		if(s1.isEmpty())
			return s2;
		if(s2.isEmpty())
			return s1;
		MultiList s3=new MultiList();
		Iterator it1=((LinkedStruct) s1).iterator();
		while(it1.hasNext())
			s3.add(((ElementList) it1.next()).getValue());
		Iterator it2=((LinkedStruct) s2).iterator();
		while(it2.hasNext())
			s3.add(((ElementList) it2.next()).getValue());
		return s3;
	}

	// return s1 inter s2
	public Structure inter(Structure s1,Structure s2)
	{
		MultiList s3=new MultiList();
		if(s1.isEmpty() || s2.isEmpty())
			return s3;
		MultiList temp=new MultiList();
		Iterator it=((MultiList) s2).iterator();
		while(it.hasNext())
			temp.add( ((ElementList) it.next()).getValue());

		Iterator it1=((MultiList) s1).iterator();
		while(it1.hasNext())
			s3.add( ((ElementList) it1.next()).getValue());

		Iterator it2=s3.iterator();
		while(it2.hasNext())
		{
			ElementList i=(ElementList) it2.next();
			if(temp.contains(i.getValue())==false)
				s3.remove(i.getValue());
			else
			{
				temp.remove(i.getValue());
			}
		}
		return s3;
	}

	public String toString()
	{
		String str=new String();
		Iterator<ElementList> it=this.iterator();
		str+="MultiList: ";
		while(it.hasNext())
			str+=it.next()+",";
		return str;
	}
}
