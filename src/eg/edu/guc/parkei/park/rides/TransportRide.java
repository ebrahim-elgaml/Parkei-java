package eg.edu.guc.parkei.park.rides;

import java.util.ArrayList;

import eg.edu.guc.parkei.amusers.Amuser;

public abstract class TransportRide extends Ride {
	private ArrayList<FunRide> routeLocations;
	private int pos;

	public TransportRide(String name, int dur, int batch,
			ArrayList<FunRide> locations) {
		super(name, dur, batch);
		routeLocations = new ArrayList<FunRide>();
		for (int i = 0; i < locations.size(); i++) {
			this.routeLocations.add((FunRide) locations.get(i));
		}
		pos = 0;
	}

	public TransportRide() {
		super();
		routeLocations = new ArrayList<FunRide>();
		pos = 0;
	}

	public TransportRide(String name, int dur, int batch) {
		super(name, dur, batch);
		routeLocations = new ArrayList<FunRide>();
		pos = 0;
	}

	public ArrayList<FunRide> getRouteLocations() {
		return routeLocations;
	}

	public void setRouteLocations(ArrayList<FunRide> routeLocations) {
		if (routeLocations.size() == 0) {
			this.routeLocations = new ArrayList<FunRide>();
			return;
		}

		for (int i = 0; i < routeLocations.size(); i++) {
			this.routeLocations.add((FunRide) routeLocations.get(i));
		}
		pos = 0;
	}

	public final boolean board(Amuser amuser) {

		if (amuser.getLocation() == routeLocations.get(pos)
				&& getRidesToMaintain() > 0 && !amuser.isRiding()
				&& getCurrentAmusers().size() < getBatchSize()) {
			addAmuser(amuser);
			amuser.setRiding(true);
			return true;
		}
		return false;
	}


	protected void forwardMove() {
		pos++;
		if (pos >= routeLocations.size()) {
			pos = 0;
		}
		for (int j = 0; j < getCurrentAmusers().size(); j++) {
			getCurrentAmusers().get(j).setLocation(routeLocations.get(pos));
		}
	}

	protected void backwardMove() {
		pos--;
		if (pos == -1) {
			pos = routeLocations.size() - 1;
		}
		for (int j = 0; j < getCurrentAmusers().size(); j++) {
			getCurrentAmusers().get(j).setLocation(routeLocations.get(pos));
		}
	}

	protected int getPos() {
		return pos;
	}
	public boolean start() {
		if (getRidesToMaintain() <= 0) {
			return false;
		}
		setRidesToMaintain(getRidesToMaintain() - 1);
		move();
		return true;
	}

	public String toString() {
		String s = super.toString() + "TransportRide [routeLocations= [ ";
		for (int i = 0; i < routeLocations.size(); i++) {
			s += routeLocations.get(i) + " , ";
		}
		s += " ] " + "CurrentLocation [ " + getCurrentLocation() + "]";
		return s;
	}

	public FunRide getCurrentLocation() {
		return routeLocations.get(pos);
	}
	public abstract String getFullRoute();
	public abstract void move();

}
