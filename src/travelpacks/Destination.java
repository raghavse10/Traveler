package travelpacks;

import java.util.*;

public class Destination {

	private String name;
	private List<Activity> actList;

	public Destination(String name, List<Activity> actList) {
		this.name = name;
		List<Activity> active = new ArrayList<>(actList);
		this.actList = active;
		
	}
	
	public Destination(String name) {
		this.name = name;
		
	}

	public List<Activity> getActList() {
		return actList;
	}

	public Destination addActivity(Activity activity) {
		this.actList.add(activity);
		return this;
	}

	public String getName() {
		return name;
	}
}
