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
	private int maxGrammarHeight;
	private Grammar<String> grammar;
	private GrammarConverter gc;
	
	private boolean DEBUG_MUTATION = true;
	private int MAX_MUTATION_TRY_COUNT = 5;
	
	// TODO: how does this parameter work?
	private int MUTATION_MAX_DEPTH = 1;
	
	protected GrammarBasedSubtreeMutation<String> mutator;
	
	public ConditionGenerator(String grammarPath, TestCampaign selectedCampaign, int maxGrammarHeight) {
		this.maxGrammarHeight = maxGrammarHeight;
		gc = new GrammarConverter(selectedCampaign);
		rng = new Random();
		
		try {
			grammar = Grammar.fromFile(grammarPath);
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
		int count = 0;
		boolean changed = false;
		Tree<String> tNew = t;
		while ((count++ < MAX_MUTATION_TRY_COUNT) && !changed) {
			if (DEBUG_MUTATION) {
				System.out.println("Try " + count + " tree before mutation = " + t);
			}
			tNew = mutator.mutate(t, rng);
			if (!tNew.equals(t)) {
				changed = true;
			}
		}
		return tNew;
	}
	
	public Tree<String> mutate(Tree<String> t) {
		// Use the default rng
		return mutate(t, rng);
	}

	public void printCondition(Condition c) {
		System.out.println(c.toString());
	}

	public String conditionToString(Condition c) {
		try {
			return "CONDITION: [" + c.getName() + ":" + conditionElementToString(c.getC()) + "]";
		} catch (InvalidElementConversion e) {
			e.printStackTrace();
			return "CONDITION: [" + c.getName() + ": INVALID]";
		}
	}
	
	public String binOpToString(BinaryLogicalOperation binop) throws InvalidElementConversion {
		if (binop == BinaryLogicalOperation.AND) {
			return "AND";
		}
		if (binop == BinaryLogicalOperation.OR) {
			return "OR";
		}
		throw new InvalidElementConversion("binop", binop.toString());
	}
	
	public String binCompToString(BinaryComparisonOperation bincomp) throws InvalidElementConversion {
		if (bincomp == BinaryComparisonOperation.LESS_THAN) {
			return "<";
		}
		if (bincomp == BinaryComparisonOperation.GREATER_THAN) {
			return ">";
		}
		if (bincomp == BinaryComparisonOperation.EQUALS) {
			return "==";
		}
		throw new InvalidElementConversion("binop", bincomp.toString());
	}


	public String conditionElementToString(ConditionElement cElt) throws InvalidElementConversion {
		if (cElt instanceof CompositeCondition) {
			CompositeCondition cComp = (CompositeCondition)cElt;
			return conditionElementToString(cComp.getLeft()) + " " + binOpToString(cComp.getBinop()) + " " + conditionElementToString(cComp.getRight());
		} else {
			// cElt is BasicCondition
			BasicCondition cBasic = (BasicCondition)cElt;
			return conditionVariableToString(cBasic.getLeft()) + " " + binCompToString(cBasic.getBincomp()) + " " + conditionExprToString(cBasic.getRight());
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
