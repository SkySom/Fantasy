package io.sommers.fantasy.api.spells.spellcaster;

public interface ISpellCaster {
    void addMana(int amount);

    void removeMana(int amount);

    int getMana();

    int getMaxMana();

    void regenerateMana();
}
