
package Chay;

import EventItem1.EvenItem1;
import EventItem1.EventMenuSelected;
import EventItem1.MousePressed;
import GiaoDienBoTro.KhungAnh;
import MODEL.ModelUser;
import MODEL.SanPhamMD;
import Nha.HoMe;
import Nha.ReadingUI;
import Nha.form1;

import Nha.form2;
import Nha.form3;

import Nha.form6;

import Nha.form8;
import Nha.form7;
import Nha.form77;
import Nha.form9;
import SwingLogin.LoginFrame1;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import sp.BookView;

public class Chay extends javax.swing.JFrame implements Serializable {
	private ModelUser modelUser;
	private ArrayList<SanPhamMD> sppp;

	public ArrayList<SanPhamMD> getSppp() {
		return sppp;
	}

	public void setSppp(ArrayList<SanPhamMD> sppp) {
		this.sppp = sppp;
	}

	public ModelUser getModelUser() {
		return modelUser;
	}

	public void setModelUser(ModelUser modelUser) {
		this.modelUser = modelUser;
	}

	private static final long serialVersionUID = 1L;

	private ObjectOutputStream out;
	private ObjectInputStream in;

	private int id;
	private String name;
	private double balance;
	private int numbers;
	private double prices;

	public double getPrices() {
		return prices;
	}

	public void setPrices(double prices) {
		this.prices = prices;
	}

	private form1 form1;
	private form2 form2;
	private form3 form3;

	private form6 form6;

	private form8 form8;
	private form9 form9;
	private form7 form7;
	private LoginFrame1 lg;

	public int x;
	public int y;

	public Chay() {

		initComponents();
		setBackground(new Color(0, 0, 0, 0));
		menu2.initMoving(this);
		form1 = new form1();

		form2 = new form2();
		form3 = new form3();

		form6 = new form6();
		form7 = new form7();

		form8 = new form8();

		menu2.addEventMenuSelected(new EventMenuSelected() {
			@Override
			public void selected(int index) {
				System.out.println(".selected()" + index);
				switch (index) {
				case 0:
					setForm(hoMe1);
					Jheader.setText("Trang Chủ");
					break;
				case 1:
					setForm(form1);
					Jheader.setText(getId() + "");
					break;
				case 2:
					Jheader.setText("AdMin");
					setForm(form3);
					break;
				case 3:
					Jheader.setText("");
					setForm(form6);
					break;
				case 4:
					Jheader.setText("");
					setForm(form8);
					break;
				case 5:
					Jheader.setText("tieu de 7");
					setForm(form7);
					form7.setId(getId());
					break;
				case 6:
					Jheader.setText("Kho");
					setForm(hoMe2);

					try {
						performAction("getPurchasedBooks", null, null);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 10:
					Jheader.setText("tieu de 1");
					setForm(form8);
					break;
				case 12:
					Jheader.setText("tieu de 1");
					chuyenve();
					break;
				default:
					System.err.println("Index not supported: " + index);
					break;
				}
			}
		});

		init();

	}

	private void setForm(JComponent com) {
		SwingUtilities.invokeLater(() -> {
			jPanel3.removeAll();
			jPanel3.add(com);
			jPanel3.repaint();
			jPanel3.revalidate();
		});
	}

	public void chuyenve() {
		int k = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn đăng xuất?", "Xác nhận",
				JOptionPane.YES_NO_OPTION);
		if (k == JOptionPane.YES_OPTION) {
			try {
				lg = new LoginFrame1();
			} catch (SQLException ex) {
				Logger.getLogger(Chay.class.getName()).log(Level.SEVERE, "Database error during login frame creation",
						ex);
			} catch (Exception ex) {
				Logger.getLogger(Chay.class.getName()).log(Level.SEVERE, "Unexpected error during login frame creation",
						ex);
			}

			dispose();

			lg.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			lg.setVisible(true);
			lg.setLocationRelativeTo(null);
		}

	}

	private void init() {
		gopNutMAC1.initEvent(this, nen1);

		jPanel1.setBackground(Color.WHITE);
		testdata();
	}

