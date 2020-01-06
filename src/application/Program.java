package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy) : ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy) : ");
		Date checkOut = sdf.parse(sc.next());
		
		/**
		 * metodo after da classe Date verifica se a data é maior que a data passada como parametro
		 * neste caso estou perguntando se checkout for antes de checkIn então entra na condição 
		 */
		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation + "\n");
			
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy) : ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy) : ");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			
			/**
			 * se checkin ou checkout forem antes, ou seja, before a data atual que é now então não posso fazer
			 * o update da reserva
			 */
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in  reservation: Reservation dates for update must be future dates");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			} else {
				reservation.updateDates(checkIn, checkOut);			
				System.out.println("Reservation: " + reservation + "\n");
			}
		}
		
		sc.close();
	}

}
