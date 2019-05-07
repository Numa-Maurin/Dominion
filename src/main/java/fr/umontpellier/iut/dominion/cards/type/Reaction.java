package fr.umontpellier.iut.dominion.cards.type;

import fr.umontpellier.iut.dominion.CardType;

import java.util.List;

public class Reaction extends Action {

    public Reaction(String name, int cost) {
        super(name, cost);
    }

    public List<CardType> getTypes() {
        List<CardType> type = super.getTypes();
        type.add(CardType.Reaction);
        return type;
    }
}
