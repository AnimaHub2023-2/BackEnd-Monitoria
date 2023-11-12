package br.com.AnimaMonitoria.repository;

import br.com.AnimaMonitoria.model.Monitoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitoriaRepository extends JpaRepository<Monitoria, Long> {
}
