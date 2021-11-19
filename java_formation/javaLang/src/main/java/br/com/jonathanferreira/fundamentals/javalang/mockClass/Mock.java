package br.com.jonathanferreira.fundamentals.javalang.mockClass;

public class Mock {
    private String anything;

    public Mock() {
    }

    public Mock(String anything) {
        this.anything = anything;
    }

    public String getAnything() {
        return anything;
    }

    public void setAnything(String anything) {
        this.anything = anything;
    }

    @Override
    public String toString() {
        return "Mock{" +
                "anything='" + anything + "'" +
                '}';
    }
}
