package frontend.Enum;

public enum COLOR {
    WHITE("-fx-background-color: #f3dcd0;"), BLACK("-fx-background-color: #b6663d;");
    private String color;

    private COLOR(String s) {
        this.color = s;
    }

    public String getColor() {
        return color;
    }
}
