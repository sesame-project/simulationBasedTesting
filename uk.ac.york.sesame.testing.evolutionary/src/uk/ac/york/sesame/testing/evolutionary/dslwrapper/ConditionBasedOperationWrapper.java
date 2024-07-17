package uk.ac.york.sesame.testing.evolutionary.dslwrapper;

import java.security.SecureRandom;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;

import it.units.malelab.jgea.representation.tree.Tree;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.Activation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.ConditionBasedActivation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.DynamicOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FixedTimeActivation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperationsFactory;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardGrammar.Condition;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardGrammar.ConditionConstraint;
import uk.ac.york.sesame.testing.evolutionary.ConditionGenerator;
import uk.ac.york.sesame.testing.evolutionary.ConstraintsNotMet;
import uk.ac.york.sesame.testing.evolutionary.ParamError;
import uk.ac.york.sesame.testing.evolutionary.grammar.ConversionFailed;

public class ConditionBasedOperationWrapper extends DynamicOperationWrapper {
	private Tree<String> storedStartTree;
	private Tree<String> storedEndTree;
	public ConditionBasedWrapperFactory cwf;
	
	public ConditionBasedOperationWrapper(DynamicOperation op, Tree<String> storedStartTree, Tree<String> storedEndTree, ConditionBasedWrapperFactory cwf) {
		super(op);
		this.cwf = cwf;
	}
	
	public ConditionBasedOperationWrapper(DynamicOperation op, ConditionBasedWrapperFactory cwf) {
		super(op);
		this.cwf = cwf;
	}
	
	@Override
	public FuzzingOperationWrapper reductionOfOperation(SecureRandom rng) throws ParamError, ConversionFailed, ConstraintsNotMet {
		// cg has to come from the wrapper factory - has to be condition based
		ConditionGenerator cg = cwf.getConditionGenerator();
		
		
		DynamicOperation dynOp = this.getDynamicOperation();
		DynamicOperation newA = EcoreUtil.copy(dynOp);
		List<ConditionConstraint> ccs = dynOp.getConditionConstraints();

		newA.setFromTemplate((FuzzingOperation)this);
		Tree<String> startTree = cg.generateOneWithConstraints(ccs);
		
		// TODO: currently only the start condition is constrained.
		Tree<String> endTree = cg.generateOne();
		
		// Store the starting and ending trees with this individual
		System.out.println("startTree = " + startTree);
		System.out.println("endTree = " + endTree);

		Condition start = cg.convert(startTree);
		Condition end = cg.convert(endTree);
		FuzzingOperationsFactory f = FuzzingOperationsFactory.eINSTANCE;
		ConditionBasedActivation ca = f.createConditionBasedActivation();
		ca.setStarting(start);
		ca.setEnding(end);
		newA.setActivation(ca);

		// TODO: factor these out into separate files
		reduceOperationSpecific(rng, newA, (FuzzingOperation)this);

		// Ensure the new individual has the stored start trees and end trees
		return new ConditionBasedOperationWrapper(newA, startTree, endTree, this.cwf);

	}
	
	public Activation getActivation() {
		return dynT.getActivation();
	}
	
	public void setActivation(Activation a) {
		dynT.setActivation(a);
	}
	
	public Tree<String> getStoredStartTree() {
		return storedStartTree;
	}

	public Tree<String> getStoredEndTree() {
		return storedEndTree;
	}
	
	public void setStoredStartTree(Tree<String> tNew) {
		storedStartTree = tNew;
	}

	public void setStoredEndTree(Tree<String> tNew) {
		storedEndTree = tNew;
	}

	public String toString() {
		String output = super.toString();
		output = output + activationToString(getActivation()) + "\n";
		return output;
	}

	public ConditionBasedOperationWrapper dup() {
		ConditionBasedOperationWrapper newSFOW = new ConditionBasedOperationWrapper(this.dynT, this.cwf);
		if (this.storedStartTree != null) {
			newSFOW.setStoredStartTree(Tree.copyOf(storedStartTree));
		}
		if (this.storedEndTree != null) {
			newSFOW.setStoredEndTree(Tree.copyOf(storedEndTree));
		}
		return newSFOW;
	}
	
	public ConditionGenerator getConditionGenerator() {
		return cwf.getConditionGenerator();
	}
}
