package TanChiShe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class JTabel extends JFrame{
	private JTable tabel;
	private Container c;
	
public static void main(String[] args) {
	JTabel frame=new JTabel();
	frame.setVisible(true);
	
}
	public JTabel(){
           super();
	setTitle("操作表格");
	setBounds(100,80,300,300);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Container c=getContentPane(); 
	String[] columnNames= {"A","B","C","D","E","F","G","F"};
	String[][] tableValues=new String[20][columnNames.length];
	for(int row=0;row<tableValues.length;row++) {
		for(int column=0;column<columnNames.length;column++) {
			tableValues[row][column]=columnNames[column]+row;
		}
	}
	JTable table =new JTable(tableValues,columnNames);
	JScrollPane sc=new JScrollPane(table);
	c.add(table,BorderLayout.CENTER);
	
	table.setSelectionForeground(Color.red);
	table.setSelectionBackground(Color.yellow);
	table.setRowHeight(30);//设置行高
	table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    System.out.println("表格共有"+table.getRowCount()+"行"+table.getColumnCount()+"");
	System.out.println("第二列的名称:"+table.getColumnName(1));
	System.out.println("第二行第二列的值是:"+table.getValueAt(1, 1));
	
	}
}
