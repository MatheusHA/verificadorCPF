package valida_cpf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class CPF {
	private String cpf;
	private ArrayList<Integer> cpfArray;
	
	public CPF(String cpf) {
		this.cpf = cpf.replace(".", "").replace("-", "");
		this.cpfArray = convertStringToArray(this.cpf);
	}

	private static ArrayList<Integer> convertStringToArray(String cpf) {
		ArrayList<Integer> array = new ArrayList();
		for (int i = 0; i < cpf.length(); i++) {
			array.add(Character.getNumericValue(cpf.charAt(i)));
		}
		return array;
	}
	
	public boolean isValid() {
		return testCPF(this.cpfArray);
	}
	
	private static boolean testCPF(ArrayList<Integer> cpf) {
		int firstDigit, secondDigit;
		if (cpf.size() != 11)
			return false;
		firstDigit = cpf.get(cpf.size()-2);
		secondDigit = cpf.get(cpf.size()-1);
		Collections.reverse(cpf);
		return checkFirstDigit(cpf, firstDigit) && checkSecondDigit(cpf, secondDigit);
	}
	
	private static boolean checkFirstDigit(ArrayList<Integer> list, int digit) {
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
	
	private static boolean checkSecondDigit(ArrayList<Integer> list, int digit) {
		int sum = 0;
		for(int i = 11; i > 1; i--) {
			sum += list.get(i-1) * i;
		}
		int result = (sum * 10) % 11;
		result = (result == 10)?0:result;
		if (result == digit)
			return true;
		else
			return false;
	}
	
	public static boolean checkCPF(String cpf) {
		cpf = cpf.replace(".", "").replace("-", "");
		ArrayList<Integer> cpfArray = convertStringToArray(cpf);
		return testCPF(cpfArray);
	}
}
