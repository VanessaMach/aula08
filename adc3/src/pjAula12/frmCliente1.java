package pjAula12;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class frmCliente1 extends JFrame
				implements ActionListener{
	
	//1 Passo - Declaração dos Objetos
	JLabel lbNome, lbCNPJ, lbTelefone, lbStatus, lbEmail, lbPessoa, lbDataCadastro, lbFaturamento, lbEstado;
	JTextField txtNome, txtEmail;
	JFormattedTextField txtCNPJ, txtTelefone, txtDataCadastro, txtFaturamento;
	JComboBox<String> cbxStatus, cbxPessoa, cbxEstado;
	MaskFormatter mascaraCNPJ, mascaraTelefone;
	
	 String status[] = {"Ativo", "Inativo"};
	 String pessoa[] = {"Pessoa Física", "Pessoa Jurídica"};
	 String estados[] = {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA",
	            "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"};
	JButton btCadastrar, btLimpar, btSair, btConsultar;
	JPanel pnCampos, pnBotoes;
	BorderLayout layout;
	GridLayout gridCampos, gridBotoes;
	File arquivo = new File("Clientes.txt");

	public frmCliente1() {
		setTitle("Cadastro de Clientes");
		setLayout(layout = new BorderLayout());
		setSize(400, 300);
		setLocation(50, 50); //posição em que exibe
		
		//2 Passo Instanciação dos Objetos
		pnCampos = new JPanel();
		pnBotoes = new JPanel();
		gridCampos = new GridLayout(4,2);
		gridBotoes = new GridLayout(1,4);
		
		lbNome = new JLabel("Razão Social ");
        lbCNPJ = new JLabel("CNPJ ");
        lbTelefone = new JLabel("Telefone ");
        lbStatus = new JLabel("Status ");
        lbEmail = new JLabel("Email ");
        lbPessoa = new JLabel("Pessoa ");
        lbDataCadastro = new JLabel("Data de Cadastro ");
        lbFaturamento = new JLabel("Faturamento ");
        lbEstado = new JLabel("Estado ");
	
		txtNome = new JTextField(20);
		try {
			mascaraCNPJ = new MaskFormatter(
					"##.###.###/####-##");
			mascaraTelefone = new MaskFormatter(
					"(##)#####-####");
		}catch(ParseException e) {
			System.err.println("Falha na Máscara.");
		}
		
		txtCNPJ = new JFormattedTextField(mascaraCNPJ);
		txtTelefone = new JFormattedTextField(mascaraTelefone);
		txtDataCadastro = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
        txtDataCadastro.setValue(new Date());
        txtFaturamento = new JFormattedTextField(NumberFormat.getCurrencyInstance());

        cbxStatus = new JComboBox<String>(status);
        cbxPessoa = new JComboBox<String>(pessoa);
        cbxEstado = new JComboBox<String>(estados);
	
		btCadastrar = new JButton("Cadastrar");
		btCadastrar.setMnemonic('C');
		btCadastrar.setToolTipText("Cadastra um cliente");
		btCadastrar.addActionListener(this);
		
		btLimpar = new JButton("Limpar");
		btLimpar.setMnemonic('L');
		btLimpar.setToolTipText("Limpa os campos");
		btLimpar.addActionListener(this);
		
		btSair = new JButton("Sair");
		btSair.setMnemonic('S');
		btSair.setToolTipText("Sai do cadastro");
		btSair.addActionListener(this);
		
		btConsultar = new JButton("Consultar");
		btConsultar.setMnemonic('t');
		btConsultar.setToolTipText("Consulta cadastro");
		btConsultar.addActionListener(this);
		
		pnCampos.setLayout(gridCampos);
		pnBotoes.setLayout(gridBotoes);
		
		//3 Passo adicionar o campos a Frame
		pnCampos.add(lbNome);
        pnCampos.add(txtNome);
        pnCampos.add(lbEmail);
        pnCampos.add(txtEmail);
        pnCampos.add(lbCNPJ);
        pnCampos.add(txtCNPJ);
        pnCampos.add(lbTelefone);
        pnCampos.add(txtTelefone);
        pnCampos.add(lbStatus);
        pnCampos.add(cbxStatus);
        pnCampos.add(lbPessoa);
        pnCampos.add(cbxPessoa);
        pnCampos.add(lbDataCadastro);
        pnCampos.add(txtDataCadastro);
        pnCampos.add(lbFaturamento);
        pnCampos.add(txtFaturamento);
        pnCampos.add(lbEstado);
        pnCampos.add(cbxEstado);
		add(pnCampos, BorderLayout.NORTH);
		
		pnBotoes.add(btCadastrar);
		pnBotoes.add(btLimpar);
		pnBotoes.add(btConsultar);
		pnBotoes.add(btSair);
		add(pnBotoes, BorderLayout.SOUTH);
		
		setResizable(false);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()== btCadastrar){
			try{				
				//Se o arquivo não existir, cria.
				if(!arquivo.exists()){
					OutputStream f0 = 
					new FileOutputStream("Clientes.txt");	
				}	
				
				PrintWriter out = 
						new PrintWriter(
							new FileWriter(arquivo, true));
				out.print(txtNome.getText());
                out.print(" | ");
                out.print(txtEmail.getText());
                out.print(" | ");
                out.print(txtCNPJ.getText());
                out.print(" | ");
                out.print(txtTelefone.getText());
                out.print(" | ");
                out.print(status[cbxStatus.getSelectedIndex()]);
                out.print(" | ");
                out.print(pessoa[cbxPessoa.getSelectedIndex()]);
                out.print(" | ");
                out.print(new SimpleDateFormat("dd/MM/yyyy").format((Date) txtDataCadastro.getValue()));
                out.print(" | ");
                out.println(txtFaturamento.getText());
                out.print(" | ");
                out.println(estados[cbxEstado.getSelectedIndex()]);
                out.close();
				
				JOptionPane.showMessageDialog(
						null, 
						"Inclusão Realizada com Sucesso!" ,
						"Inclusão no Arquivo Texto",
						JOptionPane.INFORMATION_MESSAGE);
				setLimpar();
				
			}catch (IOException erro){
				JOptionPane.showMessageDialog(null, 
				"Erro na manipulacao do Arquivo Texto." 
				+ erro,
				"Erro no Arquivo Texto",
				JOptionPane.ERROR_MESSAGE);				
			}		    
		}
		if(e.getSource() == btLimpar) {
			setLimpar();
		}
		if(e.getSource() == btConsultar) {
			frmConsulta1 consulta = new frmConsulta1(arquivo);
		}
		if(e.getSource() == btSair) {
			System.exit(0);
		}
	}
	
	public void setLimpar() {
		  txtNome.setText("");
	      txtEmail.setText("");
	      txtCNPJ.setText("");
	      txtTelefone.setText("");
	      cbxStatus.setSelectedIndex(0);
	      cbxPessoa.setSelectedIndex(0);
	      cbxEstado.setSelectedIndex(0);
	      txtNome.requestFocus();
	}
	public static void main(String[] args) {
		frmCliente1 frm = new frmCliente1();
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

