package fr.umontpellier.iut.dominion.cards.type;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.ArrayList;
import java.util.List;

public class Treasure extends Card {

    public Treasure(String name, int cost) {
        super(name, cost);
    }

    public List<CardType> getTypes() {
        ArrayList<CardType> type = new ArrayList<>();
        type.add(CardType.Treasure);
        return type;
    }
}
