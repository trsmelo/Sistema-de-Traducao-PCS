package br.unirio.pcs.suta;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Funcionario extends Pessoa {

    private String matricula;
    private String nomeUsuario;
    private String senha;

    public Funcionario(String nome, String sobreNome, String cpf, String telefone, String matricula, String nomeUsuario, String senha) {
        super(nome, sobreNome, cpf, telefone);
        this.matricula = matricula;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * Método que vai criar o xml caso ele não exista
     *
     */
    public void criaXml() {

        Element funcionarios = new Element("funcionarios");
        Document doc = new Document(funcionarios);
        XMLOutputter xmlOutput = new XMLOutputter();

        System.out.println("Arquivo Criado com Sucesso");

        try {
            xmlOutput.output(doc, new FileWriter("funcionarioXml.xml"));

        } catch (IOException ex) {
            Logger.getLogger(Obra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método que vai realizar o cadastro do funcionário
     *
     */
    public void realizarCadastro() {

        File xmlFuncionario = new File("funcionarioXml.xml");

        if (xmlFuncionario.exists()) {

            SAXBuilder builder = new SAXBuilder();
            XMLOutputter xmlOutput = new XMLOutputter();

            try {
                Document doc = (Document) builder.build(xmlFuncionario);
                Element rootNode = doc.getRootElement();//Pega a raiz do xml
                Element subRootNode = new Element("funcionario");//Adiciona um filho ao xml
                rootNode.addContent(subRootNode);

                Element funcionarios = subRootNode;

                // Adiciona novo elemento nome da cliente
                Element nome = new Element("nome").setText(this.nome);
                funcionarios.addContent(nome);
                //Adiciona novo elemento sobrenome do cliente
                Element sobrenome = new Element("sobrenome").setText(this.sobreNome);
                funcionarios.addContent(sobrenome);
                //Adiciona novo elemento cpf do cliente
                Element cpf = new Element("cpf").setText(this.cpf);
                funcionarios.addContent(cpf);
                //Adiciona novo telefone do cliente
                Element telefone = new Element("telefone").setText(this.telefone);
                funcionarios.addContent(telefone);
                //Adiciona novo elemento Username do cliente
                Element user = new Element("username").setText(this.nomeUsuario);
                funcionarios.addContent(user);
                //Adiciona novo elemento Senha do cliente
                Element senha = new Element("senha").setText(this.senha);
                funcionarios.addContent(senha);
                //Adiciona novo elemento matricula do Funcionario
                Element matricula = new Element("matricula").setText(this.matricula);
                funcionarios.addContent(matricula);

                xmlOutput.setFormat(Format.getPrettyFormat());
                xmlOutput.output(doc, new FileWriter("funcionarioXml.xml"));

                System.out.println("funcionario adicionado com sucesso");

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

        SAXBuilder builder = new SAXBuilder();
        File xmlFuncionario = new File("funcionarioXml.xml");
        int confirmaLogin = 0;
        try {
            Document doc = (Document) builder.build(xmlFuncionario);
            Element rootNode = (Element) doc.getRootElement();

            List funcionarios = rootNode.getChildren();
            Iterator i = funcionarios.iterator(); // Instancia um iterador do arquivo xml

            while (i.hasNext()) { // Loop que percorre o arquivo xml buscando por elementos

                Element funcionario = (Element) i.next(); // Itera pelos elementos do xml

                String usernameTemp = funcionario.getChildText("username");
                String psswdTmp = funcionario.getChildText("senha");

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

//    public static void main(String[] args) {
//        
//        Funcionario func = new Funcionario("tiago", "melo", "123", "4356", "001", "admin", "admin");
//        
//        func.realizarCadastro();
//    }
}
