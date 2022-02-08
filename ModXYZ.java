package PisuClient.mods.impl;

import PisuClient.gui.hud.ScreenPosition;
import PisuClient.mods.ModDraggable;

public class ModXYZ extends ModDraggable {
	
	

	@Override
	public int getWidth() {
		return font.getStringWidth(getXYZString());
	}

	@Override
	public int getHeight() {
		return font.FONT_HEIGHT;
	}

	@Override
	public void render(ScreenPosition pos) {
		font.drawString(getXYZString(), pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
		
	}

	private String getXYZString() {
		return String.format("XYZ: %.3f / %.3f / %.3f",
				mc.getRenderViewEntity().posX,
				mc.getRenderViewEntity().getEntityBoundingBox().minY,
				mc.getRenderViewEntity().posZ
				);
		
	}



}
