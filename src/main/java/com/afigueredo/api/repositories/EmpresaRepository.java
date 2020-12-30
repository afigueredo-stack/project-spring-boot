package com.afigueredo.api.repositories;

import com.afigueredo.api.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
  Empresa findByCnpj(String cnpj);
}
