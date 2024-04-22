import java.util.ArrayList;
import java.util.List;

// Interfaz que define las operaciones comunes para todos los componentes del árbol
interface Component {
    void operation();
}

// Nodo hoja que representa un elemento simple del árbol
class Leaf implements Component {
    @Override
    public void operation() {
        System.out.println("Operación en la hoja");
    }
}

// Nodo compuesto que puede contener otros nodos (hojas o nodos compuestos)
class Composite implements Component {
    private List<Component> children = new ArrayList<>();

    // Método para agregar un componente al nodo compuesto
    public void add(Component component) {
        children.add(component);
    }

    // Método para eliminar un componente del nodo compuesto
    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public void operation() {
        System.out.println("Operación en el nodo compuesto");
        // Realizar la operación en todos los hijos del nodo compuesto
        for (Component child : children) {
            child.operation();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Crear una estructura de árbol
        Composite composite = new Composite();
        composite.add(new Leaf());
        
        // Crear otro nodo compuesto
        Composite composite2 = new Composite();
        composite2.add(new Leaf());
        composite2.add(new Leaf());
        composite.add(composite2);
        
        // Ejecutar la operación en toda la estructura de árbol
        composite.operation();
    }
}
