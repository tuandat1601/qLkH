package QuanLyKhoaHoc.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.sql.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import QuanLyKhoaHoc.model.DanhMuc;
import QuanLyKhoaHoc.model.KhoaHoc;
import QuanLyServive.DanhMucService;
import QuanLyServive.KhoaHocService;





public class GiaoDien extends JFrame {
	JTabbedPane tab;
	
	
	JList<DanhMuc>listDanhMuc;
	JButton btnthemdanhmuc, btnxoadanhmuc, btnchinhsuadanhmuc;
	DefaultTableModel dtmkhoahoc;
	JTable tblkhoahoc;
	JComboBox<DanhMuc>combodanhmuc;
	JButton btntaomoi, btnluu,btnxoa;
	JTextField txtmakh, txttenkh,txtbd,txtkt;
	JTextArea  txtmota;
	DanhMuc dmSelected = null;
	ArrayList<KhoaHoc>dskh;
public GiaoDien(String title) {
	// TODO Auto-generated constructor stub
	super(title);
	addControls();
	addEvents();
	hienthidanhmuc();
}

private void hienthidanhmuc() {
	// TODO Auto-generated method stub
	DanhMucService dmservice = new DanhMucService();
	Vector<DanhMuc>vec = dmservice.doctoanbodanhmuc();
	listDanhMuc.setListData(vec);
	combodanhmuc.removeAllItems();
	for(DanhMuc dm : vec) {
		if(dm.getIsDeleted()==0)
		combodanhmuc.addItem(dm);
	}
}

private void addEvents() {
	// TODO Auto-generated method stub
	listDanhMuc.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(listDanhMuc.getSelectedValue() ==null)return;
			KhoaHocService khservice = new KhoaHocService();
			dmSelected = listDanhMuc.getSelectedValue();
			dskh = khservice.dockhoahoctheodanhmuc(
					listDanhMuc.getSelectedValue().getMaDM());
			dtmkhoahoc.setRowCount(0);
			for(KhoaHoc kh : dskh) {
				Vector<Object>vec = new Vector<Object>();
				vec.add(kh.getMaKH());
				vec.add(kh.getTenKH());
				vec.add(kh.getMoTa());
				vec.add(kh.getNgayBD());
				vec.add(kh.getNgauKT());
				dtmkhoahoc.addRow(vec);
			}
		}
	});
	btnchinhsuadanhmuc.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(listDanhMuc.getSelectedValue() ==null)return;
			dmSelected = listDanhMuc.getSelectedValue();
			CapNhatDanhMuc capnhat = new CapNhatDanhMuc(dmSelected );
			capnhat.showWindow();
			hienthidanhmuc();
		}
	});
	tblkhoahoc.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
			int row = tblkhoahoc.getSelectedRow();
		
			if(row == -1)return;
			KhoaHoc kh = dskh.get(row);
			
			txtmakh.setText(kh.getMaKH());
			txttenkh.setText(kh.getTenKH());
			txtmota.setText(kh.getMoTa());
			txtbd.setText(kh.getNgayBD().toString());
			txtkt.setText(kh.getNgauKT().toString());;
			
		}
	});
	btnluu.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				xulyluukhoahoc();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
	btnthemdanhmuc.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ThemDanhMuc them = new ThemDanhMuc("Thêm Danh Mục");
			
			them.showWindow();
			hienthidanhmuc();
		}
	});
btnxoa.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		xulyxoa();
	}
});
}



protected void xulyxoa() {
	// TODO Auto-generated method stub
	dmSelected = listDanhMuc.getSelectedValue();
		// TODO Auto-generated method stub
	DanhMucService dmservice = new DanhMucService();
	if(dmservice.xulyxoa(dmSelected)>0) {
		JOptionPane.showConfirmDialog(null, "Lưu thành công");
		hienthidanhmuc();
	}
	else {
		JOptionPane.showConfirmDialog(null, "Lưu thất bại");
		}	
	
}

