package com.hrpasquati.desafiotecnico.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Investimento(@Id
                        @GeneratedValue(strategy = GenerationType.IDENTITY)
                        val id: Long?,
                        val nomeDoInvestidor: String,
                        val valorInicialDoInvestimento: Double,
                        val tempoDeInvestimento: Int,
                        var rendimento: Double? = null,
                        var valorPoupado: Double? = null,
                        var taxaSelic: Double? = null
)