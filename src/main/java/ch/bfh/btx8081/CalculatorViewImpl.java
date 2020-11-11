package ch.bfh.btx8081;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

import java.util.ArrayList;
import java.util.List;

public class CalculatorViewImpl extends VerticalLayout implements CalculatorView {

    private TextField display = new TextField();
    private List<CalculatorViewListener> listeners = new ArrayList<CalculatorViewListener>();

    public CalculatorViewImpl() {
        display.setReadOnly(true);
        add(display);
    }

    HorizontalLayout layout_1;

    {
        layout_1 = new HorizontalLayout();
        layout_1.add(createButton("7"));
        layout_1.add(createButton("8"));
        layout_1.add(createButton("9"));
        layout_1.add(createButton("/"));
        add(layout_1);
    }

    HorizontalLayout layout_2;

    {
        layout_2 = new HorizontalLayout();
        layout_2.add(createButton("4"));
        layout_2.add(createButton("5"));
        layout_2.add(createButton("6"));
        layout_2.add(createButton("*"));
        add(layout_2);
    }

    HorizontalLayout layout_3;
    {
        layout_3 = new HorizontalLayout();
        layout_3.add(createButton("1"));
        layout_3.add(createButton("2"));
        layout_3.add(createButton("3"));
        layout_3.add(createButton("-"));
        add(layout_3);
    }

    HorizontalLayout layout_4;
    {
        layout_4 = new HorizontalLayout();
        layout_4.add(createButton("0"));
        layout_4.add(createButton("="));
        layout_4.add(createButton("C"));
        layout_4.add(createButton("+"));
        add(layout_4);
    }

    private Button createButton(String operation){
        return new Button(operation, event -> {
            for (CalculatorViewListener listener : listeners)
                listener.buttonClick((event.getSource().getText().charAt(0)));
        });
    }

    @Override
    public void setDisplay(double value) {
        display.setValue(Double.toString(value));
    }

    @Override
    public void addListener(CalculatorViewListener listener) {
        listeners.add(listener);
    }
}
