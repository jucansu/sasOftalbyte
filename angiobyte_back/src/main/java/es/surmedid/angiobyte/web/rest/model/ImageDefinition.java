package es.surmedid.angiobyte.web.rest.model;

import java.util.ArrayList;
import java.util.List;

public class ImageDefinition {
	
	private List<String> names;
	
	public ImageDefinition() {
		
	}
	
	public ImageDefinition(List<String> names) {
		this.setNames(new ArrayList<String>());
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

}
