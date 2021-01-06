package principle.isp;

/**
 * Interface Segregation Principle
 * 1. 客户端不應該依赖它不需要的介面，即一个類對另一个類的依赖應該建立在最小介面上。
 *
 * 2. 違反 : class implement 某個介面時，被迫實作此類不需要的函式。
 * 例如: oldFashionPrinter 被迫實作 scan & fax 方法)
 *
 * 3. 解法 : 將一個大介面拆成多個較小的介面，各個類別只 implement 需要的介面即可。
 * 例如: Machine interface 拆成 printer & scanner & fax interface
 */

interface printer {
    public void print(Document document);
}

interface scanner {
    public void scan(Document document);
}

// YAGNI: You ain't goint to need it
/*
interface fax {
    public void fax(Document document);
}
 */

// SingleFunctionPrinter can only print things
class SingleFunctionPrinter implements printer {
    @Override
    public void print(Document document) {
        System.out.println("print: " + document.getText());
    }
}

// Photocopier can scan & print photos
class Photocopier implements scanner, printer {
    @Override
    public void print(Document document) {
        System.out.println("print: " + document.getText());
    }

    @Override
    public void scan(Document document) {
        System.out.println("scan: " + document.getText());
    }
}

public class fixedDemo {
    public static void main(String[] args) {
        SingleFunctionPrinter sp = new SingleFunctionPrinter();
        sp.print(new Document("TEST DOC"));
    }
}
