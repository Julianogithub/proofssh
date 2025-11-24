package com.proofssd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProofssdApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProofssdApplication.class, args);
		
		System.out.println("✔️ Lista limpa e organizada\n" + "\t✔️ Cabeça = Head\n" + "\t✔️ Pescoço = Nick\n" 
							+ "\t✔️ Peitoral = chest\n" + "\t✔️ Braço = Arm\n" + "\tBarriga = stomach\n" 
							+ "\tQuadril = hip\n" + "\tCoxa = thigh\n" + "\t✔️ Perna = leg\n" + "\tPé = foot");
		System.err.println("\n\tSystema Rodando");
	}

}
