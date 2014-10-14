<%-- 
 Copyright (c) 2011, 2012 IBM Corporation and others.

 All rights reserved. This program and the accompanying materials
 are made available under the terms of the Eclipse Public License v1.0
 and Eclipse Distribution License v. 1.0 which accompanies this distribution.
 
 The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 and the Eclipse Distribution License is available at
 http://www.eclipse.org/org/documents/edl-v10.php.
 
 Contributors:
 
    Sam Padgett		 - initial API and implementation
    Michael Fiedler	 - adapted for OSLC4J
    Jad El-khoury        - initial implementation of code generator (https://bugs.eclipse.org/bugs/show_bug.cgi?id=422448)
 
 This file is generated by org.eclipse.lyo.oslc4j.codegenerator
--%>

        <%@ page import="hu.bme.mit.massif.oslc.adaptor.resources.EnableBlockResource" %>
        <%@ page import="java.util.List" %>
        <%--
        Start of user code imports
        --%>
        <%--
        End of user code
        --%>

        <%@ page contentType="application/json" language="java" pageEncoding="UTF-8" %>

{
    <%
        String selectionUri = (String) request.getAttribute("selectionUri");
        List<EnableBlockResource> resources = (List<EnableBlockResource>) request.getAttribute("resources");
        String terms = (String) request.getAttribute("terms");
    %>
    <%--
    Start of user code getRequestAttributes
    --%>
    <%--
    End of user code
    --%>
    results: [
        <% int i = 0; for (EnableBlockResource r : resources) { %>
        <% if (i > 0) { %>,
        <% } %>
        {
            "label": "<%= r.toString() %>",
            "resourceUrl": "<%= r.getAbout() %>"
        }
        <% i++; } %>
    ]
}
