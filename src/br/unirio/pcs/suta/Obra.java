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

public class Obra {

    private String nome;
    private String autor;
    private String nota;
    private String preco;
    private String editora;
    private String sinopse;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }
    
    
    public Obra(String nome, String autor, String nota, String preco, String editora, String sinopse) {

        this.nome = nome;
        this.autor = autor;
        this.nota = nota;
        this.preco = preco;
        this.editora = editora;
        this.sinopse = sinopse;

    }

    public Obra() {

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
            int count = 1;
            String countString = String.valueOf(count);

            try {
                Document doc = (Document) builder.build(xmlObra);
                Element rootNode = doc.getRootElement();
                Element subRootNode = new Element("obra").setAttribute("id", this.nome);
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
                //Adiciona novo elemento preco
                Element preco = new Element("preco").setText(this.preco);
                obras.addContent(preco);
                //Adiciona a sinopse da editora
                Element editora = new Element("editora").addContent(this.editora);
                obras.addContent(editora);
                //Adiciona a sinopse da obra
                Element sinopse = new Element("sinopse").addContent(this.sinopse);
                obras.addContent(sinopse);

                xmlOutput.setFormat(Format.getPrettyFormat());
                xmlOutput.output(doc, new FileWriter("obraXml.xml"));

                System.out.println("Obra adicionada com sucesso");
                count++;

            } catch (JDOMException ex) {
                Logger.getLogger(Obra.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Obra.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            criaXml();
        }
    }

    public void selecionarObra(String nomeObra) {

        SAXBuilder builder = new SAXBuilder();
        File xmlObra = new File("obraXml.xml");

        try {
            Document doc = (Document) builder.build(xmlObra);
            Element rootNode = (Element) doc.getRootElement();

            List obras = rootNode.getChildren();
            Iterator i = obras.iterator();

            while (i.hasNext()) {

                Element obra = (Element) i.next();
                String nomeObraTemp = obra.getChildText("nome");
                List<String> elements = new ArrayList<String>();

                if (nomeObraTemp.equals(nomeObra)) {

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
                }
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

    public List<Obra> deletarObra() {  // Refazer para remover a obra do xml

        SAXBuilder builder = new SAXBuilder();
        File xmlObra = new File("obraXml.xml");
        List<Obra> elements = new ArrayList<Obra>();
        
        try {
            Document doc = (Document) builder.build(xmlObra);
            Element rootNode = (Element) doc.getRootElement();
            Element subRootNode = rootNode.getChild("obra");

            List obras = rootNode.getChildren();

            Iterator obrasTag = rootNode.getChildren("obra").iterator();
           
            while (obrasTag.hasNext()) {

                Element obra = (Element) obrasTag.next();      
               
               // if (nomeObraTemp.equals(nomeObra)) {

                    String nome = obra.getChildText("nome");
                    String autor = obra.getChildText("autor");
                    String nota = obra.getChildText("nota");
                    String preco = obra.getChildText("preco");
                    String editora = obra.getChildText("editora");
                    String sinopse = obra.getChildText("sinopse");

                    Obra ob = new Obra(nome, autor, nota, preco, editora, sinopse);
                    elements.add(ob);

                //}
            }
        } catch (JDOMException ex) {
            Logger.getLogger(Obra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Obra.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return elements;
    }

    public String visualizarPreco() {

        return this.preco;

    }

    public static void main(String[] args) {
//
//       Obra obra = new Obra("tiago", "melo", "10", "abc", "zmshsa", "iassa");
//        Obra obra2 = new Obra("Lucas", "Azevedo", "10", "abcde", "fghij", "lmnop");
//        obra.registraObra();
//        obra2.registraObra();
//        obra.deletarObra();
//        //obra2.selecionarObra("tiago");
    }
}
