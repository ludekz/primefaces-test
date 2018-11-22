package org.primefaces.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

@ManagedBean(name = "testView")
@ViewScoped
public class TestView implements Serializable {

	private String testString;

	private List<Row> outgoingData = new ArrayList<>();

	private Row selectedRow = null;

	@PostConstruct
	public void init() {
		testString = "Welcome to PrimeFaces!!!";

		for (int i = 0; i < 6; i++) {
			outgoingData.add(new Row(false));
			outgoingData.add(new Row(false));
			outgoingData.add(new Row(true));
			outgoingData.add(new Row(false));

		}

	}

	public String getTestString() {
		return testString;
	}

	public void setTestString(String testString) {
		this.testString = testString;
	}

	public List<Row> getOutgoingData() {
		return outgoingData;
	}

	public void setOutgoingData(List<Row> outgoingData) {
		this.outgoingData = outgoingData;
	}

	public Row getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(Row selectedRow) {
		this.selectedRow = selectedRow;
	}

	public void checkAndPrepareCheckout() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
				"Selected has confirm required: " + selectedRow.isConfirmRequired()));

	}

	public static class Row implements Serializable {

		boolean confirmRequired;

		public Row(boolean confirmRequired) {
			super();
			this.confirmRequired = confirmRequired;
		}

		public boolean isConfirmRequired() {
			return confirmRequired;
		}

		public void setConfirmRequired(boolean confirmRequired) {
			this.confirmRequired = confirmRequired;
		}

	}

}
