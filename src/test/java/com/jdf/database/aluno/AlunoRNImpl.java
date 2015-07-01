package com.jdf.database.aluno;

import java.util.List;

import net.sf.jpacriteria.Criteria;

import com.jdf.database.CrudRN;
import com.jdf.database.ListConfig;
import com.jdf.database.ed.AlunoED;

/**
 * RN PADRÃO
 * @author lossurdo
 * @since 27/03/2009
 */
public class AlunoRNImpl implements CrudRN<AlunoED, AlunoED> {

	private AlunoBDImpl bd;
	private AlunoRNValImpl rnVal;

	public AlunoRNImpl() {
		bd = new AlunoBDImpl();
		rnVal = new AlunoRNValImpl();
	}

	@Override
	public void altera(AlunoED ed) {
		rnVal.validaAltera(ed);
		bd.altera(ed);
	}

	@Override
	public AlunoED consulta(AlunoED ed) {
		rnVal.validaConsulta(ed);
		return bd.consulta(ed);
	}

	@Override
	public void exclui(List<AlunoED> lista) {
		for (AlunoED alunoED : lista) {
			exclui(alunoED);
		}
	}

	@Override
	public void exclui(AlunoED ed) {
		rnVal.validaExclui(ed);
		bd.exclui(ed);
	}

	@Override
	public AlunoED inclui(AlunoED ed) {
		rnVal.validaInclui(ed);
		return bd.inclui(ed);
	}

	@Override
	public List<AlunoED> lista(AlunoED ed, Criteria criteria,
			ListConfig propsLista) {
		rnVal.validaLista(ed);
		return bd.lista(ed, criteria, propsLista);
	}

	@Override
	public List<AlunoED> lista(AlunoED ed, ListConfig propriedadesLista) {
		rnVal.validaLista(ed);
		return bd.lista(ed, propriedadesLista);
	}

	@Override
	public long conta(AlunoED ed) {
		return bd.conta(ed);
	}

	@Override
	public long conta(AlunoED ed, Criteria crit) {
		return bd.conta(ed, crit);
	}
}