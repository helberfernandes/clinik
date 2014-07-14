package br.com.wofsolutions.model;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

public class ObjDataModel<E> extends ListDataModel<E> implements
		SelectableDataModel<E>, Serializable {

	List<E> data;

	public ObjDataModel() {
	}

	public ObjDataModel(List<E> data) {

		super(data);
		this.data = data;

	}

	@Override
	public E getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<E> Es = data;

		for (E E : Es) {
			System.out.println(rowKey);
			System.out.println(E.equals(rowKey));
			if (E.equals(rowKey))
				return E;
		}

		return null;
	}

	@Override
	public Object getRowKey(E E) {
		return E.toString();
	}
}
