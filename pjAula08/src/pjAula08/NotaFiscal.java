package pjAula08;

import java.util.List;

//não existe classe estática, existem atributos e métodos

/**
 * Modelagem Conceitual de Nota Fiscal
 * @author usuario
 * @data 02/04/2024
 */

public class NotaFiscal {
	//Atributo estático
	public static int sequencia = 1;
	public static double cambio;
	
	//Atributos
	private int numero;
	private String fornecedor;
	private double total;
	private List<NotaFiscalItem> itens;
	
	//Metodo construtor
	public NotaFiscal() {
		this.numero = sequencia++;
	}
	
	//Métodos Getters and Setters -> ctrl 3 -> sellect all
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public List<NotaFiscalItem> getItens() {
		return itens;
	}
	public void setItens(List<NotaFiscalItem> itens) {
		this.itens = itens;
	}
	
	public void zueira() {
		
	}
	
	public void teste() {
		
	}
	
	public void metodoDesespero() {
		
	}
	
	public void agoraVai() {
	
	}
	
	
	
