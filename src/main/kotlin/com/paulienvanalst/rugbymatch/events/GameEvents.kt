package com.paulienvanalst.rugbymatch.events

import org.springframework.context.ApplicationEvent

sealed class SetPieceEvent(source: Any, val someArgs: Any) : ApplicationEvent(source)


