package pt.brene.ui

import com.vaadin.data.util.BeanItemContainer
import com.vaadin.navigator.View
import com.vaadin.navigator.ViewChangeListener
import com.vaadin.spring.annotation.SpringView
import com.vaadin.ui.Grid
import com.vaadin.ui.GridLayout
import pt.brene.controller.Person
import pt.brene.controller.PersonRepository

@SpringView(name = LIST_VIEW)
class ListView(repository: PersonRepository) : GridLayout(1, 1), View {

    init {
        isSpacing = true
        setMargin(true)
        var container = BeanItemContainer<Person>(Person::class.java, repository.findAll().toList())
        val grid = Grid(container)
        grid.setColumnOrder("firstName", "lastName")
        grid.removeColumn("id")
        grid.addSelectionListener {
            val selected = (grid.selectionModel as Grid.SingleSelectionModel).selectedRow
            ui.navigator.navigateTo(DETAIL_VIEW)
        }
        addComponent(grid)
    }

    override fun enter(event: ViewChangeListener.ViewChangeEvent?) {

    }
}
