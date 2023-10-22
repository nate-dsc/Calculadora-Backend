package negocio;

import java.util.ArrayList;

public class Memoria {

	private ArrayList<String> entrada;
	
	public Memoria() {
		entrada = new ArrayList<String>();
	}

	public String getEntrada() {
		return entradaToString();
	}
	
	private String entradaToString()
	{
		String saida = "";
		for (String en : entrada) {
			saida += en;
		}
		return saida;
	}
	
//	primeiraParte operação segundaParte =  resultado
	
	public void setEntrada(String en) {
		if(en.equals("="))
		{
			calcularResultado();
		}
		else
		{
			this.entrada.add(en);
		}
	}

	private void calcularResultado()
	{
		char[] arrayOp = entradaToString().toCharArray();
		double primeiraParte = 0;
		double segundaParte = 0;
		double resultado = 0;
		String resultadoStr;
		char op;
		
		int i = 0;
		while('0' <= arrayOp[i] && arrayOp[i] <= '9')
			{
				if(i < arrayOp.length)
				{
					primeiraParte = 10*primeiraParte + arrayOp[i] - '0';
					i++;
				}
			}
		op = arrayOp[i];
		i++;
		while(i < arrayOp.length)
		{
			segundaParte = 10*segundaParte + arrayOp[i] - '0';
			i++;
		}
		
		switch(op)
		{
			case '+':
				resultado = primeiraParte + segundaParte;
				break;
			case '-':
				resultado = primeiraParte - segundaParte;
				break;
			case '/':
				resultado = primeiraParte/segundaParte;
				break;
			case '*':
				resultado = primeiraParte*segundaParte;
				break;
			default:
				break;
		}
		resultadoStr = String.format("%f", resultado);
		this.entrada.clear();
		this.entrada.add(resultadoStr);
	}

}
