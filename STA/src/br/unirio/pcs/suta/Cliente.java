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

public class Cliente extends Pessoa {

    private String nomeUsuario;
    private String senhaUsuario;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

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
            String senhaUsuario,String email) {
        super(nome, sobreNome, cpf, telefone);
        this.nomeUsuario = nomeUsuario;
        this.senhaUsuario = senhaUsuario;
        this.email = email;
    }

    /**
     * Método que vai criar o xml caso ele não exista
     *
     */
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

    /**
     * Realizar cadastro do cliente no xml
     *
     */
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
                //Adiciona novo elemento Email do cliente
                Element email = new Element("email").setText(this.email);
                clientes.addContent(email);

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
     * Realiza o Login buscando os dados no Xml
     *
     * @param username - Recebe um nome de usuario pelo cliente
     * @param senha - Recebe uma senha de usuario pelo cliente
     * @return true - se o login for valido
     * @return false - se o login for invalido
     *
     */
    public boolean realizarLogin(String username, String senha) {

        SAXBuilder builder = new SAXBuilder();
        File xmlCliente = new File("clienteXml.xml");
        int confirmaLogin = 0;
        try {
            Document doc = (Document) builder.build(xmlCliente);
            Element rootNode = (Element) doc.getRootElement();

            List clientes = rootNode.getChildren();
            Iterator i = clientes.iterator(); // Instancia um iterador do arquivo xml

            while (i.hasNext()) { // Loop que percorre o arquivo xml buscando por elementos

                Element cliente = (Element) i.next(); // Itera pelos elementos do xml

                String usernameTemp = cliente.getChildText("username");
                String psswdTmp = cliente.getChildText("senha");

                if (usernameTemp.equals(username) && psswdTmp.equals(senha)) {

                    confirmaLogin = 1;
                    break;
                }
                confirmaLogin = 0;
            }

        } catch (JDOMException ex) {
            Logger.getLogger(Obra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Obra.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (confirmaLogin == 1) {

            return true;
        } else {
            return false;
        }
    }

    /**
     * Método que atualiza os dados de senha e telefone do cliente
     * 
     * @param tel - Telefone de entrada que será atualizado
     * @param senha - Senha de entrada que será atualizada
     * 
     */
    public void atualizarCadastroTelefone(String tel) {

        SAXBuilder builder = new SAXBuilder();
        File xmlCliente = new File("clienteXml.xml");

        try {
            Document doc = (Document) new SAXBuilder().build(xmlCliente);
            Element rootNode = doc.getRootElement();
            List list = rootNode.getChildren("cliente");
            XMLOutputter xmlOut = new XMLOutputter();

            for (int i = 0; i < list.size(); i++) {

                Element node = (Element) list.get(i);

                node.getChild("telefone").setText(tel);
               // node.getChild("senha").setText(senha);

                xmlOut.setFormat(Format.getPrettyFormat());
                xmlOut.output(doc, new FileWriter("clienteXml.xml"));
            }
        } catch (IOException io) {
            System.out.println(io.getMessage());
        } catch (JDOMException jdomex) {
            System.out.println(jdomex.getMessage());
        }

    }
    /**
     *
     * @param pswd
     */
    public void atualizarCadastroSenha(String senha,String senhaTmp) {
        SAXBuilder builder = new SAXBuilder();
        File xmlCliente = new File("clienteXml.xml");

        try {
            Document doc = (Document) new SAXBuilder().build(xmlCliente);
            Element rootNode = doc.getRootElement();
            List list = rootNode.getChildren("cliente");
            XMLOutputter xmlOut = new XMLOutputter();

            for (int i = 0; i < list.size(); i++) {

                Element node = (Element) list.get(i);

                node.getChild("senha").setText(senha);
               // node.getChild("senha").setText(senha);

                xmlOut.setFormat(Format.getPrettyFormat());
                xmlOut.output(doc, new FileWriter("clienteXml.xml"));
            }
        } catch (IOException io) {
            System.out.println(io.getMessage());
        } catch (JDOMException jdomex) {
            System.out.println(jdomex.getMessage());
        }
    }
    public void atualizarCadastroEmail(String email) {
        
        SAXBuilder builder = new SAXBuilder();
        File xmlCliente = new File("clienteXml.xml");

        try {
            Document doc = (Document) new SAXBuilder().build(xmlCliente);
            Element rootNode = doc.getRootElement();
            List list = rootNode.getChildren("cliente");
            XMLOutputter xmlOut = new XMLOutputter();

            for (int i = 0; i < list.size(); i++) {

                Element node = (Element) list.get(i);

                node.getChild("email").setText(email);
               // node.getChild("senha").setText(senha);

                xmlOut.setFormat(Format.getPrettyFormat());
                xmlOut.output(doc, new FileWriter("clienteXml.xml"));
            }
        } catch (IOException io) {
            System.out.println(io.getMessage());
        } catch (JDOMException jdomex) {
            System.out.println(jdomex.getMessage());
        }
        
    }
    public static void main(String[] args) {
      Cliente cliente = new Cliente("tiago", "melo", "123", "45678", "tmelo", "123","tiago.melo@gmail.com");
//    Cliente cliente2 = new Cliente("Lucas", "Azevedo", "456", "10201", "lg", "890");
//    cliente.realizarCadastro();
   cliente.realizarCadastro();
//    cliente.realizarLogin("tmelo", "123");
//        cliente.atualizarCadastroTelefone("123456789");
    }
}
