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
 *     Michael Fiedler     - initial API and implementation for Bugzilla adapter
 *     Jad El-khoury        - initial implementation of code generator (https://bugs.eclipse.org/bugs/show_bug.cgi?id=422448)
 *
 * This file is generated by org.eclipse.lyo.oslc4j.codegenerator
 *******************************************************************************/
package hu.bme.mit.massif.oslc.adaptor.services;

import hu.bme.mit.massif.oslc.adaptor.SimulinkAdaptorConstants;
import hu.bme.mit.massif.oslc.adaptor.SimulinkAdaptorManager;
import hu.bme.mit.massif.oslc.adaptor.resources.GotoResource;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.eclipse.lyo.oslc4j.core.annotation.OslcCreationFactory;
import org.eclipse.lyo.oslc4j.core.annotation.OslcDialogs;
import org.eclipse.lyo.oslc4j.core.annotation.OslcService;
import org.eclipse.lyo.oslc4j.core.model.Link;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.eclipse.lyo.oslc4j.core.model.OslcMediaType;

// Start of user code imports
// End of user code
@OslcService(SimulinkAdaptorConstants.SIMULINK_DOMAIN)
@Path("/simu/{serviceProviderId}/gotoResources")
public class GotoResourceService {
    @Context
    private HttpServletRequest  httpServletRequest;
    @Context
    private HttpServletResponse httpServletResponse;
    @Context
    private UriInfo             uriInfo;

    public GotoResourceService() {
        super();
    }

    /**
     * RDF/XML, XML and JSON representation of a change request collection
     * <p>
     * TODO: add query support
     *
     * @param productId
     * @param where
     * @param pageString
     * @return
     * @throws IOException
     * @throws ServletException
     */

    @OslcDialogs({})
    @GET
    @Produces({ OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON })
    public GotoResource[] getGotoResources(@PathParam("serviceProviderId") final String serviceProviderId,
            @QueryParam("oslc.where") final String where, @QueryParam("page") final String pageString)
            throws IOException, ServletException {
        int page = 0;
        int limit = 999;

        // Start of user code (MUST_FILL_IN) getResourceCollection_init
        // End of user code

        final List<GotoResource> resources = SimulinkAdaptorManager.getGotoResources(httpServletRequest,
                serviceProviderId, page, limit);
        return resources.toArray(new GotoResource[resources.size()]);

    }

    /**
     * HTML representation of change request collection
     * <p>
     * Forwards to changerequest_collection_html.jsp to build the html page
     *
     * @param productId
     * @param changeRequestId
     * @param pageString
     * @return
     * @throws ServletException
     * @throws IOException
     */

    @GET
    @Produces({ MediaType.TEXT_HTML })
    public Response getGotoResourcesAsHtml(@PathParam("serviceProviderId") final String serviceProviderId,
            @QueryParam("page") final String pageString) throws ServletException, IOException {
        int page = 0;
        int limit = 20;

        if (null != pageString) {
            page = Integer.parseInt(pageString);
        }

        // Start of user code (MUST_FILL_IN) getResourceCollectionAsHTML_init
        // End of user code

        final List<GotoResource> resources = SimulinkAdaptorManager.getGotoResources(httpServletRequest,
                serviceProviderId, page, limit);

        if (resources != null) {
            httpServletRequest.setAttribute("resources", resources);
            // Start of user code (RECOMMENDED)
            // getResourceCollectionAsHTML_setAttributes
            // End of user code

            httpServletRequest.setAttribute("queryUri", uriInfo.getAbsolutePath().toString() + "?oslc.paging=true");
            if (resources.size() > limit) {
                resources.remove(resources.size() - 1);
                httpServletRequest.setAttribute("nextPageUri", uriInfo.getAbsolutePath().toString()
                        + "?oslc.paging=true&amp;page=" + (page + 1));
            }
            RequestDispatcher rd = httpServletRequest
                    .getRequestDispatcher("/hu/bme/mit/simulink/oslc/adaptor/gotoresourcecollection_html.jsp");

            rd.forward(httpServletRequest, httpServletResponse);
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }

    /**
     * RDF/XML, XML and JSON representation of a single change request
     *
     * @param productId
     * @param changeRequestId
     * @return
     * @throws IOException
     * @throws ServletException
     * @throws URISyntaxException
     */

    @GET
    @Path("{gotoRes}")
    @Produces({ OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON })
    public GotoResource getGotoResource(@PathParam("serviceProviderId") final String serviceProviderId,
            @PathParam("gotoRes") final String gotoRes) throws IOException, ServletException, URISyntaxException {
        // Start of user code (MUST_FILL_IN) getResource_init
        // End of user code

        final GotoResource aGotoResource = SimulinkAdaptorManager.getGotoResource(httpServletRequest,
                serviceProviderId, gotoRes);

        if (aGotoResource != null) {
            // Start of user code (RECOMMENDED) getResource_body
            // End of user code

            return aGotoResource;
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }

    /**
     * HTML representation for a single change request - redirect the request
     * directly to Bugzilla
     *
     * @param productId
     * @param changeRequestId
     * @throws ServletException
     * @throws IOException
     * @throws URISyntaxException
     */

    @GET
    @Path("{gotoRes}")
    @Produces({ MediaType.TEXT_HTML })
    public Response getGotoResourceAsHtml(@PathParam("serviceProviderId") final String serviceProviderId,
            @PathParam("gotoRes") final String gotoRes) throws ServletException, IOException, URISyntaxException {
        // Start of user code (MUST_FILL_IN) getResourceAsHTML_init
        // End of user code

        final GotoResource aGotoResource = SimulinkAdaptorManager.getGotoResource(httpServletRequest,
                serviceProviderId, gotoRes);

        if (aGotoResource != null) {
            httpServletRequest.setAttribute("aGotoResource", aGotoResource);
            // Start of user code getResourceAsHTML_setAttributes
            // End of user code

            RequestDispatcher rd = httpServletRequest
                    .getRequestDispatcher("/hu/bme/mit/simulink/oslc/adaptor/gotoresource_html.jsp");

            rd.forward(httpServletRequest, httpServletResponse);

        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }

    /**
     * OSLC delegated selection dialog for change requests
     * <p>
     * If called without a "terms" parameter, forwards to
     * changerequest_selector.jsp to build the html for the IFrame
     * <p>
     * If called with a "terms" parameter, sends a Bug search to Bugzilla and
     * then forwards to changerequest_filtered_json.jsp to build a JSON response
     *
     * @param terms
     * @param productId
     * @throws ServletException
     * @throws IOException
     */

    @GET
    @Consumes({ MediaType.TEXT_HTML, MediaType.WILDCARD })
    public void gotoResourceSelector(@QueryParam("terms") final String terms,
            @PathParam("serviceProviderId") final String serviceProviderId) throws ServletException, IOException {
        try {
            // Start of user code (MUST_FILL_IN) resourceSelector_init
            // End of user code

            httpServletRequest.setAttribute("selectionUri", uriInfo.getAbsolutePath().toString());
            // Start of user code (RECOMMENDED) resourceSelector_setAttributes
            // End of user code

            if (terms != null) {
                httpServletRequest.setAttribute("terms", terms);
                final List<GotoResource> resources = SimulinkAdaptorManager.searchGotoResources(httpServletRequest,
                        serviceProviderId, terms);
                if (resources != null) {
                    httpServletRequest.setAttribute("resources", resources);
                    RequestDispatcher rd = httpServletRequest
                            .getRequestDispatcher("/hu/bme/mit/simulink/oslc/adaptor/gotoresourcefilteredcollection_json.jsp");

                    rd.forward(httpServletRequest, httpServletResponse);
                }
                // a empty search should return an empty list and not NULL!
                throw new WebApplicationException(Status.NOT_FOUND);

            } else {
                try {
                    RequestDispatcher rd = httpServletRequest
                            .getRequestDispatcher("/hu/bme/mit/simulink/oslc/adaptor/gotoresourceselector_html.jsp");

                    rd.forward(httpServletRequest, httpServletResponse);

                } catch (Exception e) {
                    throw new ServletException(e);
                }
            }
        } catch (Exception e) {
            throw new WebApplicationException(e);
        }

    }

    /**
     * OSLC delegated creation dialog for a single change request
     * <p>
     * Forwards to changerequest_creator.jsp to build the html form
     *
     * @param productId
     * @throws IOException
     * @throws ServletException
     */

    @GET
    @Consumes({ MediaType.WILDCARD })
    public void gotoResourceCreatorAsHtml(@PathParam("serviceProviderId") final String serviceProviderId)
            throws IOException, ServletException {
        // Start of user code (MUST_FILL_IN) resourceCreatorAsHTML_init
        // End of user code

        httpServletRequest.setAttribute("serviceProviderId", serviceProviderId);

        RequestDispatcher rd = httpServletRequest
                .getRequestDispatcher("/hu/bme/mit/simulink/oslc/adaptor/gotoresourcecreator_html.jsp");

        rd.forward(httpServletRequest, httpServletResponse);
    }

    /**
     * Backend creator for the OSLC delegated creation dialog.
     * <p>
     * Accepts the input in FormParams and returns a small JSON response
     *
     * @param productId
     * @param component
     * @param version
     * @param summary
     * @param op_sys
     * @param platform
     * @param description
     */
    @POST
    @Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
    public void createGotoResourceFromHtml(@PathParam("serviceProviderId") final String serviceProviderId) {
        try {
            GotoResource aGotoResource = new GotoResource();

            String[] paramValues;

            paramValues = httpServletRequest.getParameterValues("sourceBlock");
            if (paramValues != null) {
                if (paramValues.length == 1) {
                    if (paramValues[0].length() != 0)
                        aGotoResource.setSourceBlock(new Link(new URI(paramValues[0])));
                    // else, there is an empty value for that parameter, and
                    // hence ignore since the parameter is not actually set.
                }

            }
            paramValues = httpServletRequest.getParameterValues("fromBlocks");
            if (paramValues != null) {
                for (int i = 0; i < paramValues.length; i++) {
                    aGotoResource.addFromBlocks(new Link(new URI(paramValues[i])));
                }
            }
            paramValues = httpServletRequest.getParameterValues("trigger");
            if (paramValues != null) {
                if (paramValues.length == 1) {
                    if (paramValues[0].length() != 0)
                        aGotoResource.setTrigger(new Link(new URI(paramValues[0])));
                    // else, there is an empty value for that parameter, and
                    // hence ignore since the parameter is not actually set.
                }

            }
            paramValues = httpServletRequest.getParameterValues("ports");
            if (paramValues != null) {
                for (int i = 0; i < paramValues.length; i++) {
                    aGotoResource.addPorts(new Link(new URI(paramValues[i])));
                }
            }
            paramValues = httpServletRequest.getParameterValues("property");
            if (paramValues != null) {
                for (int i = 0; i < paramValues.length; i++) {
                    aGotoResource.addProperty(paramValues[i]);
                }
            }
            paramValues = httpServletRequest.getParameterValues("gotoTag");
            if (paramValues != null) {
                if (paramValues.length == 1) {
                    if (paramValues[0].length() != 0)
                        aGotoResource.setGotoTag(paramValues[0]);
                    // else, there is an empty value for that parameter, and
                    // hence ignore since the parameter is not actually set.
                }

            }
            paramValues = httpServletRequest.getParameterValues("inports");
            if (paramValues != null) {
                for (int i = 0; i < paramValues.length; i++) {
                    aGotoResource.addInports(new Link(new URI(paramValues[i])));
                }
            }
            paramValues = httpServletRequest.getParameterValues("enabler");
            if (paramValues != null) {
                if (paramValues.length == 1) {
                    if (paramValues[0].length() != 0)
                        aGotoResource.setEnabler(new Link(new URI(paramValues[0])));
                    // else, there is an empty value for that parameter, and
                    // hence ignore since the parameter is not actually set.
                }

            }
            paramValues = httpServletRequest.getParameterValues("tagVisibility");
            if (paramValues != null) {
                if (paramValues.length == 1) {
                    if (paramValues[0].length() != 0)
                        aGotoResource.setTagVisibility(paramValues[0]);
                    // else, there is an empty value for that parameter, and
                    // hence ignore since the parameter is not actually set.
                }

            }
            paramValues = httpServletRequest.getParameterValues("parent");
            if (paramValues != null) {
                if (paramValues.length == 1) {
                    if (paramValues[0].length() != 0)
                        aGotoResource.setParent(new Link(new URI(paramValues[0])));
                    // else, there is an empty value for that parameter, and
                    // hence ignore since the parameter is not actually set.
                }

            }
            paramValues = httpServletRequest.getParameterValues("name");
            if (paramValues != null) {
                if (paramValues.length == 1) {
                    if (paramValues[0].length() != 0)
                        aGotoResource.setName(paramValues[0]);
                    // else, there is an empty value for that parameter, and
                    // hence ignore since the parameter is not actually set.
                }

            }
            paramValues = httpServletRequest.getParameterValues("outports");
            if (paramValues != null) {
                for (int i = 0; i < paramValues.length; i++) {
                    aGotoResource.addOutports(new Link(new URI(paramValues[i])));
                }
            }
            paramValues = httpServletRequest.getParameterValues("simulinkRef");
            if (paramValues != null) {
                if (paramValues.length == 1) {
                    if (paramValues[0].length() != 0)
                        aGotoResource.setSimulinkRef(paramValues[0]);
                    // else, there is an empty value for that parameter, and
                    // hence ignore since the parameter is not actually set.
                }

            }

            final GotoResource newGotoResource = SimulinkAdaptorManager.createGotoResource(httpServletRequest,
                    aGotoResource, serviceProviderId);

            httpServletRequest.setAttribute("newResource", newGotoResource);
            httpServletRequest.setAttribute("newResourceUri", newGotoResource.getAbout().toString());

            // Send back to the form a small JSON response
            httpServletResponse.setContentType("application/json");
            httpServletResponse.setStatus(Status.CREATED.getStatusCode());
            httpServletResponse.addHeader("Location", newGotoResource.getAbout().toString());
            PrintWriter out = httpServletResponse.getWriter();
            out.print("{" + "\"resource\" : \"" + newGotoResource.getAbout().toString() + "\"}");
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(e);
        }

    }

    /**
     * Create a single BugzillaChangeRequest via RDF/XML, XML or JSON POST
     *
     * @param productId
     * @param changeRequest
     * @return
     * @throws IOException
     * @throws ServletException
     */

    @OslcDialogs({})
    @OslcCreationFactory(title = "DO_NOT_USE", label = "DO_NOT_USE", resourceShapes = { OslcConstants.PATH_RESOURCE_SHAPES
            + "/" + SimulinkAdaptorConstants.PATH_GOTORESOURCE }, resourceTypes = {
            SimulinkAdaptorConstants.TYPE_BLOCKRESOURCE, SimulinkAdaptorConstants.TYPE_PORTRESOURCE,
            SimulinkAdaptorConstants.TYPE_INPORTRESOURCE, SimulinkAdaptorConstants.TYPE_OUTPORTRESOURCE,
            SimulinkAdaptorConstants.TYPE_TRIGGERRESOURCE, SimulinkAdaptorConstants.TYPE_ENABLERESOURCE,
            SimulinkAdaptorConstants.TYPE_BUSSELECTORRESOURCE, SimulinkAdaptorConstants.TYPE_BUSCREATORRESOURCE,
            SimulinkAdaptorConstants.TYPE_GOTORESOURCE, SimulinkAdaptorConstants.TYPE_FROMRESOURCE,
            SimulinkAdaptorConstants.TYPE_SIMULINKMODELRESOURCE, SimulinkAdaptorConstants.TYPE_PORTBLOCKRESOURCE,
            SimulinkAdaptorConstants.TYPE_OUTPORTBLOCKRESOURCE, SimulinkAdaptorConstants.TYPE_INPORTBLOCKRESOURCE,
            SimulinkAdaptorConstants.TYPE_TRIGGERBLOCKRESOURCE, SimulinkAdaptorConstants.TYPE_ENABLEBLOCKRESOURCE,
            SimulinkAdaptorConstants.TYPE_SUBSYSTEMRESOURCE, SimulinkAdaptorConstants.TYPE_BUSSPECIFICATIONRESOURCE,
            SimulinkAdaptorConstants.TYPE_SIMULINKELEMENTRESOURCE }, usages = { OslcConstants.OSLC_USAGE_DEFAULT })
    @POST
    @Consumes({ OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON })
    @Produces({ OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON })
    public Response createGotoResource(@PathParam("serviceProviderId") final String serviceProviderId,
            final GotoResource aGotoResource) throws IOException, ServletException {
        try {
            GotoResource newGotoResource = SimulinkAdaptorManager.createGotoResource(httpServletRequest, aGotoResource,
                    serviceProviderId);
            httpServletResponse.setHeader("ETag", SimulinkAdaptorManager.getETagFromGotoResource(newGotoResource));
            return Response.created(newGotoResource.getAbout()).entity(aGotoResource).build();
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(e);
        }
    }

    // Start of user code (RECOMMENDED) functions
    // End of user code

}
