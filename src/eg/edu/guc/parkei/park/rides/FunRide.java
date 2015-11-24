package eg.edu.guc.parkei.park.rides;

import eg.edu.guc.parkei.amusers.Amuser;
import eg.edu.guc.parkei.utilities.Effect;

import java.util.ArrayList;

public abstract class FunRide extends Ride {
	public FunRide() {
		super();
	}

	public FunRide(String name, int duration, int batchSize) {
		super(name, duration, batchSize);
	}

	public final boolean start() {
		if (getCurrentAmusers().size() < 1) {
			return false;
		}
		if (getRidesToMaintain() <= 0) {
			return false;
		}
		setRidesToMaintain(getRidesToMaintain() - 1);
		for (int i = 0; i < getCurrentAmusers().size(); i++) {
			ArrayList<Effect> a = affects(getCurrentAmusers().get(i));
			if (affects(getCurrentAmusers().get(i)) != null) {
				for (int j = 0; j < a.size(); j++) {
					getCurrentAmusers().get(i).applyEffect(a.get(j));
				}
			}
		}
		return true;
	}

	public final boolean board(Amuser amuser) {
		if (checkToBoard(amuser) && amuser.getLocation() == this
				&& !amuser.isRiding()) {
			super.board(amuser);
			return true;
		}
		return false;
	}

	public String toString() {
		return this.getName();
	}

	public abstract boolean eligibleToRide(Amuser amuser);

	public boolean availableForAll() {
		return false;
	}
	public abstract ArrayList<Effect> affects(Amuser amuser);

}
