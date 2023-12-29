package org.vaadin.example;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;


@Route("/Dashboard")
public class DashboardView extends VerticalLayout{

    HorizontalLayout layout = new HorizontalLayout();
    HorizontalLayout layout2 = new HorizontalLayout();
    

    public DashboardView() {

        
        layout.setJustifyContentMode(JustifyContentMode.CENTER);
        layout.setSizeFull();
        layout2.setJustifyContentMode(JustifyContentMode.CENTER);
        layout2.setSizeFull();

        LoginForm loginForm = new LoginForm();
        loginForm.setForgotPasswordButtonVisible(false);


        // Add login listener
        loginForm.addLoginListener(e -> {
            String username = e.getUsername();
            String password = e.getPassword();
            // Do something with the username and password
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
        });

        Text field = new Text("If you don't have an account or forgot your password: ");
        Button button = new Button("Contact Administrator");
        button.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);

        Dialog dialog = new Dialog();
        dialog.setMaxWidth("600px");
        VerticalLayout dialogLayout = new VerticalLayout();
        HorizontalLayout dialogLayout2 = new HorizontalLayout();
        HorizontalLayout dialogLayout3 = new HorizontalLayout();
        dialogLayout2.setJustifyContentMode(JustifyContentMode.CENTER);
        dialogLayout2.setSizeFull();
        dialogLayout3.setPadding(true);
        dialogLayout3.setJustifyContentMode(JustifyContentMode.END);
        Text text = new Text("The account details will be sent to your email address once your petition is verified.");
        EmailField email = new EmailField();
        email.setLabel("Email");
        email.setClearButtonVisible(true);
        email.setRequired(true);
        email.setErrorMessage("Not a valid email address");
        TextField dni = new TextField();
        dni.setLabel("DNI");
        dni.setClearButtonVisible(true);
        dni.setRequired(true);
        dni.setErrorMessage("This field is required");
        Button send = new Button("Send");
        Button cancel = new Button("Cancel");
        cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE, ButtonVariant.LUMO_ERROR);
        dialogLayout3.add(send, cancel);




        dialog.setHeaderTitle("Request Details");

        dialogLayout2.add(email, dni);
        dialogLayout.add(dialogLayout2);
        dialog.add(text, dialogLayout, dialogLayout3);

        button.addClickListener(e -> {
            dialog.open();
            cancel.addClickListener(f -> {
                dialog.close();
            });
        });


        layout.add(loginForm);
        layout2.add(field, button);
               
        add(layout, layout2);
    }
    
}
