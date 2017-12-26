package org.jersey.learning.messagnger;

import java.util.HashMap;
import java.util.List;

public class AutoHashMap<K, V> extends HashMap {
	@SuppressWarnings("unchecked")
	public AutoHashMap(List<K> keys, List<V> values)throws Exception {
		super();
		if(keys.size() != values.size() ) new Exception("Keys and Values are not equals");
		for(int i = 0;i<keys.size() ; i++) {
			Object newKey = keys.get(i);
			Object newValue = values.get(i);
			this.put(newKey, newValue);
		}
	}
}
