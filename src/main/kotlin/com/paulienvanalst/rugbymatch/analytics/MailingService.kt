package com.paulienvanalst.rugbymatch.analytics

import com.paulienvanalst.rugbymatch.events.lineOutEvents
import com.paulienvanalst.rugbymatch.events.lostBy
import com.paulienvanalst.rugbymatch.events.scrumEvents
import com.paulienvanalst.rugbymatch.events.wonBy
import com.paulienvanalst.rugbymatch.team.TeamName
import org.apache.ibatis.annotations.Param
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

@Component
class MailingService {

    var mailToSend : String = ""

    @EventListener
    fun generateReport(generateGameReport: GenerateGameReport) {
        mailToSend = generateGameReport.report.format()
    }


}