protected void xulyluukhoahoc() throws ParseException  {
	// TODO Auto-generated method stub
	KhoaHoc kh = new KhoaHoc();
	SimpleDateFormat smd = new SimpleDateFormat("yyyy/mm/dd");
	kh.setMaDM(dmSelected.getMaDM());
	kh.setMaKH(txtmakh.getText());
	kh.setTenKH(txttenkh.getText());
	kh.setMoTa(txtmota.getText());
	kh.setNgayBD(smd.parse(txtbd.getText()));
	kh.setNgauKT(smd.parse(txtkt.getText()));
	KhoaHocService khservice = new KhoaHocService();
	if(khservice.luukhoahoc(kh)>0) {
		JOptionPane.showConfirmDialog(null, "Lưu thành công");
	}
	else {
		JOptionPane.showConfirmDialog(null, "Lưu thất bại");
		}
	}
	


private void addControls() {
	// TODO Auto-generated method stub
	Container con = getContentPane();
	con.setLayout(new BorderLayout());
	tab = new JTabbedPane();
	JPanel tab1 = new JPanel();
	JPanel tab2 = new JPanel();
	JPanel tab3 = new JPanel();
	tab.add(tab1,"Màn Hình Chính");
	
	tab.add(tab2,"Quản Lý Khóa Học");
	tab.add(tab3,"Quản Lý Học Viên");
	con.add(tab);
	
	tab2.setLayout(new BorderLayout());
	JPanel pnlefttab2 = new JPanel();
	pnlefttab2.setPreferredSize(new Dimension(300, 0));
	JPanel pnrighttab2 = new JPanel();
	JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnlefttab2, pnrighttab2);
	sp.setOneTouchExpandable(true);
	
	tab2.add(sp, BorderLayout.CENTER);
	pnlefttab2.setLayout(new BorderLayout());
	listDanhMuc = new JList<DanhMuc>();
	JScrollPane sclistdanhmuc = new JScrollPane(listDanhMuc,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	pnlefttab2.add(sclistdanhmuc,BorderLayout.CENTER);
	TitledBorder borderlist = 
			new TitledBorder(BorderFactory.createLineBorder(Color.red),"Danh mục khóa học");
	listDanhMuc.setBorder(borderlist);
	btnchinhsuadanhmuc = new JButton("Cập nhật");
	btnthemdanhmuc = new JButton("Thêm DM");
	btnxoadanhmuc = new JButton("Xóa DM");
	JPanel pnButtondanhmuc = new JPanel();
	pnButtondanhmuc.setLayout(new FlowLayout());
	pnButtondanhmuc.add(btnthemdanhmuc);
	pnButtondanhmuc.add(btnchinhsuadanhmuc);
	pnButtondanhmuc.add(btnxoadanhmuc);
	pnlefttab2.add(pnButtondanhmuc,BorderLayout.SOUTH);
	
	
	pnrighttab2.setLayout(new BorderLayout());
	JPanel pntoprighttab2 = new JPanel();
	pntoprighttab2.setLayout(new BorderLayout());
	pnrighttab2.add(pntoprighttab2,BorderLayout.CENTER);
	pntoprighttab2.setPreferredSize(new Dimension(0,300));
	dtmkhoahoc = new DefaultTableModel();
	dtmkhoahoc.addColumn("Mã khóa học");
	dtmkhoahoc.addColumn("Tên khóa học");
	dtmkhoahoc.addColumn("Mô tả");
	dtmkhoahoc.addColumn("Ngày bắt đầu");
	dtmkhoahoc.addColumn("Ngày kết thúc");
	tblkhoahoc = new JTable(dtmkhoahoc);
	JScrollPane sctable = new JScrollPane(tblkhoahoc, 
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	pntoprighttab2.add(sctable, BorderLayout.CENTER);
	
	JPanel pnbottomrighttab2 = new JPanel();
	pnbottomrighttab2.setLayout(new BoxLayout(pnbottomrighttab2, BoxLayout.Y_AXIS));
	pnrighttab2.add(pnbottomrighttab2, BorderLayout.SOUTH);
	pnbottomrighttab2.setPreferredSize(new Dimension(0, 300));
	JPanel pnDanhmuc = new JPanel();
	pnDanhmuc.setLayout(new FlowLayout(FlowLayout.LEFT));
	JLabel lbdanhmuc = new JLabel("Danh mục:");
	combodanhmuc = new JComboBox<DanhMuc>();
	combodanhmuc.setPreferredSize(new Dimension(200, 30));
	pnDanhmuc.add(lbdanhmuc);
	pnDanhmuc.add(combodanhmuc);
	pnbottomrighttab2.add(pnDanhmuc);
	
	JPanel pnmakh = new JPanel();
	pnmakh.setLayout(new FlowLayout(FlowLayout.LEFT));
	JLabel lbmakh = new JLabel("Mã KH:");
	txtmakh = new JTextField(30);
	pnmakh.add(lbmakh);
	pnmakh.add(txtmakh);
	pnbottomrighttab2.add(pnmakh);
	
	JPanel pntenkh = new JPanel();
	pntenkh.setLayout(new FlowLayout(FlowLayout.LEFT));
	JLabel lbtenkh = new JLabel("Tên KH:");
	txttenkh = new JTextField(30);
	pntenkh.add(lbtenkh);
	pntenkh.add(txttenkh);
	pnbottomrighttab2.add(pntenkh);
	
	JPanel pnmotakh = new JPanel();
	pnmotakh.setLayout(new FlowLayout(FlowLayout.LEFT));
	JLabel lbmotakh = new JLabel("Mô tả:");
	txtmota = new JTextArea(6,30);
	JScrollPane scmota = new JScrollPane(txtmota, 
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	pnmotakh.add(lbmotakh);
	pnmotakh.add(scmota);
	pnbottomrighttab2.add(pnmotakh);
	
	JPanel pnngaybd = new JPanel();
	pnngaybd.setLayout(new FlowLayout(FlowLayout.LEFT));
	JLabel lbngaybd = new JLabel("Ngày bắt đầu:");
	txtbd = new JTextField(30);
	pnngaybd.add(lbngaybd);
	pnngaybd.add(txtbd);
	pnbottomrighttab2.add(pnngaybd);
	
	JPanel pnngaykt = new JPanel();
	pnngaykt.setLayout(new FlowLayout(FlowLayout.LEFT));
	JLabel lbngaykt = new JLabel("Ngày kết thúc:");
	txtkt = new JTextField(30);
	pnngaykt.add(lbngaykt);
	pnngaykt.add(txtkt);
	pnbottomrighttab2.add(pnngaykt);
	lbmakh.setPreferredSize(lbngaykt.getPreferredSize());
	lbtenkh.setPreferredSize(lbngaykt.getPreferredSize());
	lbmotakh.setPreferredSize(lbngaykt.getPreferredSize());
	lbngaybd.setPreferredSize(lbngaykt.getPreferredSize());
	lbdanhmuc.setPreferredSize(lbngaykt.getPreferredSize());
	
	JPanel pnbuttonsp = new JPanel();
	pnbuttonsp.setLayout(new FlowLayout(FlowLayout.LEFT));
	btntaomoi = new JButton("Tạo mới");
	btnluu = new JButton("Lưu");
	btnxoa = new JButton("Xóa");
	pnbuttonsp.add(btntaomoi);
	pnbuttonsp.add(btnluu);
	pnbuttonsp.add(btnxoa);
	pnbottomrighttab2.add(pnbuttonsp);
	
}
public void showWindow() {
	this.setSize(600, 600);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setLocationRelativeTo(null);
	this.setVisible(true);
}
}
