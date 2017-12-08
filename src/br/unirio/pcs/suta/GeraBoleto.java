/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unirio.pcs.suta;
import static org.jrimum.utilix.text.DateFormat.DDMMYYYY_B;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.jrimum.bopepo.BancosSuportados;
import org.jrimum.bopepo.Boleto;
import org.jrimum.bopepo.view.BoletoViewer;
import org.jrimum.domkee.comum.pessoa.endereco.CEP;
import org.jrimum.domkee.comum.pessoa.endereco.Endereco;
import org.jrimum.domkee.comum.pessoa.endereco.UnidadeFederativa;
import org.jrimum.domkee.financeiro.banco.ParametrosBancariosMap;
import org.jrimum.domkee.financeiro.banco.febraban.Agencia;
import org.jrimum.domkee.financeiro.banco.febraban.Banco;
import org.jrimum.domkee.financeiro.banco.febraban.Carteira;
import org.jrimum.domkee.financeiro.banco.febraban.Cedente;
import org.jrimum.domkee.financeiro.banco.febraban.ContaBancaria;
import org.jrimum.domkee.financeiro.banco.febraban.NumeroDaConta;
import org.jrimum.domkee.financeiro.banco.febraban.Sacado;
import org.jrimum.domkee.financeiro.banco.febraban.TipoDeCobranca;
import org.jrimum.domkee.financeiro.banco.febraban.TipoDeMoeda;
import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
import org.jrimum.domkee.financeiro.banco.febraban.Titulo.EnumAceite;
/**
 * 
 * 
 *
 * @author Lucas Azevedo
 * 
 */
public class GeraBoleto {

	public void fazBoleto (String nomeCliente, String cpfCliente, String enderecoCliente, String numeroCliente, String complementoCliente, String bairroCliente, String cepCliente, String cidadeCliente) {
		
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate hoje = LocalDate.now();
 		/* 
		 * INFORMANDO DADOS SOBRE O CEDENTE.
		 * */
		Cedente cedente = new Cedente("VLB - Venda de Livros Braille", "00.000.208/0001-00");
		
		// Informando dados sobre a conta bancária do cendente.		
		Banco banco = BancosSuportados.BANCO_RURAL.create();
		
		ContaBancaria contaBancariaCed = new ContaBancaria(banco);
		NumeroDaConta numeroConta = new NumeroDaConta(1234567);
		numeroConta.setDigitoDaConta("1");
		contaBancariaCed.setNumeroDaConta(numeroConta);
		
		
		Carteira carteira = new Carteira();
		carteira.setTipoCobranca(TipoDeCobranca.COM_REGISTRO);
		contaBancariaCed.setCarteira(carteira);
		contaBancariaCed.setAgencia( new Agencia( new Integer(61), new String("0")));
		cedente.addContaBancaria(contaBancariaCed);		
		
		/* 
		 * INFORMANDO DADOS SOBRE O SACADO.
		 * */
		Sacado sacado = new Sacado(nomeCliente, cpfCliente);

		// Informando o endereço do sacado.
		Endereco enderecoSac = new Endereco();
		enderecoSac.setLogradouro(enderecoCliente);
		enderecoSac.setNumero(numeroCliente);
		enderecoSac.setComplemento(complementoCliente);
		enderecoSac.setBairro(bairroCliente);
		enderecoSac.setCep(new CEP(cepCliente));
		enderecoSac.setLocalidade(cidadeCliente);
		enderecoSac.setUF(UnidadeFederativa.DESCONHECIDO);
		sacado.addEndereco(enderecoSac);

		
		/* 
		 * INFORMANDO OS DADOS SOBRE O TÍTULO.
		 * */		
		Titulo titulo = new Titulo(contaBancariaCed, sacado, cedente);
		titulo.setNumeroDoDocumento("222");
		titulo.setNossoNumero("2224491");
		titulo.setDigitoDoNossoNumero("1");
		titulo.setValor(BigDecimal.valueOf(9.65)); // -------->> Ainda precisar ser passado esse valor no método
		titulo.setDataDoDocumento(DDMMYYYY_B.parse(dtf.format(hoje)));
		titulo.setDataDoVencimento(DDMMYYYY_B.parse("31/12/2017"));
		titulo.setAceite(EnumAceite.A);
		titulo.setTipoDeMoeda(TipoDeMoeda.REAL);
		/*
		 * INFORMANDO MAIS DADOS BANCÁRIOS, QUANDO NECESSÁRIO.
		 * Dependendo do banco, talvez seja necessário informar mais dados além de: 
		 * 
		 * > Valor do título; 
		 * > Vencimento; 
		 * > Nosso número; 
		 * > Código do banco 
		 * > Data de vencimento; 
		 * > Agência/Código do cedente; 
		 * > Código da carteira; 
		 * > Código da moeda;
		 * 
		 * Definidos como padrão pela FEBRABAN.
		 * Verifique na documentação.
		 */
		titulo.setParametrosBancarios(new ParametrosBancariosMap());
		
		/* 
		 * INFORMANDO OS DADOS SOBRE O BOLETO.
		 * */
		Boleto boleto = new Boleto(titulo);
		boleto.setLocalPagamento("PAGAR PREFERENCIALMENTE EM AGÊNCIA DO BANCO RURAL");
		boleto.setInstrucao1("Após o vencimento cobrar multa de 2,00% e juros de 0,02% por mês de atraso.");
		boleto.setInstrucao3("Até o vencimento conceder desconto de 10%.");
		
		/* 
		 * GERANDO O BOLETO BANCÁRIO.
		 * */
		// Instanciando um objeto "BoletoViewer", classe responsável pela geração
		// do boleto bancário.
		BoletoViewer boletoViewer = new BoletoViewer(boleto);
		
		// Gerando o arquivo. No caso o arquivo mencionado será salvo na mesma
		// pasta do projeto. Outros exemplos:
		// WINDOWS: boletoViewer.getAsPDF("C:/Temp/MeuBoleto.pdf");
		// LINUX: boletoViewer.getAsPDF("/home/temp/MeuBoleto.pdf");
		File arquivoPdf = boletoViewer.getPdfAsFile("Boleto.pdf");
		
		// Mostrando o boleto gerado na tela.
		mostreBoletoNaTela(arquivoPdf);
	}
	
	
	private static void mostreBoletoNaTela(File arquivoBoleto) {
		
		java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
		try {
			desktop.open(arquivoBoleto);
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
	}
	
}
