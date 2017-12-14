package Buscador_IMV;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author pej7132
 */
public class VistaBuscadorpdf extends javax.swing.JFrame
{

    /**
     * Creates new form VistaBuscadorpdf
     */
    public VistaBuscadorpdf()
    {
        initComponents();
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        invisible();
        Image icon = new ImageIcon(getClass().getResource("house-searcher.png")).getImage();
        setIconImage(icon);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jMenu3 = new javax.swing.JMenu();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane2.setMinimumSize(null);

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jTextArea2.setRows(5);
        jTextArea2.setEnabled(false);
        jScrollPane2.setViewportView(jTextArea2);

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Por Favor Seleccione La Carpeta Donde Buscar");
        jTextField1.setDragEnabled(true);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Seleccionar Carpeta");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Archivo/ Ubicacion");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Lineas en las que aparece el texto a buscar");

        jScrollPane3.setMinimumSize(null);

        jList1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel<String>()
        {
            String[] strings = { "Archivo 1", "Archivo 2", "Archivo 3", "Archivo 4", "Archivo 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.setEnabled(false);
        jScrollPane3.setViewportView(jList1);

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField2.setText("Palabra a Buscar 1");

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Buscar en esta Carpeta");
        jButton2.setToolTipText("Buscaremos en todos los archivos pdf de la carpeta seleccionada");

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setText("Abrir PDF");
        jButton3.setEnabled(false);

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField3.setText("Palabra a Buscar 2");

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField4.setText("Palabra a Buscar  3");

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton4.setText("Buscar en Carpeta y SubCarpetas");
        jButton4.setToolTipText("Este metodo sera un poco mas lento ya que accedera a todas las carpetas que esten dentro de la carpeta seleccionada");

        jButton5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton5.setText("Cancelar");
        jButton5.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                                .addGap(21, 21, 21))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JButton getjButton1()
    {
        return jButton1;
    }

    public void setjButton1(JButton jButton1)
    {
        this.jButton1 = jButton1;
    }

    public JLabel getjLabel1()
    {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1)
    {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel2()
    {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2)
    {
        this.jLabel2 = jLabel2;
    }

    public JMenu getjMenu3()
    {
        return jMenu3;
    }

    public void setjMenu3(JMenu jMenu3)
    {
        this.jMenu3 = jMenu3;
    }

    public JScrollPane getjScrollPane2()
    {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2)
    {
        this.jScrollPane2 = jScrollPane2;
    }

    public JTextArea getjTextArea2()
    {
        return jTextArea2;
    }

    public void setjTextArea2(JTextArea jTextArea2)
    {
        this.jTextArea2 = jTextArea2;
    }

    public JTextField getjTextField1()
    {
        return jTextField1;
    }

    public void setjTextField1(JTextField jTextField1)
    {
        this.jTextField1 = jTextField1;
    }

    public JList<String> getjList1()
    {
        return jList1;
    }

    public void setjList1(JList<String> jList1)
    {
        this.jList1 = jList1;
    }

    public JScrollPane getjScrollPane3()
    {
        return jScrollPane3;
    }

    public void setjScrollPane3(JScrollPane jScrollPane3)
    {
        this.jScrollPane3 = jScrollPane3;
    }

    public JButton getjButton2()
    {
        return jButton2;
    }

    public void setjButton2(JButton jButton2)
    {
        this.jButton2 = jButton2;
    }

    public JTextField getjTextField2()
    {
        return jTextField2;
    }

    public void setjTextField2(JTextField jTextField2)
    {
        this.jTextField2 = jTextField2;
    }

    public JButton getjButton5()
    {
        return jButton5;
    }

    public void setjButton5(JButton jButton5)
    {
        this.jButton5 = jButton5;
    }

    public void paso1()
    {

        this.jTextField2.setVisible(true);
        this.jTextField3.setVisible(true);
        this.jTextField4.setVisible(true);
        this.jButton2.setVisible(true);
        this.jButton4.setVisible(true);
        this.jTextField2.setEnabled(true);
        this.jTextField3.setEnabled(true);
        this.jTextField4.setEnabled(true);
        this.jButton2.setEnabled(true);
        this.jButton4.setEnabled(true);
        this.jButton5.setVisible(false);
        this.jButton5.setVisible(false);
        this.jScrollPane2.setVisible(false);
        this.jTextArea2.setVisible(false);
        this.jButton1.setEnabled(true);
    }

    public void paso2()
    {
        this.jList1.setVisible(true);
        this.jLabel1.setVisible(true);
        this.jLabel2.setVisible(true);
        this.jButton3.setVisible(true);
        this.jScrollPane3.setVisible(true);
        this.jButton5.setVisible(false);
        this.jTextField2.setEnabled(true);
        this.jTextField3.setEnabled(true);
        this.jTextField4.setEnabled(true);
        this.jButton2.setEnabled(true);
        this.jButton4.setEnabled(true);
    }

    public void busqueda()
    {
        this.jTextArea2.setVisible(true);
        this.jScrollPane2.setVisible(true);
        this.jButton5.setVisible(true);
        this.jTextField2.setEnabled(false);
        this.jTextField3.setEnabled(false);
        this.jTextField4.setEnabled(false);
        this.jButton2.setEnabled(false);
        this.jButton4.setEnabled(false);
        this.jList1.setVisible(true);
        this.jScrollPane3.setVisible(true);
        this.jLabel1.setVisible(true);
        this.jLabel2.setVisible(true);
        this.jList1.setEnabled(false);
        this.jScrollPane3.setEnabled(false);
        this.jButton3.setVisible(true);
        this.jButton1.setEnabled(false);
        this.jTextArea2.setEnabled(false);
        this.jScrollPane2.setEnabled(false);

    }

    public void invisible()
    {
        this.jList1.setVisible(false);
        this.jButton2.setVisible(false);
        this.jTextArea2.setVisible(false);
        this.jLabel1.setVisible(false);
        this.jLabel2.setVisible(false);
        this.jTextField2.setVisible(false);
        this.jScrollPane2.setVisible(false);
        this.jScrollPane3.setVisible(false);
        this.jButton3.setVisible(false);
        this.jTextField3.setVisible(false);
        this.jTextField4.setVisible(false);
        this.jButton4.setVisible(false);
        this.jButton5.setVisible(false);

    }

    public void cancerlar()
    {
        this.jTextField2.setVisible(true);
        this.jTextField3.setVisible(true);
        this.jTextField4.setVisible(true);
        this.jButton2.setVisible(true);
        this.jButton4.setVisible(true);
        this.jTextField2.setEnabled(true);
        this.jTextField3.setEnabled(true);
        this.jTextField4.setEnabled(true);
        this.jButton2.setEnabled(true);
        this.jButton4.setEnabled(true);
        this.jButton5.setVisible(false);
        this.jScrollPane2.setEnabled(true);
        this.jTextArea2.setEnabled(true);
        this.jScrollPane2.setVisible(true);
        this.jTextArea2.setVisible(true);
        this.jButton1.setEnabled(true);
        this.jList1.setEnabled(true);
        this.jScrollPane3.setEnabled(true);
        this.jButton3.setEnabled(true);
    }

    public JTextField getjTextField3()
    {
        return jTextField3;
    }

    public void setjTextField3(JTextField jTextField3)
    {
        this.jTextField3 = jTextField3;
    }

    public JButton getjButton3()
    {
        return jButton3;
    }

    public void setjButton3(JButton jButton3)
    {
        this.jButton3 = jButton3;
    }

    public JTextField getjTextField4()
    {
        return jTextField4;
    }

    public JButton getjButton4()
    {
        return jButton4;
    }

    public void setjButton4(JButton jButton4)
    {
        this.jButton4 = jButton4;
    }

    public void setjTextField4(JTextField jTextField4)
    {
        this.jTextField4 = jTextField4;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables

}
