//Componente
interface Automovil {
    public void acelerar();
    public void frenar();
};
//Implementacion concreta del componente
class CarroEstandar implements Automovil {
    protected String nombre;
    public CarroEstandar(String s) {
        nombre = s;
    }
    @Override
    public void acelerar() {
        System.out.println("Aceleracion estandar");
    }
    @Override
    public void frenar() {
        System.out.println("Frenando el carro");
    }
};
//Decorador abstracto
abstract class AutomovilDecorador implements Automovil {
    private Automovil auto;
    public AutomovilDecorador(Automovil auto) {
        this.auto = auto;
    }
    protected Automovil getAuto() {
        return auto;
    }
}
//Decorador concreto que agrega funcionalidad extra
 class AutoElectrico extends AutomovilDecorador {
    public AutoElectrico(Automovil auto) {
        super(auto);
    }
    @Override
    public void acelerar() {
        System.out.println("Aceleracion electrica");
    } 
    @Override
    public void frenar() {
        System.out.println("Frenando el carro electrico");
    }
}

public class MainDecorator {
    public static void main(String[] args) {
        //Se crea componente concreto
        Automovil carro = new CarroEstandar("Chevy");
        //se envuelve con el decorador
        Automovil auto = new AutoElectrico(carro);
        auto.acelerar();
        auto.frenar();
    }
}