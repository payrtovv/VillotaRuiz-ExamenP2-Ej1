import java.util.LinkedList;

public class PowerRanger {
    private int ID;
    private String NombreReal;
    private String TipoDePoder;
    private int NivelDeEntrenamiento;
    private String BaseSecreta;

    public PowerRanger(int ID, String nombreReal, String tipoDePoder, int nivelDeEntrenamiento, String baseSecreta) { //Constructor para powerRanger
        this.ID = ID;
        NombreReal = nombreReal;
        TipoDePoder = tipoDePoder;
        NivelDeEntrenamiento = nivelDeEntrenamiento;
        BaseSecreta = baseSecreta;
    }


    public static int contarRangersPorTipo(LinkedList<PowerRanger> lista, String tipoPoder, int indice) {
        if (indice == lista.size()) {//Con este if controlamos que se haya recorrido toda la lista
            return 0;
        }

        PowerRanger actual = lista.get(indice); //Usamos el indice para asignar al ranger y guardarlo temporalmente en una instancia (cuando el indice suba va a irse al siguiente ranger)
        String poderActual = actual.getTipoDePoder(); // Guardamos el poder de este en un String

        if (poderActual.equals(tipoPoder)) {// comparamos el poder del actual con el que le dimos
            return 1 + contarRangersPorTipo(lista, tipoPoder,  indice + 1); // Si es igual retornamos + 1 y aumentamos el indice
        } else {
            return contarRangersPorTipo(lista, tipoPoder, indice + 1); //Si no es igual solo aumentamos el indice
        }
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
