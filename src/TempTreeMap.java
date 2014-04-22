import java.util.Iterator;
import java.util.Map;

import org.mapdb.BTreeMap;
import org.mapdb.DBMaker;


public class TempTreeMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String, String> map = DBMaker.newTempTreeMap();

        //put some stuff into map
        //all data are stored in file in temp folder
		for (int i=0 ; i < 100000; i++) {
	        map.put("aa", "bb");
	        map.put("cc", "dd");
		}
        // Close map to release resources.
        // It is optional, there is JVM shutdown hook which deletes files on JVM exit.
		
		Iterator<String> iter = map.keySet().iterator();
		
		while(iter.hasNext()) {
			String key = iter.next();
			
		}
		
		System.out.println(map.values().size());
		
        ((BTreeMap)map).close();

	}

}
