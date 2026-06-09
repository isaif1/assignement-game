package com.gameoflife.rules;

import com.gameoflife.model.CellState;

import java.util.Arrays;
import java.util.List;

/*
 * Evaluates rules in order and returns the first matching result.
 * Can be constructed with custom rules if needed (e.g. for HighLife variant).
 */
public class StandardRuleEngine {

    private final List<GameRule> rules;

    public StandardRuleEngine() {
        this.rules = Arrays.asList(
                new UnderpopulationRule(),
                new SurvivalRule(),
                new OvercrowdingRule(),
                new ReproductionRule()
        );
    }

    public StandardRuleEngine(List<GameRule> rules) {
        this.rules = rules;
    }

    public CellState evaluateNextState(CellState currentState, int aliveNeighbors) {
        for (GameRule rule : rules) {
            CellState result = rule.apply(currentState, aliveNeighbors);
            if (result != null) {
                return result;
            }
        }
        // fallback - shouldn't really happen with the standard rules
        return currentState;
    }
}
