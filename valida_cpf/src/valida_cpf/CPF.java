package valida_cpf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class CPF {
	private String cpf;
	private ArrayList<Integer> cpfArray;
	
	public CPF() {
		this.cpf = "";
		this.cpfArray = new ArrayList();
	}
	
	public CPF(String cpf) {
		this.cpf = cpf.replace(".", "").replace("-", "");
		buildCpfArray(this.cpf);
	}
	
	public CPF(int cpf) {
		this.cpf = String.valueOf(cpf);
		buildCpfArray(this.cpf);
	}
	
	private void buildCpfArray(String cpf) {
		this.cpfArray = convertStringToArray(this.cpf);
	}

	private ArrayList<Integer> convertStringToArray(String cpf) {
		ArrayList<Integer> array = new ArrayList();
		for (int i = 0; i < cpf.length(); i++) {
			array.add(Character.getNumericValue(cpf.charAt(i)));
		}
		return array;
	}
	
	public boolean isValid() {
		int firstDigit, secondDigit;
		if (this.cpfArray.size() != 11)
			return false;
		ArrayList<Integer> list = this.cpfArray;
		firstDigit = list.get(list.size()-2);
		secondDigit = list.get(list.size()-1);
		Collections.reverse(list);
		return checkFirstDigit(list, firstDigit);
	}
	
	private boolean checkFirstDigit(ArrayList<Integer> list, int digit) {
		int sum = 0;
		for(int i = 10; i > 1; i--) {
			sum += list.get(i) * i;
		}
		int result = (sum * 10) % 11;
		result = (result == 10)?0:result;
		if (result == digit)
			return true;
		else
			return false;
	}
}
