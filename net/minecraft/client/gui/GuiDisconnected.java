package net.minecraft.client.gui;

import gq.vapu.czfclient.Util.RamdonUtil;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Session;

import java.io.IOException;
import java.util.List;

public class GuiDisconnected extends GuiScreen {
	private String reason;
	private IChatComponent message;
	private List<String> multilineMessage;
	private final GuiScreen parentScreen;
	private int field_175353_i;
	private String username;

	public GuiDisconnected(GuiScreen screen, String reasonLocalizationKey, IChatComponent chatComp) {
		this.parentScreen = screen;
		this.reason = I18n.format(reasonLocalizationKey, new Object[0]);
		this.message = chatComp;
	}
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
	}
	public void initGui() {
		this.buttonList.clear();
		this.multilineMessage = this.fontRendererObj.listFormattedStringToWidth(this.message.getFormattedText(),
				this.width - 50);
		this.field_175353_i = this.multilineMessage.size() * this.fontRendererObj.FONT_HEIGHT;
		this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 2 + this.field_175353_i / 2 + this.fontRendererObj.FONT_HEIGHT, I18n.format("gui.toMenu", new Object[0])));
	    this.buttonList.add(new GuiButton(1, this.width, this.height, I18n.format("Random offline")));
	}

	/**
	 * Called by the controls from the buttonList when activated. (Mouse pressed for
	 * buttons)
	 */
	protected void actionPerformed(GuiButton button) throws IOException {
		if (button.id == 0) {
			this.mc.displayGuiScreen(this.parentScreen);
		}
		if(button.id == 1){
			RamdonUtil test = new RamdonUtil();
			this.username = "gq/vapu/czfclient" + test.getStringRandom(8);
			this.mc.session = new Session(this.username, "", "", "mojang");
		}
	}

	/**
	 * Draws the screen and all the components in it. Args : mouseX, mouseY,
	 * renderPartialTicks
	 */
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		if(this.multilineMessage.contains("Ban") || this.multilineMessage.contains("ban") || this.multilineMessage.contains("·â") || this.multilineMessage.contains("Hacking") || this.multilineMessage.contains("Cheating")) {
			ScaledResolution Screen = new ScaledResolution(mc);
			mc.getTextureManager().bindTexture(new ResourceLocation("ClientRes/mainMenu/GoodNews.png"));
			Gui.drawModalRectWithCustomSizedTexture(0, 0, 0, 0, Screen.getScaledWidth(), Screen.getScaledHeight(), Screen.getScaledWidth(), Screen.getScaledHeight());
		} else {
			drawDefaultBackground();
		}
		this.drawCenteredString(this.fontRendererObj, this.reason, this.width / 2,
				this.height / 2 - this.field_175353_i / 2 - this.fontRendererObj.FONT_HEIGHT * 2, 11184810);
		int i = this.height / 2 - this.field_175353_i / 2;

		if (this.multilineMessage != null) {
			for (String s : this.multilineMessage) {
				this.drawCenteredString(this.fontRendererObj, s, this.width / 2, i, 16777215);
				i += this.fontRendererObj.FONT_HEIGHT;
			}
		}

		super.drawScreen(mouseX, mouseY, partialTicks);
	}
}
