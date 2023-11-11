package br.com.AnimaMonitoria.repository;

import br.com.AnimaMonitoria.model.Campos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CamposRepository extends JpaRepository<Campos, Long> {
}