package com.afigueredo.myfirstproject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class MyFirstProjectApplicationTests {

	@Value("${paginacao.qtd_por_pagina}")
	private int qtdPorPagina;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCarrregarContextoDeTeste() {
		assertEquals(25, this.qtdPorPagina);
	}

}
