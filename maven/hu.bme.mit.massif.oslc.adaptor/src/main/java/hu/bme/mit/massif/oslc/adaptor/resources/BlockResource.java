/*******************************************************************************
 * Copyright (c) 2012 IBM Corporation and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompanies this distribution.
 *
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *
 *     Russell Boykin       - initial API and implementation
 *     Alberto Giammaria    - initial API and implementation
 *     Chris Peters         - initial API and implementation
 *     Gianluca Bernardini  - initial API and implementation
 *	   Sam Padgett	       - initial API and implementation
 *     Michael Fiedler     - adapted for OSLC4J
 *     Jad El-khoury        - initial implementation of code generator (https://bugs.eclipse.org/bugs/show_bug.cgi?id=422448)
 *
 * This file is generated by org.eclipse.lyo.oslc4j.codegenerator
 *******************************************************************************/

package hu.bme.mit.massif.oslc.adaptor.resources;

import hu.bme.mit.massif.oslc.adaptor.SimulinkAdaptorConstants;
import hu.bme.mit.massif.oslc.adaptor.servlet.ServletListener;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.UriBuilder;

import org.eclipse.lyo.oslc4j.core.annotation.OslcDescription;
import org.eclipse.lyo.oslc4j.core.annotation.OslcName;
import org.eclipse.lyo.oslc4j.core.annotation.OslcNamespace;
import org.eclipse.lyo.oslc4j.core.annotation.OslcOccurs;
import org.eclipse.lyo.oslc4j.core.annotation.OslcPropertyDefinition;
import org.eclipse.lyo.oslc4j.core.annotation.OslcRange;
import org.eclipse.lyo.oslc4j.core.annotation.OslcReadOnly;
import org.eclipse.lyo.oslc4j.core.annotation.OslcResourceShape;
import org.eclipse.lyo.oslc4j.core.annotation.OslcTitle;
import org.eclipse.lyo.oslc4j.core.annotation.OslcValueType;
import org.eclipse.lyo.oslc4j.core.model.Link;
import org.eclipse.lyo.oslc4j.core.model.Occurs;
import org.eclipse.lyo.oslc4j.core.model.ValueType;

// Start of user code imports
// End of user code

@OslcNamespace(SimulinkAdaptorConstants.SIMULINK_NAMSPACE)
@OslcName(SimulinkAdaptorConstants.BLOCKRESOURCE)
@OslcResourceShape(title = "BlockResource Resource Shape", describes = SimulinkAdaptorConstants.TYPE_BLOCKRESOURCE)
public class BlockResource extends SimulinkElementResource

{

    private HashSet<String> propertys   = new HashSet<String>();
    private HashSet<Link>   portss      = new HashSet<Link>();
    private Link            trigger     = new Link();
    private Link            enabler     = new Link();
    private HashSet<Link>   inportss    = new HashSet<Link>();
    private HashSet<Link>   outportss   = new HashSet<Link>();
    private Link            parent      = new Link();
    private Link            sourceBlock = new Link();

    public BlockResource() throws URISyntaxException {
        super();

        // Start of user code constructor1
        // End of user code
    }

    public BlockResource(final URI about) throws URISyntaxException {
        super(about);

        // Start of user code constructor2
        // End of user code
    }

    public static URI constructURI(final String serviceProviderId, final String blockRes) {
        String basePath = ServletListener.getServicesBase();
        Map<String, Object> pathParameters = new HashMap<String, Object>();
        pathParameters.put("serviceProviderId", serviceProviderId);

        pathParameters.put("blockRes", blockRes);
        String instanceURI = "/simu/{serviceProviderId}/blockResources/{blockRes}";

        final UriBuilder builder = UriBuilder.fromUri(basePath);
        return builder.path(instanceURI).buildFromMap(pathParameters);
    }

    public String toString() {
        String result = "";
        // Start of user code toString_init
        // End of user code

        result = getAbout().toString();

        // Start of user code toString_finalize
        // End of user code

        return result;
    }

    public String toHtml() {
        String result = "";
        // Start of user code toHtml_init
        // End of user code

        result = "<a href=\"" + getAbout() + "\">" + toString() + "</a>";

        // Start of user code toHtml_finalize
        // End of user code

        return result;
    }

    public void addProperty(final String property) {
        this.propertys.add(property);
    }

    public void addPorts(final Link ports) {
        this.portss.add(ports);
    }

