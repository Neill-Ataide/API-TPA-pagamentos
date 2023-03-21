package uea.pagamentos_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import uea.pagamentos_api.models.Lancamento;
import uea.pagamentos_api.repositories.lancamento.LancamentoRepositoryQuery;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery {
	
}