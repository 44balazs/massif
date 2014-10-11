/**
 */
package hu.bme.mit.transima.Simulink.impl;

import hu.bme.mit.transima.Simulink.Enable;
import hu.bme.mit.transima.Simulink.EnableStates;
import hu.bme.mit.transima.Simulink.SimulinkPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.transima.Simulink.impl.EnableImpl#getStatesWhenEnabling <em>States When Enabling</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnableImpl extends InPortImpl implements Enable {
    /**
	 * The default value of the '{@link #getStatesWhenEnabling() <em>States When Enabling</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getStatesWhenEnabling()
	 * @generated
	 * @ordered
	 */
    protected static final EnableStates STATES_WHEN_ENABLING_EDEFAULT = EnableStates.HELD;

    /**
	 * The cached value of the '{@link #getStatesWhenEnabling() <em>States When Enabling</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getStatesWhenEnabling()
	 * @generated
	 * @ordered
	 */
    protected EnableStates statesWhenEnabling = STATES_WHEN_ENABLING_EDEFAULT;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected EnableImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return SimulinkPackage.Literals.ENABLE;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EnableStates getStatesWhenEnabling() {
		return statesWhenEnabling;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setStatesWhenEnabling(EnableStates newStatesWhenEnabling) {
		EnableStates oldStatesWhenEnabling = statesWhenEnabling;
		statesWhenEnabling = newStatesWhenEnabling == null ? STATES_WHEN_ENABLING_EDEFAULT : newStatesWhenEnabling;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulinkPackage.ENABLE__STATES_WHEN_ENABLING, oldStatesWhenEnabling, statesWhenEnabling));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SimulinkPackage.ENABLE__STATES_WHEN_ENABLING:
				return getStatesWhenEnabling();
		}
		return super.eGet(featureID, resolve, coreType);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SimulinkPackage.ENABLE__STATES_WHEN_ENABLING:
				setStatesWhenEnabling((EnableStates)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public void eUnset(int featureID) {
		switch (featureID) {
			case SimulinkPackage.ENABLE__STATES_WHEN_ENABLING:
				setStatesWhenEnabling(STATES_WHEN_ENABLING_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SimulinkPackage.ENABLE__STATES_WHEN_ENABLING:
				return statesWhenEnabling != STATES_WHEN_ENABLING_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (statesWhenEnabling: ");
		result.append(statesWhenEnabling);
		result.append(')');
		return result.toString();
	}

} //EnableImpl
