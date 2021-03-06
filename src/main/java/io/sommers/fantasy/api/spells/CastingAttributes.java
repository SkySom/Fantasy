package io.sommers.fantasy.api.spells;

import net.minecraft.nbt.NBTTagCompound;

public class CastingAttributes {
    private double power;
    private double cost;
    private double length;

    public CastingAttributes() {
        this(1.0, 1.0, 1.0);
    }

    public CastingAttributes(double power, double cost, double length) {
        this.power = power;
        this.cost = cost;
        this.length = length;
    }

    public CastingAttributes(NBTTagCompound castingAttributes) {
        this.power = castingAttributes.getDouble("power");
        this.cost = castingAttributes.getDouble("cost");
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public NBTTagCompound writeToNBT(NBTTagCompound nbtTagCompound) {
        nbtTagCompound.setDouble("power", this.power);
        nbtTagCompound.setDouble("cost", this.cost);
        return nbtTagCompound;
    }
}
