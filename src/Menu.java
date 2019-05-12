import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;


public class Menu {


	private Structure[] s;


	public Menu()
	{
		this.s=new Structure[3];
		this.command();
	}

	public void selectStruct()
	{
		Scanner sc=new Scanner(System.in);
		int i;
		do
		{
			System.out.println("Select a Column");
			try
			{
				i=sc.nextInt();
			}
			catch (InputMismatchException e)
			{
				System.out.println("enter a value to add");
				i=1;
			}
		}while(i<1 || i>2);

		System.out.println("Choose a structure type: \n"+
		"0:Set\n1:MultiSet\n2:LinkedSet\n3:MultiLinkedSet\n4:List\n5:MultiList");
		int k=sc.nextInt();
		switch(k)
		{
			case 0: s[i-1]=new Set();break;
		    case 1: s[i-1]=new MultiSet();break;
		    case 2: s[i-1]=new LinkedSet();break;
		    case 3: s[i-1]=new MultiLinkedSet();break;
		    case 4: s[i-1]=new List();break;
		    case 5: s[i-1]=new MultiList();break;
		    default: s= null;
		 }

	}

	public void command()
	{
		int i=0;
		do{

		System.out.println("List 1: "+this.s[0]+"\nList 2: "+this.s[1]+"\nresult: "+this.s[2]);
		System.out.println("select an operation:\n1:create\n2:delete\n3:add\n4:remove\n" +
				"5:removeAll\n6:union\n7:inter\n8:réinitialiser\n9:transfert\n10:quitter");
		Scanner sc=new Scanner(System.in);
		i=sc.nextInt()-1;
		switch(i)
		{
		case 0:this.create();break;
		case 1:this.delete();break;
		case 2:this.add();break;
		case 3:this.remove();break;
		case 4:this.removeAll();break;
		case 5:this.union();break;
		case 6:this.inter();break;
		case 7:this.reInit();break;
		case 8:this.transfert();break;
		default:break;
		}
		}while(i<9);

	}

	public void create()
	{
		this.selectStruct();
	}

	public void delete()
	{
		System.out.println("choose a column");
		Scanner scn=new Scanner(System.in);
		s[scn.nextInt()-1]=null;
	}

	public void add(){
		Scanner scn=new Scanner (System.in);
		System.out.println("enter: N°list value");
		String command=scn.nextLine();
		Scanner sc=new Scanner(command);
		s[(sc.nextInt())-1].add(sc.nextInt());

	}

	public void remove() {
		Scanner scn=new Scanner (System.in);
		System.out.println("enter: N°list value");
		String command=scn.nextLine();
		Scanner sc=new Scanner(command);
		s[(sc.nextInt())-1].remove(sc.nextInt());

	}

	public void removeAll()
	{
		Scanner scn=new Scanner (System.in);
		System.out.println("enter: N°list value");
		String command=scn.nextLine();
		Scanner sc=new Scanner(command);
		(s[(sc.nextInt())-1]).removeAll(sc.nextInt());
	}

	public void union()
	{
		s[2]=s[0].union(s[1],s[0]);
	}

	public void inter()
	{
		s[2]=s[0].inter(s[1],s[0]);
	}

	public void reInit()
	{
		Scanner scn=new Scanner (System.in);
	    System.out.println("enter: N°list ");
	    s[(scn.nextInt())-1].reInit();
	}

	public void transfert()
	{
		Scanner scn=new Scanner (System.in);
		System.out.println("enter: sourceList  dirList");
		String command=scn.nextLine();
		Scanner sc=new Scanner(command);
		int i1=sc.nextInt();int i2=sc.nextInt();
		s[i1-1].copy(s[i2-1]);
		s[i1-1].reInit();
	}
}