package book;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class TableSj extends JFrame{
  JTable table;
  DefaultTableModel tableM;
  JScrollPane jsp;
  JPopupMenu jpm;
  Vector<String> name = new Vector<String>();
  Vector<String> data = new Vector<String>();
  public static void main(String[] args) {
    // TODO �Զ����ɵķ������
    new TableSj();
  }
  TableSj(){
    name.add("����");
    name.add("����");
    data.add("����");
    data.add("19");
    tableM = new DefaultTableModel(name,0);
    tableM.addRow(data);
    tableM.addRow(data);
    table = new JTable(tableM);
    jsp = new JScrollPane(table);
    table.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e){
        if (e.getButton() == MouseEvent.BUTTON3){
          //��table��ʾ
          jpm = new JPopupMenu();
          //��� ��rowAtPoint���������������ڵ��кţ�����Ϊ�������ͣ�
          int i = table.rowAtPoint(e.getPoint());
          jpm.add(i+"");
          jpm.show(table, e.getX(), e.getY());
        }
      }
    });
    this.add(jsp);
    this.setVisible(true);
    this.setSize(400, 400);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
}

