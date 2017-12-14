package Buscador_IMV;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ReadPdf
{

    private static VistaBuscadorpdf v;
    private static File fichero;
    private static String direcctorio;
    private static DefaultListModel listModel;
    private static Buscador b;

    public ReadPdf() throws IOException
    {

        v = new VistaBuscadorpdf();

        v.setTitle("Buscador Texto en PDF");
        v.setVisible(true);
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setMaximumSize(v.getMaximumSize());

        JButton btn = v.getjButton1();
        JButton btnBuscar = v.getjButton2();
        JButton btnBusquedaRec = v.getjButton4();
        JButton btncancelar = v.getjButton5();
        JTextField text1 = v.getjTextField2();
        JTextField text2 = v.getjTextField3();
        JTextField text3 = v.getjTextField4();

        text1.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                text1.setText("");
            }

            @Override
            public void focusLost(FocusEvent e)
            {

            }
        });

        text2.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                text2.setText("");
            }

            @Override
            public void focusLost(FocusEvent e)
            {

            }
        });

        text3.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                text3.setText("");
            }

            @Override
            public void focusLost(FocusEvent e)
            {

            }
        });

        btncancelar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                b.stop();
                v.cancerlar();
            }
        });

        btn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                v.invisible();
                JFileChooser fc = new JFileChooser(fichero);
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int seleccion = fc.showOpenDialog(btn);

                if (seleccion == JFileChooser.APPROVE_OPTION)
                {
                    fichero = fc.getSelectedFile();

                    v.getjTextField1().setText(fichero.getAbsolutePath());
                    v.paso1();

                } else
                {
                    v.getjTextField1().setText("Por Favor Seleccione La Carpeta Donde Buscar");
                }
            }
        });

        btnBuscar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                b = new Buscador(fichero.getAbsolutePath(), v.getjTextField2().getText(),
                        v.getjTextField3().getText(), v.getjTextField4().getText(), v, false);
                b.getListModel().clear();
                b.start();

            }
        });

        btnBusquedaRec.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                b = new Buscador(fichero.getAbsolutePath(), v.getjTextField2().getText(),
                        v.getjTextField3().getText(), v.getjTextField4().getText(), v, true);
                b.getListModel().clear();
                b.start();

            }

        });

        JList list = v.getjList1();
        list.addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                boolean adjust = e.getValueIsAdjusting();

                if (!adjust)
                {
                    JList list = (JList) e.getSource();
                    int selections[] = list.getSelectedIndices();
                    Object selectionValues[] = list.getSelectedValues();
                    for (int i = 0, n = selections.length; i < n; i++)
                    {
                        try
                        {
                            direcctorio = fichero.getAbsolutePath() + "/" + selectionValues[i];
                            leer_datos(v.getjTextField2().getText(), v.getjTextField3().getText(), v.getjTextField4().getText());

                        } catch (IOException ex)
                        {
                            Logger.getLogger(ReadPdf.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        });

        JButton btnpdf = v.getjButton3();
        btnpdf.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                abrir_pdf(v.getjList1().getSelectedValue());
            }
        });

    }

    public static void leer_datos(String palabraabuscar, String palabrabuscar2, String palabrabuscar3) throws IOException
    {

        v.setCursor(Cursor.WAIT_CURSOR);
        v.getjTextArea2().setText("");

        ReadPdfClass pdf = new ReadPdfClass(v.getjList1().getSelectedValue());

        pdf.leer(palabraabuscar, palabrabuscar2, palabrabuscar3);

        for (int i = 0; i < pdf.getLineas().size(); i++)
        {

            v.getjTextArea2().setText(v.getjTextArea2().getText() + i + "/- " + pdf.getLineas().get(i) + "\n");
        }

        v.setCursor(Cursor.DEFAULT_CURSOR);
    }

    public static void abrir_pdf(String directorio)
    {
        try
        {
            File path = new File(directorio);
            Desktop.getDesktop().open(path);
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

}
