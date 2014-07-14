package br.com.wofsolutions.model;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import br.com.wofsolutions.vo.Medico;

public class MedicoDataModel extends ListDataModel<Medico> implements
		SelectableDataModel<Medico>, Serializable {

	

	public MedicoDataModel() {
	}

	public MedicoDataModel(List<Medico> data) {

		super(data);
	

	}

	@Override
	public Medico getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<Medico> Medicos = (List<Medico>) getWrappedData();

		for (Medico medico : Medicos) {
			System.out.println(rowKey);
			if(medico.getMedicoId().equals(Integer.parseInt(rowKey))) 
				return medico;
		}

		return null;
	}

	@Override
	public Integer getRowKey(Medico medico) {
		return medico.getMedicoId();
	}
}
