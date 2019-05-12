import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class Window extends JFrame {


	private Structure[]s=new Structure[3]; // contain the 3 structures of columns

	JLabel []l=new JLabel[3];
	JButton b1= new JButton("Create");
	JButton b2= new JButton("Convert");
	JButton b3= new JButton("Add");
	JButton b4= new JButton("Remove");
	JButton b5= new JButton("RemoveAll");
	JButton b6= new JButton("Union");
	JButton b7= new JButton("Inter");
	JButton b8= new JButton("Transfert");
	public Window()
	{
		this.setTitle(" ");
		this.setSize(1000, 250);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		b1.addMouseListener(new Controler1());
		b2.addMouseListener(new Controler9());
		b3.addMouseListener(new Controler3());
		b4.addMouseListener(new Controler4());
		b5.addMouseListener(new Controler5());
		b6.addMouseListener(new Controler6());
		b7.addMouseListener(new Controler7());
		b8.addMouseListener(new Controler8());

		for(int i=0;i<3;i++){
			l[i]=new JLabel();
			l[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			l[i].setText("Empty");
		}
		JPanel pan=new JPanel();
		JPanel jp1=new JPanel();

		GridLayout gl1=new GridLayout(1,3);
		jp1.setLayout(gl1);
		jp1.add(l[0]);
		jp1.add(l[1]);
		jp1.add(l[2]);
		JPanel jp2=new JPanel();
		GridLayout gl2=new GridLayout(2,4);
		jp2.setLayout(gl2);
		jp2.add(b1);
		jp2.add(b2);
		jp2.add(b3);
		jp2.add(b4);
		jp2.add(b5);
		jp2.add(b6);
		jp2.add(b7);
		jp2.add(b8);
		GridLayout gl3=new GridLayout(2,1);
		pan.setLayout(gl3);
		pan.add(jp1);
		pan.add(jp2);
		this.setContentPane(pan);

		this.setVisible(true);
	}

	// create a new type of column
	public class Controler1 implements MouseListener
	{
		public void mouseClicked(MouseEvent arg0) {
			try {
				Integer []column={1,2};
				Integer j=(Integer) JOptionPane.showInputDialog(null,"Select a column",null,JOptionPane.QUESTION_MESSAGE,null,column, column[0]);
				int i=j.intValue();
				Structure []type={new Set(),new MultiSet(),new LinkedSet(),new MultiLinkedSet(),new List(),new MultiList()};
				Structure name=(Structure) JOptionPane.showInputDialog(null,"Select a type of list",null,JOptionPane.QUESTION_MESSAGE,null,type, type[0]);
				s[i-1]=name;
				l[i-1].setText(s[i-1].toString());
			} catch (NullPointerException e) {}
			}
		public void mouseEntered(MouseEvent arg0) {
			}
		public void mouseExited(MouseEvent arg0) {
			}
		public void mousePressed(MouseEvent arg0) {
			}
		public void mouseReleased(MouseEvent arg0) {
			}

	}

	// remove a column
	public class Controler2 implements MouseListener
	{
		public void mouseClicked(MouseEvent e) {

			try {
				Integer []column={1,2};
				JOptionPane jo1=new JOptionPane();
				Integer j=(Integer) jo1.showInputDialog(null,"Select a column",null,JOptionPane.QUESTION_MESSAGE,null,column, column[0]);
				int i=j.intValue();
				l[i-1].setText("empty");
			} catch (NullPointerException e1) {}
			}
		public void mouseEntered(MouseEvent e) {
			}
		public void mouseExited(MouseEvent e) {
			}
		public void mousePressed(MouseEvent e) {
			}
		public void mouseReleased(MouseEvent e) {
			}

	}

	// add a column
	public class Controler3 implements MouseListener
	{
		public void mouseClicked(MouseEvent e){
			Integer []column={1,2};
			JOptionPane jo1=new JOptionPane();
			Integer k=(Integer) jo1.showInputDialog(null,"Select a column",null,JOptionPane.QUESTION_MESSAGE,null,column, column[0]);
				try {
					int i=k.intValue();
					if(s[i-1]==null)
					throw new Failure("This column is empty");
					JOptionPane jo=new JOptionPane();
					String m= JOptionPane.showInputDialog(null,"Enter a value ",null,JOptionPane.QUESTION_MESSAGE);
					int j=Integer.parseInt(m);
					s[i-1].add(j);
					l[i-1].setText(s[i-1].toString());
				} catch (Failure e1) {
					JOptionPane jo2=new JOptionPane();
					jo2.showMessageDialog(null, e1.getMessage());

				}catch (NumberFormatException e1)
				{
					JOptionPane jo2=new JOptionPane();
					jo2.showMessageDialog(null, "Enter an integer!");
				}
				catch (NullPointerException e1){}
            }
		public void mouseEntered(MouseEvent e) {

			}
		public void mouseExited(MouseEvent e) {
			}
		public void mousePressed(MouseEvent e) {
			}
		public void mouseReleased(MouseEvent e) {
			}

	}

	// remove element from a column
	public class Controler4 implements MouseListener
	{
		public void mouseClicked(MouseEvent e) {
			Integer []column={1,2};
			JOptionPane jo1=new JOptionPane();
			Integer k=(Integer) jo1.showInputDialog(null,"Select a column",null,JOptionPane.QUESTION_MESSAGE,null,column, column[0]);

			try {
				int i=k.intValue();
				if(s[i-1]==null)throw new Failure("This column is empty!");
				JOptionPane jo=new JOptionPane();
				String m= jo.showInputDialog(null,"Enter a value ",null,JOptionPane.QUESTION_MESSAGE);
				int j=Integer.parseInt(m);
				s[i-1].remove(j);
				l[i-1].setText(s[i-1].toString());
			} catch (Failure e1) {
				JOptionPane jo2=new JOptionPane();
				jo2.showMessageDialog(null, e1.getMessage());
			} catch(NumberFormatException e1)
			{
				JOptionPane jo2=new JOptionPane();
				jo2.showMessageDialog(null,"Enter an integer!");
			}catch (NullPointerException e1){}
			}
		public void mouseEntered(MouseEvent e) {
			}
		public void mouseExited(MouseEvent e) {
			}
		public void mousePressed(MouseEvent e) {
			}
		public void mouseReleased(MouseEvent e) {
			}

	}

	// remove all elements from the column
	public class Controler5 implements MouseListener
	{
		public void mouseClicked(MouseEvent e) {
			Integer []column={1,2};
			JOptionPane jo1=new JOptionPane();
			Integer k=(Integer) jo1.showInputDialog(null,"Select a column",null,JOptionPane.QUESTION_MESSAGE,null,column, column[0]);
			try {
				int i=k.intValue();
				if(s[i-1]==null) throw new Failure("This column is empty !");
				JOptionPane jo=new JOptionPane();
				String m= jo.showInputDialog(null,"Enter a value ",null,JOptionPane.QUESTION_MESSAGE);
				int j=Integer.parseInt(m);
				s[i-1].removeAll(j);
				l[i-1].setText(s[i-1].toString());

			} catch (NumberFormatException e1) {
				JOptionPane jo2=new JOptionPane();
				jo2.showMessageDialog(null, "Enter an integer!");
			} catch (Failure e1) {
				JOptionPane jo2=new JOptionPane();
				jo2.showMessageDialog(null, e1.getMessage());
			}catch (NullPointerException e1){}
			}
		public void mouseEntered(MouseEvent e) {
			}
		public void mouseExited(MouseEvent e) {
			}
		public void mousePressed(MouseEvent e) {
			}
		public void mouseReleased(MouseEvent e) {
			}

	}

	// compute operation union between column 1 and column 2
	public class Controler6 implements MouseListener
	{
		public void mouseClicked(MouseEvent e) {

			try {
				if(s[0]==null || s[1]==null)throw new Failure("Columns must be defined");
				if(s[0].getClass()!=(s[1].getClass()))throw new Failure("Columns must have the same type");
					s[2]=s[0].union(s[1],s[0]);
					l[2].setText(s[2].toString());
			} catch (Failure e1) {
				JOptionPane jo2=new JOptionPane();
				jo2.showMessageDialog(null,e1.getMessage());
			}catch (NullPointerException e1){}

			}
		public void mouseEntered(MouseEvent e) {
			}
		public void mouseExited(MouseEvent e) {
			}
		public void mousePressed(MouseEvent e) {
			}
		public void mouseReleased(MouseEvent e) {
			}

	}

	// compute operation inter between column 1 and column 2
	public class Controler7 implements MouseListener
	{
		public void mouseClicked(MouseEvent e) {
			try {
				if(s[0]==null || s[1]==null)throw new Failure("Columns must be defined");
				if((s[0].getClass())!=(s[1].getClass()))throw new Failure("Columns must have the same type");
				    s[2]=s[0].inter(s[1],s[0]);
					l[2].setText(s[2].toString());
			} catch (Failure e1) {
				JOptionPane jo2=new JOptionPane();
				jo2.showMessageDialog(null,e1.getMessage());
			}catch (NullPointerException e1){}

			}
		public void mouseEntered(MouseEvent e) {
			}
		public void mouseExited(MouseEvent e) {
			}
		public void mousePressed(MouseEvent e) {
			}
		public void mouseReleased(MouseEvent e) {
			}

	}

	// copy elements of a column to another
	public class Controler8 implements MouseListener
	{
		public void mouseClicked(MouseEvent e) {
			try {
				Integer []column1={1,2,3};
				JOptionPane jo1=new JOptionPane();
				Integer k=(Integer) jo1.showInputDialog(null,"Select a column",null,JOptionPane.QUESTION_MESSAGE,null,column1, column1[0]);
				int i=k.intValue();
				Integer []column2={1,2};
				JOptionPane jo2=new JOptionPane();
				Integer m=(Integer) jo2.showInputDialog(null,"Select a column",null,JOptionPane.QUESTION_MESSAGE,null,column2, column2[0]);
				int j=m.intValue();
				s[i-1].copy(s[j-1]);
				s[i-1].reInit();
				l[i-1].setText(s[i-1].toString());
				l[j-1].setText(s[j-1].toString());
			} catch (NullPointerException e1) {}
			}
		public void mouseEntered(MouseEvent e) {
			}
		public void mouseExited(MouseEvent e) {
			}
		public void mousePressed(MouseEvent e) {
			}
		public void mouseReleased(MouseEvent e) {
			}
	}

	// convert column to another type
	public class Controler9 implements MouseListener
	{
		public void mouseClicked(MouseEvent arg0) {
			try {
				Integer []column={1,2};
				Integer j=(Integer) JOptionPane.showInputDialog(null,"Select a column",null,JOptionPane.QUESTION_MESSAGE,null,column, column[0]);
				int i=j.intValue();
				Structure []type={new Set(),new MultiSet(),new LinkedSet(),new MultiLinkedSet(),new List(),new MultiList()};
				Structure name=(Structure) JOptionPane.showInputDialog(null,"Select a type of list",null,JOptionPane.QUESTION_MESSAGE,null,type, type[0]);

				s[i-1].copy(name);
				s[i-1]=name;
				l[i-1].setText(s[i-1].toString());
			} catch (NullPointerException e) {}

		}
		public void mouseEntered(MouseEvent arg0) {
	    }
		public void mouseExited(MouseEvent arg0) {
		}
		public void mousePressed(MouseEvent arg0) {

		}
		public void mouseReleased(MouseEvent arg0) {

		}

	}
}
