package ar.edu.utn.frc.backend.menu;

@FunctionalInterface
/*
FuncAction (interfaz funcional)
Rol: representar una acción ejecutable del menú.
Firma: void run() (sin parámetros en esta etapa).
Criterio de aceptación: debe permitir usar lambdas y method references. Con @FunctionalInterface.
*/
public interface FuncAction {
    void run();

}