	public void testdata() {

		// Đặt Runnable lồng vào đầu phương thức testdata
		Runnable setupEvents = new Runnable() {
			@Override
			public void run() {
				hoMe1.setEvent(new EvenItem1() {
					@Override
					public void itemClick(Component com, SanPhamMD spmd) {
						hoMe1.setSelected(com);

					}
				});

				hoMe1.setEvent2(new MousePressed() {
					@Override
					public void itemClick(Component com, SanPhamMD spmd) {
						hoMe1.setSelected(com);
						form9 bv = new form9();
						bv.setData(spmd);
						setPrices(spmd.getPrice());
						setForm(bv);

						bv.getBuy().addMouseListener(new MouseListener() {

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
								double currentBalance = Double.parseDouble(form1.getBalances().getText());
								System.out.println(currentBalance);
								bv.getTry().addMouseListener(new MouseAdapter() {

									@Override
									public void mouseClicked(MouseEvent e) {
										// TODO Auto-generated method stub
										super.mouseClicked(e);
									}

								});
								System.out.println(bv.getBalance());
								System.out.println(bv.isCheck());
								System.out.println(getPrices());
								if (currentBalance != 0 && currentBalance >= getPrices()) {
									JOptionPane.showMessageDialog(Chay.this,
											"Bạn đã mua thành công, vui lòng vào kho để đọc!");
									bv.getBuy().setText("Đã mua");
									double afterPrices = currentBalance - getPrices();
									form1.getBalances().setText(String.valueOf(afterPrices));
									String sent = "update";
									System.out.println(bv.getBalance());
									String BookID = String.valueOf(spmd.getItemID());
									String updateBalance = form1.getBalances().getText();
									String UserID = form1.getId().getText();
									try {
										performAction(sent, BookID, updateBalance);
									} catch (ClassNotFoundException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								} else {
									JOptionPane.showMessageDialog(Chay.this, "Số dư của bạn không đủ!");
								}

							}

						});

					}
				});
			}
		};

		Thread setupThread = new Thread(setupEvents);
		setupThread.start();

	}

