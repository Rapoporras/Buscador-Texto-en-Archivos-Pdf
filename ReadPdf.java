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

        listModel = new DefaultListModel();

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

        btn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                v.invisible();
                JFileChooser fc = new JFileChooser();
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

                v.setCursor(Cursor.WAIT_CURSOR);
                listModel.clear();
                v.getjTextArea2().setText("");
                buscar(fichero.getAbsolutePath(), v.getjTextField2().getText(), v.getjTextField3().getText(), v.getjTextField4().getText());

                if (listModel.size() == 0)
                {
                    listModel.addElement("Cadena de busqueda no encontrada");
                    v.getjList1().setEnabled(false);
                    v.getjButton3().setEnabled(false);

                } else
                {
                    v.getjList1().setEnabled(true);
                    v.getjButton3().setEnabled(true);

                }

                v.getjList1().setModel(listModel);
                v.setCursor(Cursor.DEFAULT_CURSOR);
                v.paso2();
            }
        });

        btnBusquedaRec.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                v.setCursor(Cursor.WAIT_CURSOR);
                listModel.clear();
                v.getjTextArea2().setText("");
                buscarRec(fichero.getAbsolutePath(), v.getjTextField2().getText(), v.getjTextField3().getText(), v.getjTextField4().getText());

                if (listModel.size() == 0)
                {
                    listModel.addElement("Cadena de busqueda no encontrada");
                    v.getjList1().setEnabled(false);
                    v.getjButton3().setEnabled(false);

                } else
                {
                    v.getjList1().setEnabled(true);
                    v.getjButton3().setEnabled(true);

                }

                v.getjList1().setModel(listModel);
                v.setCursor(Cursor.DEFAULT_CURSOR);
                v.paso2();
            }

        });

        JButton btnpdf = v.getjButton3();
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

        btnpdf.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                abrir_pdf(v.getjList1().getSelectedValue());
            }
        });

    }

    private static void buscarRec(String absolutePath, String text, String text0, String text1)
    {

        File dir = new File(absolutePath);

        File[] ficheros = dir.listFiles();

        if (ficheros.length != 0)
        {
            for (int x = 0; x < ficheros.length; x++)
            {
                v.getjTextArea2().setText(v.getjTextArea2().getText() + ficheros[x].getAbsolutePath() + "\n");
                if (ficheros[x].isDirectory())
                {
                    buscarRec(ficheros[x].getAbsolutePath(), text, text0, text1);
                } else
                {
                    String ext = obtener_extencion(ficheros[x].getAbsolutePath());
                    if (ext.equals("pdf"))
                    {
                        try
                        {
                            ReadPdfClass pdf = new ReadPdfClass(ficheros[x].getAbsolutePath());
                            pdf.leer(text, text0, text1);

                            if (pdf.getLineas().size() != 0)
                            {
                                listModel.addElement(ficheros[x].getAbsolutePath());
                            }
                        } catch (IOException ex)
                        {
                            Logger.getLogger(ReadPdf.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }

    }

    public static void buscar(String directorio, String palabraabuscar, String palabrabuscar2, String palabrabuscar3)
    {
        File dir = new File(directorio);

        File[] ficheros = dir.listFiles();

        if (ficheros.length != 0)
        {
            for (int x = 0; x < ficheros.length; x++)
            {
                if (!ficheros[x].isDirectory())
                {
                    String ext = obtener_extencion(ficheros[x].getAbsolutePath());
                    if (ext.equals("pdf"))
                    {
                        try
                        {
                            ReadPdfClass pdf = new ReadPdfClass(ficheros[x].getAbsolutePath());
                            pdf.leer(palabraabuscar, palabrabuscar2, palabrabuscar3);

                            if (pdf.getLineas().size() != 0)
                            {
                                listModel.addElement(ficheros[x].getAbsolutePath());
                            }
                        } catch (IOException ex)
                        {
                            Logger.getLogger(ReadPdf.class
                                    .getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }

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

    private static String obtener_extencion(String path)
    {
        String filename = path;

        String fileArray[] = filename.split("\\.");

        return fileArray[fileArray.length - 1];
    }

}
