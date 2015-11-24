package eg.edu.guc.parkei.park.rides;

import java.util.ArrayList;
import eg.edu.guc.parkei.amusers.Amuser;

public abstract class Ride {
	private String name;
	private int duration;
	private int batchSize;
	private ArrayList<Amuser> currentAmusers;
	private int ridesToMaintain = 10;

	public Ride() {
		name = null;
		duration = 0;
		batchSize = 0;
		currentAmusers = new ArrayList<Amuser>();
		ridesToMaintain = 10;
	}

	public Ride(String name, int duration, int batchSize) {
		this.name = name;
		this.duration = duration;
		this.batchSize = batchSize;
		currentAmusers = new ArrayList<Amuser>();
		ridesToMaintain = 10;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final int getDuration() {
		return duration;
	}

	public final void setDuration(int duration) {
		this.duration = duration;
	}

	public final int getBatchSize() {
		return batchSize;
	}

	public final void setBatchSize(int batchSize) {
		this.batchSize = batchSize;
	}

	public final ArrayList<Amuser> getCurrentAmusers() {
		return currentAmusers;
	}

	public final void setCurrentAmusers(ArrayList<Amuser> currentAmusers) {
		if (currentAmusers.size() == 0) {
			this.currentAmusers = new ArrayList<Amuser>();
			return;
		}
		this.currentAmusers = currentAmusers;
	}

	public final int getRidesToMaintain() {
		return ridesToMaintain;
	}

	public final void setRidesToMaintain(int ridesToMaintain) {
		this.ridesToMaintain = ridesToMaintain;
	}

	protected final void addAmuser(Amuser amuser) {
		currentAmusers.add(amuser);
	}

	public String toString() {
		String s = "Ride [name=" + name + ", duration=" + duration
				+ ", batchSize=" + batchSize + ", currentAmusers= [";
		for (int i = 0; i < currentAmusers.size(); i++) {
			s += currentAmusers.get(i) + " , ";
		}
		s += " ]" + ", ridesToMaintain=" + ridesToMaintain + "]";
		return s;
	}

	protected final void getAmuser(int i) {
		currentAmusers.get(i);
	}

	protected final boolean checkToBoard(Amuser amuser) {
		return (ridesToMaintain > 0 && !amuser.isRiding() && currentAmusers
				.size() < batchSize);

	}

	public boolean board(Amuser amuser) {
		if (ridesToMaintain > 0 && !amuser.isRiding()
				&& currentAmusers.size() < batchSize) {
			currentAmusers.add(amuser);
			amuser.setRiding(true);
			return true;
		}
		return false;
	}

	public final void unBoard() {
		for (int i = 0; i < currentAmusers.size(); i++) {
			currentAmusers.get(i).setRiding(false);
		}
		currentAmusers.clear();
	}

	public final boolean unBoard(Amuser amuser) {
		if (currentAmusers.contains(amuser)) {
			currentAmusers.remove(amuser);
			amuser.setRiding(false);
			return true;
		}
		return false;
	}

	public boolean start() {
		if (ridesToMaintain <= 0) {
			return false;
		}
		ridesToMaintain--;
		return true;

	}

	public final boolean inMaintenance() {
		return ridesToMaintain <= 0;
	}

	public final void endMaintenance() {
		ridesToMaintain = 10;
	}

	public boolean availableForAll() {
		return true;
	}

}
