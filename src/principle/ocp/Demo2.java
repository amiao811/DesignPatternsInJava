package principle.ocp;

/**
 * Scenario: I want a Graphic Editor which can draw circle & rectangle
 *
 * 1. Defination: open to extension, close to modification. 對擴展開放(對提供方)，對修改關閉(對使用方)。
 *
 * 2. How: 用抽象(abstract)构建框架，用实现扩展细节。尽量通过扩展软件实体的行为来实现变化，而不是通过修改已有的代码来实现变化。
 *   Thought: 把創建 Shape 類做成抽象類，並提供一個抽象的 draw 方法，讓子類去實現即可。
 *   這樣我们有新的圖形種類時，只需要讓新的圖形類繼承 Shape，並實現 draw 方法即可，使用方的代码就不需要修改  -> 滿足了 OCP
 *
 * 3. 编程中遵循其它原则，以及使用設計模式的目的就是遵循開閉原则。
 */

// 用於繪圖的類屬於使用方: GraphicEditor 使用 Shape 提供的 draw 功能。對修改關閉。
class GraphicEditor {
    public void draw(Shape shape) {
        shape.draw();
    }
}

// Shape 提供 draw 方法。可以藉由繼承 Shape 實現對擴展開放
abstract class Shape {
    abstract void draw();
}

class Triangle extends Shape {
    @Override
    void draw() {
        System.out.println("draw triangle");
    }
}

class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("draw rectangle");
    }
}

public class Demo2 {
    public static void main(String[] args) {
        GraphicEditor ge = new GraphicEditor();
        ge.draw(new Rectangle());
    }
}
