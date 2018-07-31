/*******************************************************************************
 * Copyright (c) 2010-2018, IncQuery Labs Ltd., logi.cals GmbH, McGill University 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Marton Bur - initial API and implementation 
 *******************************************************************************/
package hu.bme.mit.massif.communication.matlabengine;

import java.util.Map;

import com.mathworks.engine.EngineException;

import hu.bme.mit.massif.communication.ConnectorCreationException;
import hu.bme.mit.massif.communication.ICommandEvaluator;
import hu.bme.mit.massif.communication.ICommandEvaluatorFactory;

/**
 * @author Marton Bur
 */
public class MatlabEngineEvaluatorFactory implements ICommandEvaluatorFactory {

	@Override
	public ICommandEvaluator createCommandEvaluator(Map<String, Object> parameters) throws ConnectorCreationException {
		ICommandEvaluator evaluator;
		try {
			evaluator = new MatlabEngineEvaluator();
		} catch (EngineException | InterruptedException e) {
			throw new ConnectorCreationException("Failed to create " + getConnectorName(), e);
		}
		return evaluator;
	}

	@Override
	public String getConnectorName() {
		return "MatlabEngine";
	}

}