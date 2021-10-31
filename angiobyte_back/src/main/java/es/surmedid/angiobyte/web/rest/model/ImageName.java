package es.surmedid.angiobyte.web.rest.model;

import java.util.List;

public class ImageName {
	private List<String> listNames;

	public ImageName(List<String> listNames) {
		super();
		this.listNames = listNames;
	}

	public List<String> getListNames() {
		return listNames;
	}

	public void setListNames(List<String> listNames) {
		this.listNames = listNames;
	}

	@Override
	public String toString() {
		return "ImageName [listNames=" + listNames + "]";
	}

}
