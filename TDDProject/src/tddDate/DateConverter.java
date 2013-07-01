package tddDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

public class DateConverter {

	private final SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");

	public String getDate(String date) {
		String result = "Codification Error";
		String[] splitDate = date.split("/");
		if (splitDate.length == 3) {
			Arrays.sort(splitDate);
			ArrayList<String> combinations = getCombine(splitDate);
			for (String dateString : combinations) {
				if(validationDate(dateString)){
					result = dateString;
					break;
				}
			}
		}
		return result;
	}

	private ArrayList<String> getCombine(String[] splitDate) {
		ArrayList<String> result = new ArrayList<>();
		int[][] combinations = {{2,1,0},{2,0,1},{1,2,0},{1,0,2},{0,2,1},{0,1,2}};
		for(int[] combination : combinations){
			// Unchecked yet
			String year = combination[2] == 0? "00" : ""+combination[2];
			result.add(splitDate[combination[0]] + "/" + splitDate[combination [1]] + "/20" + year);
		}
		return result;
	}

	private boolean validationDate(String date) {
		boolean res = false;
		Date validationDate;
		try {
			validationDate = FORMAT.parse(date);
			String newDate = FORMAT.format(validationDate);
			res = newDate.equals(date);
		} catch (ParseException e) {
		}
		return res;
	}
}
