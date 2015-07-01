package com.jdf.database.aluno;

import com.jdf.database.CrudBDImpl;
import com.jdf.database.ed.AlunoED;

/**
 * BD PADRÃO
 * @author lossurdo
 * @since 27/03/2009
 */
class AlunoBDImpl extends CrudBDImpl<AlunoED, AlunoED> {

	public AlunoBDImpl() {
		super("JDF");
	}

}
