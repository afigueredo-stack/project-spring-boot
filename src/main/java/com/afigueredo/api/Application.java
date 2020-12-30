package com.afigueredo.api;

import java.util.List;

import com.afigueredo.api.documents.Cliente;
import com.afigueredo.api.entities.Empresa;
import com.afigueredo.api.repositories.ClienteRepository;
import com.afigueredo.api.repositories.EmpresaRepository;
import com.afigueredo.api.services.ExemploService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.afigueredo.api")
@EntityScan("com.afigueredo.api.entities")
public class Application {

  @Autowired
  private EmpresaRepository empresaRepository;

  @Autowired
  private ExemploService exemploService;

  @Autowired
  private ClienteRepository clienteRepository;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner() {
    return args -> {
      // CRIANDO OBJETO E SETANDO VALORES
      Empresa empresa = new Empresa();
      empresa.setRazaoSocial("Joystick Loja");
      empresa.setCnpj("17007777000177");

      // PERSISTINDO NO H2 - BANCO DE DADOS
      this.empresaRepository.save(empresa);

      // CRIANDO LISTA PARA EXIBICAO
      List<Empresa> empresas = empresaRepository.findAll();
      System.out.println("");
      System.out.println("### Exibindo todas as empresas...");
      empresas.forEach(System.out::println);// NEW JAVA 8

      // CONSULTANDO EMPRESA CRIANDO NO BANCO
      try {
        Empresa empresaDb = empresaRepository.findById(1L).orElse(null);

        if (empresaDb != null) {
          System.out.println("");
          System.out.println("### Empresa por ID: " + empresaDb);
        }

        // ATUALIZANDO RAZAO DA EMPRESA
        empresaDb.setRazaoSocial("Joystick Loja Web");
        this.empresaRepository.save(empresaDb);

        Empresa empresaCNPJ = empresaRepository.findByCnpj("17007777000177");
        System.out.println("");
        System.out.println("### Empresa por CNPJ: " + empresaCNPJ);

        this.empresaRepository.deleteById(1L);
        empresas = empresaRepository.findAll();

        System.out.println("");
        System.out.println("### Quantidade de empresas: " + empresas.size());
      } catch (Exception e) {
        System.out.println("");
        System.err.println("### Empresa não localizada. Motivo: " + e);
      }

      // Testando serviço
      this.exemploService.testarServico();

      // AULA DE USO NO MONGODB
      clienteRepository.deleteAll();

      clienteRepository.save(new Cliente("Alice", 20));
      clienteRepository.save(new Cliente("João", 30));
      clienteRepository.save(new Cliente("Maria", 40));

      System.out.println("Lista todos com o findAll():");
      System.out.println("-------------------------------");
      clienteRepository.findAll().forEach(System.out::println);
      System.out.println();

      System.out.println("Busca um único cliente com o findByNome('Alice'):");
      System.out.println("--------------------------------");
      System.out.println(clienteRepository.findByNome("Alice"));
      System.out.println();

      System.out.println("Clientes com idade entre 18 and 35:");
      System.out.println("--------------------------------");
      clienteRepository.findByIdadeBetween(18, 35).forEach(System.out::println);
    };
  }

}
