package eg.edu.guc.parkei.park.rides;

import eg.edu.guc.parkei.amusers.*;
import eg.edu.guc.parkei.utilities.Effect;

import java.util.ArrayList;

public class WaterRide extends FunRide {

	public WaterRide() {
		super();
	}

	public WaterRide(String name, int duration, int batchSize) {
		super(name, duration, batchSize);
	}

	public final boolean eligibleToRide(Amuser amuser) {
		if (amuser instanceof Baby) {
			return false;
		}
		return true;
	}

	public final ArrayList<Effect> affects(Amuser amuser) {
		if (!eligibleToRide(amuser)) {
			return null;
		}
		ArrayList<Effect> a = new ArrayList<Effect>();
		a.add(Effect.Wet);
		if (amuser instanceof Kid) {
			a.add(Effect.Thrilled);
		}
		if (amuser instanceof Adult) {
			a.add(Effect.Happy);
		}
		if (amuser instanceof Senior) {
			a.add(Effect.Angry);
		}
		return a;
	}

}
