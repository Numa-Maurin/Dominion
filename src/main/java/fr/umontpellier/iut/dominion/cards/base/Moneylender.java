package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.cards.type.Action;

/**
 * Carte Prêteur sur gages (Moneylender)
 *
 * Écartez une carte Cuivre de votre main.
 * Dans ce cas, +3 Pièces.
 */
public class Moneylender extends Action {
    public Moneylender() {
        super("Moneylender", 4);
    }
}