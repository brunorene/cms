package pt.brene.ui

import com.vaadin.data.fieldgroup.BeanFieldGroup
import com.vaadin.event.ShortcutAction
import com.vaadin.navigator.View
import com.vaadin.navigator.ViewChangeListener
import com.vaadin.spring.annotation.SpringView
import com.vaadin.ui.Button
import com.vaadin.ui.TextField
import com.vaadin.ui.VerticalLayout
import pt.brene.controller.Person
import pt.brene.controller.PersonRepository

@SpringView(name = DETAIL_VIEW)
class DetailView(repository: PersonRepository) : VerticalLayout(), View {

    private val person: Person = Person()
    private val firstName = TextField("First Name")
    private val lastName = TextField("Last Name")

    init {
        isSpacing = true
        setMargin(true)
        val saveButton = Button("Save", Button.ClickListener { repository.save(person) })
        saveButton.setClickShortcut(ShortcutAction.KeyCode.ENTER)
        addComponents(firstName, lastName, saveButton)
        BeanFieldGroup.bindFieldsUnbuffered(person, this)
    }

    override fun enter(event: ViewChangeListener.ViewChangeEvent?) {

    }
}