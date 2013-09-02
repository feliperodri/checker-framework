package dataflow.cfg.block;

import dataflow.analysis.Store;

/**
 * Implementation of a conditional basic block.
 *
 * @author Stefan Heule
 *
 */
public class ConditionalBlockImpl extends BlockImpl implements ConditionalBlock {

    /** Successor of the then branch. */
    protected BlockImpl thenSuccessor;

    /** Successor of the else branch. */
    protected BlockImpl elseSuccessor;

    /**
     * The rules below say that the THEN store before a conditional
     * block flows to BOTH of the stores of the then successor, while
     * the ELSE store before a conditional block flows to BOTH of the
     * stores of the else successor.
     */
    protected Store.FlowRule thenStoreFlow = Store.FlowRule.THEN_TO_BOTH;
    
    protected Store.FlowRule elseStoreFlow = Store.FlowRule.ELSE_TO_BOTH;

    /**
     * Initialize an empty conditional basic block to be filled with contents
     * and linked to other basic blocks later.
     */
    public ConditionalBlockImpl() {
        type = BlockType.CONDITIONAL_BLOCK;
    }

    /**
     * Set the then branch successor.
     */
    public void setThenSuccessor(BlockImpl b) {
        thenSuccessor = b;
        b.addPredecessor(this);
    }

    /**
     * Set the else branch successor.
     */
    public void setElseSuccessor(BlockImpl b) {
        elseSuccessor = b;
        b.addPredecessor(this);
    }

    @Override
    public Block getThenSuccessor() {
        return thenSuccessor;
    }

    @Override
    public Block getElseSuccessor() {
        return elseSuccessor;
    }

    @Override
    public Store.FlowRule getThenStoreFlow() {
        return thenStoreFlow;
    }

    @Override
    public Store.FlowRule getElseStoreFlow() {
        return elseStoreFlow;
    }

    @Override
    public void setThenStoreFlow(Store.FlowRule rule) {
        thenStoreFlow = rule;
    }

    @Override
    public void setElseStoreFlow(Store.FlowRule rule) {
        elseStoreFlow = rule;
    }

    @Override
    public String toString() {
        return "ConditionalBlock()";
    }
}
