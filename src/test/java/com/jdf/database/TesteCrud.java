package com.jdf.database;

import java.util.ArrayList;
import java.util.List;

import com.jdf.database.ListConfig;
import com.jdf.database.aluno.AlunoRNImpl;
import com.jdf.database.ed.AlunoED;
import com.jdf.database.ed.TurmaED;

public class TesteCrud {

	public static void main(String[] args) {		
		AlunoED a1 = new AlunoED(null,"Alanis Morissette");
		AlunoED a2 = new AlunoED(null,"Rafael Lossurdo");
		AlunoED a3 = new AlunoED(null,"Queisi Oliveira");

		TurmaED t1 = new TurmaED(null, "Java Avançado");
		ArrayList<TurmaED> lt = new ArrayList<TurmaED>();
		lt.add(t1);

		TurmaED t2 = new TurmaED(null, "Java Básico");
		TurmaED t3 = new TurmaED(null, "RPM - Gerente de Projetos");
		ArrayList<TurmaED> lt2 = new ArrayList<TurmaED>();
		lt2.add(t2);
		lt2.add(t3);

		a1.setListaTurmas(lt);
		a2.setListaTurmas(lt2);
		a3.setListaTurmas(lt);		
		
		AlunoRNImpl rn = new AlunoRNImpl();
		rn.inclui(a1);
		rn.inclui(a2);
		rn.inclui(a3);
		
		List<AlunoED> lis = rn.lista(new AlunoED(), new ListConfig());
		for (AlunoED alunoED : lis) {
			System.out.println(alunoED.toString() + alunoED.getListaTurmas());
		}

	}

}
