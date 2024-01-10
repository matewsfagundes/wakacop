package academy.wakanda.wakacop.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import academy.wakanda.wakacop.sessaovotacao.domain.SessaoVotacao;

public interface SessaoVotacaoSpringDataJPARepository extends JpaRepository<SessaoVotacao, UUID>{

}
