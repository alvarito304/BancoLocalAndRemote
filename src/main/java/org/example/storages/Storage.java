package org.example.storages;

import reactor.core.publisher.Flux;

import java.io.File;
import java.util.List;

public interface Storage<K> {

    /**
     * Importar datos desde un archivo
     * @param file el archivo a importar
     * @return un flujo de los datos importados
     * @author Javier Hernandez, Yahya El Hadri, Javier Ruiz, Alvaro Herrero, Samuel Cortes, Raul Fernandez
     * @version 1.0
     */

    Flux<K> importList(File file);

    /**
     * Exportar datos a un archivo
     * @param lista la lista de datos a exportar
     * @param file el archivo al que exportar
     * @author Javier Hernandez, Yahya El Hadri, Javier Ruiz, Alvaro Herrero, Samuel Cortes, Raul Fernandez
     * @version 1.0
     */

    void exportList(List<K> lista, File file);
}
