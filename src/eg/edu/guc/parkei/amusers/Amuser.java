package eg.edu.guc.parkei.amusers;

import eg.edu.guc.parkei.park.rides.FunRide;
import eg.edu.guc.parkei.utilities.Effect;
import eg.edu.guc.parkei.utilities.Ticket;

import java.util.ArrayList;

public abstract class Amuser implements Rider {
	private String name;
	private int age;
	private double height;
	private FunRide location;
	private boolean riding;
	private ArrayList<Effect> effects;

	public Amuser() {
		name = null;
		age = 0;
		height = 0;
		location = null;
		riding = false;
		effects = new ArrayList<Effect>();
	}

	public Amuser(String name, int age, double height) {
		this.name = name;
		this.age = age;
		this.height = height;
		location = null;
		riding = false;
		effects = new ArrayList<Effect>();
	}

	public final boolean move(FunRide newLocation) {
		if (!riding) {
			location = newLocation;
			return true;
		}
		return false;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String s) {
		name = s;
	}

	public final int getAge() {
		return age;
	}

	public final void setAge(int x) {
		age = x;
	}

	public final double getHeight() {
		return height;
	}

	public final void setHeight(double h) {
		height = h;
	}

	public final boolean isRiding() {
		return riding;
	}

	public final void setRiding(boolean f) {
		riding = f;
	}

	public final FunRide getLocation() {
		return location;
	}

	public final void setLocation(FunRide newLocation) {
		location = newLocation;
	}

	public final ArrayList<Effect> getEffects() {
		return effects;
	}

	public final void setEffects(ArrayList<Effect> effects) {
		effects = new ArrayList<Effect>();
		this.effects = effects;
	}

	public final void applyEffect(Effect e) {
		effects.add(e);
	}

	public String toString() {
		return "Amuser [name=" + name + ", age=" + age + ", height=" + height
				+ ", location=" + location + ", riding=" + riding + "]";
	}

	public final Ticket getTicket() {

		if (this instanceof Baby) {
			return Ticket.Micro;
		}
		if (this instanceof Kid) {
			return Ticket.Mini;
		}
		if (this instanceof Senior) {
			return Ticket.Micro;
		}
		if (this instanceof Adult) {
			return Ticket.Maxi;
		}
		return null;
	}

}