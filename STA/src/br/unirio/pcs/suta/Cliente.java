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
	/**
	 * Protï¿½tipo do mï¿½todo de cadastro de cliente.
	 * 
	 * Realizar uma reengenharia desse mï¿½todo, de forma que nï¿½o seja necessï¿½rio passar um cliente como argumento.
	 * 
	 * @param cliente Cliente criado com os dados.
	 */
	public void realizarCadastro() {
                //Cliente cliente = new Cliente();
		XStream xstream = new XStream();

		try {

			SAXBuilder builder = new SAXBuilder();
			//File xmlFile = new File("C:\\Users\\Tiago\\workspace\\clienteXML.xml");
			File xmlFile = new File("C:\\Users\\Tiago\\workspace\\STA\\src\\clienteXML.xml");
			  
			Document doc = (Document) builder.build(xmlFile);
			Element rootNode = doc.getRootElement();

			// Raï¿½z do xml
			Element staff = rootNode;

			// Adiciona novo elemento nome
			Element name = new Element("nome").setText(this.nome);
			staff.addContent(name);

			// Adiciona novo sobreNome element
			Element sobreNome = new Element("sobreNome").setText(this.sobreNome);
			staff.addContent(sobreNome);

			// Adiciona novo cpf element
			Element cpf = new Element("cpf").setText(this.cpf);
			staff.addContent(cpf);

			// Adiciona novo telefone element
			Element telefone = new Element("telefone").setText(this.telefone);
			staff.addContent(telefone);

			// Adiciona novo nomeUsuario element
			Element nomeUsuario = new Element("nomeUsuario").setText(this.nomeUsuario);
			staff.addContent(nomeUsuario);

			// Adiciona novo senhaUsuario element
			Element senhaUsuario = new Element("senhaUsuario").setText(this.senhaUsuario);
			staff.addContent(senhaUsuario);

			// update salary value
			// staff.getChild("salary").setText("7000");

			// remove firstname element
			// staff.removeChild("firstname");

			XMLOutputter xmlOutput = new XMLOutputter();

			// display nice nice
			xmlOutput.setFormat(Format.getPrettyFormat());
			xmlOutput.output(doc, new FileWriter("C:\\Users\\Tiago\\workspace\\clienteXML.xml"));

			// xmlOutput.output(doc, System.out);

			System.out.println("Cliente adicionado com sucesso");

		} catch (IOException io) {
			io.printStackTrace();
		} catch (JDOMException e) {
			e.printStackTrace();
		}

	}
        /**
         * 
         * 
         */
        public boolean realizarLogin(String username, String senha){
            
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
            
            if(username.equals(staff.getAttribute(username)) && senha.equals(staff.getAttribute(senha))){
                
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
}