package net.sf.jpacriteria;

import net.sf.jpacriteria.aggregation.Aggregation;
import net.sf.jpacriteria.argument.Argument;
import net.sf.jpacriteria.argument.Arguments;
import net.sf.jpacriteria.argument.UnmodifiableArgument;
import net.sf.jpacriteria.join.Join;
import net.sf.jpacriteria.order.Order;
import net.sf.jpacriteria.reference.Reference;
import net.sf.jpacriteria.restriction.Restriction;
import net.sf.jpacriteria.select.Selection;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * @author Maxim Butov
 * @version $Id: CompiledCriteriaImpl.java,v 1.20 2007/09/23 19:41:45 maxim_butov Exp $
 */
public class CompiledCriteriaImpl implements Criteria, Serializable {

    private static final long serialVersionUID = 4600804286363084823L;

    private String queryString;
    private Integer firstResult;
    private Integer maxResults;
    private Argument argument;

    public CompiledCriteriaImpl(String queryString, Integer firstResult, Integer maxResults, Argument argument) {
        this.queryString = queryString;
        this.firstResult = firstResult;
        this.maxResults = maxResults;
        this.argument = new UnmodifiableArgument(argument);
    }

    public Criteria firstResult(int firstResult) {
        this.firstResult = firstResult;
        return this;
    }

    public Criteria maxResults(int resultCount) {
        this.maxResults = resultCount;
        return this;
    }

    public Criteria compile() {
        return this;
    }

    public String toQueryString() {
        return queryString;
    }

    public Query toQuery(EntityManager entityManager, Argument argument) {
        Query query = entityManager.createQuery(queryString);
        Argument arg = Arguments.union(this.argument, argument);
        for (String name : arg.names()) {
            query.setParameter(name, arg.get(name));
        }
        if (firstResult != null) {
            query.setFirstResult(firstResult);
        }
        if (maxResults != null) {
            query.setMaxResults(maxResults);
        }
        return query;
    }

    @Override
    public String toString() {
        return queryString + ", [" + argument.toString() + "]";
    }

    public Argument getArgument() {
        return argument;
    }

    public Criteria copy() {
        try {
            return (Criteria) clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getAlias() {
        throw new UnsupportedOperationException();
    }

    public String getFrom() {
        throw new UnsupportedOperationException();
    }

    public Selection getSelection() {
        throw new UnsupportedOperationException();
    }

    public Aggregation getAggregation() {
        throw new UnsupportedOperationException();
    }

    public Collection<Join> getJoins() {
        throw new UnsupportedOperationException();
    }

    public Restriction getWhere() {
        throw new UnsupportedOperationException();
    }

    public Selection getGroups() {
        throw new UnsupportedOperationException();
    }

    public Restriction getHaving() {
        throw new UnsupportedOperationException();
    }

    public Order getOrder() {
        throw new UnsupportedOperationException();
    }

    public Criteria select(Selection selection, Selection... selections) {
        throw new UnsupportedOperationException();
    }

    public Criteria aggregate(Aggregation aggregation, Aggregation... aggregations) {
        throw new UnsupportedOperationException();
    }

    public Criteria join(Join join, Join... joins) {
        throw new UnsupportedOperationException();
    }

    public Criteria group(Selection selection, Selection... selections) {
        throw new UnsupportedOperationException();
    }

    public Criteria having(Restriction restriction, Restriction... restrictions) {
        throw new UnsupportedOperationException();
    }

    public Criteria order(Order order, Order... orders) {
        throw new UnsupportedOperationException();
    }

    public Criteria argument(Argument argument, Argument... arguments) {
        throw new UnsupportedOperationException();
    }

    public Criteria where(Restriction where, Restriction... restrictions) {
        throw new UnsupportedOperationException();
    }

    public Reference getProperty(String name) {
        throw new UnsupportedOperationException();
    }
}
