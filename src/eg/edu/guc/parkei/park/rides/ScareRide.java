package eg.edu.guc.parkei.park.rides;

import java.util.ArrayList;

import eg.edu.guc.parkei.amusers.*;
import eg.edu.guc.parkei.utilities.Effect;

public class ScareRide extends FunRide {

	public ScareRide() {
		super();
	}

	public ScareRide(String name, int duration, int batchSize) {
		super(name, duration, batchSize);
	}

	public final boolean eligibleToRide(Amuser amuser) {
		return (amuser instanceof Adult);
	}

	public final ArrayList<Effect> affects(Amuser amuser) {
		ArrayList<Effect> a = new ArrayList<Effect>();
		if (amuser instanceof Adult) {
			a.add(Effect.Scared);
			return a;
		}
		return null;
	}

}
