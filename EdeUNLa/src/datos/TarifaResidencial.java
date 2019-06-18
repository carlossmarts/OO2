package datos;

public class TarifaResidencial extends Tarifa {

	private double montoMinimo;
	private double cargoVariable;
	private int limiteInferiorConsumo;
	private int limiteSuperiorConsumo;
	
	
	public TarifaResidencial(String codigo, double montoMinimo, double cargoVariable, int limiteInferiorConsumo,
			int limiteSuperiorConsumo) {
		super(codigo);
		this.montoMinimo = montoMinimo;
		this.cargoVariable = cargoVariable;
		this.limiteInferiorConsumo = limiteInferiorConsumo;
		this.limiteSuperiorConsumo = limiteSuperiorConsumo;
	}
	
	public double getMontoMinimo() {
		return montoMinimo;
	}

	public void setMontoMinimo(double montoMinimo) {
		this.montoMinimo = montoMinimo;
	}

	public double getCargoVariable() {
		return cargoVariable;
	}

	public void setCargoVariable(double cargoVariable) {
		this.cargoVariable = cargoVariable;
	}

	public int getLimiteInferiorConsumo() {
		return limiteInferiorConsumo;
	}

	public void setLimiteInferiorConsumo(int limiteInferiorConsumo) {
		this.limiteInferiorConsumo = limiteInferiorConsumo;
	}


	public int getLimiteSuperiorConsumo() {
		return limiteSuperiorConsumo;
	}

	public void setLimiteSuperiorConsumo(int limiteSuperiorConsumo) {
		this.limiteSuperiorConsumo = limiteSuperiorConsumo;
	}

	public TarifaResidencial() {
		super();
	}

	
	
	
}
