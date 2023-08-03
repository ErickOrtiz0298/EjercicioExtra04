package mx.com.globant.servicio;

import mx.com.globant.entidades.CodigoPostal;

import java.util.*;

public class CodigoPostalServicio {
    static HashMap<Long,String> ListaCiudades =new HashMap<>();
    static Scanner sc = new Scanner(System.in).useDelimiter("\n");
    protected static CodigoPostal crearCodigo(){
        CodigoPostal codigoPostal = new CodigoPostal();
        System.out.println("Por favor ingresa el codigo Postal");
        codigoPostal.setCodigoPostal(sc.nextLong());

        System.out.println("Por favor ingresa el nombre de la ciudad");
        codigoPostal.setCiudad(sc.next());

        return codigoPostal;
    }

    public static void interactuarUsuario(){

        int i = 0;
        do {
            guardarCodigosPostales(crearCodigo());
            i++;
        }while(i < 5);

        mostrarCiudades();
        buscarCiudadCodigoPostal();
        System.out.println("Ingrese una ciudad mas a la lista: ");
        agregarUnaCiudad(crearCodigo());
        eliminarTresCiudades();
        mostrarCiudades();

    }

    protected static void guardarCodigosPostales(CodigoPostal codigoPostal){
        ListaCiudades.put(codigoPostal.getCodigoPostal(), codigoPostal.getCiudad());
    }

    protected static void mostrarCiudades(){
        System.out.println("Las ciudades de la lista son: ");
        for(Map.Entry<Long,String>ciudad: ListaCiudades.entrySet()){
            Long key = ciudad.getKey();
            String value = ciudad.getValue();
            System.out.println(" key: " + key + " value: " + value);
        }
    }

    protected static void buscarCiudadCodigoPostal(){
        System.out.println("Ingresa el codigo postal de una ciudad para buscarla: ");
        Long codigoPostal = sc.nextLong();

        /*
        if(ListaCiudades.get(codigoPostal)!= null){
            System.out.println(ListaCiudades.get(codigoPostal));
        }else{
            System.out.println("No se encuentra esa ciudad");
        }*/

        System.out.println
                (ListaCiudades.get(codigoPostal)!=null?
                ListaCiudades.get(codigoPostal):
                "No se encuentra esa ciudad");

    }

    protected static void agregarUnaCiudad(CodigoPostal codigoPostal){
        ListaCiudades.put(codigoPostal.getCodigoPostal(),codigoPostal.getCiudad());
    }

    protected static void eliminarTresCiudades(){
        int i= 0;
        do {
            System.out.println("Ingrese el nombre de la ciudad a Eliminar");
            String nombreCiudad = sc.next();
            eliminadorCiudades(nombreCiudad);
            i ++;

        }while(i < 3);

    }

    /*
    protected static void eliminadorCiudades(String nombreCiudad){
        Iterator<Map.Entry<Long,String>> it = ListaCiudades.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Long,String> entry = it.next();
            System.out.println("Imprimiendo desde eliminador Ciudades" + entry);
            if(entry.getValue().equals(nombreCiudad)){
                it.remove();
            }else{
                System.out.println("Esa ciudad no se encuentra en la lista.");
            }
        }
    }
    */
    //Con lambdas
    protected static void eliminadorCiudades(String nombreCiudad) {
        ListaCiudades.entrySet().removeIf(entry -> entry.getValue().equals(nombreCiudad));
    }



}
