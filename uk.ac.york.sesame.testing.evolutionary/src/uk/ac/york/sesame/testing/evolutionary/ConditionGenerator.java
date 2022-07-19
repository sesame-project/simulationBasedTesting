package uk.ac.york.sesame.testing.evolutionary;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import it.units.malelab.jgea.representation.tree.Tree;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardGrammar.*;
import uk.ac.york.sesame.testing.evolutionary.grammar.*;
import uk.ac.york.sesame.testing.evolutionary.grammar.Grammar;
import uk.ac.york.sesame.testing.evolutionary.grammar.GrammarBasedSubtreeMutation;
import uk.ac.york.sesame.testing.evolutionary.grammar.GrammarConverter;
import uk.ac.york.sesame.testing.evolutionary.grammar.GrowGrammarTreeFactory;

public class ConditionGenerator {
	
	private Random rng;
	
	// TODO: maxGrammarHeight should be configurable
	private int maxGrammarHeight = 4;
	private Grammar<String> grammar;
	private GrammarConverter gc;
	
	private boolean DEBUG_MUTATION = true;
	
	// TODO: how does this parameter work?
	private int MUTATION_MAX_DEPTH = 1;
	
	protected GrammarBasedSubtreeMutation<String> mutator;
	
	public ConditionGenerator(TestCampaign selectedCampaign) {
		String GRAMMAR_FILE = "/home/jharbin/academic/sesame/WP6/uk.ac.york.sesame.testing.generator/files/grammar/sesame-standardgrammar-firstExperiment.bnf";
		gc = new GrammarConverter(selectedCampaign);
		rng = new Random();
		
		try {
			grammar = Grammar.fromFile(GRAMMAR_FILE);
			mutator = new GrammarBasedSubtreeMutation<String>(MUTATION_MAX_DEPTH, grammar);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}
	
	public Tree<String> generateOne(int depth) throws ConversionFailed {
		int depthToUse = Math.min(maxGrammarHeight, depth);
		GrowGrammarTreeFactory<String> gen = new GrowGrammarTreeFactory<String>(depthToUse, grammar);
		List<Tree<String>> generated = gen.build(1, rng);
		Tree<String> genTree = generated.get(0);
		return genTree;
	}
	
	public Tree<String> generateOne() throws ConversionFailed {
		return generateOne(maxGrammarHeight);
	}
	
	public Condition convert(Tree<String> t) throws ConversionFailed {
		return gc.convertTree(t);
	}

	public Tree<String> mutate(Tree<String> t, Random rng) {
		if (DEBUG_MUTATION) {
			System.out.println("Tree before mutation = " + t);
		}
		return mutator.mutate(t, rng);
	}
	
	public Tree<String> mutate(Tree<String> t) {
		// Use the default rng
		return mutate(t, rng);
	}

	public void printCondition(Condition c) {
		System.out.println(c.toString());
	}

	public String conditionToString(Condition c) {
		return "CONDITION: [" + c.getName() + ":" + conditionElementToString(c.getC()) + "]";
	}
	
	public String conditionElementToString(ConditionElement cElt) {
		if (cElt instanceof CompositeCondition) {
			CompositeCondition cComp = (CompositeCondition)cElt;
			return conditionElementToString(cComp.getLeft()) + cComp.getBinop().toString() + conditionElementToString(cComp.getRight());
		} else {
			// cElt is BasicCondition
			BasicCondition cBasic = (BasicCondition)cElt;
			return conditionVariableToString(cBasic.getLeft()) + cBasic.getBincomp().toString() + conditionExprToString(cBasic.getRight());
		}
	}

	private String conditionVariableToString(ConditionVariable var) {
		return var.getMetric().getName();
	}
	
	private String conditionExprToString(ConditionExpr expr) {
		if (expr instanceof ConditionInteger) {
			ConditionInteger i = (ConditionInteger)expr;
			String s = String.valueOf(i.getValue());
			return s;
		} else {
			// Variable 
			ConditionVariable var = (ConditionVariable)expr;
			return conditionVariableToString(var);
		}
	}

}
