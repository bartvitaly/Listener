
package test.java;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Map.Entry;
import java.util.Random;

import org.testng.annotations.Test;

import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

public class ListenTest {

	boolean run = true;

	@Test(groups = { "demo" })
	public void aFastTest() throws InterruptedException {
		listener();
		try {
			while (true) {
				int random = getRandom(3);
				System.out.println("aFastTest: " + random);
				System.out.println("aFastTest VK_ALT + VK_TAB");
				complexClick(KeyEvent.VK_ALT, KeyEvent.VK_TAB);
				if (random == 1) {
					System.out.println("aFastTest VK_CONTROL + VK_TAB");
					complexClick(KeyEvent.VK_CONTROL, KeyEvent.VK_TAB);
				} else if (random == 2) {
					System.out.println("aFastTest VK_CONTROL + VK_PAGE_UP");
					complexClick(KeyEvent.VK_CONTROL, KeyEvent.VK_PAGE_UP);
				} else {
					System.out.println("aFastTest VK_CONTROL + VK_PAGE_DOWN");
					complexClick(KeyEvent.VK_CONTROL, KeyEvent.VK_PAGE_DOWN);
				}
				simpleClick();
				random = getRandom(100);
				System.out.println("sleep: " + random);
				Thread.sleep(random * 1000);
			}
		} catch (

		AWTException e) {
			e.printStackTrace();
		}
	}

	public void simpleClick() throws AWTException, InterruptedException {
		Thread.sleep(100);
		Robot robot = new Robot();
		int random = getRandom(4);
		System.out.println("simpleClick: " + random);
		if (random == 1) {
			System.out.println("simpleClick CAPS");
			robot.keyPress(KeyEvent.VK_CAPS_LOCK);
			Thread.sleep(100);
			robot.keyRelease(KeyEvent.VK_CAPS_LOCK);
		} else if (random == 2) {
			System.out.println("simpleClick VK_DOWN");
			robot.keyPress(KeyEvent.VK_DOWN);
			Thread.sleep(100);
			robot.keyRelease(KeyEvent.VK_DOWN);
		} else if (random == 3) {
			System.out.println("simpleClick PAGE_DOWN");
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			Thread.sleep(100);
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		} else if (random == 4) {
			System.out.println("simpleClick PAGE_UP");
			robot.keyPress(KeyEvent.VK_PAGE_UP);
			Thread.sleep(100);
			robot.keyRelease(KeyEvent.VK_PAGE_UP);
		}
		Thread.sleep(100);
	}

	public void complexClick(int button1, int button2) throws AWTException, InterruptedException {
		Thread.sleep(100);
		Robot robot = new Robot();
		robot.keyPress(button1);
		Thread.sleep(100);

		int random = getRandom(3);
		System.out.println("complexClick: " + random);
		for (int i = 0; i < random; i++) {
			robot.keyPress(button2);
			Thread.sleep(100);
			robot.keyRelease(button2);
			Thread.sleep(100);
		}

		robot.keyRelease(button1);
		Thread.sleep(100);
	}

	public int getRandom(int max) {
		Random rand = new Random();
		return rand.nextInt(max) + 1;
	}

	public void listener() {
		// GlobalKeyboardHook keyboardHook = new GlobalKeyboardHook(true);
		//
		// for (Entry<Long, String> keyboard :
		// GlobalKeyboardHook.listKeyboards().entrySet())
		// System.out.format("%d: %s\n", keyboard.getKey(),
		// keyboard.getValue());
		//
		// keyboardHook.addKeyListener(new GlobalKeyAdapter() {
		// @Override
		// public void keyPressed(GlobalKeyEvent event) {
		// System.out.println(event);
		// if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_ESCAPE)
		// run = false;
		// }
		//
		// @Override
		// public void keyReleased(GlobalKeyEvent event) {
		// System.out.println(event);
		// }
		// });
		//
		// try {
		// while (run)
		// Thread.sleep(128);
		// } catch (InterruptedException e) {
		// /* nothing to do here */ } finally {
		// keyboardHook.shutdownHook();
		// }
	}

}
