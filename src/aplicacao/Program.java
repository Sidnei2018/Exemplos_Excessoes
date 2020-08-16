package aplicacao;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;
import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		// solução muito ruim = lógica na classe principal

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

			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Erro na reserva: Datas não podem ser anteriores a data atual!");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Erro na reserva: Data de checkOut não pode ser anterior a de checkIn!");
			} else {
				reservation.updateDates(checkIn, checkOut); // atualiza a reserva
				System.out.println("Reserva atualizada com sucesso!");
				System.out.println("Reservation: " + reservation);
			}

		}

		sc.close();

	}

}