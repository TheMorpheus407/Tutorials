import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		HashMap<String, Float> hm = new HashMap<String, Float>();
		hm.put("Epsilon", 0.0004f);
		System.out.println(hm.get("Epsilon"));
		TreeMap<String, Integer> t = new TreeMap<String, Integer>();
		t.put("Nobody", 42);
		t.put("Batman", -42);
		t.put("Gerald", 42);
		
		Iterator i = t.entrySet().iterator();
		while(i.hasNext())
		{
			System.out.println(((Map.Entry)i.next()).getValue());
		}
	}

}
