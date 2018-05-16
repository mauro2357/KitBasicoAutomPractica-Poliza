package com.sura.polizas.datos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sura.polizas.entidades.Poliza;

@Repository
public interface PolizasRepository extends JpaRepository<Poliza, Long> {

}
