package com.proofssd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProofssdApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProofssdApplication.class, args);
		
		System.out.println("✔️ Lista limpa e organizada\n" + "\t✔️ Cabeça\n" + "\t✔️ Pescoço\n" + "\tPeitoral\n" + "\tBraço\n"
				+ "\tBarriga\n" + "\tQuadril\n" + "\tCoxa\n" + "\tPerna\n" + "\tPé");
		System.err.println("\n\tSystema Rodando");
	}

}
