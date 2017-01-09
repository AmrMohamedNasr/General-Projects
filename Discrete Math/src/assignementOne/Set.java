package assignementOne;

import java.util.ArrayList;

public class Set {

	private ArrayList<String> list;
	
	public Set(String[] setList) {
		list = new ArrayList<String>();
		for(int i = 0; i < setList.length; i++) {
			list.add(setList[i]);
		}
	}
	
	public Set(ArrayList<String> setList) {
		list = new ArrayList<String>();
		for(int i = 0; i < setList.size(); i++) {
			list.add(setList.get(i));
		}
	}
	
	static Set intersection(Set a, Set b) {
		ArrayList<String> aList = a.getSetList();
		ArrayList<String> bList = b.getSetList();
		ArrayList<String> intersectionList = new ArrayList<String>();
		for (int i = 0; i < aList.size(); i++) {
			for(int j = 0;j < bList.size(); j++) {
				if(aList.get(i).equals(bList.get(j))) {
					intersectionList.add(aList.get(i));
				}
			}
		}
		return new Set(intersectionList);
	}
	
	static Set union(Set a, Set b) {
		ArrayList<String> aList = a.getSetList();
		ArrayList<String> bList = b.getSetList();
		ArrayList<String> uList = new ArrayList<String>();
		for (int i = 0; i < aList.size(); i++) {
			uList.add(aList.get(i));
		}
		for (int i = 0; i < bList.size(); i++) {
			uList.add(bList.get(i));
		}
		for (int i = 0; i < aList.size(); i++) {
			for(int j = 0;j < bList.size(); j++) {
				if(aList.get(i).equals(bList.get(j))) {
					uList.remove(aList.get(i));
				}
			}
		}
		return new Set(uList);
	}
	
	static Set complement(Set u, Set a) {
		ArrayList<String> aList = a.getSetList();
		ArrayList<String> uList = u.getSetList();
		ArrayList<String> cList = new ArrayList<String>();
		for (int i = 0; i < uList.size(); i++) {
			cList.add(uList.get(i));
		}
		for (int i = 0; i < aList.size(); i++) {
			cList.remove(aList.get(i));
		}
		return new Set(cList);
	}
	
	public ArrayList<String> getSetList() {
		return list;
	}
	
	public boolean contains(String text) {
		return list.contains(text);
	}
	
	public void printSet() {
		System.out.print("{");
		if(list.size() == 0) {
			System.out.print("phi");
		}
		for(int i = 0;i < list.size();i++) {
			if(i == list.size() -1) {
				System.out.print(list.get(i));
			} else {
				System.out.print(list.get(i) + ", ");
			}
		}
		System.out.println("}");
	}
}
