package br.com.AnimaMonitoria.repository;

import br.com.AnimaMonitoria.model.Instituicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InstituicaoRepository extends JpaRepository<Instituicao, Long> {

    @Query(value = "select * from instituicao order by nome", nativeQuery = true)
    List<Instituicao> findAllOrderBynome();
}
