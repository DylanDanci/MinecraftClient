package PisuClient.mods.impl;

import PisuClient.gui.hud.ScreenPosition;
import PisuClient.mods.ModDraggable;

public class ModTimeChanger extends ModDraggable{
	
	private ScreenPosition pos;

	@Override
	public int getWidth() {
		return 0;
	}

	@Override
	public int getHeight() {
		return 0;
	}

	@Override
	public void render(ScreenPosition pos) {
		
	}

	@Override
	public void save(ScreenPosition pos) {
		this.pos = pos;
		
	}

	@Override
	public ScreenPosition load() {
		return pos;
	}

}