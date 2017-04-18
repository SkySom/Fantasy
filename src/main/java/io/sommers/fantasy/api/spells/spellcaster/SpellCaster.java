package io.sommers.fantasy.api.spells.spellcaster;

public class SpellCaster implements ISpellCaster {
    private int mana;
    private int maxMana;

    public SpellCaster(int mana, int maxMana) {
        this.mana = mana;
        this.maxMana = maxMana;
    }

    @Override
    public void addMana(int amount) {
        mana = Math.min(maxMana, mana + amount);
    }

    @Override
    public void removeMana(int amount) {
        mana = Math.max(0, mana - amount);
    }

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public int getMaxMana() {
        return maxMana;
    }

    @Override
    public void regenerateMana() {
        this.addMana(50);
    }
}
