import java.util.Iterator;


public class List  extends LinkedStruct {
	public void add(int i)
	{
		if(contains(i)==false)
		{

		if(first==null)
		{
			ElementList el=new ElementList(i);
			this.first=last=el;
		}
		else{
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
				else{

					ElementList ptr=first;
					ElementList prec=null;
					boolean b=false;
					while(ptr.getNext()!=null && b==false)
					{
						prec=ptr;
						ptr=ptr.getNext();
						if(i<ptr.getValue())
						{
							//System.out.println("insertion between "+prec+",and "+ ptr);
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
		//else System.out.println(i +" already exist in the list");

}
	// add to the list elements from other
	public void union(Structure other)
	{
		if(!other.isEmpty()){
		Iterator it=((List) other).iterator();
		while(it.hasNext())
		{
			this.add(((ElementList) it.next()).getValue());
		}
	   }
	}

	// remove from the list elements not contains in other
	public void inter(Structure other)
	{
		if(this.isEmpty() || other.isEmpty())
			this.reInit();
		else{
		Iterator it2=this.iterator();
		while(it2.hasNext())
		{
			ElementList i=(ElementList) it2.next();
			if(other.contains(i.getValue())==false)
				this.remove(i.getValue());
			}
		}
	}

    // return list of elements contained in l1 or l2
	public Structure union(Structure l1,Structure l2)
	{
		if(l1.isEmpty())
			return l2;
		if(l2.isEmpty())
			return l1;
		List l3=new List();
		Iterator it=((List) l1).iterator();
		while(it.hasNext())
			l3.add(((ElementList) it.next()).getValue());
		Iterator it2=((List) l2).iterator();
		while(it2.hasNext())
			l3.add(((ElementList) it2.next()).getValue());
		return l3;
	}

	// return list of elements contained in l1 and l2
	public Structure inter(Structure s1,Structure s2)
	{
		List s3=new List();
		if(s1.isEmpty() || s2.isEmpty())
			return s3;

		Iterator it1=((List) s1).iterator();
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
		Iterator it=this.iterator();
		str+="List: ";
		while(it.hasNext())
			str+=it.next()+",";
		return str;
	}

}

