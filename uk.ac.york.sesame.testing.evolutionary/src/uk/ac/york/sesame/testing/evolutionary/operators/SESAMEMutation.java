package uk.ac.york.sesame.testing.evolutionary.operators;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import uk.ac.york.sesame.testing.evolutionary.SESAMETestAttack;
import uk.ac.york.sesame.testing.evolutionary.SESAMETestSolution;
import org.uma.jmetal.operator.mutation.MutationOperator;

//import it.units.malelab.jgea.representation.tree.Tree;

import uk.ac.york.sesame.testing.evolutionary.grammar.Grammar;

// TODO: check mutation logic against the changes that I made with Simos on github last year
// Things to check: ensuring all strings/options etc are fresh

// I think it has to be ensured in the crossover operation - ensuring creating a fresh one
abstract public class SESAMEMutation extends SESAMEMutationOperation {

}
