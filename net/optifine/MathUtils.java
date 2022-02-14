package net.optifine;

import net.minecraft.client.Minecraft;

public class MathUtils {
	public static int getAverage(int[] p_getAverage_0_) {
		if (p_getAverage_0_.length <= 0) {
			return 0;
		} else {
			int i = 0;

			for (int j = 0; j < p_getAverage_0_.length; ++j) {
				int k = p_getAverage_0_[j];
				i += k;
			}

			int l = i / p_getAverage_0_.length;
			return l;
		}
	}

	public static double getIncremental(final double val, final double inc) {
		final double one = 1.0 / inc;
		return Math.round(val * one) / one;
	}

	public static float toDegree(double x, double z) {
		return (float)(Math.atan2(z - (Minecraft.getMinecraft()).thePlayer.posZ, x - (Minecraft.getMinecraft()).thePlayer.posX) * 180.0D / Math.PI) - 90.0F;
	}
}
