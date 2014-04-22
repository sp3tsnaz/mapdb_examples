

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.concurrent.ConcurrentNavigableMap;

import org.mapdb.*;

public class Runner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Set<Fun.Tuple2<String,Long>> set =  DBMaker.newTempHashSet();
		
		for (int i=0 ; i < 100000; i++) {
			set.add(Fun.t2("aa",1L));
	        set.add(Fun.t2("aa",2L));
	        set.add(Fun.t2("aa",3L));
	        set.add(Fun.t2("bb",1L));
		}
		
		System.out.println(set.size());
		
		Iterator<Fun.Tuple2<String,Long>> iter = set.iterator();
		
		while(iter.hasNext()) {
			Fun.Tuple2<String,Long> tuple = iter.next();
			System.out.println(tuple.a + "\t" + tuple.b );
		}
		

	}

}
