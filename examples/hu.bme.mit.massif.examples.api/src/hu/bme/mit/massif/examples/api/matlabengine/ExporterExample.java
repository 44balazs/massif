/*******************************************************************************
 * Copyright (c) 2010-2013, Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Marton Bur, Abel Hegedus, Akos Horvath - initial API and implementation 
 *     Krisztian Gabor Mayer - additional features     
 *******************************************************************************/
package hu.bme.mit.massif.examples.api.matlabengine;

import hu.bme.mit.massif.communication.ICommandEvaluator;
import hu.bme.mit.massif.communication.command.MatlabCommandFactory;
import hu.bme.mit.massif.communication.matlabcontrol.MatlabControlEvaluator;
import hu.bme.mit.massif.communication.matlabengine.MatlabEngineEvaluator;
import hu.bme.mit.massif.simulink.SimulinkModel;
import hu.bme.mit.massif.simulink.api.Exporter;
import hu.bme.mit.massif.simulink.api.exception.SimulinkApiException;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.mathworks.engine.EngineException;

import br.com.embraer.massif.commandevaluation.exception.MatlabRMIException;

/**
 * This class demonstrates how to use the Simulink Importer from code via a
 * basic example.
 * 
 * Run it as a JUnit plug-in test.
 * 
 * @author Marton Bur
 *
 */
public class ExporterExample {

	private ICommandEvaluator commandEvaluator;

	@Before
	public void initializeCommandEvaluator() throws MatlabRMIException, EngineException, SimulinkApiException, InterruptedException {
	    commandEvaluator = new MatlabEngineEvaluator(MatlabEngineExampleSettings.PRINT_ISSUED_COMMANDS);
	}

	@Test
	public void exampleExport() throws SimulinkApiException, IOException {

		MatlabCommandFactory commandFactory = new MatlabCommandFactory(commandEvaluator);

		// EMF model to read and export
		String modelPath = MatlabEngineExampleSettings.EMF_MODEL_PATH;
		String modelName = MatlabEngineExampleSettings.EMF_MODEL_NAME;

		Exporter exporter = new Exporter();
		SimulinkModel loadedModel = exporter.loadSimulinkModel(modelPath + modelName);
		
		exporter.export(loadedModel, commandFactory);
		String fqn = loadedModel.getSimulinkRef().getFQN();
		exporter.saveSimulinkModel(fqn,"slx");
	}

}
