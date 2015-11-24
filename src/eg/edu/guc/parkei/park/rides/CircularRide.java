package eg.edu.guc.parkei.park.rides;

import java.util.ArrayList;

public class CircularRide extends TransportRide {

	public CircularRide() {
		super();
	}

	public CircularRide(String name, int dur, int batch,
			ArrayList<FunRide> locations) {
		super(name, dur, batch, locations);
	}

	public CircularRide(String name, int dur, int batch) {
		super(name, dur, batch);
	}

	public final void move() {
		FunRide curr = getCurrentLocation();
		super.forwardMove();
		while (getCurrentLocation() != curr) {
			super.forwardMove();
		}
		super.forwardMove();
	}

	public final String getFullRoute() {
		String s = "The followed route is: ";
		FunRide curr = getCurrentLocation();
		super.forwardMove();
		s += curr.getName() + ", ";
		while (getCurrentLocation() != curr) {
			s += getCurrentLocation().getName() + ", ";
			super.forwardMove();
		}
		s += curr.getName();
		return s;

	}

}
