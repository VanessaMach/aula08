package pjAula08;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class Reflection {
	public static void main (String[] args) {
		List<String> listaNegra = new ArrayList<String>();
		listaNegra.add("teste");
		listaNegra.add("agoraVai");
		listaNegra.add("zueira");
		
		Field[] campos =
				NotaFiscal.class.getDeclaredFields();
		
		for(Field f : campos) {
			System.out.println(f.getType() + " " +
					f.getName()); //sysout ctrl espa�o
			if(f.getName().length() <6) {
				System.err.println("N�o atende ao padr�o");
				//System.err.println("N�o atende ao padr�o");
			}
			
		}
		
		Method[] metodos =
				NotaFiscal.class.getDeclaredMethods();
		for (Method m : metodos) {
			System.out.println(m.getName() + " " + m.getReturnType());
			
		}
		
				
	}

}
