package eg.edu.guc.parkei.park.rides;

import java.util.ArrayList;

public class BiDirectionalRide extends TransportRide {
	private ArrayList<Boolean> flag = new ArrayList<Boolean>();

	public BiDirectionalRide() {
		super();
	}

	public BiDirectionalRide(String name, int dur, int batch,
			ArrayList<FunRide> locations) {
		super(name, dur, batch, locations);
		String[] s = getFullRouteArray();
		flag = new ArrayList<Boolean>();
		for (int i = 0; i < s.length; i++) {
			flag.add(false);
		}
	}

	public BiDirectionalRide(String name, int dur, int batch) {
		super(name, dur, batch);
	}

	public final void setRouteLocations(ArrayList<FunRide> routeLocations) {
		super.setRouteLocations(routeLocations);
		String[] s = getFullRouteArray();
		flag = new ArrayList<Boolean>();
		for (int i = 0; i < s.length; i++) {
			flag.add(false);
		}
	}

	public final void move() {
		String[] s = getFullRouteArray();
		for (int i = 0; i < s.length; i++) {
			if (s[i].equals(getCurrentLocation().getName())) {
				if (!(flag.get(i))) {
					flag.set(i, true);

					if (i < s.length / 2) {
						forwardMove();
					} else {
						backwardMove();
					}
					return;
				} else {
					flag.set(i, false);
				}
			}
		}
	}

	public final String getFullRoute() {
		String s = "The followed route is: ";
		int l = s.length();
		int index = 0;
		do {
			s += getRouteLocations().get(index) + ", ";
			index++;
		} while (index < getRouteLocations().size());
		String[] t = s.substring(l).split(", ");
		for (int i = t.length - 2; i >= 0; i--) {
			s += t[i] + ", ";
		}
		return s.substring(0, s.length() - 2);
	}

	private String[] getFullRouteArray() {
		String s = "The followed route is: ";
		int l = s.length();
		int index = 0;
		do {
			s += getRouteLocations().get(index) + ", ";
			index++;
		} while (index < getRouteLocations().size());
		String[] t = s.substring(l).split(", ");
		for (int i = t.length - 2; i >= 0; i--) {
			s += t[i] + ", ";
		}
		s = s.substring(0, s.length() - 2);
		t = s.substring(l).split(", ");
		return t;
	}

}
