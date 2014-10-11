/**
 */
package hu.bme.mit.transima.Simulink.impl;

import hu.bme.mit.transima.Simulink.IdentifierReference;
import hu.bme.mit.transima.Simulink.ModelReference;
import hu.bme.mit.transima.Simulink.SimulinkModel;
import hu.bme.mit.transima.Simulink.SimulinkPackage;
import hu.bme.mit.transima.Simulink.SimulinkReference;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.incquery.querybasedfeatures.runtime.IQueryBasedFeatureHandler;
import org.eclipse.incquery.querybasedfeatures.runtime.QueryBasedFeatureKind;
import org.eclipse.incquery.querybasedfeatures.runtime.QueryBasedFeatureHelper;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.transima.Simulink.impl.ModelReferenceImpl#getReferencedModel <em>Referenced Model</em>}</li>
 *   <li>{@link hu.bme.mit.transima.Simulink.impl.ModelReferenceImpl#getModelRef <em>Model Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelReferenceImpl extends BlockImpl implements ModelReference {
    /**
	 * The cached setting delegate for the '{@link #getReferencedModel() <em>Referenced Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedModel()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate REFERENCED_MODEL__ESETTING_DELEGATE = ((EStructuralFeature.Internal)SimulinkPackage.Literals.MODEL_REFERENCE__REFERENCED_MODEL).getSettingDelegate();
				/**
	 * The cached value of the '{@link #getModelRef() <em>Model Ref</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getModelRef()
	 * @generated
	 * @ordered
	 */
    protected IdentifierReference modelRef;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected ModelReferenceImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return SimulinkPackage.Literals.MODEL_REFERENCE;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public SimulinkModel getReferencedModel() {
		return (SimulinkModel)REFERENCED_MODEL__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public SimulinkModel basicGetReferencedModelGen() {
		return (SimulinkModel)REFERENCED_MODEL__ESETTING_DELEGATE.dynamicGet(this, null, 0, false, false);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public IdentifierReference getModelRef() {
		return modelRef;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetModelRef(IdentifierReference newModelRef, NotificationChain msgs) {
		IdentifierReference oldModelRef = modelRef;
		modelRef = newModelRef;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SimulinkPackage.MODEL_REFERENCE__MODEL_REF, oldModelRef, newModelRef);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setModelRef(IdentifierReference newModelRef) {
		if (newModelRef != modelRef) {
			NotificationChain msgs = null;
			if (modelRef != null)
				msgs = ((InternalEObject)modelRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SimulinkPackage.MODEL_REFERENCE__MODEL_REF, null, msgs);
			if (newModelRef != null)
				msgs = ((InternalEObject)newModelRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SimulinkPackage.MODEL_REFERENCE__MODEL_REF, null, msgs);
			msgs = basicSetModelRef(newModelRef, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulinkPackage.MODEL_REFERENCE__MODEL_REF, newModelRef, newModelRef));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SimulinkPackage.MODEL_REFERENCE__MODEL_REF:
				return basicSetModelRef(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SimulinkPackage.MODEL_REFERENCE__REFERENCED_MODEL:
				if (resolve) return getReferencedModel();
				return basicGetReferencedModel();
			case SimulinkPackage.MODEL_REFERENCE__MODEL_REF:
				return getModelRef();
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
			case SimulinkPackage.MODEL_REFERENCE__MODEL_REF:
				setModelRef((IdentifierReference)newValue);
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
			case SimulinkPackage.MODEL_REFERENCE__MODEL_REF:
				setModelRef((IdentifierReference)null);
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
			case SimulinkPackage.MODEL_REFERENCE__REFERENCED_MODEL:
				return REFERENCED_MODEL__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case SimulinkPackage.MODEL_REFERENCE__MODEL_REF:
				return modelRef != null;
		}
		return super.eIsSet(featureID);
	}

    /**
     * EMF-IncQuery handler for query-based feature referencedModel
     */
    private IQueryBasedFeatureHandler referencedModelHandler;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @query-based getter created by EMF-IncQuery for query-based feature referencedModel
     */
    public SimulinkModel basicGetReferencedModel() {
        if (referencedModelHandler == null) {
            referencedModelHandler = QueryBasedFeatureHelper.getQueryBasedFeatureHandler(this,
                SimulinkPackageImpl.Literals.MODEL_REFERENCE__REFERENCED_MODEL,
                "hu.bme.mit.transima.models.simulink.derived.referencedModel", "This", "Target",
                QueryBasedFeatureKind.SINGLE_REFERENCE, true, false);
        }
        return (hu.bme.mit.transima.Simulink.SimulinkModel) referencedModelHandler.getSingleReferenceValue(this);
    }

} //ModelReferenceImpl
