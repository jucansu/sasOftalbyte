package es.surmedid.angiobyte.web.rest.model;

public class Image {
	private String name;
	private String data;
	private String id;
	private String type;
	private String date;
	private String number;
	private String eye;
	private long creationDate;

	public Image() {
		
	}
	
	public Image(String name, String data, String id, String type, String date, String number, String eye, long creationDate) {
		super();
		this.name = name;
		this.data = data;
		this.id = id;
		this.type = type;
		this.date = date;
		this.number = number;
		this.eye = eye;
		this.setCreationDate(creationDate);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEye() {
		return eye;
	}

	public void setEye(String eye) {
		this.eye = eye;
	}
	
	public long getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(long creationDate) {
		this.creationDate = creationDate;
	}
	

	@Override
	public String toString() {
		return "Image [name=" + name + ", data=" + data + ", id=" + id + ", type=" + type + ", date=" + date
				+ ", number=" + number + ", eye=" + eye + ", creationDate=" + creationDate + "]";
	}
}
