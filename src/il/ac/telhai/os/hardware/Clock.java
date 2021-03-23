package il.ac.telhai.os.hardware;

import java.util.ArrayList;

public class Clock implements Runnable {
	double freq;
	boolean on;
	ArrayList<Clockeable> array;

	public Clock(double freq) {
		this.freq = freq;
		array = new ArrayList<Clockeable>();
		// TODO Auto-generated constructor stub
	}

	public void addDevice(Clockeable device) {
		array.add(device);
	}
	@Override
	public void run() {
		on = true;

				while (on) {

					for (Clockeable clockeable : array) {
						clockeable.tick();

					}
					try {
						Thread.sleep((long) (1000 / freq));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		
		};

	}

	public void shutdown() {
		on = false;
	};
}
