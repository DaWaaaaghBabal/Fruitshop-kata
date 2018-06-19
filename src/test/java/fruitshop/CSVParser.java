package fruitshop;


public class CSVParser implements InputParser {

	@Override
	public String[] readProductNames(String input) {
		// TODO Auto-generated method stub
		return input.split(", *");
	}

}
