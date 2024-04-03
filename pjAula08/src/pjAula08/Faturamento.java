package pjAula08;

public class Faturamento {
	public static void main (String[] args) {
		/*System.out.println(
				"Atualmente Notal Fiscal.sequencia" +
						NotaFiscal.sequencia);
		
		NotaFiscal notaA = new NotaFiscal ();
		System.out.println("Número da Nota " +
									notaA.getNumero());
		
		for(int i=0; i<1000; i++) {
			new NotaFiscal();
		}
		
		System.out.println(
				"Atualmente Notal Fiscal.sequencia" +
						NotaFiscal.sequencia);*/
		
		NotaFiscal entrada = new NotaFiscal();
		entrada.setFornecedor("Livraria Ática");
		entrada.setTotal(634);
		NotaFiscal.cambio = 5.450;
		
		NotaFiscal saida = new NotaFiscal();
		saida.setFornecedor("UNISAL");
		saida.setTotal(120);
		saida.cambio = 2.175;
		
		System.out.println("Entrada " + "numero " + entrada.getNumero() + "total " + entrada.getTotal() * entrada.cambio);
		System.out.println("Saida " + "numero " + saida.getNumero() + "total " + saida.getTotal() * saida.cambio);
	}

	
	
}
