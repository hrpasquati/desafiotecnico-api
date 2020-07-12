package com.hrpasquati.desafiotecnico.repositories

import com.hrpasquati.desafiotecnico.model.Investimento
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InvestimentoRepository : JpaRepository<Investimento, Long> {


}