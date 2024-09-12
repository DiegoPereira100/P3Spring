package br.edu.fatecpg.spring.ConsomeApi;

import br.edu.fatecpg.spring.ConsomeApi.model.Serie;
import br.edu.fatecpg.spring.ConsomeApi.service.ConsumoApi;
import br.edu.fatecpg.spring.ConsomeApi.service.ConvertDado;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class ConsomeApiApplication implements CommandLineRunner {
	Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		SpringApplication.run(ConsomeApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		boolean start = true;

		while (start) {
			System.out.println("-------- Consultar serie ou filme --------");
			System.out.println("1 - Consultar");
			System.out.println("2 - Sair");
			int op = scan.nextInt();
			scan.nextLine();

			switch(op) {
				case 1:
					System.out.println("Entre com o titulo: ");
					String titulo = scan.nextLine();
					String json = ConsumoApi.obterDado(titulo);

					ConvertDado conversor = new ConvertDado();
					Serie serie = conversor.obterDado(json, Serie.class);
					System.out.println(serie);
					break;
				case 2:
					start = false;
					System.out.println("Saindo da aplicação...");
			}
		}
	}
}
