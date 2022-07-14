package uk.ac.york.sesame.testing.evolutionary.grammar;

import org.eclipse.emf.common.util.EList;

import it.units.malelab.jgea.representation.tree.Tree;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.Metric;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardGrammar.*;

public class GrammarConverter {
	
	private StandardGrammarFactory factory = StandardGrammarFactory.eINSTANCE;
	private TestCampaign testCampaign;
	
	public GrammarConverter(TestCampaign tc) { 
		this.testCampaign = tc;
	}
	
	// TODO: conversion from the string tree to an actual condition
	public Condition convertTree(Tree<String> t) throws ConversionFailed {
		StandardGrammarFactory f = StandardGrammarFactory.eINSTANCE;
		Condition c = (Condition)f.createCondition();
		try {
			ConditionElement ce = convert(t);
			c.setC(ce);
		} catch (UnrecognisedBinOp | UnrecognisedLiteral | UnrecognisedComparison | UnrecognisedTreeNode e) {
			throw new ConversionFailed(e);
		}
		return c;
	}

	public Tree<String> convertTree(Condition c) {
		return new Tree<String>(null, null);
	}

	protected final boolean DEBUG_GRAMMER_CONVERT = true; 
	
	protected ConditionVariable createVariable(String varName) {
		ConditionVariable v = factory.createConditionVariable();
		EList<Metric> ms = testCampaign.getConditionMetrics();
		
		// Set link to Metrics here from testCampaign	
		for (Metric m : ms) {
			if (m.getName().equals(varName)) {
				v.setMetric(m);
			}
		}
		
		return v;		
	}
	
	public ConditionElement convert(Tree<String> stringTree) throws UnrecognisedBinOp, UnrecognisedLiteral, UnrecognisedComparison, UnrecognisedTreeNode {
		
		if (DEBUG_GRAMMER_CONVERT) {
			System.out.print("convert - Tree...\n");
			stringTree.prettyPrint(System.out);
			System.out.println();
		}
		
		String s = stringTree.content();
		// Binary combined condition
		if (s.equals("<compcond>") && stringTree.nChildren() == 3) {
			if (DEBUG_GRAMMER_CONVERT) {
				System.out.println("COMPCOND - BINARY");
				System.out.println("Child 0 = " + stringTree.child(0));
				System.out.println("Child 1 = " + stringTree.child(1));
				System.out.println("Child 2 = " + stringTree.child(2));
			}
			Tree<String> lhs = stringTree.child(0);
			String bincomp = stringTree.child(1).child(0).content();
			Tree<String> rhs = stringTree.child(2);
			
			ConditionElement condlhs = convert(lhs);
			BinaryLogicalOperation op = convertBinLogicOp(bincomp);
			ConditionElement condrhs = convert(rhs);
			
			CompositeCondition c = factory.createCompositeCondition();
			c.setLeft(condlhs);
			c.setRight(condrhs);
			c.setBinop(op);
			return c;
		}
		
		if (s.equals("<basic_cond>")) {
			if (DEBUG_GRAMMER_CONVERT) {
				System.out.println("BASIC_COND");
				System.out.println("Child 0 = " + stringTree.child(0));
				System.out.println("Child 1 = " + stringTree.child(1));
				System.out.println("Child 2 = " + stringTree.child(2));
			}
			Tree<String> lhs = stringTree.child(0);
			String bincomp = stringTree.child(1).child(0).content();
			Tree<String> rhs = stringTree.child(2);
			
//			// If the string is a literal
//			if (rhs.child(0).content().equals("<var>")) {
//				
//				
//			}
			
			ConditionVariable v = convertVariable(lhs);
			ConditionLiteral l = convertLiteral(rhs);
			BasicCondition basicCond = factory.createBasicCondition();
			basicCond.setLeft(v);
			basicCond.setRight(l);
			basicCond.setBincomp(convertCompare(bincomp));
			return basicCond;
		}
		
		if (s.equals("<expr>")) {
			return convert(stringTree.child(0));
		}
		
		throw new UnrecognisedTreeNode(s);
		
	}
	
	private ConditionVariable convertVariable(Tree<String> t) {
		return createVariable(t.child(1).content());
	}
	
	private ConditionLiteral convertLiteral(Tree<String> t) throws UnrecognisedLiteral {
		if (t.child(0).content().equals("<var>")) {
			return convertVariable(t);
		}
		
		if (t.child(0).content().equals("<int>")) {
			int i = Integer.valueOf(t.child(1).content());
			ConditionInteger ci = factory.createConditionInteger();
			ci.setValue(i);
			return ci;
		}
		
		throw new UnrecognisedLiteral(t);
	}

	private BinaryLogicalOperation convertBinLogicOp(String compStr) throws UnrecognisedBinOp {
		if (compStr.equals(".AND")) {
			return BinaryLogicalOperation.AND;
		}
		
		if (compStr.equals(".OR")) {
			return BinaryLogicalOperation.OR;
		}
		
		throw new UnrecognisedBinOp(compStr);
	}

	private BinaryComparisonOperation convertCompare(String compStr) throws UnrecognisedComparison {
		if (compStr.equals(".EQUALS")) {
			return BinaryComparisonOperation.EQUALS;
		}
		
		if (compStr.equals(".LESS_THAN")) {
			return BinaryComparisonOperation.LESS_THAN;
		}
		
		if (compStr.equals(".GREATER_THAN")) {
			return BinaryComparisonOperation.GREATER_THAN;
		}
		
		throw new UnrecognisedComparison(compStr);
	}
}
