package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		String delimeterChars = "\n";

		if(text.equals("")){
			return 0;
		}
		else if(text.contains(",")){
			return sum(splitNumbers(text));
		}
		else if(text.contains("//")){
			text = text.substring(2);
			return sum(ChangeTheDelimiter(text.substring(0, 1), text));
		}
		else if(text.contains("\n")){
			return sum(splitNumbers(text));
		}
		else
			return 1;
	}

	private static int toInt(String number){
		int theNumber = Integer.parseInt(number);
		if(theNumber > 1000){
			theNumber = 0;
		}
		return theNumber;
	}

	private static String[] splitNumbers(String numbers){
	    return numbers.split(",|\n");
	}

	private static String[] ChangeTheDelimiter(String delimiter, String number){
		return number.substring(2).split(delimiter);
	}

    	private static int sum(String[] numbers){
 		int total = 0;
        	for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    	}


}
