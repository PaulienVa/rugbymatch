package com.paulienvanalst.rugbymatch.analytics

import org.apache.logging.log4j.LogManager
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service

@Service
class MailingService {
    val LOG = LogManager.getLogger(MailingService::class.java)


    @EventListener
    fun mailingTheGameReport(generateGameReport: GenerateGameReport) {
        LOG.error(" We got ourselves a report for the game : ${generateGameReport.report.hostingTeam} versus ${generateGameReport.report.visitingTeam}} : \n" +
                "${generateGameReport.report.format()}"
        )

    }


}