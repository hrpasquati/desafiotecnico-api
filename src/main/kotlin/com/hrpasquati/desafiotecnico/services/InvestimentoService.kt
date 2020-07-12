package com.hrpasquati.desafiotecnico.services

import com.hrpasquati.desafiotecnico.model.Investimento
import com.hrpasquati.desafiotecnico.model.InvestimentoDTO
import com.hrpasquati.desafiotecnico.model.enums.TaxaDeInvestimento
import com.hrpasquati.desafiotecnico.repositories.InvestimentoRepository
import org.springframework.stereotype.Service

@Service
class InvestimentoService(val investimentoRepository: InvestimentoRepository) {

    fun insert(investimento: Investimento) = investimentoRepository.save(investimento)

    fun findByAll(): List<Investimento> {
        return investimentoRepository.findAll()
    }

    fun fromDTO(investimentoDTO: InvestimentoDTO): Investimento {
        var investimento = Investimento(null, investimentoDTO.nome, investimentoDTO.investimentoInicial,
                investimentoDTO.tempoInvestimento, null, 0.0, TaxaDeInvestimento.TAXA_SELIC.valor)
        return investimento
    }

    fun converterTempoDeSemanaParaDias(tempoEmSemana: Int): Int {
        return ((tempoEmSemana / 4) * 252) / 12
    }

    fun calcularRentabilidade(investimentoInicial: Double, tempoDeInvestimentoEmSemana: Int, tempoEmSemana: Int, taxaDeInvestimento: TaxaDeInvestimento): Double {
        return (investimentoInicial * tempoDeInvestimentoEmSemana) * Math.pow(1 + (taxaDeInvestimento.valor / 100), converterTempoDeSemanaParaDias(tempoEmSemana).toDouble() / 252)
    }


}


