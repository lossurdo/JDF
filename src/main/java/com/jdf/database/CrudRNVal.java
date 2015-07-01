package com.jdf.database;

/**
 * 
 * @author lossurdo
 * @since 27/03/2009
 * @param <TED>
 * @param <TPED>
 */
public interface CrudRNVal<TED, TPED extends TED> {
	public void validaConta(TPED ed);

	public void validaInclui(TED ed);

	public void validaAltera(TED ed);

	public void validaConsulta(TED ed);

	public void validaExclui(TED ed);

	public void validaLista(TPED ed);
}
