package hu.bme.mit.transima.models.simulink.util.util;

import com.google.common.collect.Sets;
import hu.bme.mit.transima.models.simulink.util.MultiConnectionMatch;
import hu.bme.mit.transima.models.simulink.util.MultiConnectionMatcher;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;

/**
 * A pattern-specific query specification that can instantiate MultiConnectionMatcher in a type-safe way.
 * 
 * @see MultiConnectionMatcher
 * @see MultiConnectionMatch
 * 
 */
@SuppressWarnings("all")
public final class MultiConnectionQuerySpecification extends BaseGeneratedQuerySpecification<MultiConnectionMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static MultiConnectionQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected MultiConnectionMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return MultiConnectionMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.bme.mit.transima.models.simulink.util.multiConnection";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("outP","inP","pc");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("outP", "hu.bme.mit.transima.Simulink.OutPort"),new PParameter("inP", "hu.bme.mit.transima.Simulink.InPort"),new PParameter("pc", "hu.bme.mit.transima.Simulink.SingleConnection"));
  }
  
  @Override
  public MultiConnectionMatch newEmptyMatch() {
    return MultiConnectionMatch.newEmptyMatch();
  }
  
  @Override
  public MultiConnectionMatch newMatch(final Object... parameters) {
    return MultiConnectionMatch.newMatch((hu.bme.mit.transima.Simulink.OutPort) parameters[0], (hu.bme.mit.transima.Simulink.InPort) parameters[1], (hu.bme.mit.transima.Simulink.SingleConnection) parameters[2]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_outP = body.getOrCreateVariableByName("outP");
      PVariable var_inP = body.getOrCreateVariableByName("inP");
      PVariable var_pc = body.getOrCreateVariableByName("pc");
      PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_outP, "outP"), 
        new ExportedParameter(body, var_inP, "inP"), 
        new ExportedParameter(body, var_pc, "pc")
      ));
      
      
      
      new TypeBinary(body, CONTEXT, var_inP, var_pc, getFeatureLiteral("http://hu.bme.mit.transima/simulink/1.0", "InPort", "connection"), "http://hu.bme.mit.transima/simulink/1.0/InPort.connection");
      new TypeBinary(body, CONTEXT, var_pc, var__virtual_1_, getFeatureLiteral("http://hu.bme.mit.transima/simulink/1.0", "SingleConnection", "parent"), "http://hu.bme.mit.transima/simulink/1.0/SingleConnection.parent");
      new TypeBinary(body, CONTEXT, var__virtual_1_, var_outP, getFeatureLiteral("http://hu.bme.mit.transima/simulink/1.0", "Connection", "from"), "http://hu.bme.mit.transima/simulink/1.0/Connection.from");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static MultiConnectionQuerySpecification INSTANCE = make();
    
    public static MultiConnectionQuerySpecification make() {
      return new MultiConnectionQuerySpecification();					
      
    }
  }
}
