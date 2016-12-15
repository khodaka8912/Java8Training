package ch04.ex03;

import javafx.beans.property.Property;

import java.util.function.Supplier;

/**
 * @author hodaka
 */
public class LatentProperty<T> {

    T value;
    Property<T> property;
    Supplier<Property<T>> supplier;

    LatentProperty(Supplier<Property<T>> supplier, T defaultValue) {
        this.supplier = supplier;
        value = defaultValue;
    }

    Property<T> property() {
        return property == null ? createProperty() : property;
    }

    T getValue() {
        return property == null ? value : property.getValue();
    }

    void setValue(T value) {
        if (property == null) {
            this.value = value;
        } else {
            property.setValue(value);
        }
    }

    private Property<T> createProperty() {
        property = supplier.get();
        property.setValue(value);
        return property;
    }
}
