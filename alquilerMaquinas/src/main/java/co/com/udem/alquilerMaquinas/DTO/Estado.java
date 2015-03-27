package co.com.udem.alquilerMaquinas.DTO;

public class Estado {
	private String status;
	
	public Estado(String status) {
		super();
		this.status = status;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}
