package com.paulienvanalst.rugbymatch.game

import mu.KotlinLogging
import org.springframework.stereotype.Repository

@Repository
open class SubstitutionRepository {
    private val logger = KotlinLogging.logger {  }

    fun save(substitution: Substitution) {
        logger.info { "Saving sub event $substitution" }
    }
}