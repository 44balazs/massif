/**
 */
package hu.bme.mit.transima.Simulink;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Goto</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The Goto block passes its input to its corresponding #{simulink.From} blocks.
 *  From and #{simulink.Goto} blocks allow you to pass a signal from one block to another without actually connecting them.
 * 
 * See @{http://www.mathworks.com/help/simulink/slref/goto.html}
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.transima.Simulink.Goto#getFromBlocks <em>From Blocks</em>}</li>
 *   <li>{@link hu.bme.mit.transima.Simulink.Goto#getTagVisibility <em>Tag Visibility</em>}</li>
 *   <li>{@link hu.bme.mit.transima.Simulink.Goto#getGotoTag <em>Goto Tag</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getGoto()
 * @model
 * @generated
 */
public interface Goto extends VirtualBlock {
    /**
	 * Returns the value of the '<em><b>From Blocks</b></em>' reference list.
	 * The list contents are of type {@link hu.bme.mit.transima.Simulink.From}.
	 * It is bidirectional and its opposite is '{@link hu.bme.mit.transima.Simulink.From#getGotoBlock <em>Goto Block</em>}'.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>From Blocks</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>From Blocks</em>' reference list.
	 * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getGoto_FromBlocks()
	 * @see hu.bme.mit.transima.Simulink.From#getGotoBlock
	 * @model opposite="gotoBlock"
	 * @generated
	 */
    EList<From> getFromBlocks();

    /**
	 * Returns the value of the '<em><b>Tag Visibility</b></em>' attribute.
	 * The literals are from the enumeration {@link hu.bme.mit.transima.Simulink.TagVisibility}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Tag Visibility</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Tag Visibility</em>' attribute.
	 * @see hu.bme.mit.transima.Simulink.TagVisibility
	 * @see #setTagVisibility(TagVisibility)
	 * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getGoto_TagVisibility()
	 * @model
	 * @generated
	 */
    TagVisibility getTagVisibility();

    /**
	 * Sets the value of the '{@link hu.bme.mit.transima.Simulink.Goto#getTagVisibility <em>Tag Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tag Visibility</em>' attribute.
	 * @see hu.bme.mit.transima.Simulink.TagVisibility
	 * @see #getTagVisibility()
	 * @generated
	 */
    void setTagVisibility(TagVisibility value);

    /**
	 * Returns the value of the '<em><b>Goto Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Goto Tag</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Goto Tag</em>' attribute.
	 * @see #setGotoTag(String)
	 * @see hu.bme.mit.transima.Simulink.SimulinkPackage#getGoto_GotoTag()
	 * @model
	 * @generated
	 */
    String getGotoTag();

    /**
	 * Sets the value of the '{@link hu.bme.mit.transima.Simulink.Goto#getGotoTag <em>Goto Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Goto Tag</em>' attribute.
	 * @see #getGotoTag()
	 * @generated
	 */
    void setGotoTag(String value);

} // Goto
