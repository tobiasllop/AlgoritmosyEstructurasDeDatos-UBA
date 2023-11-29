package aed;

public class InternetToolkit {
    public InternetToolkit() {
    }

    public Fragment[] tcpReorder(Fragment[] fragments) {
        InsertionSort.sort(fragments);
        return fragments;
    }

    public Router[] kTopRouters(Router[] routers, int k, int umbral) {
        // Crear un Heap para almacenar los routers
        Heap<Router> maxHeap = new Heap<>(routers.length);

        // Insertar todos los routers en el Heap
        for (Router router : routers) {
            if (router.getTrafico() > umbral) {
                maxHeap.insert(router);
            }
        }

        // Crear un arreglo para almacenar los k routers con mayor tráfico
        Router[] topRouters = new Router[k];

        // Extraer los k routers con mayor tráfico del Heap
        for (int i = 0; i < k && maxHeap.size() > 0; i++) {
            topRouters[i] = maxHeap.extractMax();
        }

        return topRouters;
    }

    public IPv4Address[] sortIPv4(String[] ipv4) {
        IPv4Address[] result = new IPv4Address[ipv4.length];
        for (int i = 0; i < ipv4.length; i++) {
            result[i] = new IPv4Address(ipv4[i]);
        }

        // Ordenar el array utilizando el algoritmo de burbuja con comparación personalizada
        for (int i = 0; i < result.length - 1; i++) {
            for (int j = 0; j < result.length - i - 1; j++) {
                if (compareIPv4Addresses(result[j], result[j + 1]) > 0) {
                    // Intercambiar elementos si están en el orden incorrecto
                    IPv4Address temp = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = temp;
                }
            }
        }

        return result;
    }

    // Método de comparación personalizado para IPv4Address
    private int compareIPv4Addresses(IPv4Address addr1, IPv4Address addr2) {
        for (int i = 0; i < 4; i++) {
            if (addr1.getOctet(i) != addr2.getOctet(i)) {
                return Integer.compare(addr1.getOctet(i), addr2.getOctet(i));
            }
        }
        return 0;  // Las direcciones son iguales
    }
}