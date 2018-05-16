package com.sura.polizas;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.sura.polizas.datos.PolizasRepository;
import com.sura.polizas.entidades.Poliza;

@Profile("test")
public class PolizaRepositoryFake implements PolizasRepository{
	
	private List<Poliza> polizas = new ArrayList<>();
	
	public PolizaRepositoryFake() {
		
		polizas.add(new Poliza(1,"SURA",new BigDecimal("1000"),"S" ));
		polizas.add(new Poliza(2,"INTEGRA",new BigDecimal("2000"),"N" ));
		polizas.add(new Poliza(3,"FONDOS",new BigDecimal("3000"),"S" ));
	
	}

	@Override
	public List<Poliza> findAll() {
		// TODO Auto-generated method stub
		return polizas;
	}

	@Override
	public List<Poliza> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Poliza> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Poliza> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Poliza> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Poliza> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Poliza getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Poliza> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Poliza> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Poliza> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Poliza> S save(S entity) {
		polizas.add(entity);
		return entity;
	}

	@Override
	public Optional<Poliza> findById(Long id) {
		for (Poliza poliza : polizas) {
			if(poliza.getIdPoliza()==id) {
				return Optional.of(poliza);
			}
		}
		
		return Optional.empty();
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Poliza entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Poliza> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Poliza> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Poliza> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Poliza> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Poliza> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

}
