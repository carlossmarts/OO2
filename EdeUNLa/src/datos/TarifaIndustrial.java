package datos;

public class TarifaIndustrial extends Tarifa {

	private int limiteConsumo;
	private boolean consumoMayor;
	private String tension;
	private double cargoFijo;
	private double cargoVariablePico;
	private double cargoVariableValle;
	private double cargoVariableResto;

	
	public TarifaIndustrial() {
		super();
	}


	public TarifaIndustrial(String codigo, int limiteConsumo, boolean consumoMayor, String tension, double cargoFijo,
			double cargoVariablePico, double cargoVariableValle, double cargoVariableResto) {
		super(codigo);
		this.limiteConsumo = limiteConsumo;
		this.consumoMayor = consumoMayor;
		this.tension = tension;
		this.cargoFijo = cargoFijo;
		this.cargoVariablePico = cargoVariablePico;
		this.cargoVariableValle = cargoVariableValle;
		this.cargoVariableResto = cargoVariableResto;
	}




	public int getLimiteConsumo() {
		return limiteConsumo;
	}


	public void setLimiteConsumo(int limiteConsumo) {
		this.limiteConsumo = limiteConsumo;
	}


	public boolean isConsumoMayor() {
		return consumoMayor;
	}


	public void setConsumoMayor(boolean consumoMayor) {
		this.consumoMayor = consumoMayor;
	}


	public String getTension() {
		return tension;
	}


	public void setTension(String tension) {
		this.tension = tension;
	}


	public double getCargoFijo() {
		return cargoFijo;
	}


	public void setCargoFijo(double cargoFijo) {
		this.cargoFijo = cargoFijo;
	}


	public double getCargoVariablePico() {
		return cargoVariablePico;
	}


	public void setCargoVariablePico(double cargoVariablePico) {
		this.cargoVariablePico = cargoVariablePico;
	}


	public double getCargoVariableValle() {
		return cargoVariableValle;
	}


	public void setCargoVariableValle(double cargoVariableValle) {
		this.cargoVariableValle = cargoVariableValle;
	}


	public double getCargoVariableResto() {
		return cargoVariableResto;
	}


	public void setCargoVariableResto(double cargoVariableResto) {
		this.cargoVariableResto = cargoVariableResto;
	}


	@Override
	public String toString() {
		return super.toString() + "\nTarifaIndustrial [limiteConsumo=" + limiteConsumo + ", consumoMayor=" + consumoMayor + ", tension="
				+ tension + ", cargoFijo=" + cargoFijo + ", cargoVariablePico=" + cargoVariablePico
				+ ", cargoVariableValle=" + cargoVariableValle + ", cargoVariableResto=" + cargoVariableResto + "]";
	}

	

}
