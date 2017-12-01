package br.unirio.pcs.suta.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SutaUI {
	
	private JFrame janela;
	private JPanel painelPrincipal;
	
	public void montaTelaPrincipal(){
		  preparaJanela();
		  preparaPainelPrincipal();
		  preparaBotaoCadastrar();
		  preparaBotaoSair();
		  mostraJanela();
	}
	private void preparaJanela() {
	    janela = new JFrame("STA - Sistema de Tradu��o e Acessibilidade");
	    janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	private void preparaPainelPrincipal() {
		painelPrincipal = new JPanel();
		janela.add(painelPrincipal);
		
	}
	private void preparaBotaoCadastrar() {
		
		JButton botaoCadastrar = new JButton("Cadastre-se");
		botaoCadastrar.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		      //new EscolhedorDeXML().escolhe();
		    }
		  });
		  painelPrincipal.add(botaoCadastrar);
	}
	private void preparaBotaoSair() {
		
		JButton botaoSair = new JButton("Sair");
		  botaoSair.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		      System.exit(0);
		    }
		  });
		  painelPrincipal.add(botaoSair);
		
	}
	private void mostraJanela() {
            janela.pack();
	    janela.setSize(540, 540);
	    janela.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		new SutaUI().montaTelaPrincipal();

	}

}
