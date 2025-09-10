package ar.edu.utn.frc.backend.menu;

public class MenuOption implements Comparable<MenuOption> {
    public final int code;
    public final String label;
    public final FuncAction action;

    public MenuOption(int code, String label, FuncAction action) {
        this.code = code;
        this.label = label;
        this.action = action;
    }


    @Override
    public int compareTo(MenuOption o) {
        return Integer.compare(this.code, o.code);
    }

}
