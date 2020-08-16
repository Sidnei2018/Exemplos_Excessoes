package aplicacao;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;
import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		// solução boa

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.println("Room Number: ");
			int number = sc.nextInt();
			System.out.println("CheckIn Date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.println("CheckOut Date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
	
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reserva realizada com sucesso!");
			System.out.println("Reservation: " + reservation);
	
			System.out.println();
			System.out.println("Entre com as datas para atualização da reserva: ");
			System.out.println("CheckIn Date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.println("CheckOut Date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
	
			reservation.updateDates(checkIn, checkOut); // atualiza a reserva
			System.out.println("Reservation: " + reservation);
		}
		catch(ParseException e) {
			System.out.println("Data inválida!");
		}
		catch(DomainException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		
		sc.close();
	}
}