package pt.brene.internal

import org.springframework.boot.actuate.info.Info
import org.springframework.boot.actuate.info.InfoContributor
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.stereotype.Component

@Component
class MainInfoContributor(val context: ConfigurableApplicationContext) : InfoContributor {

    override fun contribute(builder: Info.Builder?) {
        context.environment.propertySources.forEach { builder?.withDetail(it.name, it.source.toString()) }
    }
}