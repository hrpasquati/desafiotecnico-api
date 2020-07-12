package com.hrpasquati.desafiotecnico.resources

import com.hrpasquati.desafiotecnico.model.Investimento
import com.hrpasquati.desafiotecnico.model.InvestimentoDTO
import com.hrpasquati.desafiotecnico.model.enums.TaxaDeInvestimento
import com.hrpasquati.desafiotecnico.services.InvestimentoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/investimentos")
class InvestimentoResource(val investimentoService : InvestimentoService) {



    @PostMapping
    fun create(@RequestBody investimentoDTO: InvestimentoDTO): ResponseEntity<Void> {
        val investimento = Investimento(null, investimentoDTO.nome, investimentoDTO.investimentoInicial,
                investimentoDTO.tempoInvestimento, null, 0.0, null)

        investimento.taxaSelic = TaxaDeInvestimento.TAXA_SELIC.valor

        investimento.rendimento = investimentoService.calcularRentabilidade(investimento.valorInicialDoInvestimento,
        investimento.tempoDeInvestimento, investimentoService.converterTempoDeSemanaParaDias(investimento.tempoDeInvestimento),
        TaxaDeInvestimento.TAXA_SELIC)

        investimento.valorPoupado = investimento.rendimento!! - (investimentoDTO.investimentoInicial * investimentoDTO.tempoInvestimento)
        investimentoService.insert(investimento)

        return ResponseEntity.ok().build()

    }

    @GetMapping
    fun findAll() = ResponseEntity.ok(investimentoService.findByAll())


}





