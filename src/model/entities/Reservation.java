package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	/**
	 * atributo static para não ser instanciado 1 a cada objeto que eu instanciar pois eu so precisso de 1
	 * SimpleDateFormat
	 */
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
		/**
		 * estou pegando o valor de milisegundos das datas recebendo esse dado
		 * a diferença de tempo em milisegundos
		 */
		long diff = checkOut.getTime() - checkIn.getTime();
		
		/**
		 * e agora com a classe TimeUnit consegui converter um valor de milisegundos para o numero de dias
		 * e retorno esse valor
		 */
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Romm ");
		stringBuilder.append(roomNumber);
		stringBuilder.append(", check-in ");
		stringBuilder.append(sdf.format(checkIn));
		stringBuilder.append(", check-out ");
		stringBuilder.append(sdf.format(checkOut));
		stringBuilder.append(", ");
		stringBuilder.append(duration());
		stringBuilder.append(" nights");
		
		return stringBuilder.toString();
	}
}
