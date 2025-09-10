package kauan_giacomin.hexagonal.src.main.java.com.seuapp.pessoas.adapters.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaSpringDataRepository extends JpaRepository<PessoaEntity, Long> { }