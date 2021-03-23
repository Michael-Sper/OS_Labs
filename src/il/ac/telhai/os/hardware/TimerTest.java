package il.ac.telhai.os.hardware;

import org.junit.Test;

public class TimerTest extends CPU {
	public TimerTest(Clock clock, RealMemory realMemory) {
		super(clock, realMemory);
		// TODO Auto-generated constructor stub
	}

	private static final int FREQUENCY = 10;
	Clock clock = new Clock(FREQUENCY);  

	@Test
	public void test() {
		Timer t = new Timer(this, clock);
		t.set(10);
		clock.run();
	}
	
	public void interrupt (InterruptSource source) {
		clock.shutdown();
	}

}