	private synchronized void performAction(String action, String BookID, String bl) throws ClassNotFoundException {
		if (action.equals("getPurchasedBooks")) {
			try (Socket socket = new Socket("localhost", 9999);
					ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
					ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

				this.out = out;
				this.in = in;

				out.writeObject(action);
				String id = form1.getId().getText();
				out.writeObject(id);
				out.writeObject(bl);
				out.writeObject(BookID);
				processResponse();

			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (action.equals("update")) {
			try (Socket socket = new Socket("localhost", 9999);
					ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
					ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

				this.out = out;
				this.in = in;

				out.writeObject(action);
				String id = form1.getId().getText();
				out.writeObject(id);
				out.writeObject(bl);
				out.writeObject(BookID);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void processResponse() throws IOException, ClassNotFoundException {
		if (in == null) {
			throw new IOException("ObjectInputStream is not initialized.");
		}

		ArrayList<Integer> purchasedBooks = (ArrayList<Integer>) in.readObject();
		System.out.println(purchasedBooks.get(0));
		processPurchasedBooksResponse(purchasedBooks);
	}

	private void processPurchasedBooksResponse(ArrayList<Integer> purchasedBooks) {
		if (sppp == null) {
			System.out.println("sppp is null. Cannot process purchased books.");
			return;
		}


		ArrayList<Integer> matchedItems = new ArrayList<>();
		ArrayList<SanPhamMD> newSpMD = new ArrayList<>();

		for (Integer purchasedBook : purchasedBooks) {
			for (SanPhamMD sp : sppp) {
				if (sp.getItemID() == purchasedBook) {
					matchedItems.add(purchasedBook);
					newSpMD.add(sp);
					break;
				}
			}
		}
		
		// Clear old items and upload new ones
		hoMe2.clearItems();
		uploaddata2(newSpMD);
		
		test2();
		// For debugging or confirmation
		System.out.println("Matched Items: " + matchedItems.size());
	}

	public void test2() {
		Runnable setupEvents2 = () -> {
			hoMe2.setEvent(new EvenItem1() {
				@Override
				public void itemClick(Component com, SanPhamMD spmd) {
					hoMe2.setSelected(com);
				}
			});

			hoMe2.setEvent2(new MousePressed() {
				@Override
				public void itemClick(Component com, SanPhamMD spmd) {
					hoMe2.setSelected(com);
					form77 bvv = new form77();
					bvv.setData(spmd);
					setPrices(spmd.getPrice());
					setForm(bvv);

					bvv.getBuy().addMouseListener(new MouseListener() {
						@Override
						public void mouseClicked(MouseEvent e) {
							ReadingUI readingUi = new ReadingUI();
							readingUi.getjTextArea1().setText(spmd.getContent());
							readingUi.setVisible(true);
						}

						@Override
						public void mouseReleased(MouseEvent e) {
						}

						@Override
						public void mousePressed(MouseEvent e) {
						}

						@Override
						public void mouseExited(MouseEvent e) {
						}

						@Override
						public void mouseEntered(MouseEvent e) {
						}
					});
				}
			});
		};

		// Run the setup events in a separate thread
		new Thread(setupEvents2).start();
	}

	public void uploadUserData(ModelUser modelUser) {
		form1.check(modelUser);
		setId(modelUser.getId());
		setBalance(modelUser.getBalance());
	}

	public void uploaddata2(ArrayList<SanPhamMD> lk) {
		for (int i = 0; i < lk.size(); i++) {
			int id = lk.get(i).getItemID();
			String itemName = lk.get(i).getItemName();
			String description = lk.get(i).getDescription();
			double price = lk.get(i).getPrice();
			String brandName = lk.get(i).getBrandName();
			String imageUrl = "https://atlas-content-cdn.pixelsquid.com/stock-images/error-language-w7GWrk8-600.jpg";
			String author = lk.get(i).getAuthor();
			String content = lk.get(i).getContent();

			Runnable task = new Runnable() {
				@Override
				public void run() {
					SanPhamMD spmd = new SanPhamMD(id, itemName, description, price, brandName, imageUrl, author,
							content);
					hoMe2.addItem(spmd);

				}
			};

			Thread thread = new Thread(task);
			thread.start();
		}
	}

	public void uploaddata(ArrayList<SanPhamMD> ll) {
		setSppp(ll);
		for (int i = 0; i < ll.size(); i++) {
			int id = ll.get(i).getItemID();
			String itemName = ll.get(i).getItemName();
			String description = ll.get(i).getDescription();
			double price = ll.get(i).getPrice();
			String brandName = ll.get(i).getBrandName();
			String imageUrl = "https://atlas-content-cdn.pixelsquid.com/stock-images/error-language-w7GWrk8-600.jpg";
			String author = ll.get(i).getAuthor();
			String content = ll.get(i).getContent();

			Runnable task = new Runnable() {
				@Override
				public void run() {
					SanPhamMD spmd = new SanPhamMD(id, itemName, description, price, brandName, imageUrl, author,
							content);
					hoMe1.addItem(spmd);

				}
			};

			Thread thread = new Thread(task);
			thread.start();
		}
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		nen1 = new TaoNen.Nen();
		jPanel1 = new javax.swing.JPanel();
		menu2 = new MenuSwing.Menu();
		jPanel2 = new javax.swing.JPanel();
		gopNutMAC1 = new NutNhanMAC.GopNutMAC();
		Jheader = new javax.swing.JLabel();
		jPanel3 = new javax.swing.JPanel();
		hoMe1 = new Nha.HoMe();
		hoMe2 = new Nha.HoMe();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setBackground(new java.awt.Color(255, 255, 255));
		setUndecorated(true);

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(menu2, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(menu2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		jPanel2.setBackground(new java.awt.Color(255, 255, 255));
		jPanel2.setMinimumSize(new java.awt.Dimension(100, 60));
		jPanel2.setOpaque(false);
		jPanel2.setPreferredSize(new java.awt.Dimension(104, 60));

		Jheader.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
		Jheader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		Jheader.setText("");

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout
				.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
								.addComponent(Jheader, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(gopNutMAC1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addComponent(gopNutMAC1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 30, Short.MAX_VALUE))
				.addComponent(Jheader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE));

		jPanel3.setOpaque(false);
		jPanel3.setLayout(new java.awt.BorderLayout());
		jPanel3.add(hoMe1, java.awt.BorderLayout.CENTER);

		javax.swing.GroupLayout nen1Layout = new javax.swing.GroupLayout(nen1);
		nen1.setLayout(nen1Layout);
		nen1Layout.setHorizontalGroup(nen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(nen1Layout.createSequentialGroup().addContainerGap()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(nen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
								.addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE))
						.addContainerGap()));
		nen1Layout.setVerticalGroup(nen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(nen1Layout.createSequentialGroup().addContainerGap().addGroup(nen1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(nen1Layout.createSequentialGroup()
								.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addContainerGap())
						.addGroup(nen1Layout.createSequentialGroup()
								.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				nen1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(nen1,
				javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
		setLocationRelativeTo(null);
	}// </editor-fold>

	public static void main(String args[]) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Chay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Chay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Chay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Chay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Chay().setVisible(true);
			}
		});
	}

	public int getNumbers() {
		return numbers;
	}

	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	// Variables declaration - do not modify
	private javax.swing.JLabel Jheader;
	private NutNhanMAC.GopNutMAC gopNutMAC1;
	private Nha.HoMe hoMe1;
	private Nha.HoMe hoMe2;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private MenuSwing.Menu menu2;
	private TaoNen.Nen nen1;
	// End of variables declaration
}
