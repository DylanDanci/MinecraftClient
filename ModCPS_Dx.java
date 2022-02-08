package PisuClient.mods.impl;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Mouse;

import PisuClient.gui.hud.ScreenPosition;
import PisuClient.mods.ModDraggable;

public class ModCPS_Dx extends ModDraggable {
	
	private List<Long> clicksDx = new ArrayList<Long>();
	private boolean wasPressed;
	private long lastPressed;
	

	@Override
	public int getWidth() {
		return font.getStringWidth("CPS: 00");
	}

	@Override
	public int getHeight() {
		return font.FONT_HEIGHT;
	}

	@Override
	public void render(ScreenPosition pos) {
	
		
		final boolean pressedDx = Mouse.isButtonDown(1);

		
		if(pressedDx != this.wasPressed) {
			this.lastPressed = System.currentTimeMillis();
			this.wasPressed = pressedDx;
			if(pressedDx) {
				this.clicksDx.add(this.lastPressed);
			}
		}
		
		
		font.drawString("CPS_Dx: " + getCPS_Dx(), pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
		
	}
	

	
	private int getCPS_Dx() {
		
		final long time = System.currentTimeMillis();
		this.clicksDx.removeIf(aLong -> aLong + 1000 < time);
		return this.clicksDx.size();
		
	}
}
