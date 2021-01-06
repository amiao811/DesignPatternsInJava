package principle.isp;

class Document{
    private String text;
    public Document(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

interface Machine{
    public void print(Document document);
    public void fax(Document document);
    public void scan(Document document);
}

// multi function printer which can print & fax & scan documents
class multiFunctionPrinter implements Machine{
    @Override
    public void print(Document document) {
        System.out.println("print: " + document.getText());
    }

    @Override
    public void fax(Document document) {
        System.out.println("fax: " + document.getText());
    }

    @Override
    public void scan(Document document) {
        System.out.println("scan: " + document.getText());
    }
}

// old fashion printer which can only print documents
class oldFashionPrinter implements Machine{

    @Override
    public void print(Document document) {
        System.out.println("print things" + document);
    }

    @Override
    public void fax(Document document) {
        // TODO
        // oldFashionPrinter do not have this function, violate ISP
    }

    @Override
    public void scan(Document document) {
        // TODO
        // oldFashionPrinter do not have this function, violate ISP
    }
}


public class ViolationDemo {
    public static void main(String[] args) {

    }
}
