
/*
 HW1 Taboo problem class.
 Taboo encapsulates some rules about what objects
 may not follow other objects.
 (See handout).
*/

import java.util.*;

public class Taboo<T> {

	List<T> rules;
	
	/**
	 * Constructs a new Taboo using the given rules (see handout.)
	 * @param rules rules for new Taboo
	 */
	public Taboo(List<T> rules) {
		this.rules = rules;
	}
	
	/**
	 * Returns the set of elements which should not follow
	 * the given element.
	 * @param elem
	 * @return elements which should not follow the given element
	 */
	public Set<T> noFollow(T elem) {
		Set<T> result = new HashSet<>();

		boolean check = false;
		for(int i = 0; i < rules.size(); i++){
			if(check){
				result.add(rules.get(i));
				check = false;
			}
			if(rules.get(i).equals(elem)){
				check = true;
			}
		}

		if(!result.isEmpty()) return result;

		return Collections.emptySet();
	}
	
	/**
	 * Removes elements from the given list that
	 * violate the rules (see handout).
	 * @param list collection to reduce
	 */
	public void reduce(List<T> list) {
		HashMap< T,Set<T> > map = new HashMap<>();
		for(T item : list){
			map.put(item,noFollow(item));
		}
		int i = 1;
		while (i < list.size()){
			Set<T> cur = map.get(list.get(i-1));
			if(cur != null && cur.contains(list.get(i))){
				list.remove(i);
			} else {
				i++;
			}
		}
	}
}
