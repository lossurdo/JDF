package net.sf.jpacriteria.builder;

import net.sf.jpacriteria.Criteria;
import net.sf.jpacriteria.ReservedIdentifier;
import net.sf.jpacriteria.alias.Aliased;
import net.sf.jpacriteria.argument.Argument;

/**
 * @author Maxim Butov
 * @version $Id: CriteriaBuffer.java,v 1.13 2007/04/04 22:44:41 maxim_butov Exp $
 */
public class CriteriaBuffer implements Aliased {

    private interface Characters {

        char SPACE = ' ';
        char COMMA = ',';
        char DOT = '.';
        char BLOCK_START = '(';
        char BLOCK_END = ')';
    }

    private CriteriaBuilder builder;
    private String alias;
    private StringBuilder buffer = new StringBuilder();

    public CriteriaBuffer(CriteriaBuilder builder, String alias) {
        this.builder = builder;
        this.alias = alias;
    }

    public CriteriaBuffer newBuffer() {
        return new CriteriaBuffer(builder, alias);
    }

    public CriteriaBuilder getBuilder() {
        return builder;
    }

    public Criteria getCriteria() {
        return builder.getCriteria();
    }

    public Argument getArgument() {
        return builder.getArgument();
    }

    public String getAlias() {
        return alias;
    }

    public boolean isEmpty() {
        return buffer.length() == 0;
    }

    public CriteriaBuffer insert(Object obj) {
        insertSpace();
        insertNoSpace(obj);
        return this;
    }

    public CriteriaBuffer insertNoSpace(Object obj) {
        buffer.insert(0, obj);
        return this;
    }

    public CriteriaBuffer append(Object obj) {
        appendSpace();
        appendNoSpace(obj);
        return this;
    }

    public CriteriaBuffer appendNoSpace(Object obj) {
        buffer.append(obj);
        return this;
    }

    public CriteriaBuffer appendAliased(Object obj) {
        appendAliased(getAlias(), obj);
        return this;
    }

    public CriteriaBuffer appendAliased(String alias, Object obj) {
        appendSpace();
        buffer.append(alias);
        if (obj != null) {
            buffer.append(Characters.DOT).append(obj);
        }
        return this;
    }

    @Override
    public String toString() {
        trim();
        return buffer.toString();
    }

    private void appendSpace() {
        if (!isEmpty() && buffer.charAt(buffer.length() - 1) != Characters.SPACE) {
            buffer.append(Characters.SPACE);
        }
    }

    private void insertSpace() {
        if (!isEmpty() && buffer.charAt(0) != Characters.SPACE) {
            buffer.insert(0, Characters.SPACE);
        }
    }

    private void trim() {
        if (!isEmpty() && buffer.charAt(0) == Characters.SPACE) {
            buffer.deleteCharAt(0);
        }
        if (!isEmpty() && buffer.charAt(buffer.length() - 1) == Characters.SPACE) {
            buffer.deleteCharAt(buffer.length() - 1);
        }
    }

    public CriteriaBuffer appendComma() {
        trim();
        buffer.append(Characters.COMMA);
        return this;
    }

    public CriteriaBuffer append(CriteriaBlock block) {
        block.build(this);
        return this;
    }

    public CriteriaBuffer enclose() {
        trim();
        buffer.insert(0, Characters.BLOCK_START).append(Characters.BLOCK_END);
        return this;
    }

    public CriteriaBuffer enclose(ReservedIdentifier identifier) {
        enclose();
        insertNoSpace(identifier);
        return this;
    }
}
