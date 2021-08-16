package converters;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.tools.javac.parser.ReferenceParser.ParseException;

import cucumber.api.Transformer;

public class DateConverter extends Transformer <Date> {

	@Override
	public Date transform(String arg0) {
		DateFormat format = new SimpleDateFormat("dd/MM/yyy");
		try{
			Date retorno = format.parse(arg0);
		return retorno;
	} catch (java.text.ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return null;
	}

}
