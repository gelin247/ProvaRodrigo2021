package br.edu.univas.main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import br.edu.univas.vo.Carro;
import br.edu.univas.vo.Competidor;
import br.edu.univas.vo.Moto;
import br.edu.univas.vo.Motor;
import br.edu.univas.vo.Veiculo;

public class StartApp {
	public static void main(String[] args) {
		int opcao;
		Scanner scanner = new Scanner(System.in);
		ArrayList<Competidor> competidores = new ArrayList<>();
		int velFin[] = new int[5];
		for (int i = 0; i < 5; i++) {
			System.out.println("Bem vindo ao simulador de corridas");
			System.out.println("Digite 1 para carro ou 2 para moto");

			opcao = scanner.nextInt();
			scanner.nextLine();
			if (opcao == 1) {
				Competidor competidor = new Competidor();
				Carro carro = new Carro();
				Motor motor = new Motor();

				System.out.println("Digite apelido do competidor");
				competidor.setApelido(scanner.nextLine());

				System.out.println("Digite o ano de fabricação do carro: ");
				carro.setAnoFabricacao(scanner.nextInt());

				System.out.println("Digite o ano do modelo do carro");
				carro.setAnoModelo(scanner.nextInt());

				System.out.println("Por favor escreva a cor do veiculo");
				carro.setCor(scanner.next());

				System.out.println("Por favor digite potencia do motor ");
				motor.setPotencia(scanner.nextInt());

				System.out.println("Por favor digite o torque do motor: ");
				motor.setTorque(scanner.nextInt());

				carro.setMotor(motor);
				competidor.setVeiculo(carro);
				competidores.add(competidor);

			} else if (opcao == 2) {
				Competidor competidor = new Competidor();
				Moto moto = new Moto();
				Motor motor = new Motor();

				System.out.println("Digite apelido do competidor");
				competidor.setApelido(scanner.nextLine());

				System.out.println("Digite o ano de fabricação da moto: ");
				moto.setAnoFabricacao(scanner.nextInt());

				System.out.println("Digite o ano do modelo da moto");
				moto.setAnoModelo(scanner.nextInt());

				System.out.println("Por favor escreva a cor da moto");
				moto.setCor(scanner.next());

				System.out.println("Por favor digite potencia do motor ");
				motor.setPotencia(scanner.nextInt());

				System.out.println("Por favor digite o torque do motor: ");
				motor.setTorque(scanner.nextDouble());

				moto.setMotor(motor);
				competidor.setVeiculo(new Moto());
				competidores.add(competidor);

			}

			for (int z = 0; z < 10; z++) {
				for (int y = 0; y < 5; y++) {
					Random gerador = new Random();
					int n = 5 + gerador.nextInt(16);
					Veiculo veiculo = competidores.get(y).getVeiculo();
					veiculo.acelerar(n);

				}

			}

			for (int k = 0; k < 5; k++)
				velFin[i] = competidores.get(i).getVeiculo().getVelocidadeAtual();

			int n = velFin.length;
			int temp = 0;
			for (int b = 0; b < n; b++) {
				for (int j = 1; j < (n - b); j++) {
					if (velFin[j - 1] > velFin[j]) {

						temp = velFin[j - 1];
						velFin[j - 1] = velFin[j];
						velFin[j] = temp;
					}

				}
			}

			System.out.println("o ganhador é o que tinha velocidade: " + velFin[4]);

		}
	}

}
