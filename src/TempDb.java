import java.util.Iterator;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;

import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.Fun;
import org.mapdb.Fun.Tuple3;


public class TempDb {

	public static void main(String [] args) {
		
		
		NavigableSet<Fun.Tuple3<String,Long,String>> multiMap = DBMaker.newTempTreeSet();

        //optionally you can use set with Delta Encoding. This may save lot of space
       /* multiMap = db.createTreeSet("test2")
                .serializer(BTreeKeySerializer.TUPLE2)
                .make();
		*/
		long value = System.currentTimeMillis();
		for (int i = 0 ; i < 100000; i++) {		
	        multiMap.add(Fun.t3("aa",value++,"aa"));	
	        multiMap.add(Fun.t3("ab",value++,"ab"));
		}
		
		Iterator<String> iter = Fun.filter(multiMap, "aa", null).iterator();
		System.out.println(multiMap.size());
		
		int j = 0;
		while(iter.hasNext()) {
			iter.next();
			j++;
		}
		
		System.out.println(j);
		
		iter = Fun.filter(multiMap, "ab", null).iterator();
		j = 0;
		while(iter.hasNext()) {
			System.out.println(iter.next());
			j++;
		}
		
		System.out.println(j);
	}
	
}
