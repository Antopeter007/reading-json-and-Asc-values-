package Studies.json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonStudies {
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		List<Map<String, Object>> ascValues = new ArrayList<>();
		File file = new File("C:\\Peter\\json/loanData.json");
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> userData = mapper.readValue(file, Map.class);
		List<Map<String, Object>> loans = (List<Map<String, Object>>) userData.get("loans");
		for (Map<String, Object> mapValues : loans) {
			String overDue = (String) mapValues.get("overdue_y_n");
			if (overDue.equals("Y")) {
				ascValues.add(mapValues);
				Collections.sort(ascValues, new Comparator<Map<String, Object>>() {

					@Override
					public int compare(Map<String, Object> dateValues, Map<String, Object> dateValues2) {
						SimpleDateFormat sdf = new SimpleDateFormat("DD-MM-YY");

						try {
							Date d1 = sdf.parse((String) dateValues.get("disb_date"));
							Date d2 = sdf.parse((String) dateValues2.get("disb_date"));
							return d2.compareTo(d1);
						} catch (ParseException e) {
							System.out.println(e);
						}
						return 0;
					}

				});

			} else if (overDue.equals("N")) {
				ascValues.add(mapValues);
				Collections.sort(ascValues, new Comparator<Map<String, Object>>() {

					@Override
					public int compare(Map<String, Object> amount, Map<String, Object> amount2) {
						Double amt = (Double) amount.get("total_repayment_amount");
						Double amt2 = (Double) amount2.get("total_repayment_amount");
						return amt2.compareTo(amt);
					}
				});
			}
			Collections.sort(ascValues, new Comparator<Map<String, Object>>() {

				@Override
				public int compare(Map<String, Object> mapValues, Map<String, Object> mapValues1) {
					String overDue = (String) mapValues.get("overdue_y_n");
					String overDue1 = (String) mapValues1.get("overdue_y_n");
					return overDue1.compareTo(overDue);
				}
			});
		}
		System.out.println(ascValues);
	}
}
