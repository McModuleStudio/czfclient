package net.minecraft.client.gui;

import gq.vapu.czfclient.Client;
import gq.vapu.czfclient.Manager.FileManager;
import gq.vapu.czfclient.UI.Font.CFontRenderer;
import gq.vapu.czfclient.UI.Font.FontLoaders;
import gq.vapu.czfclient.UI.Login.GuiAltManager;
import gq.vapu.czfclient.Util.BlurUtil;
import gq.vapu.czfclient.Util.Render.RenderUtil;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GuiMainMenu extends GuiScreen implements GuiYesNoCallback {

	CFontRenderer font = FontLoaders.GoogleSans20;
	CFontRenderer font1 = FontLoaders.GoogleSans28;

	@Override
	public void initGui() {
		super.initGui();
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		int Height;
		int h = Height = new ScaledResolution(this.mc).getScaledHeight();
		int Width;
		int w = Width = new ScaledResolution(this.mc).getScaledWidth();
		boolean isOverSingleplayer = mouseX > w / 2 - 100 && mouseX < w / 2 - 84 && mouseY > h / 2 + 26
				&& mouseY < h / 2 + 44;
		boolean isOverMultiplayer = mouseX > w / 2 - 56 && mouseX < w / 2 - 32 && mouseY > h / 2 + 26
				&& mouseY < h / 2 + 44;
		boolean isOverAltManager = mouseX > w / 2 - 10 && mouseX < w / 2 + 20 && mouseY > h / 2 + 26
				&& mouseY < h / 2 + 44;
		boolean isOverSettings = mouseX > w / 2 + 46 && mouseX < w / 2 + 62 && mouseY > h / 2 + 26
				&& mouseY < h / 2 + 44;
		boolean isOverExit = mouseX > w / 2 + 90 && mouseX < w / 2 + 105 && mouseY > h / 2 + 26 && mouseY < h / 2 + 44;
		GL11.glPushMatrix();
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
//		this.mc.getTextureManager().bindTexture(new ResourceLocation("ClientRes/mainMenu/BackGround.png"));
//		drawScaledCustomSizeModalRect(0, 0, 0.0f, 0.0f, width, height, width, height, width, height);
		//获取屏幕长和高
		ScaledResolution s = new ScaledResolution(mc);
		mc.getTextureManager().bindTexture(new ResourceLocation("ClientRes/mainMenu/BackGround.png"));
//		File f = new File("CzfClient\\ACG.png");
//		mc.getTextureManager().bindTexture(new ResourceLocation(FileManager.read(f,true)));
//		mc.getTextureManager().bindTexture(new ResourceLocation("D:\\client\\czf\\CzfClient\\ACG.png"));
//		String path = this.getServletContext().getRealPath("images/photo.jpg");
		Gui.drawModalRectWithCustomSizedTexture(0, 0, 0, 0, s.getScaledWidth(), s.getScaledHeight(), s.getScaledWidth(), s.getScaledHeight());
		FontLoaders.NovICON44.drawString("M", 44, 20, new Color(210, 132, 246).getRGB());
		font.drawString("Minecraft 1.8 | " + Client.name + " " + Client.ver+" | Default resource pack is created by @MyLunar", 2, h - 10, new Color(255, 255, 255).getRGB());
//        font.drawString(Client.instance.name + " Version "+ Client.instance.ver,
//                w - font.getStringWidth(Client.instance.name + " Version " +Client.instance.ver)
//                        - 2,
//                h - 10, new Color(108, 108, 108).getRGB());

		//RenderUtil.R2DUtils.drawRect(w / 2 - 120, h / 2 + 15, w / 2 + 120, h / 2 + 52, ClientUtil.reAlpha(3, 0.3F));
		BlurUtil.blurAreaBoarder(w / 2 - 120, h / 2 + 6, 250, 48, 36);
		FontLoaders.NovICON44.drawString("C", w / 2 - 100, h / 2 + 26,
				isOverSingleplayer ? new Color(222, 221, 226).getRGB() : new Color(142, 142, 142).getRGB());
		FontLoaders.NovICON44.drawString("B", w / 2 - 56, h / 2 + 26,
				isOverMultiplayer ? new Color(222, 221, 226).getRGB() : new Color(142, 142, 142).getRGB());
		FontLoaders.NovICON44.drawString("A", w / 2 - 10, h / 2 + 26,
				isOverAltManager ? new Color(222, 221, 226).getRGB() : new Color(142, 142, 142).getRGB());
		FontLoaders.NovICON44.drawString("G", w / 2 + 46, h / 2 + 26,
				isOverSettings ? new Color(222, 221, 226).getRGB() : new Color(142, 142, 142).getRGB());
		FontLoaders.NovICON44.drawString("D", w / 2 + 90, h / 2 + 26,
				isOverExit ? new Color(222, 221, 226).getRGB() : new Color(142, 142, 142).getRGB());

		font.drawString("Welcome, " + mc.session.getUsername(), w - 150 - (mc.session.getUsername().length()*3), 0 + 40, new Color(222, 221, 226).getRGB());
		RenderUtil.drawImage(new ResourceLocation("ClientRes/mainMenu/avatar.png"), w-50, 0+27, 32, 32);//Skid for Hanabi[给心心]
		if (isOverSingleplayer) {
			Gui.drawRect(w / 2 - 100, h / 2 + 50, w / 2 - 84, h / 2 + 54, new Color(210, 132, 246).getRGB());
		}
		if (isOverMultiplayer) {
			Gui.drawRect(w / 2 - 56, h / 2 + 50, w / 2 - 32, h / 2 + 54, new Color(210, 132, 246).getRGB());
		}
		if (isOverAltManager) {
			Gui.drawRect(w / 2 - 10, h / 2 + 50, w / 2 + 20, h / 2 + 54, new Color(210, 132, 246).getRGB());
		}
		if (isOverSettings) {
			Gui.drawRect(w / 2 + 46, h / 2 + 50, w / 2 + 62, h / 2 + 54, new Color(210, 132, 246).getRGB());
		}
		if (isOverExit) {
			Gui.drawRect(w / 2 + 90, h / 2 + 50, w / 2 + 105, h / 2 + 54, new Color(180, 61, 236).getRGB());
		}
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1f);
		GL11.glPopMatrix();
		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	public int rgbToHex(int r, int g, int b) {
		return ((1 << 24) + (r << 16) + (g << 8) + b);
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		int Height;
		int h = Height = new ScaledResolution(this.mc).getScaledHeight();
		int Width;
		int w = Width = new ScaledResolution(this.mc).getScaledWidth();
		boolean isOverSingleplayer = mouseX > w / 2 - 100 && mouseX < w / 2 - 84 && mouseY > h / 2 + 26
				&& mouseY < h / 2 + 44;
		boolean isOverMultiplayer = mouseX > w / 2 - 56 && mouseX < w / 2 - 32 && mouseY > h / 2 + 26
				&& mouseY < h / 2 + 44;
		boolean isOverAltManager = mouseX > w / 2 - 10 && mouseX < w / 2 + 20 && mouseY > h / 2 + 26
				&& mouseY < h / 2 + 44;
		boolean isOverSettings = mouseX > w / 2 + 46 && mouseX < w / 2 + 62 && mouseY > h / 2 + 26
				&& mouseY < h / 2 + 44;
		boolean isOverExit = mouseX > w / 2 + 90 && mouseX < w / 2 + 105 && mouseY > h / 2 + 26 && mouseY < h / 2 + 44;

		if (mouseButton == 0 && isOverSingleplayer) {
			this.mc.displayGuiScreen(new GuiSelectWorld(this));
		}

		if (mouseButton == 0 && isOverMultiplayer) {
			this.mc.displayGuiScreen(new GuiMultiplayer(this));
		}

		if (mouseButton == 0 && isOverAltManager) {
			this.mc.displayGuiScreen(new GuiAltManager());
		}

		if (mouseButton == 0 && isOverSettings) {
			this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
		}

		if (mouseButton == 0 && isOverExit) {
			this.mc.shutdown();
		}
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}
}
