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
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.*;

/**
 *
 * @author OI392639
 */
@Data
public class Obra {

    private String id;
    private String nome;
    private String autor;
    private String nota;
    private String sinopse;

    public Obra(String id, String nome, String autor, String nota, String sinopse) {
        this.id = id;
        this.nome = nome;
        this.autor = autor;
        this.nota = nota;
        this.sinopse = sinopse;
    }
    //método que cria o Xml Caso ele não exista
    public void criaXml() {
        
        Element obras = new Element("obras");
        Document doc = new Document(obras);
        XMLOutputter xmlOutput = new XMLOutputter();
        
        System.out.println("Arquivo Criado com Sucesso");
        
        try {
            xmlOutput.output(doc, new FileWriter("obraXml.xml"));
        } catch (IOException ex) {
            Logger.getLogger(Obra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //método que cadastra obras no Xml
    /**
     * Método que vai inserir uma obra no XML e checar se ele existe, criando 
     * caso não exista.
     */
    public void registraObra() {

        File xmlObra = new File("obraXml.xml");

        if (xmlObra.exists()) {
            
            SAXBuilder builder = new SAXBuilder();
            XMLOutputter xmlOutput = new XMLOutputter();

            try {
                Document doc = (Document) builder.build(xmlObra);
                Element rootNode = doc.getRootElement();
                Element subRootNode = new Element("obra");
                rootNode.addContent(subRootNode);

                Element obras = subRootNode;

                // Adiciona novo elemento nome da obra
                Element nome = new Element("nome").setText(this.nome);
                obras.addContent(nome);
                //Adiciona novo elemento autor da obra
                Element autor = new Element("autor").setText(this.autor);
                obras.addContent(autor);
                //Adiciona novo elemento nota que vai levar a obra
                Element nota = new Element("nota").setText(this.nota);
                obras.addContent(nota);

                xmlOutput.setFormat(Format.getPrettyFormat());
                xmlOutput.output(doc, new FileWriter("obraXml.xml"));

                System.out.println("Obra adicionada com sucesso");

            } catch (JDOMException ex) {
                Logger.getLogger(Obra.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Obra.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            criaXml();
        }
    }
//    public static void main(String[] args){
//           
//        Obra obra = new Obra("1","tiago","melo","10","abc");
//        Obra obra2 = new Obra("2","Lucas","Azevedo","10","abcde");
//        //obra.registraObra();
//        obra2.registraObra();
//    }
}

