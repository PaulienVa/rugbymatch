package com.paulienvanalst.rugbymatch.game

import com.paulienvanalst.rugbymatch.events.*
import com.paulienvanalst.rugbymatch.team.Team
import com.paulienvanalst.rugbymatch.team.TeamName
import mu.KotlinLogging
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
open class TeamManager (
        private val publisher : ApplicationEventPublisher,
        private val substitutionRepository: SubstitutionRepository
) {
    private val logger =  KotlinLogging.logger {  }

    private lateinit var hostingTeam : Team

    private lateinit var visitingTeam : Team

    @EventListener
    fun start(gameAnnounced: GameAnnounced) {
        hostingTeam = Team(listOf(), gameAnnounced.hostingTeam)
        visitingTeam = Team(listOf(), gameAnnounced.visitingTeam)
    }

    @EventListener
    fun squadAnnounced(squadAnnounced: SquadAnnounced) {
        val teamSquadAnnounced = squadAnnounced.teamName
        if (teamSquadAnnounced == hostingTeam.name ) {
            teamSquadAnnounced.apply { hostingTeam.players = squadAnnounced.startingPlayers }
        } else {
            teamSquadAnnounced.apply { visitingTeam.players = squadAnnounced.startingPlayers }
        }
    }

    @EventListener
    fun substitution(substitutionAnnouncedEvent: SubstitutionAnnounced) {
        substitutionAnnouncedEvent.let {
            logger.info { "A substituion is announced $it" }
        }

        val name = substitutionAnnouncedEvent.teamName
        val startingPlayer = substitutionAnnouncedEvent.startingPlayer
        val sub = substitutionAnnouncedEvent.sub

        substitutionAnnouncedEvent.run {
            substitutionRepository.save(Substitution(name, sub, startingPlayer))
        }

        val teamChanging = determineTeam(substitutionAnnouncedEvent.teamName)

        val newPlayers = teamChanging.players.also { it.filter { player -> player != startingPlayer } + sub }

        val changedTeam = Team(newPlayers, name)

        val publisherContext = this

        with(changedTeam) {
            publisher.publishEvent(SubstitutionPerformed(publisherContext, this.name, this.players))
        }
    }

    fun currentCompositionOfTeams(): Pair<Team, Team> {
        return hostingTeam to visitingTeam
    }

    private fun determineTeam(name: TeamName): Team {
        return if (hostingTeam.name == name) {
            hostingTeam
        } else {
            visitingTeam
        }
    }
}