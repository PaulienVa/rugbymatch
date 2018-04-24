package com.paulienvanalst.rugbymatch.analytics

import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
open class MailingService {

    var mailToSend : String = ""

    @EventListener
    fun generateReport(generateGameReport: GenerateGameReport) {
        mailToSend = generateGameReport.report.format()
    }


}





