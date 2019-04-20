package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.cards.type.Attack;

/**
 * Carte Sorcière (Witch)
 *
 * +2 Cartes.
 * Tous vos adversaires recoivent une carte Curse.
 */
public class Witch extends Attack {
    public Witch() {
        super("Witch", 5);
    }
}