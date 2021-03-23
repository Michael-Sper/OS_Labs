package il.ac.telhai.os.hardware;

public class Timer implements Clockeable, InterruptSource {
	Clock clk;
	CPU cpu;
	int ticks;

	public Timer(CPU cpu, Clock clock) {
		clk = clock;
		clk.addDevice(this); // adding the timer to the clock's array
		this.cpu = cpu;
	};

	public void set(int clockTicks) {
		ticks = clockTicks; // sets the seconds to count
	};

	public void tick() {
		System.out.println(ticks);
		if (--ticks == 0) { // timer reaches zero
			cpu.interrupt(this);
		}

	};
}
