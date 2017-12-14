/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Buscador_IMV;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author pej7132
 */
public class Buscador extends Thread
{

    private long initialTime = 0;
    private DefaultListModel listModel;
    private String directorio, palabrabuscar, palabrabuscar2, palabrabuscar3;
    private VistaBuscadorpdf vista;
    private Boolean recursiva;

    public Buscador(String directorio, String palabrabuscar, String palabrabuscar2, String palabrabuscar3, VistaBuscadorpdf vista, Boolean rec)
    {
        listModel = new DefaultListModel();
        this.directorio = directorio;
        this.palabrabuscar = palabrabuscar;
        this.palabrabuscar2 = palabrabuscar2;
        this.palabrabuscar3 = palabrabuscar3;
        this.vista = vista;
        this.recursiva = rec;

    }

    @Override
    public void run()
    {
        this.vista.busqueda();
        this.vista.getjTextArea2().setText("Inicio Busqueda..." + "\n");
        if (this.recursiva == true)
        {
            this.buscarRec(this.directorio);
        } else
        {
            this.buscar(this.directorio);
        }

        comprobar_lista();

        this.vista.getjList1().setModel(this.listModel);
        this.vista.paso2();

    }

    private void esperarXsegundos(int segundos)
    {
        try
        {
            Thread.sleep(segundos * 1000);
            System.out.println("Espera " + segundos);
        } catch (InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    public DefaultListModel getListModel()
    {
        return listModel;
    }

    public void setListModel(DefaultListModel listModel)
    {
        this.listModel = listModel;
    }

    public long getInitialTime()
    {
        return initialTime;
    }

    public String getDirectorio()
    {
        return directorio;
    }

    public void setDirectorio(String directorio)
    {
        this.directorio = directorio;
    }

    public String getPalabrabuscar()
    {
        return palabrabuscar;
    }

    public void setPalabrabuscar(String palabrabuscar)
    {
        this.palabrabuscar = palabrabuscar;
    }

    public String getPalabrabuscar2()
    {
        return palabrabuscar2;
    }

    public void setPalabrabuscar2(String palabrabuscar2)
    {
        this.palabrabuscar2 = palabrabuscar2;
    }

    public String getPalabrabuscar3()
    {
        return palabrabuscar3;
    }

    public void setPalabrabuscar3(String palabrabuscar3)
    {
        this.palabrabuscar3 = palabrabuscar3;
    }

    public VistaBuscadorpdf getVista()
    {
        return vista;
    }

    public void setVista(VistaBuscadorpdf vista)
    {
        this.vista = vista;
    }

    public void setInitialTime(long initialTime)
    {
        this.initialTime = initialTime;
    }

    private String obtener_extencion(String path)
    {
        String filename = path;

        String fileArray[] = filename.split("\\.");

        return fileArray[fileArray.length - 1];
    }

    private void buscarRec(String directorio)
    {
        File dir = new File(directorio);

        File[] ficheros = dir.listFiles();

        if (ficheros.length != 0)
        {
            for (int x = 0; x < ficheros.length; x++)
            {
                this.esperarXsegundos(1);
                this.vista.getjTextArea2().setText(this.vista.getjTextArea2().getText() + ficheros[x].getAbsolutePath() + "\n");
                if (ficheros[x].isDirectory())
                {
                    buscarRec(ficheros[x].getAbsolutePath());
                } else
                {
                    String ext = obtener_extencion(ficheros[x].getAbsolutePath());
                    if (ext.equals("pdf"))
                    {
                        try
                        {
                            ReadPdfClass pdf = new ReadPdfClass(ficheros[x].getAbsolutePath());
                            pdf.leer(this.palabrabuscar, this.palabrabuscar2, this.palabrabuscar3);

                            if (pdf.getLineas().size() != 0)
                            {
                                this.listModel.addElement(ficheros[x].getAbsolutePath());
                            }
                        } catch (IOException ex)
                        {
                            Logger.getLogger(ReadPdf.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                this.vista.getjList1().setModel(this.listModel);
            }
        }

    }

    public void buscar(String directorio)
    {
        File dir = new File(directorio);

        File[] ficheros = dir.listFiles();

        if (ficheros.length != 0)
        {
            for (int x = 0; x < ficheros.length; x++)
            {
                this.vista.getjTextArea2().setText(this.vista.getjTextArea2().getText() + ficheros[x].getAbsolutePath() + "\n");
                if (!ficheros[x].isDirectory())
                {
                    String ext = obtener_extencion(ficheros[x].getAbsolutePath());
                    if (ext.equals("pdf"))
                    {
                        try
                        {
                            ReadPdfClass pdf = new ReadPdfClass(ficheros[x].getAbsolutePath());
                            pdf.leer(this.palabrabuscar, this.palabrabuscar2, this.palabrabuscar3);

                            if (pdf.getLineas().size() != 0)
                            {
                                this.listModel.addElement(ficheros[x].getAbsolutePath());
                            }
                        } catch (IOException ex)
                        {
                            Logger.getLogger(ReadPdf.class
                                    .getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                this.vista.getjList1().setModel(this.listModel);
            }
        }

    }

    public void comprobar_lista()
    {
        if (this.listModel.size() == 0)
        {
            this.listModel.addElement("Cadena de busqueda no encontrada");
            this.vista.getjList1().setEnabled(false);
            this.vista.getjButton3().setEnabled(false);
        } else
        {
            this.vista.getjList1().setEnabled(true);
            this.vista.getjButton3().setEnabled(true);
        }
    }

}
