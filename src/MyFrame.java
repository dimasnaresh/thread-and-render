package com.dimas.gariskuker;

public class MyFrame extends javax.swing.JFrame{

	private GarisKurangKerjaan objGarisKuKer;
	private Thread proses;

	public MyFrame(){
		initFrame();
		proses = new Thread(objGarisKuKer);
		proses.start();

	}

	private void initFrame(){
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGap(0, 300, Short.MAX_VALUE)
			);
		layout.setVerticalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGap(0, 300, Short.MAX_VALUE)
			);

		pack();
		/*add create new GarisKurangKerjaan object
		 *and add to JFrame
		 *
		 */
		objGarisKuKer = new GarisKurangKerjaan(this);
		getContentPane().add(objGarisKuKer);
		addKeyListener(new java.awt.event.KeyAdapter(){
			public void keyPressed(java.awt.event.KeyEvent act){
				if(act.getKeyCode() == java.awt.event.KeyEvent.VK_DOWN){
                    objGarisKuKer.arah=GarisKurangKerjaan.BAWAH;
                    
                } else if(act.getKeyCode() == java.awt.event.KeyEvent.VK_UP){
                    objGarisKuKer.arah=GarisKurangKerjaan.ATAS;
                    
                } else if(act.getKeyCode() == java.awt.event.KeyEvent.VK_LEFT){
                    objGarisKuKer.arah=GarisKurangKerjaan.KIRI;
                } else if(act.getKeyCode() == java.awt.event.KeyEvent.VK_RIGHT){
                    objGarisKuKer.arah=GarisKurangKerjaan.KANAN;
                }
			}
		});
		setFocusable(true);
		requestFocusInWindow();
	}

	public static void main(String[] args){
		new MyFrame().setVisible(true);
	}

}