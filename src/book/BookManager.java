package book;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.result.Row;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class BookManager {

	private JFrame frame;
	private JTable table;
	private static Connection conn;
	private static Statement st;
	private static ResultSet rs;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookManager window = new BookManager();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BookManager() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 323, 231);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"ID", "\u56FE\u4E66\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u4F5C\u8005", "\u51FA\u7248\u793E"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton add = new JButton("\u589E\u52A0");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BookInfo book = new BookInfo();
				int row = table.getSelectedRow();//获取你选中的行号（记录）
				int col = table.getSelectedColumn();
				if(row == -1) {
					JOptionPane.showMessageDialog(null,"请选中需要增加的一行");
				}else {
					if(table.getValueAt(row, 1)==null||table.getValueAt(row, 2)==null||table.getValueAt(row, 3)==null||table.getValueAt(row, 4)==null) {
						JOptionPane.showMessageDialog(null,"不能有空值");
					}
					else {
						book.setBookNo(table.getValueAt(row, 1).toString());
						book.setBookName(table.getValueAt(row, 2).toString());
						book.setAuthor(table.getValueAt(row, 3).toString());
						book.setPublisher(table.getValueAt(row, 4).toString());
						System.out.println(book.getAuthor());
						System.out.println(book.getBookName());
						try {
							Book.addBook(book);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						System.out.println(row);
					}
					
				}
			}
		});
		add.setBounds(352, 24, 59, 23);
		frame.getContentPane().add(add);
		
		JButton delete = new JButton("\u5220\u51CF");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int flag = 0 ;

				int row = table.getSelectedRow();
				if(row == -1) {
					JOptionPane.showMessageDialog(null,"请选中需要删除的一行");
				}else {
				int id = (int) table.getValueAt(row, 0);
				try {
					 flag = Book.deleteBook(id);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(flag == 1) {
					DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
					tableModel.removeRow(row);
					JOptionPane.showMessageDialog(null,"删除成功");
				}
				else {
					JOptionPane.showMessageDialog(null,"删除失败查无此编号");
				}
			  }
			}
		});
		delete.setBounds(352, 80, 59, 23);
		frame.getContentPane().add(delete);
		
		JButton update = new JButton("\u4FEE\u6539");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();//获取你选中的行号（记录）
				
				int col = table.getSelectedColumn();
				if(row == -1) {
					JOptionPane.showMessageDialog(null,"请选中需要修改的一行");
				}else {
				BookInfo book = new BookInfo();
				String getname= table.getValueAt(row, col).toString();
//				System.out.println(row+" "+col);
					book.setId((int) table.getValueAt(row, 0));
					book.setBookNo(table.getValueAt(row, 1).toString());
					book.setBookName(table.getValueAt(row, 2).toString());
					book.setAuthor(table.getValueAt(row, 3).toString());
					book.setPublisher(table.getValueAt(row, 4).toString());
					System.out.println(book.getAuthor());
					try {
						Book.updateBook(book);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		update.setBounds(352, 136, 59, 23);
		frame.getContentPane().add(update);
		
		JButton select = new JButton("\u67E5\u8BE2");
		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				dtm.setRowCount(0);
				try {
					ResultSet rs = Book.selectBook();
					while(rs.next()) {
						Vector v = new Vector();
						v.add(rs.getInt("id"));
						v.add(rs.getString("bookno"));
						v.add(rs.getString("bookname"));
						v.add(rs.getString("author"));
						v.add(rs.getString("publisher"));
						dtm.addRow(v);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		select.setBounds(352, 190, 59, 23);
		frame.getContentPane().add(select);
		/////////////////////
		//鼠标右键
		  table.addMouseListener(new MouseAdapter() {
		      public void mouseClicked(MouseEvent e){
		        if (e.getButton() == MouseEvent.BUTTON3){
		        	DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
					Vector<String[]> dataVector=new Vector<String[]>();
					tableModel.addRow(dataVector);
					int count=table.getRowCount();//获得总行数
					table.requestFocus();
					table.setRowSelectionInterval(count-1, count-1);//最后一行获得焦点
					table.editCellAt(count-1, 0);
		        }
		      }
		    });
	}
	
}
