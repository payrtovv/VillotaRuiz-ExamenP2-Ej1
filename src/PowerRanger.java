public class PowerRanger {
    private int ID;
    private String NombreReal;
    private String TipoDePoder;
    private int NivelDeEntrenamiento;
    private String BaseSecreta;

    public PowerRanger(int ID, String nombreReal, String tipoDePoder, int nivelDeEntrenamiento, String baseSecreta) {
        this.ID = ID;
        NombreReal = nombreReal;
        TipoDePoder = tipoDePoder;
        NivelDeEntrenamiento = nivelDeEntrenamiento;
        BaseSecreta = baseSecreta;
    }

    public int getID() {
        return ID;
    }

    public String getNombreReal() {
        return NombreReal;
    }

    public String getTipoDePoder() {
        return TipoDePoder;
    }

    public int getNivelDeEntrenamiento() {
        return NivelDeEntrenamiento;
    }

    public String getBaseSecreta() {
        return BaseSecreta;
    }

    @Override
    public String toString() {
        return "PowerRanger{" +
                "ID=" + ID +
                ", NombreReal='" + NombreReal + '\'' +
                ", TipoDePoder='" + TipoDePoder + '\'' +
                ", NivelDeEntrenamiento=" + NivelDeEntrenamiento +
                ", BaseSecreta='" + BaseSecreta + '\'' +
                '}';
    }
}
