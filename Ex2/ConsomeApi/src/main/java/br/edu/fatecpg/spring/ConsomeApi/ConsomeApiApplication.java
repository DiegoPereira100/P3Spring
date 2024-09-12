package br.edu.fatecpg.spring.ConsomeApi;

import br.edu.fatecpg.spring.ConsomeApi.service.ConsumoApi;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class ConsomeApiApplication implements CommandLineRunner {

	private Scanner scan = new Scanner(System.in);
	private ConsumoApi.ConsomeApi api  = new ConsumoApi.ConsomeApi();

	public static void main(String[] args) {
		SpringApplication.run(ConsomeApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		while (true) {
			System.out.println("Selecione uma opção:");
			System.out.println("1 - Listar marcas");
			System.out.println("2 - Listar modelos de uma marca");
			System.out.println("3 - Listar anos de um modelo");
			System.out.println("4 - Consultar preço de um carro");
			System.out.println("5 - Sair");

			int opcao = scan.nextInt();
			scan.nextLine(); // Consumir nova linha

			switch (opcao) {
				case 1:
					listarMarcas();
					break;
				case 2:
					listarModelos();
					break;
				case 3:
					listarAnos();
					break;
				case 4:
					consultarPreco();
					break;
				case 5:
					System.out.println("Saindo...");
					return;
				default:
					System.out.println("Opção inválida. Tente novamente.");
			}
		}
	}

	private void listarMarcas() {
		try {
			String marcas = api.retornarMarcas();
			System.out.println("Marcas:");
			System.out.println(marcas);
		} catch (IOException | InterruptedException e) {
			System.err.println("Erro ao obter marcas: " + e.getMessage());
		}
	}

	private void listarModelos() {
		try {
			System.out.print("Digite o código da marca: ");
			String codigoMarca = scan.nextLine();
			String modelos = api.retornarModelos(codigoMarca);
			System.out.println("Modelos:");
			System.out.println(modelos);
		} catch (IOException | InterruptedException e) {
			System.err.println("Erro ao obter modelos: " + e.getMessage());
		}
	}

	private void listarAnos() {
		try {
			System.out.print("Digite o código da marca: ");
			String codigoMarca = scan.nextLine();
			System.out.print("Digite o código do modelo: ");
			String codigoModelo = scan.nextLine();
			String anos = api.retornarAnos(codigoMarca, codigoModelo);
			System.out.println("Anos:");
			System.out.println(anos);
		} catch (IOException | InterruptedException e) {
			System.err.println("Erro ao obter anos: " + e.getMessage());
		}
	}

	private void consultarPreco() {
		try {
			System.out.print("Digite o código da marca: ");
			String codigoMarca = scan.nextLine();
			System.out.print("Digite o código do modelo: ");
			String codigoModelo = scan.nextLine();
			System.out.print("Digite o código do ano: ");
			String codigoAno = scan.nextLine();
			String preco = api.retornarPreco(codigoMarca, codigoModelo, codigoAno);
			System.out.println("Preço:");
			System.out.println(preco);
		} catch (IOException | InterruptedException e) {
			System.err.println("Erro ao consultar preço: " + e.getMessage());
		}
	}
}
