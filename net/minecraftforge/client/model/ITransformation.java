package net.minecraftforge.client.model;

import gq.vapu.czfclient.Libraries.javax.vecmath.Matrix4f;
import net.minecraft.util.EnumFacing;

public interface ITransformation {
	Matrix4f getMatrix();

	EnumFacing rotate(EnumFacing var1);

	int rotate(EnumFacing var1, int var2);
}
