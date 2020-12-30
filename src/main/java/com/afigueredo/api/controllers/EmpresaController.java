package com.afigueredo.api.controllers;

import com.afigueredo.api.dtos.EmpresaDto;
import com.afigueredo.api.responses.Response;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

  @PostMapping
  public ResponseEntity<Response<EmpresaDto>> cadastrar(@Validated @RequestBody EmpresaDto empresaDto,
      BindingResult result) {
    Response<EmpresaDto> response = new Response<EmpresaDto>();

    if (result.hasErrors()) {
      result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
      return ResponseEntity.badRequest().body(response);
    }

    empresaDto.setId(1L);
    response.setData(empresaDto);

    System.out.println("");
    System.out.println("### Empresa cadastrada com sucesso!.");
    return ResponseEntity.ok(response);

  }
}
