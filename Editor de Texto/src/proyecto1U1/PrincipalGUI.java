package proyecto1U1;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.BadLocationException;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

public class PrincipalGUI extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
    private String clipboard="";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalGUI frame = new PrincipalGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrincipalGUI() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				Gestion.salir();
			}
		});
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		mnArchivo.setMnemonic('A');
		menuBar.add(mnArchivo);

		JMenuItem mntmNewMenuItem = new JMenuItem("Nuevo");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Gestion.nuevo();
			}
		});
		mnArchivo.add(mntmNewMenuItem);

		JMenuItem mntmAbrir = new JMenuItem("Abrir...");
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Gestion.abrir();
			}
		});
		mnArchivo.add(mntmAbrir);

		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Gestion.guardar();
			}
		});
		mnArchivo.add(mntmGuardar);

		JMenuItem mntmGuardarComo = new JMenuItem("Guardar como...");
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Gestion.guardarComo();
			}
		});
		mnArchivo.add(mntmGuardarComo);

		JSeparator separator = new JSeparator();
		mnArchivo.add(separator);
                
                JMenuItem mntmImprimir = new JMenuItem("Imprimir");
                mntmImprimir.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    try {
                        getTextArea().print();
                    } catch (java.awt.print.PrinterException e) {
                        System.err.format("Cannot print %s%n", e.getMessage());
                    }
                }
    }   );
    mnArchivo.add(mntmImprimir);
                

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Gestion.salir();
			}
		});
		mnArchivo.add(mntmSalir);

		JMenu mnEditar = new JMenu("Edici\u00F3n");
		mnEditar.setMnemonic('E');
		menuBar.add(mnEditar);
                
              
                JMenuItem mntmTipoDeLetra = new JMenuItem("Tipo de letra");
                mntmTipoDeLetra.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        Gestion.seleccionarTipoDeLetra(PrincipalGUI.this);
                    }
                });
                mnEditar.add(mntmTipoDeLetra);

                
		
		JMenuItem mntmCopiar = new JMenuItem("Copiar"); // Crear opción "Copiar"
                mntmCopiar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK)); // Asignar acceso directo Ctrl+C
                mnEditar.add(mntmCopiar); // Agregar opción "Copiar" al menú "Editar"
                mntmCopiar.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						clipboard = textArea.getSelectedText();
						
					}
                	
                });
                JMenuItem mntmPegar = new JMenuItem("Pegar"); // Crear opción "Pegar"
                mntmPegar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK)); // Asignar acceso directo Ctrl+V
                mnEditar.add(mntmPegar); // Agregar opción "Pegar" al menú "Editar"
                mntmPegar.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						int cp = textArea.getCaretPosition();
						try {
							textArea.getDocument().insertString(cp, clipboard, null);
						} catch (BadLocationException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
                	
                });
                
                JMenu mnAyuda = new JMenu("Ayuda"); // Crear menú "Ayuda"
                mnAyuda.setMnemonic('A');
		menuBar.add(mnAyuda);
                
                JMenuItem mntmAcercaDe = new JMenuItem("Acerca de"); // Crear opción "Acerca de"
                mntmAcercaDe.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Crear cuadro de diálogo con los datos del autor del programa
                        JOptionPane.showMessageDialog(null, "Autor: Wilfredo Pardo Arizqueta\nMateria: Topicos Avanzados de Programacion", "Matricula: 19170648", JOptionPane.INFORMATION_MESSAGE);
                    }
                });
                mnAyuda.add(mntmAcercaDe); // Agregar opción "Acerca de" al menú "Ayuda"
            

		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		setTextArea(new JTextArea());
		getTextArea().setWrapStyleWord(true);
		getTextArea().setLineWrap(true);
		scrollPane.setViewportView(getTextArea());
		getTextArea().getDocument().addUndoableEditListener(new UndoableEditListener() {
			
			@Override
			public void undoableEditHappened(UndoableEditEvent arg0) {
				Gestion.setModificado(true);
			}
		});
		Gestion.setPrincipalGUI(this);
		Gestion.resetear(null);
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	/**
	 * @param textArea
	 *            the textArea to set
	 */
	private void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
}