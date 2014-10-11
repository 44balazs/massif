package hu.bme.mit.transima.models.simulink.util;

import hu.bme.mit.transima.Simulink.InPort;
import hu.bme.mit.transima.models.simulink.util.InPortToInPortConnectionMatch;
import hu.bme.mit.transima.models.simulink.util.util.InPortToInPortConnectionQuerySpecification;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.api.IQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.tuple.Tuple;
import org.eclipse.incquery.runtime.rete.misc.DeltaMonitor;
import org.eclipse.incquery.runtime.util.IncQueryLoggingUtil;

/**
 * Generated pattern matcher API of the hu.bme.mit.transima.models.simulink.util.inPortToInPortConnection pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link InPortToInPortConnectionMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern inPortToInPortConnection(sourceInPort, targetInPort) {
 * 	find simpleInPortToInPortConnection(sourceInPort, targetInPort, _pc);
 * } or {
 * 	find busSpecificationInPortToOutPort(sourceInPort, outPortOfBS);
 * 	find portConnection(outPortOfBS, targetInPort, _pc);
 * }
 * </pre></code>
 * 
 * @see InPortToInPortConnectionMatch
 * @see InPortToInPortConnectionProcessor
 * @see InPortToInPortConnectionQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class InPortToInPortConnectionMatcher extends BaseMatcher<InPortToInPortConnectionMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<InPortToInPortConnectionMatcher> querySpecification() throws IncQueryException {
    return InPortToInPortConnectionQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static InPortToInPortConnectionMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    InPortToInPortConnectionMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new InPortToInPortConnectionMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_SOURCEINPORT = 0;
  
  private final static int POSITION_TARGETINPORT = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(InPortToInPortConnectionMatcher.class);
  
  /**
   * Initializes the pattern matcher over a given EMF model root (recommended: Resource or ResourceSet).
   * If a pattern matcher is already constructed with the same root, only a light-weight reference is returned.
   * The scope of pattern matching will be the given EMF model root and below (see FAQ for more precise definition).
   * The match set will be incrementally refreshed upon updates from this scope.
   * <p>The matcher will be created within the managed {@link IncQueryEngine} belonging to the EMF model root, so
   * multiple matchers will reuse the same engine and benefit from increased performance and reduced memory footprint.
   * @param emfRoot the root of the EMF containment hierarchy where the pattern matcher will operate. Recommended: Resource or ResourceSet.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * @deprecated use {@link #on(IncQueryEngine)} instead, e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}
   * 
   */
  @Deprecated
  public InPortToInPortConnectionMatcher(final Notifier emfRoot) throws IncQueryException {
    this(IncQueryEngine.on(emfRoot));
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * @deprecated use {@link #on(IncQueryEngine)} instead
   * 
   */
  @Deprecated
  public InPortToInPortConnectionMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSourceInPort the fixed value of pattern parameter sourceInPort, or null if not bound.
   * @param pTargetInPort the fixed value of pattern parameter targetInPort, or null if not bound.
   * @return matches represented as a InPortToInPortConnectionMatch object.
   * 
   */
  public Collection<InPortToInPortConnectionMatch> getAllMatches(final InPort pSourceInPort, final InPort pTargetInPort) {
    return rawGetAllMatches(new Object[]{pSourceInPort, pTargetInPort});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSourceInPort the fixed value of pattern parameter sourceInPort, or null if not bound.
   * @param pTargetInPort the fixed value of pattern parameter targetInPort, or null if not bound.
   * @return a match represented as a InPortToInPortConnectionMatch object, or null if no match is found.
   * 
   */
  public InPortToInPortConnectionMatch getOneArbitraryMatch(final InPort pSourceInPort, final InPort pTargetInPort) {
    return rawGetOneArbitraryMatch(new Object[]{pSourceInPort, pTargetInPort});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pSourceInPort the fixed value of pattern parameter sourceInPort, or null if not bound.
   * @param pTargetInPort the fixed value of pattern parameter targetInPort, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final InPort pSourceInPort, final InPort pTargetInPort) {
    return rawHasMatch(new Object[]{pSourceInPort, pTargetInPort});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSourceInPort the fixed value of pattern parameter sourceInPort, or null if not bound.
   * @param pTargetInPort the fixed value of pattern parameter targetInPort, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final InPort pSourceInPort, final InPort pTargetInPort) {
    return rawCountMatches(new Object[]{pSourceInPort, pTargetInPort});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pSourceInPort the fixed value of pattern parameter sourceInPort, or null if not bound.
   * @param pTargetInPort the fixed value of pattern parameter targetInPort, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final InPort pSourceInPort, final InPort pTargetInPort, final IMatchProcessor<? super InPortToInPortConnectionMatch> processor) {
    rawForEachMatch(new Object[]{pSourceInPort, pTargetInPort}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSourceInPort the fixed value of pattern parameter sourceInPort, or null if not bound.
   * @param pTargetInPort the fixed value of pattern parameter targetInPort, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final InPort pSourceInPort, final InPort pTargetInPort, final IMatchProcessor<? super InPortToInPortConnectionMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pSourceInPort, pTargetInPort}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters.
   * It can also be reset to track changes from a later point in time,
   * and changes can even be acknowledged on an individual basis.
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pSourceInPort the fixed value of pattern parameter sourceInPort, or null if not bound.
   * @param pTargetInPort the fixed value of pattern parameter targetInPort, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<InPortToInPortConnectionMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final InPort pSourceInPort, final InPort pTargetInPort) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pSourceInPort, pTargetInPort});
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSourceInPort the fixed value of pattern parameter sourceInPort, or null if not bound.
   * @param pTargetInPort the fixed value of pattern parameter targetInPort, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public InPortToInPortConnectionMatch newMatch(final InPort pSourceInPort, final InPort pTargetInPort) {
    return InPortToInPortConnectionMatch.newMatch(pSourceInPort, pTargetInPort);
    
  }
  
  /**
   * Retrieve the set of values that occur in matches for sourceInPort.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<InPort> rawAccumulateAllValuesOfsourceInPort(final Object[] parameters) {
    Set<InPort> results = new HashSet<InPort>();
    rawAccumulateAllValues(POSITION_SOURCEINPORT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for sourceInPort.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InPort> getAllValuesOfsourceInPort() {
    return rawAccumulateAllValuesOfsourceInPort(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for sourceInPort.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InPort> getAllValuesOfsourceInPort(final InPortToInPortConnectionMatch partialMatch) {
    return rawAccumulateAllValuesOfsourceInPort(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for sourceInPort.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InPort> getAllValuesOfsourceInPort(final InPort pTargetInPort) {
    return rawAccumulateAllValuesOfsourceInPort(new Object[]{null, pTargetInPort});
  }
  
  /**
   * Retrieve the set of values that occur in matches for targetInPort.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<InPort> rawAccumulateAllValuesOftargetInPort(final Object[] parameters) {
    Set<InPort> results = new HashSet<InPort>();
    rawAccumulateAllValues(POSITION_TARGETINPORT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for targetInPort.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InPort> getAllValuesOftargetInPort() {
    return rawAccumulateAllValuesOftargetInPort(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for targetInPort.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InPort> getAllValuesOftargetInPort(final InPortToInPortConnectionMatch partialMatch) {
    return rawAccumulateAllValuesOftargetInPort(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for targetInPort.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InPort> getAllValuesOftargetInPort(final InPort pSourceInPort) {
    return rawAccumulateAllValuesOftargetInPort(new Object[]{pSourceInPort, null});
  }
  
  @Override
  protected InPortToInPortConnectionMatch tupleToMatch(final Tuple t) {
    try {
      return InPortToInPortConnectionMatch.newMatch((hu.bme.mit.transima.Simulink.InPort) t.get(POSITION_SOURCEINPORT), (hu.bme.mit.transima.Simulink.InPort) t.get(POSITION_TARGETINPORT));
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in tuple not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected InPortToInPortConnectionMatch arrayToMatch(final Object[] match) {
    try {
      return InPortToInPortConnectionMatch.newMatch((hu.bme.mit.transima.Simulink.InPort) match[POSITION_SOURCEINPORT], (hu.bme.mit.transima.Simulink.InPort) match[POSITION_TARGETINPORT]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected InPortToInPortConnectionMatch arrayToMatchMutable(final Object[] match) {
    try {
      return InPortToInPortConnectionMatch.newMutableMatch((hu.bme.mit.transima.Simulink.InPort) match[POSITION_SOURCEINPORT], (hu.bme.mit.transima.Simulink.InPort) match[POSITION_TARGETINPORT]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
}
