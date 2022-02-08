package PisuClient.mods.impl;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Mouse;

import PisuClient.gui.hud.ScreenPosition;
import PisuClient.mods.ModDraggable;

public class ModCPS_Sx extends ModDraggable {
	
	private List<Long> clicksSx = new ArrayList<Long>();
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
	
		final boolean pressedSx = Mouse.isButtonDown(0);
		
		
		if(pressedSx != this.wasPressed) {
			this.lastPressed = System.currentTimeMillis();
			this.wasPressed = pressedSx;
			if(pressedSx) {
				this.clicksSx.add(this.lastPressed);
			}
		}
		

		
		font.drawString("CPS_Sx: " + getCPS_Sx(), pos.getAbsoluteX(), pos.getAbsoluteY(), -1);

		
	}
	
	private int getCPS_Sx() {
		
		final long time = System.currentTimeMillis();
		this.clicksSx.removeIf(aLong -> aLong + 1000 < time);
		return this.clicksSx.size();
		
	}


}
