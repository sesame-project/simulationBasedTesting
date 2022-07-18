package uk.ac.york.sesame.testing.evolutionary;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import it.units.malelab.jgea.representation.tree.Tree;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardGrammar.Condition;
import uk.ac.york.sesame.testing.evolutionary.grammar.ConversionFailed;
import uk.ac.york.sesame.testing.evolutionary.grammar.Grammar;
import uk.ac.york.sesame.testing.evolutionary.grammar.GrammarBasedSubtreeMutation;
import uk.ac.york.sesame.testing.evolutionary.grammar.GrammarConverter;
import uk.ac.york.sesame.testing.evolutionary.grammar.GrowGrammarTreeFactory;

public class ConditionGenerator {
	
	private Random rng;
	private int maxGrammarHeight;
	private Grammar<String> grammar;
	private GrammarConverter gc;
	
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

	public Tree<String> mutate(Tree<String> t, Random rng2) {
		return mutator.mutate(t, rng);
	}
	
}
