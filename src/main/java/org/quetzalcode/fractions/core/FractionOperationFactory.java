package org.quetzalcode.fractions.core;

import java.util.HashMap;
import java.util.Map;

import org.quetzalcode.fractions.core.operation.AddFractionOperation;
import org.quetzalcode.fractions.core.operation.DivideFractionOperation;
import org.quetzalcode.fractions.core.operation.FractionOperation;
import org.quetzalcode.fractions.core.operation.MultiplyFractionOperation;
import org.quetzalcode.fractions.core.operation.SubstractFractionOperation;

/**
 * Lazy load singleton factory to get the FractionOperation implementation based on operator
 * @author OBarenque
 *
 */
public class FractionOperationFactory {
	
	private static final Map<Operator, FractionOperation> instances=new HashMap<Operator, FractionOperation>(Operator.values().length);
	
	private FractionOperationFactory() {
	}
	/**
	 * gets a FractionOperation instance based on operator
	 * @param operator
	 * @return
	 */
	public static synchronized FractionOperation  getFractionOperation(final Operator operator) {
		if(instances.containsKey(operator)) {
			return instances.get(operator);
		}
		FractionOperation fractionOperation=null;
		switch(operator) {
			case MULTIPLY:
				fractionOperation= new MultiplyFractionOperation();
				break;
			case ADD:
				fractionOperation=new AddFractionOperation();
				break;
			case DIVIDE:
				fractionOperation= new DivideFractionOperation();
				break;
			case SUBSTRACT:
				fractionOperation= new SubstractFractionOperation();
				break;
			default:
				throw new FractionException("Not supported operation ".concat(operator.name()));
		}
		instances.put(operator, fractionOperation);
		return fractionOperation;
	}

}
