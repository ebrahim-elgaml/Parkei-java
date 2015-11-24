package eg.edu.guc.parkei.park.rides;

import java.util.ArrayList;

import eg.edu.guc.parkei.amusers.*;
import eg.edu.guc.parkei.utilities.Effect;

public class RollerCoaster extends FunRide {

	public RollerCoaster() {
		super();
	}

	public RollerCoaster(String name, int duration, int batchSize) {
		super(name, duration, batchSize);
	}

	public final boolean eligibleToRide(Amuser amuser) {
		if (amuser instanceof Adult) {
			return true;
		}
		if (amuser instanceof Kid) {
			if (amuser.getHeight() > 140) {
				return true;
			}
		}
		return false;
	}

	public final ArrayList<Effect> affects(Amuser amuser) {
		if (!eligibleToRide(amuser)) {
			return null;
		}
		ArrayList<Effect> a = new ArrayList<Effect>();
		if (amuser instanceof Kid) {
			a.add(Effect.Sick);
		}
		if (amuser instanceof Adult) {
			a.add(Effect.High);
		}
		return a;
	}

}
