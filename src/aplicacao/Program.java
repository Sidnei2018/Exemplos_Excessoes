package aplicacao;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;
import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		// solução ruim = 

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Room Number: ");
		int number = sc.nextInt();
		System.out.println("CheckIn Date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("CheckOut Date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: Data de checkOut não pode ser anterior a de checkIn!");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reserva realizada com sucesso!");
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Entre com as datas para atualização da reserva: ");
			System.out.println("CheckIn Date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.println("CheckOut Date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			String error = reservation.updateDates(checkIn, checkOut); // atualiza a reserva
			if (error != null) {
				System.out.println("Erro na reserva: " + error);
			} else {
				System.out.println("Reservation: " + reservation);
			}
		}

		sc.close();

	}
}