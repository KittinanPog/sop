package com.example.demo;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;


@Route(value="index2")
public class CashierView extends VerticalLayout {
    private TextField tfMoney ,tf1000,tf500,tf100,tf20,tf10,tf5,tf1;
    private Button btnCal ;

    public CashierView(){
        tfMoney = new TextField("เงินทอน");
        tfMoney.setPrefixComponent(new Span("$"));
        btnCal =new Button("คำนวณเงินทอน");
        tf1000 = new TextField();
        tf1000.setPrefixComponent(new Span("$1000: "));
        tf1000.setReadOnly(true);
        tf500 = new TextField();
        tf500.setPrefixComponent(new Span("$500: "));
        tf500.setReadOnly(true);
        tf100 = new TextField();
        tf100.setPrefixComponent(new Span("$100: "));
        tf100.setReadOnly(true);
        tf20 = new TextField();
        tf20.setPrefixComponent(new Span("$20: "));
        tf20.setReadOnly(true);
        tf10 = new TextField();
        tf10.setPrefixComponent(new Span("$10: "));
        tf10.setReadOnly(true);
        tf5 = new TextField();
        tf5.setPrefixComponent(new Span("$5: "));
        tf5.setReadOnly(true);
        tf1 = new TextField();
        tf1.setPrefixComponent(new Span("$1: "));
        tf1.setReadOnly(true);

        add(tfMoney,btnCal,tf1000,tf500,tf100,tf20,tf10,tf5,tf1);

        btnCal.addClickListener(event ->{

            int money = Integer.parseInt(tfMoney.getValue());

            Change out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/getChange/"+money)
                    .retrieve()
                    .bodyToMono(Change.class)
                    .block();

            tf1000.setValue(Integer.toString(out.getB1000()));
            tf500.setValue(Integer.toString(out.getB500()));
            tf100.setValue(Integer.toString(out.getB100()));
            tf20.setValue(Integer.toString(out.getB20()));
            tf10.setValue(Integer.toString(out.getB10()));
            tf5.setValue(Integer.toString(out.getB5()));
            tf1.setValue(Integer.toString(out.getB1()));


        });
    }

}
