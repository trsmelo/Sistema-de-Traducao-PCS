package br.unirio.pcs.suta;

import java.io.File;
import java.io.FileOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import com.thoughtworks.xstream.XStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.*;
import org.w3c.dom.NodeList;

/**
 *
 * @author Tiago Melo
 */
public class CatalogoObra {

    public CatalogoObra() {

    }

    public void listaObras() {

        SAXBuilder builder = new SAXBuilder();
        File xmlObra = new File("obraXml.xml");

        try {
            Document doc = (Document) builder.build(xmlObra);
            Element rootNode = (Element) doc.getRootElement();

            List obras = rootNode.getChildren();
            Iterator i = obras.iterator();

            while (i.hasNext()) {

                Element obra = (Element) i.next();
                ArrayList<String> elements = new ArrayList<String>();

                String nome = obra.getChildText("nome");
                String autor = obra.getChildText("autor");
                String nota = obra.getChildText("nota");
                String preco = obra.getChildText("preco");
                String editora = obra.getChildText("editora");
                String sinopse = obra.getChildText("sinopse");

                elements.add(nome);
                elements.add(autor);
                elements.add(nota);
                elements.add(preco);
                elements.add(editora);
                elements.add(sinopse);

                for (String element : elements) {

                    System.out.println(element);
                }

            }

        } catch (JDOMException ex) {
            Logger.getLogger(Obra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Obra.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {

        CatalogoObra cat = new CatalogoObra();

        cat.listaObras();

    }

}
