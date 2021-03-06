//package com.snail.springboot.vaadin;
//
//
///**
// * @Author: SnailBBB
// * @Description:
// * @Date: 2020/9/14 22:50
// */
//
//import com.snail.springboot.jpa.JpaCustomer;
//import com.snail.springboot.jpa.VaadinCustomerRepository;
//import com.vaadin.flow.component.button.Button;
//import com.vaadin.flow.component.grid.Grid;
//import com.vaadin.flow.component.icon.VaadinIcon;
//import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.component.textfield.TextField;
//import com.vaadin.flow.data.value.ValueChangeMode;
//import com.vaadin.flow.router.Route;
//import com.vaadin.flow.spring.annotation.UIScope;
//import org.springframework.util.StringUtils;
//
////@Route
//public class MainView extends VerticalLayout {
//
//    private final VaadinCustomerRepository repo;
//
//    private final CustomerEditor editor;
//
//    final Grid<JpaCustomer> grid;
//
//    final TextField filter;
//
//    private final Button addNewBtn;
//
//    public MainView(VaadinCustomerRepository repo, CustomerEditor editor) {
//        this.repo = repo;
//        this.editor = editor;
//        this.grid = new Grid<>(JpaCustomer.class);
//        this.filter = new TextField();
//        this.addNewBtn = new Button("New customer", VaadinIcon.PLUS.create());
//
//        // build layout
//        HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
//        add(actions, grid, editor);
//
//        grid.setHeight("300px");
//        grid.setColumns("id", "firstName", "lastName");
//        grid.getColumnByKey("id").setWidth("50px").setFlexGrow(0);
//
//        filter.setPlaceholder("Filter by last name");
//
//        // Hook logic to components
//
//        // Replace listing with filtered content when user changes filter
//        filter.setValueChangeMode(ValueChangeMode.EAGER);
//        filter.addValueChangeListener(e -> listCustomers(e.getValue()));
//
//        // Connect selected Customer to editor or hide if none is selected
//        grid.asSingleSelect().addValueChangeListener(e -> {
//            editor.editCustomer(e.getValue());
//        });
//
//        // Instantiate and edit new Customer the new button is clicked
//        addNewBtn.addClickListener(e -> editor.editCustomer(new JpaCustomer("", "")));
//
//        // Listen changes made by the editor, refresh data from backend
//        editor.setChangeHandler(() -> {
//            editor.setVisible(false);
//            listCustomers(filter.getValue());
//        });
//
//        // Initialize listing
//        listCustomers(null);
//    }
//
//    // tag::listCustomers[]
//    void listCustomers(String filterText) {
//        if (StringUtils.isEmpty(filterText)) {
//            grid.setItems(repo.findAll());
//        }
//        else {
//            grid.setItems(repo.findByLastNameStartsWithIgnoreCase(filterText));
//        }
//    }
//    // end::listCustomers[]
//
//}
