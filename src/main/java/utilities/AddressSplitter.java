package utilities;

import java.util.HashMap;

public class AddressSplitter {

		
	public static HashMap<String,String> split(String address) {
		String [] components = address.split(", ");
		String [] stateComp = components[2].split(" ");
		HashMap<String, String> addMap = new HashMap<>();
		
		addMap.put("street", components[0]);
		addMap.put("city", components[1]);
		addMap.put("state", stateComp[0]);
		addMap.put("zipcode", stateComp[1]);
		
		
		return addMap;
	}

}
