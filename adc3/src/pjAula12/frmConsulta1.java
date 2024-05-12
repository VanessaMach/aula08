package pjAula12;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class frmConsulta1 extends JFrame implements ActionListener {

	JTextArea txtConsulta;
	JButton btSair;
	
	public frmConsulta1(File arqPesquisa){
		setTitle ("Consulta de Clientes");
		setLayout(new BorderLayout());
		setSize(400,300);
		setLocation(50,50);
		
		txtConsulta = new JTextArea(15,35);
		String texto = new String();
		
		try{			
		    FileReader arq = new FileReader(arqPesquisa);
		    BufferedReader buffer = new BufferedReader(arq);     
		    int cont = 1;
		    String linha = buffer.readLine( );
		    while ( linha != null ) {
		    	texto += cont++ + " - " + linha + "\n";
		        linha = buffer.readLine( );
		    }
		    buffer.close();		    
		}
		catch(IOException erro){
			JOptionPane.showMessageDialog(null, "Erro na manipulacao do Arquivo Texto." + erro,"Erro no Arquivo Texto",JOptionPane.ERROR_MESSAGE);
		}
		
		txtConsulta.setText(texto);	    
		
		btSair = new JButton("Sair");
		btSair.setMnemonic('S');
		btSair.setToolTipText("Sair da Consulta do Cadastro de Cliente");
		btSair.addActionListener(this);
		
		add(txtConsulta,BorderLayout.NORTH);
		add(btSair,BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent evento){
		dispose();
	}	
}
