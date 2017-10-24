package Buscador_IMV;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

/**
 *
 * @author pej7132
 */
public class ReadPdfClass
{

    String directorio;
    PDDocument document;
    ArrayList<String> lineas;

    public ReadPdfClass(String directorio) throws IOException
    {

        this.document = new PDDocument();
        this.directorio = directorio;
        this.lineas = new ArrayList<>();
    }

    public void leer(String palabraabuscar, String palabraabuscar2, String palabrabuscar3) throws IOException
    {

        this.document = PDDocument.load(new File(this.directorio));

        this.document.getClass();

        if (!this.document.isEncrypted())
        {

            PDFTextStripperByArea stripper = new PDFTextStripperByArea();
            stripper.setSortByPosition(true);

            PDFTextStripper tStripper = new PDFTextStripper();

            String pdfFileInText = tStripper.getText(this.document);

            String lines[] = pdfFileInText.split("\\r?\\n");
            for (int i = 0; i < lines.length; i++)
            {
                String line = lines[i].toLowerCase();
                if (line.contains(palabraabuscar) || line.contains(palabraabuscar2) || line.contains(palabrabuscar3))
                {

                    this.lineas.add(line);

                }
            }
        }
        document.close();

    }

    public String getDirectorio()
    {
        return directorio;
    }

    public void setDirectorio(String directorio)
    {
        this.directorio = directorio;
    }

    public PDDocument getDocument()
    {
        return document;
    }

    public void setDocument(PDDocument document)
    {
        this.document = document;
    }

    public ArrayList<String> getLineas()
    {
        return lineas;
    }

    public void setLineas(ArrayList<String> lineas)
    {
        this.lineas = lineas;
    }

}
