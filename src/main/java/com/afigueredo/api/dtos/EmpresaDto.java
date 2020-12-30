package com.afigueredo.api.dtos;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

public class EmpresaDto {

  private Long id;
  private String razaoSocial;
  private String cnpj;

  public EmpresaDto() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @NotNull(message = "Razão social não pode ser vazia")
  @Length(min = 5, max = 200, message = "Razão social deve conter entre 5 e 200 caracteres.")
  public String getRazaoSocial() {
    return razaoSocial;
  }

  public void setRazaoSocial(String razaoSocial) {
    this.razaoSocial = razaoSocial;
  }

  @NotNull(message = "CNPJ não pode ser vazia")
  @CNPJ(message = "CNPJ inválido")
  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  @Override
  public String toString() {
    return "EmpresaDto [cnpj=" + cnpj + ", id=" + id + ", razaoSocial=" + razaoSocial + "]";
  }

}
