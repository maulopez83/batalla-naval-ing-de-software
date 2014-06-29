package negocio.comunicacion.mensajes;

public class MensajeTurno extends Mensaje {

	private static final long serialVersionUID = 1L;
	private boolean turno;
	private String toast;
	public MensajeTurno(){
		setType(new MTurno());
		setToast(null);
	}
	public MensajeTurno(boolean turno){
		setType(new MTurno());
		this.turno=turno;
		setToast(null);
	}
	public MensajeTurno(boolean turno,String toast){
		setType(new MTurno());
		this.turno=turno;
		this.setToast(toast);
	}
	public void setTurno(boolean turno) {
		this.turno = turno;
	}
	public boolean isTurno() {
		return turno;
	}
	public void setToast(String toast) {
		this.toast = toast;
	}
	public String getToast() {
		return toast;
	}
	

}
