package principal;

import valida_cpf.CPF;

public class main {

	public static void main(String[] args) {
		CPF cpf = new CPF("529.982.247-av");
		System.out.println(cpf.isValid());
		System.out.println(CPF.checkCPF("529.982.247-25"));
		
		// TODO: Implementar testes para classe
	}

}