    public void addInports(final Link inports) {
        this.inportss.add(inports);
    }

    public void addOutports(final Link outports) {
        this.outportss.add(outports);
    }

    @OslcName("property")
    @OslcPropertyDefinition(SimulinkAdaptorConstants.SIMULINK_NAMSPACE + "property")
    @OslcDescription("")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.String)
    @OslcReadOnly(false)
    @OslcTitle("property")
    public HashSet<String> getPropertys() {
        return propertys;
    }

    @OslcName("ports")
    @OslcPropertyDefinition(SimulinkAdaptorConstants.SIMULINK_NAMSPACE + "ports")
    @OslcDescription("")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcRange(SimulinkAdaptorConstants.TYPE_PORTRESOURCE)
    @OslcReadOnly(false)
    @OslcTitle("ports")
    public HashSet<Link> getPortss() {
        return portss;
    }

    @OslcName("trigger")
    @OslcPropertyDefinition(SimulinkAdaptorConstants.SIMULINK_NAMSPACE + "trigger")
    @OslcDescription("The values are computed by filtering Trigger ports from the values of the ports feature.")
    @OslcOccurs(Occurs.ZeroOrOne)
    @OslcValueType(ValueType.Resource)
    @OslcRange(SimulinkAdaptorConstants.TYPE_TRIGGERRESOURCE)
    @OslcReadOnly(false)
    @OslcTitle("trigger")
    public Link getTrigger() {
        return trigger;
    }

    @OslcName("enabler")
    @OslcPropertyDefinition(SimulinkAdaptorConstants.SIMULINK_NAMSPACE + "enabler")
    @OslcDescription("The values are computed by filtering Enable ports from the values of the ports feature.")
    @OslcOccurs(Occurs.ZeroOrOne)
    @OslcValueType(ValueType.Resource)
    @OslcRange(SimulinkAdaptorConstants.TYPE_ENABLERESOURCE)
    @OslcReadOnly(false)
    @OslcTitle("enabler")
    public Link getEnabler() {
        return enabler;
    }

    @OslcName("inports")
    @OslcPropertyDefinition(SimulinkAdaptorConstants.SIMULINK_NAMSPACE + "inports")
    @OslcDescription("The values are computed by filtering Inports from the values of the ports feature.")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcRange(SimulinkAdaptorConstants.TYPE_INPORTRESOURCE)
    @OslcReadOnly(false)
    @OslcTitle("inports")
    public HashSet<Link> getInportss() {
        return inportss;
    }

    @OslcName("outports")
    @OslcPropertyDefinition(SimulinkAdaptorConstants.SIMULINK_NAMSPACE + "outports")
    @OslcDescription("The values are computed by filtering Outports from the values of the ports feature.")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcRange(SimulinkAdaptorConstants.TYPE_OUTPORTRESOURCE)
    @OslcReadOnly(false)
    @OslcTitle("outports")
    public HashSet<Link> getOutportss() {
        return outportss;
    }

    @OslcName("parent")
    @OslcPropertyDefinition(SimulinkAdaptorConstants.SIMULINK_NAMSPACE + "parent")
    @OslcDescription("")
    @OslcOccurs(Occurs.ZeroOrOne)
    @OslcValueType(ValueType.Resource)
    @OslcRange(SimulinkAdaptorConstants.TYPE_SUBSYSTEMRESOURCE)
    @OslcReadOnly(false)
    @OslcTitle("parent")
    public Link getParent() {
        return parent;
    }

    @OslcName("sourceBlock")
    @OslcPropertyDefinition(SimulinkAdaptorConstants.SIMULINK_NAMSPACE + "sourceBlock")
    @OslcDescription("")
    @OslcOccurs(Occurs.ZeroOrOne)
    @OslcValueType(ValueType.Resource)
    @OslcRange(SimulinkAdaptorConstants.TYPE_BLOCKRESOURCE)
    @OslcReadOnly(false)
    @OslcTitle("sourceBlock")
    public Link getSourceBlock() {
        return sourceBlock;
    }

    public void setPropertys(final HashSet<String> property) {
        this.propertys.clear();
        if (property != null) {
            this.propertys.addAll(property);
        }

    }

    public void setPortss(final HashSet<Link> ports) {
        this.portss.clear();
        if (ports != null) {
            this.portss.addAll(ports);
        }

    }

    public void setTrigger(final Link trigger) {
        this.trigger = trigger;
    }

    public void setEnabler(final Link enabler) {
        this.enabler = enabler;
    }

    public void setInportss(final HashSet<Link> inports) {
        this.inportss.clear();
        if (inports != null) {
            this.inportss.addAll(inports);
        }

    }

    public void setOutportss(final HashSet<Link> outports) {
        this.outportss.clear();
        if (outports != null) {
            this.outportss.addAll(outports);
        }

    }

    public void setParent(final Link parent) {
        this.parent = parent;
    }

    public void setSourceBlock(final Link sourceBlock) {
        this.sourceBlock = sourceBlock;
    }

    static public String propertysToHtmlForCreation(final HttpServletRequest httpServletRequest,
            final String serviceProviderId) {
        String s = "";

        // Start of user code propertysasHtmlForCreation_init
        // End of user code

        s = s + "<label for=\"property\">property: </LABEL>";

        // Start of user code propertysasHtmlForCreation_mid
        // End of user code

        s = s + "<input name=\"property\" type=\"text\" style=\"width: 400px\" id=\"property\" >";

        // Start of user code propertysasHtmlForCreation_finalize
        // End of user code

        return s;
    }

    static public String portssToHtmlForCreation(final HttpServletRequest httpServletRequest,
            final String serviceProviderId) {
        String s = "";

        // Start of user code portssasHtmlForCreation_init
        // End of user code

        s = s + "<label for=\"ports\">ports: </LABEL>";

        // Start of user code portssasHtmlForCreation_mid
        // End of user code

        // Start of user code portssasHtmlForCreation_finalize
        // End of user code

        return s;
    }

    static public String triggerToHtmlForCreation(final HttpServletRequest httpServletRequest,
            final String serviceProviderId) {
        String s = "";

        // Start of user code triggerasHtmlForCreation_init
        // End of user code

        s = s + "<label for=\"trigger\">trigger: </LABEL>";

        // Start of user code triggerasHtmlForCreation_mid
        // End of user code

        // Start of user code triggerasHtmlForCreation_finalize
        // End of user code

        return s;
    }

    static public String enablerToHtmlForCreation(final HttpServletRequest httpServletRequest,
            final String serviceProviderId) {
        String s = "";

        // Start of user code enablerasHtmlForCreation_init
        // End of user code

        s = s + "<label for=\"enabler\">enabler: </LABEL>";

        // Start of user code enablerasHtmlForCreation_mid
        // End of user code

        // Start of user code enablerasHtmlForCreation_finalize
        // End of user code

        return s;
    }

    static public String inportssToHtmlForCreation(final HttpServletRequest httpServletRequest,
            final String serviceProviderId) {
        String s = "";

        // Start of user code inportssasHtmlForCreation_init
        // End of user code

        s = s + "<label for=\"inports\">inports: </LABEL>";

        // Start of user code inportssasHtmlForCreation_mid
        // End of user code

        // Start of user code inportssasHtmlForCreation_finalize
        // End of user code

        return s;
    }

    static public String outportssToHtmlForCreation(final HttpServletRequest httpServletRequest,
            final String serviceProviderId) {
        String s = "";

        // Start of user code outportssasHtmlForCreation_init
        // End of user code

        s = s + "<label for=\"outports\">outports: </LABEL>";

        // Start of user code outportssasHtmlForCreation_mid
        // End of user code

        // Start of user code outportssasHtmlForCreation_finalize
        // End of user code

        return s;
    }

    static public String parentToHtmlForCreation(final HttpServletRequest httpServletRequest,
            final String serviceProviderId) {
        String s = "";

        // Start of user code parentasHtmlForCreation_init
        // End of user code

        s = s + "<label for=\"parent\">parent: </LABEL>";

        // Start of user code parentasHtmlForCreation_mid
        // End of user code

        // Start of user code parentasHtmlForCreation_finalize
        // End of user code

        return s;
    }

    static public String sourceBlockToHtmlForCreation(final HttpServletRequest httpServletRequest,
            final String serviceProviderId) {
        String s = "";

        // Start of user code sourceBlockasHtmlForCreation_init
        // End of user code

        s = s + "<label for=\"sourceBlock\">sourceBlock: </LABEL>";

        // Start of user code sourceBlockasHtmlForCreation_mid
        // End of user code

        // Start of user code sourceBlockasHtmlForCreation_finalize
        // End of user code

        return s;
    }

    public String propertysToHtml() {
        String s = "";

        // Start of user code propertystoHtml_init
        // End of user code

        s = s + "<label for=\"property\"><strong>property</strong>: </LABEL>";

        // Start of user code propertystoHtml_mid
        // End of user code

        try {
            s = s + "<ul>";
            Iterator<String> itr = propertys.iterator();
            while (itr.hasNext()) {
                s = s + "<li>";
                s = s + itr.next().toString();
                s = s + "</li>";
            }
            s = s + "</ul>";
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Start of user code propertystoHtml_finalize
        // End of user code

        return s;
    }

    public String portssToHtml() {
        String s = "";

        // Start of user code portsstoHtml_init
        // End of user code

        s = s + "<label for=\"ports\"><strong>ports</strong>: </LABEL>";

        // Start of user code portsstoHtml_mid
        // End of user code

        try {
            s = s + "<ul>";
            Iterator<Link> itr = portss.iterator();
            while (itr.hasNext()) {
                s = s + "<li>";
                s = s + (new PortResource(itr.next().getValue())).toHtml();
                s = s + "</li>";
            }
            s = s + "</ul>";
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Start of user code portsstoHtml_finalize
        // End of user code

        return s;
    }

    public String triggerToHtml() {
        String s = "";

        // Start of user code triggertoHtml_init
        // End of user code

        s = s + "<label for=\"trigger\"><strong>trigger</strong>: </LABEL>";

        // Start of user code triggertoHtml_mid
        // End of user code

        try {
            s = s + (new TriggerResource(trigger.getValue())).toHtml();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Start of user code triggertoHtml_finalize
        // End of user code

        return s;
    }

    public String enablerToHtml() {
        String s = "";

        // Start of user code enablertoHtml_init
        // End of user code

        s = s + "<label for=\"enabler\"><strong>enabler</strong>: </LABEL>";

        // Start of user code enablertoHtml_mid
        // End of user code

        try {
            s = s + (new EnableResource(enabler.getValue())).toHtml();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Start of user code enablertoHtml_finalize
        // End of user code

        return s;
    }

    public String inportssToHtml() {
        String s = "";

        // Start of user code inportsstoHtml_init
        // End of user code

        s = s + "<label for=\"inports\"><strong>inports</strong>: </LABEL>";

        // Start of user code inportsstoHtml_mid
        // End of user code

        try {
            s = s + "<ul>";
            Iterator<Link> itr = inportss.iterator();
            while (itr.hasNext()) {
                s = s + "<li>";
                s = s + (new InPortResource(itr.next().getValue())).toHtml();
                s = s + "</li>";
            }
            s = s + "</ul>";
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Start of user code inportsstoHtml_finalize
        // End of user code

        return s;
    }

    public String outportssToHtml() {
        String s = "";

        // Start of user code outportsstoHtml_init
        // End of user code

        s = s + "<label for=\"outports\"><strong>outports</strong>: </LABEL>";

        // Start of user code outportsstoHtml_mid
        // End of user code

        try {
            s = s + "<ul>";
            Iterator<Link> itr = outportss.iterator();
            while (itr.hasNext()) {
                s = s + "<li>";
                s = s + (new OutPortResource(itr.next().getValue())).toHtml();
                s = s + "</li>";
            }
            s = s + "</ul>";
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Start of user code outportsstoHtml_finalize
        // End of user code

        return s;
    }

    public String parentToHtml() {
        String s = "";

        // Start of user code parenttoHtml_init
        // End of user code

        s = s + "<label for=\"parent\"><strong>parent</strong>: </LABEL>";

        // Start of user code parenttoHtml_mid
        // End of user code

        try {
            s = s + (new SubSystemResource(parent.getValue())).toHtml();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Start of user code parenttoHtml_finalize
        // End of user code

        return s;
    }

    public String sourceBlockToHtml() {
        String s = "";

        // Start of user code sourceBlocktoHtml_init
        // End of user code

        s = s + "<label for=\"sourceBlock\"><strong>sourceBlock</strong>: </LABEL>";

        // Start of user code sourceBlocktoHtml_mid
        // End of user code

        try {
            s = s + (new BlockResource(sourceBlock.getValue())).toHtml();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Start of user code sourceBlocktoHtml_finalize
        // End of user code

        return s;
    }

}
