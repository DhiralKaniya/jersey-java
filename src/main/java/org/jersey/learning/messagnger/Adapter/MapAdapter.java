package org.jersey.learning.messagnger.Adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import org.jersey.learning.messagnger.Model.*;
public class MapAdapter extends XmlAdapter<MapAdapter.AdapterMap, Map<Integer, Comment>> {
	public static class AdapterMap{
		public List<Entry> entry = new ArrayList<Entry>();
	}
	public static class Entry{
		public Integer key;
		public Comment value;
	}

	@Override
	public Map<Integer, Comment> unmarshal(AdapterMap v) throws Exception {
		Map<Integer, Comment> map = new HashMap<Integer, Comment>();
		for(Entry entry : v.entry) {
			map.put(entry.key, entry.value);
		}
		return map;
	}
	@Override
	public AdapterMap marshal(Map<Integer, Comment> v) throws Exception {
		AdapterMap adaptedMap = new AdapterMap();
		for(Map.Entry<Integer, Comment> mapEntry : v.entrySet()) {
			Entry entry = new Entry();
			entry.key = mapEntry.getKey();
			entry.value = mapEntry.getValue();
			adaptedMap.entry.add(entry);
		}
		return adaptedMap;
	}
}
