package principal;

import valida_cpf.CPF;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CPF cpf = new CPF("529.982.247-25");
		System.out.println(cpf.isValid());
		System.out.println(CPF.checkCPF("529.982.247-25"));
	}

}
