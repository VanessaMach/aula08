package br.unisal.Gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.unisal.Modelagem.Produto;
import br.unisal.Modelagem.Situacao;
import br.unisal.Modelagem.UnidadeMedida;

public class frmProduto extends JFrame implements ActionListener{
	
	JLabel lbCodigo, lbDescricao, lbUnidadeMedida, lbLargura, lbComprimento, lbSituacao, lbLocalizacao;
	JTextField txtCodigo, txtDescricao, txtLargura, txtComprimento, txtLocalizacao;
	JComboBox cbxUnidadeMedida, cbxSituacao;
	JPanel pnCampos, pnBotoes;
	JButton btnInclui, btnExclui, btnAltera, btnPesquisa, btnLimpar;
	List<Produto> bdProduto= new ArrayList<Produto>();
	
	public frmProduto() {
		super("Cadastro de Produto");
		setSize(480, 250);
		setLayout(new BorderLayout());
		
		//2 Passo contruir os objetos
		lbCodigo = new JLabel("Código");
		lbDescricao = new JLabel("Descrição");
		lbUnidadeMedida = new JLabel("Un. Medida");
		lbLargura = new JLabel("Largura");
		lbComprimento = new JLabel("Comprimento");
		lbSituacao = new JLabel("Situação");
		lbLocalizacao = new JLabel("Localização");
		
		lbCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		lbDescricao.setHorizontalAlignment(SwingConstants.CENTER);
		lbUnidadeMedida.setHorizontalAlignment(SwingConstants.CENTER);
		lbLargura.setHorizontalAlignment(SwingConstants.CENTER);
		lbComprimento.setHorizontalAlignment(SwingConstants.CENTER);
		lbSituacao.setHorizontalAlignment(SwingConstants.CENTER);
		lbLocalizacao.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		txtCodigo = new JTextField();
		txtDescricao = new JTextField();
		txtLargura = new JTextField();
		txtComprimento = new JTextField();
		txtLocalizacao = new JTextField();
		cbxSituacao = new JComboBox<Situacao>(Situacao.values());
		cbxUnidadeMedida = new JComboBox<String>(UnidadeMedida.getUnidades());
		
		btnInclui = new JButton("Incluir");
		btnAltera = new JButton("Alterar");
		btnExclui = new JButton("Excluir");
		btnPesquisa = new JButton("Pesquisa");
		btnLimpar = new JButton("Limpar");
		
		pnCampos = new JPanel(new GridLayout(7,2));
		pnBotoes = new JPanel(new GridLayout(1,4));
		
		//3 Passo adicionar os campos ao frame
		pnCampos.add(lbCodigo);
		pnCampos.add(txtCodigo);
		pnCampos.add(lbDescricao);
		pnCampos.add(txtDescricao);
		pnCampos.add(lbUnidadeMedida);
		pnCampos.add(cbxUnidadeMedida);
		pnCampos.add(lbLargura);
		pnCampos.add(txtLargura);
		pnCampos.add(lbComprimento);
		pnCampos.add(txtComprimento);
		pnCampos.add(lbSituacao);
		pnCampos.add(cbxSituacao);
		pnCampos.add(lbLocalizacao);
		pnCampos.add(txtLocalizacao);
		
		add(pnCampos, BorderLayout.CENTER);
		
		pnBotoes.add(btnInclui);
		pnBotoes.add(btnAltera);
		pnBotoes.add(btnExclui);
		pnBotoes.add(btnPesquisa);
		pnBotoes.add(btnLimpar);
		
		add(pnBotoes, BorderLayout.SOUTH);
		
		//4 Passo inclui os elementos no Listener de Ações
		btnInclui.addActionListener(this);
		btnAltera.addActionListener(this);
		btnExclui.addActionListener(this);
		btnPesquisa.addActionListener(this);
		btnLimpar.addActionListener(this);
		
		setVisible(true);
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(ProdutoEncontrado != null) {
			btnExclui.setEnabled(true);
			btnAltera.setEnabled(true);
		}else {
			btnExclui.setEnabled(false);
			btnAltera.setEnabled(false);
		}
		
		if (e.getSource() == btnLimpar) {
			
			txtCodigo.setText(null);
			txtDescricao.setText(null);
			txtLargura.setText(null);
			txtComprimento.setText(null);
			txtLocalizacao.setText(null);
		}
		
		if(e.getSource() == btnInclui) {
			Produto p = instanciar();
			if(p != null) {
				bdProduto.add(p);
			}
		}
		if(e.getSource() == btnAltera) {
			for(Produto p : bdProduto) {
				if(p.getCodigo() == p.getCodigo()) {
					Produto objeto = instanciar();
					if(objeto != null) {
						p = objeto;
					}
				}
			}
		}
		System.out.println(bdProduto);
	}
	
	private Produto instanciar() {
		
		Produto ProdutoEncontrado = new Produto ();
		
		Produto p = new Produto();
		try {
			p.setCodigo(Integer.parseInt(txtCodigo.getText()));
		}catch(NumberFormatException e) {
			JOptionPane.showInternalMessageDialog(null, "Codigo do Produto Inválido", "Validação", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		p.setDescricao(txtDescricao.getText());
		p.setUn(UnidadeMedida.values()[cbxUnidadeMedida.getSelectedIndex()]);
		
		try {
			p.setCodigo(Integer.parseInt(txtLargura.getText()));
		}catch(NumberFormatException e) {
			JOptionPane.showInternalMessageDialog(null, "Largura do Produto Inválido", "Validação", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		p.setDescricao(txtDescricao.getText());
		p.setUn(UnidadeMedida.values()[cbxUnidadeMedida.getSelectedIndex()]);
		
		try {
			p.setCodigo(Integer.parseInt(txtComprimento.getText()));
		}catch(NumberFormatException e) {
			JOptionPane.showInternalMessageDialog(null, "Comprimento do Produto Inválido", "Validação", JOptionPane.ERROR_MESSAGE);
		}
		p.setDescricao(txtDescricao.getText());
		p.setUn(UnidadeMedida.values()[cbxUnidadeMedida.getSelectedIndex()]);
		
		p.setSituacao(Situacao.values()[cbxSituacao.getSelectedIndex()]);
		p.setLocalizacao(txtLocalizacao.getText());
		return p;
		
	}
	
	private void pesquisarProduto() {
		try {
			int codigo = Integer.parseInt(txtCodigo.getText());
			for (Produto p : bdProduto) {
				if (p.getCodigo() == codigo) {
					break;
				}
			}
			
			if (ProdutoEncontrado != null) {
				//Produto Encontrado, atribua-o a produtoAtual
				ProdutoAtual = ProdutoEncontrado;
				
			}
		}
		
	}
	
	public static void main(String[] args) {
		frmProduto frm = new frmProduto();
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
	
