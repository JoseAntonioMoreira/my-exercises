enum Colors {
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    BLUE("\u001B[34m"),
    YELLOW("\u001B[33m"),
    WHITE("\u001B[37m");
    private String color;
    Colors(String color){
        this.color = color;
    }

    public String getColor(){return color;}
}
