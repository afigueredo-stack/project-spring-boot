package com.afigueredo.api.exemple;

import com.afigueredo.utils.SenhaUtils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyFirstProjectApplication {

	@Value("${paginacao.qtd_por_pagina}")
	private int qtdPorPagina;

	public static void main(String[] args) {
		SpringApplication.run(MyFirstProjectApplication.class, args);
		System.out.println("");
		System.out.println("Primeira Aula");
		System.out.println("Meu primeiro projeto usando Spring");
	}

	// @Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			System.out.println("");
			System.out.println("Aula de uso de Profiles");
			System.out.println("### Quantidade de elementos por página = " + this.qtdPorPagina);

			System.out.println("");
			System.out.println("Aula de Criptografia");
			String senhaEncoded = SenhaUtils.gerarBCrypt("123456");
			System.out.println("Senha encoded: " + senhaEncoded);

			senhaEncoded = SenhaUtils.gerarBCrypt("123456");
			System.out.println("Senha encoded novamente: " + senhaEncoded);

			System.out.println("Senha válida: " + SenhaUtils.senhaValida("123456", senhaEncoded));
		};
	}

}
