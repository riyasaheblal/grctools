package org.kc.rg.GrcToolApplication.Repository;


import org.kc.rg.GrcToolApplication.Model.Risk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiskRepository extends JpaRepository<Risk, Long> {
}

