package pt.brene.ui

import com.vaadin.annotations.Theme
import com.vaadin.server.VaadinRequest
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.ui.UI
import pt.brene.controller.PersonRepository

const val LIST_VIEW: String = "list"
const val DETAIL_VIEW: String = "detail"

@Theme("valo")
@SpringUI(path = "/ui")
class PersonUI(val repository: PersonRepository) : UI() {


    override fun init(request: VaadinRequest?) {
    }
}