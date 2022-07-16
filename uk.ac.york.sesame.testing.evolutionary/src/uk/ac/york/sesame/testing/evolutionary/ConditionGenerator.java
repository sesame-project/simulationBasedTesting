package uk.ac.york.sesame.testing.evolutionary;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;

import it.units.malelab.jgea.representation.tree.Tree;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardGrammar.Condition;
import uk.ac.york.sesame.testing.evolutionary.grammar.ConversionFailed;
import uk.ac.york.sesame.testing.evolutionary.grammar.Grammar;
import uk.ac.york.sesame.testing.evolutionary.grammar.GrammarConverter;
import uk.ac.york.sesame.testing.evolutionary.grammar.GrowGrammarTreeFactory;

public class ConditionGenerator {
	
	private Random rng;
	private int maxGrammarHeight;
	private Grammar<String> grammar;
	private GrammarConverter gc;
	
	public ConditionGenerator(TestCampaign selectedCampaign) {
		String GRAMMAR_FILE = "/home/jharbin/academic/sesame/WP6/uk.ac.york.sesame.testing.generator/files/grammar/sesame-standardgrammar-firstExperiment.bnf";
		gc = new GrammarConverter(selectedCampaign);
		rng = new Random();
		try {
			grammar = Grammar.fromFile(GRAMMAR_FILE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}
	
	public Condition generateOne(int depth) throws ConversionFailed {
		int depthToUse = Math.min(maxGrammarHeight, depth);
		GrowGrammarTreeFactory<String> gen = new GrowGrammarTreeFactory<String>(depthToUse, grammar);
		List<Tree<String>> generated = gen.build(1, rng);
		Tree<String> genTree = generated.get(0);
		return gc.convertTree(genTree); 
	}
	
	public Condition generateOne() throws ConversionFailed {
		return generateOne(maxGrammarHeight);
	}
}
