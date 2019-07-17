package model;

interface PhoneKeyPad {

	public String determineTelcoProvider();
	public String convertToNumeric();
	public boolean validateTelcoNumber();
	public boolean validatePhoneNumber();
}
