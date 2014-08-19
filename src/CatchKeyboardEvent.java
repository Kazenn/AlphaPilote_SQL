import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;

public class CatchKeyboardEvent implements HotkeyListener {
	String RaccourciCapture = "Rien";

	public void installKeyGrabber() {
		JIntellitype.getInstance();
		JIntellitype.getInstance().registerHotKey(1, JIntellitype.MOD_WIN, 'A');
		JIntellitype.getInstance().registerHotKey(2, JIntellitype.MOD_WIN, 'X');
		JIntellitype.getInstance().registerHotKey(3, JIntellitype.MOD_WIN, 'V');
		JIntellitype.getInstance().addHotKeyListener(this);

	}

	@Override
	public void onHotKey(int aIdentifier) {
		if (aIdentifier == 1) {
			System.out.println("WINDOWS+A hotkey pressed");

		}
		if (aIdentifier == 2) {
			System.out.println("WINDOWS+X hotkey pressed");
			RaccourciCapture = "Capture";

		}
		if (aIdentifier == 3) {
			System.out.println("WINDOWS+V hotkey pressed");
			RaccourciCapture = "Putty";

		}
	}

}
