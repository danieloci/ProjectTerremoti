package application.model;

public class Terremoto {
	
	private String id;
	private String data;
	private String latitudine;
	private String longitudine;
	private String profondita;
	private String tipoMagnitudo;
	private String magnitudo;
	private String zona;
	
	
	
	public Terremoto(String id, String data, String latitudine, String longitudine, String profondita,
			String tipoMagnitudo, String magnitudo, String zona) {
		super();
		this.id = id;
		this.data = data;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
		this.profondita= profondita;
		this.tipoMagnitudo = tipoMagnitudo;
		this.magnitudo = magnitudo;
		this.zona = zona;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getLatitudine() {
		return latitudine;
	}
	public void setLatitudine(String latitudine) {
		this.latitudine = latitudine;
	}
	public String getLongitudine() {
		return longitudine;
	}
	public void setLongitudine(String longitudine) {
		this.longitudine = longitudine;
	}
	public String getProfondita () {
		return profondita;
	}
	public void setProfondita (String profondita) {
		this.profondita= profondita;
	}
	public String getTipoMagnitudo() {
		return tipoMagnitudo;
	}
	public void setTipoMagnitudo(String tipoMagnitudo) {
		this.tipoMagnitudo = tipoMagnitudo;
	}
	public String getMagnitudo() {
		return magnitudo;
	}
	public void setMagnitudo(String magnitudo) {
		this.magnitudo = magnitudo;
	}
	public String getZona() {
		return zona;
	}
	public void setZona(String zona) {
		this.zona = zona;
	}
		
	
	public String toString() {
		return id+" "+data+" "+latitudine+" "+longitudine+" "+profondita
				+" "+tipoMagnitudo+" "+magnitudo+" "+zona;
	}
}
