package net.sf.jpacriteria;

import net.sf.jpacriteria.argument.Argument;
import net.sf.jpacriteria.argument.ArgumentImpl;
import net.sf.jpacriteria.argument.Arguments;
import net.sf.jpacriteria.builder.CriteriaBuilder;

import javax.persistence.*;

/**
 * @author Maxim Butov
 * @version $Id: CriteriaImpl.java,v 1.20 2007/09/21 08:26:16 maxim_butov Exp $
 */
public class CriteriaImpl extends BasicCriteriaImpl<Criteria> implements Criteria {

    private static final long serialVersionUID = -6681011784244965931L;

    private Integer firstResult;
    private Integer maxResults;
    private Argument argument = new ArgumentImpl();

    public CriteriaImpl(String entity) {
        this(entity, null);
    }

    public CriteriaImpl(String entity, String alias) {
        super(entity, alias);
    }

    public Criteria firstResult(int firstResult) {
        this.firstResult = firstResult;
        return this;
    }

    public Criteria maxResults(int resultCount) {
        this.maxResults = resultCount;
        return this;
    }

    public Criteria argument(Argument argument, Argument... arguments) {
        this.argument.add(argument);
        for (Argument a : arguments) {
            this.argument.add(a);
        }
        return this;
    }

    public Argument getArgument() {
        return argument;
    }

    public Criteria compile() {
        CriteriaBuilder builder = new CriteriaBuilder(this);
        String queryString = builder.toString();
        return new CompiledCriteriaImpl(queryString, firstResult, maxResults, Arguments.union(argument, builder.getArgument()));
    }

    public String toQueryString() {
        return compile().toQueryString();
    }

    public Query toQuery(EntityManager entityManager, Argument argument) {
        return compile().toQuery(entityManager, argument);
    }

    @Override
    public String toString() {
        return compile().toString();
    }
}
