/**
 */
package hu.bme.mit.transima.Simulink.impl;

import hu.bme.mit.transima.Simulink.SimulinkPackage;
import hu.bme.mit.transima.Simulink.VirtualBlock;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Virtual Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class VirtualBlockImpl extends BlockImpl implements VirtualBlock {
    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected VirtualBlockImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return SimulinkPackage.Literals.VIRTUAL_BLOCK;
	}

} //VirtualBlockImpl
