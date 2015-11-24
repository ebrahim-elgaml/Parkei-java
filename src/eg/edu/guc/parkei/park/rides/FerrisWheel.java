package eg.edu.guc.parkei.park.rides;

import java.util.ArrayList;

import eg.edu.guc.parkei.amusers.*;
import eg.edu.guc.parkei.utilities.Effect;

public class FerrisWheel extends FunRide {

	public FerrisWheel() {
		super();
	}

	public FerrisWheel(String name, int duration, int batchSize) {
		super(name, duration, batchSize);
	}

	public final boolean availableForAll() {
		return true;
	}

	public final boolean eligibleToRide(Amuser amuser) {
		return true;
	}

	public final ArrayList<Effect> affects(Amuser amuser) {
		ArrayList<Effect> a = new ArrayList<Effect>();
		if (amuser instanceof Baby) {
			a.add(Effect.Thrilled);
		}
		if (amuser instanceof Adult) {
			a.add(Effect.Bored);
		}
		if (amuser instanceof Senior || amuser instanceof Kid) {
			a.add(Effect.Happy);
		}
		return a;
	}

}
