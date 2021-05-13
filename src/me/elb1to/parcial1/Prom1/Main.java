package me.elb1to.parcial1.Prom1;

import me.elb1to.parcial1.Prom1.team.impl.BasketballPlayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Elb1to
 * Project: DS3
 * Date: 5/11/2021 @ 10:15 AM
 */
public class Main {

	static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	static BasketballPlayer basketballPlayer = new BasketballPlayer();
	static ArrayList<String> players = new ArrayList<>();
	static ArrayList<Integer> points = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		String execController, teamName;

		System.out.println("Introduzca el nombre del equipo de basketball para el jugador...");
		teamName = bufferedReader.readLine();
		basketballPlayer.setTeamName(teamName);
		System.out.println("El nombre del equipo es: " + basketballPlayer.getTeamName());

		do {
			createBasketballPlayer(basketballPlayer);

			System.out.println("Continuar? S/N");
			execController = bufferedReader.readLine();
		} while (execController.equalsIgnoreCase("s"));

		System.out.println("Cantidad total de jugadores: " + players.size());
		System.out.println("Cantidad total de puntos anotados: " + points.stream().mapToInt(value -> value).sum());
	}

	private static void createBasketballPlayer(BasketballPlayer basketballPlayer) {
		String playerName;
		int uniformNumber, pointsScored;

		System.out.println("\n\n");
		System.out.println(String.join("", Collections.nCopies(64, "-")));
		System.out.println("Creando jugador para el equipo " + basketballPlayer.getTeamName());
		System.out.println(String.join("", Collections.nCopies(64, "-")));

		try {
			System.out.println("Introduzca el nombre del jugador: ");
			playerName = bufferedReader.readLine();
			basketballPlayer.setPlayerName(playerName);

			System.out.println("Introduzca el numero para el uniforme de " + basketballPlayer.getPlayerName() + ": ");
			uniformNumber = Integer.parseInt(bufferedReader.readLine());
			basketballPlayer.setUniformNumber(uniformNumber);

			System.out.println("Introduzca la cantidad de puntos anotados por " + basketballPlayer.getPlayerName() + ": ");
			pointsScored = Integer.parseInt(bufferedReader.readLine());
			basketballPlayer.setPointsScored(pointsScored);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (players.contains(basketballPlayer.getPlayerName())) {
			System.out.println("Este jugador ya pertenece a este equipo!");
		} else {
			players.add(basketballPlayer.getPlayerName());
			points.add(basketballPlayer.getPointsScored());
		}
	}
}
