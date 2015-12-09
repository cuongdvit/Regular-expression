package validate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate_FileCSV {
	
	public static boolean validateName(String str){
		String expression = "^[\\p{L} .'-]+$";
		Pattern r = Pattern.compile(expression);
		Matcher matcher = r.matcher(str);
		return matcher.matches();
	}
	public static boolean validateLessDateNow(String str) throws ParseException{
		String expression = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";
		Pattern r = Pattern.compile(expression);
		Matcher matcher = r.matcher(str);
		if(matcher.matches()){
			Date dateNow = new Date();
			DateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
			String date = ft.format(dateNow);
			Date dn = ft.parse(date);
			Date din = ft.parse(str);
			int a =  dn.compareTo(din);
			if(a == 1){
				return true;
			}else{
				return false;
			}
			
		}else {
			return false;
		}
	}
	public static boolean validateBirthday(String str) throws ParseException{
		String expression = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";
		Pattern r = Pattern.compile(expression);
		Matcher matcher = r.matcher(str);
		if(matcher.matches()){
			Date dateNow = new Date();
			DateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
			String date = ft.format(dateNow);
			Date dn = ft.parse(date);
			Date din = ft.parse(str);
			int a = dn.getYear() - din.getYear();
			if(a >= 18){
				return true;
			}else{
				return false;
			}
			
		}else {
			return false;
		}
	}
	public static boolean validateIntegerOrFloat(String str){
		String expression = "\\d+(?:\\.\\d+)?";
		Pattern r = Pattern.compile(expression);
		Matcher matcher = r.matcher(str);
		return matcher.matches();
	}
	public static boolean validateQuality(String str){
		String expression = "^[0-9]*$";
		Pattern r = Pattern.compile(expression);
		Matcher matcher = r.matcher(str);
		return matcher.matches();
	}
	public static void main(String[] args) throws ParseException {
		if(validateIntegerOrFloat("2.5")){
			System.out.println("okie");
		}
	}

}
