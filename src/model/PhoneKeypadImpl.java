package model;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

public class PhoneKeypadImpl implements PhoneKeyPad{

	private String telco;
	private String number;
	
	private ServletContext context; //null
	
	public PhoneKeypadImpl() {
	}
	
	public PhoneKeypadImpl(String telco, String number, ServletContext context) {
		setTelco(telco);
		setNumber(number);
		this.context = context;
	}




	public String getTelco() {
		return telco;
	}

	public void setTelco(String telco) {
		this.telco = telco;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	
// Business Logic Methods
	@Override
	public String determineTelcoProvider() {
		Map<String, String> telcoName = new HashMap<>();
		{
			
			telcoName.put("0919", "SMART");
			telcoName.put("0920", "SMART");
			telcoName.put("0960", "SMART");
			telcoName.put("0992", "SMART");
			
			telcoName.put("0917", "GLOBE");
			telcoName.put("0927", "GLOBE");
			telcoName.put("0926", "GLOBE");
			telcoName.put("0935", "GLOBE");
			
			telcoName.put("0922", "SUN");
			telcoName.put("0933", "SUN");
			telcoName.put("0951", "SUN");
			telcoName.put("0972", "SUN");
		}
		
		String returnTelco = telcoName.get(telco);
		return returnTelco;
	}


@Override
	public String convertToNumeric() {
	
		String tempString = "";
		
		Map<Character, String> keypad = new HashMap<>();
		{

			keypad.put('1', "1");
			keypad.put('0', "0");
			
			keypad.put('A', "2");
			keypad.put('B', "2");
			keypad.put('C', "2");
			
			keypad.put('D', "3");
			keypad.put('E', "3");
			keypad.put('F', "3");
			
			keypad.put('G', "4");
			keypad.put('H', "4");
			keypad.put('I', "4");
			
			keypad.put('J', "5");
			keypad.put('K', "5");
			keypad.put('L', "5");
			
			keypad.put('M', "6");
			keypad.put('N', "6");
			keypad.put('O', "6");
			
			keypad.put('P', "7");
			keypad.put('Q', "7");
			keypad.put('R', "7");
			keypad.put('S', "7");
			
			keypad.put('T', "8");
			keypad.put('U', "8");
			keypad.put('V', "8");
			
			keypad.put('W', "9");
			keypad.put('X', "9");
			keypad.put('Y', "9");
			keypad.put('Z', "9");
		}
		
        char[] stringToCharArray = number.toCharArray();
			for (int i = 0; i < number.length(); ++i) {
			       if(!Character.isDigit(stringToCharArray[i])){
			    	   tempString += keypad.get(Character.toUpperCase(stringToCharArray[i]));

			       } else {
	                   tempString += stringToCharArray[i];
	                }
			}
			
		return tempString;
	}



	@Override
	public boolean validateTelcoNumber() {
		
		boolean validate = false;
		if (telco.length() == 4) {
			char[] stringToCharArray = telco.toCharArray();
			for (char checker: stringToCharArray) {
			       if(!Character.isDigit(checker)){
			    	   validate = false;
                   // length == 4 but there is a non-digit in the String
			       } else {
			    	   validate = true;
                   //length == 4 and all of it are digits
                }
			}
		}
        else {
        	validate = false;
         // length != 4
      }
		return validate;
	}




	@Override
	public boolean validatePhoneNumber() {
		boolean checker = false;
		if(number.length() == 7) {
			// true == passed
			checker = true;
		}
		return checker;
	}
}
