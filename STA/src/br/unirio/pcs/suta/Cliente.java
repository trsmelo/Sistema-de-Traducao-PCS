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

public class Cliente extends Pessoa {

    private String nomeUsuario;
    private String senhaUsuario;

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public Cliente() {

    }

    public Cliente(String nome, String sobreNome, String cpf, String telefone, String nomeUsuario,
            String senhaUsuario) {
        super(nome, sobreNome, cpf, telefone);
        this.nomeUsuario = nomeUsuario;
        this.senhaUsuario = senhaUsuario;
    }

    public void criaXml() {

        Element clientes = new Element("clientes");
        Document doc = new Document(clientes);
        XMLOutputter xmlOutput = new XMLOutputter();

        System.out.println("Arquivo Criado com Sucesso");

        try {
            xmlOutput.output(doc, new FileWriter("clienteXml.xml"));
            
        } catch (IOException ex) {
            Logger.getLogger(Obra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void realizarCadastro() {
        
        File xmlCliente = new File("clienteXml.xml");

        if (xmlCliente.exists()) {

            SAXBuilder builder = new SAXBuilder();
            XMLOutputter xmlOutput = new XMLOutputter();

            try {
                Document doc = (Document) builder.build(xmlCliente);
                Element rootNode = doc.getRootElement();//Pega a raiz do xml
                Element subRootNode = new Element("cliente");//Adiciona um filho ao xml
                rootNode.addContent(subRootNode);

                Element clientes = subRootNode;

                // Adiciona novo elemento nome da cliente
                Element nome = new Element("nome").setText(this.nome);
                clientes.addContent(nome);
                //Adiciona novo elemento sobrenome do cliente
                Element sobrenome = new Element("sobrenome").setText(this.sobreNome);
                clientes.addContent(sobrenome);
                //Adiciona novo elemento cpf do cliente
                Element cpf = new Element("cpf").setText(this.cpf);
                clientes.addContent(cpf);
                //Adiciona novo telefone do cliente
                Element telefone = new Element("telefone").setText(this.telefone);
                clientes.addContent(telefone);
                //Adiciona novo elemento Username do cliente
                Element user = new Element("username").setText(this.nomeUsuario);
                clientes.addContent(user);
                //Adiciona novo elemento Senha do cliente
                Element senha = new Element("senha").setText(this.senhaUsuario);
                clientes.addContent(senha);

                xmlOutput.setFormat(Format.getPrettyFormat());
                xmlOutput.output(doc, new FileWriter("clienteXml.xml"));

                System.out.println("Cliente adicionado com sucesso");

            } catch (JDOMException ex) {
                Logger.getLogger(Obra.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Obra.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            criaXml();
        }
    }

    /**
     *
     *
     */
    public boolean realizarLogin(String username, String senha) {

        XStream xstream = new XStream();

        try {
            SAXBuilder builder = new SAXBuilder();
            File xmlFile = new File("C:\\Users\\Tiago\\workspace\\clienteXML.xml");

            Document doc = (Document) builder.build(xmlFile);
            Element rootNode = doc.getRootElement();

            // Raiz do xml
            Element staff = rootNode;

            // Element loginname = new Element("nomeUsuario");
            //Element senhaClient = new Element("senhaUsuario");
            if (username.equals(staff.getAttribute(username)) && senha.equals(staff.getAttribute(senha))) {

                System.out.println(staff.getAttribute(username));

                return true;
            }

        } catch (JDOMException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }
//        public static void main(String[] args){
//           
//            Cliente cliente = new Cliente("tiago","melo","123","45678","tmelo","123");
//            Cliente cliente2 = new Cliente("Lucas","Azevedo","456","10201","lg","890");
//            cliente2.realizarCadastro();
//            //cliente.realizarCadastro();
//    }
}
